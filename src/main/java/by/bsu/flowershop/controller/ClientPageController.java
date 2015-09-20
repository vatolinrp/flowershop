package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.mongodb.LogRepositoryDao;
import by.bsu.flowershop.model.service.FOrderService;
import by.bsu.flowershop.model.service.ServiceException;
import by.bsu.flowershop.model.service.util.HtmlCreator;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Map;

@Controller
public class ClientPageController
{
    @Autowired
    private LogRepositoryDao logRepositoryDao;

    @Autowired
    private FOrderService fOrderService;

    @RequestMapping(value = "/create-by-yourself", method = RequestMethod.GET)
    public String clearFields(Map<String, Object> model)
    {
        FOrder fOrder = new FOrder();
        model.put("fOrder", fOrder);
        return "client/order-add";
    }

    @RequestMapping(value = "/create-order", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("fOrder") FOrder fOrder, Map<String, Object> model)
    {
        try
        {
            fOrder.setCost(fOrderService.getCost(fOrder.getPlacement()));
            model.put("positions", HtmlCreator.getHTMLPositions(fOrder.getPlacement()));
        }
        catch (ServiceException e)
        {
            logRepositoryDao.setLogMessage(ExceptionUtils.getStackTrace(e));
            return "client/client-error";
        }
        model.put("fOrder", fOrder);
        return "client/confirm-order";
    }
}
