package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.entities.FFlower;
import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.service.FFlowerService;
import by.bsu.flowershop.model.service.FOrderService;
import by.bsu.flowershop.model.service.ServiceException;
import by.bsu.flowershop.model.service.util.HtmlCreator;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ClientPageController
{
    @Autowired
    private FOrderService orderService;

    @Autowired
    private FFlowerService flowerService;

    @RequestMapping(value = "/create-by-yourself", method = RequestMethod.GET)
    public String clearFields(Map<String, Object> model)
    {
        FOrder order = new FOrder();
        List<FFlower> list = flowerService.getAllTypes();
        model.put("possible_flowers", HtmlCreator.getPossibleFlowers(list));
        model.put("order", order);
        return "client/order-add";
    }

    @RequestMapping(value = "/save-order", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") FOrder order, Map<String, Object> model)
    {
        try
        {
            order.setCreationDate(new Date());
            orderService.create(order);
            model.put("message","Your order was successfully created. Expect a call");
        }
        catch (ServiceException e)
        {
            return "client/error-client";
        }

        return "welcome";
    }
}
