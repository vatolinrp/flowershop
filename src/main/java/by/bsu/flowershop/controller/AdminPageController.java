package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.entities.ListFOrders;
import by.bsu.flowershop.model.mongodb.LogRepositoryDao;
import by.bsu.flowershop.model.service.FOrderService;
import by.bsu.flowershop.model.service.ServiceException;
import by.bsu.flowershop.model.service.util.HtmlCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class AdminPageController
{
    private ListFOrders deleteOrders;

    @Autowired
    private LogRepositoryDao logRepositoryDao;

    @Autowired
    private FOrderService orderService;

    @Autowired
    private LogRepositoryDao logger;

    @RequestMapping(value = { "/order-list" }, method = RequestMethod.GET)
    public String orderList(Map<String, Object> model)
    {
        List<FOrder> list = null;
        deleteOrders = new ListFOrders();
        try
        {
            list = orderService.getAll();
        }
        catch (ServiceException e)
        {
            return "admin/error-admin";
        }
        deleteOrders.setOrderTOList(list);
        model.put("deleteOrderTO", deleteOrders);
        return "admin/order-list";
    }

    @RequestMapping(value = "/order-view/{orderId}", method = RequestMethod.GET)
    public String displayOrder(@PathVariable String orderId, Map<String, Object> model)
    {
        FOrder order = null;
        try
        {
            order = orderService.getById(orderId);
            logger.setLogMessage(order.toString());
            order.setCost(orderService.getCost(order.getPlacement()));
            model.put("positions", HtmlCreator.getHTMLPositions(order.getPlacement()));
            model.put("order", order);
        }
        catch (ServiceException e)
        {
            return "admin/error-admin";
        }
        return "admin/order-view";
    }

    @RequestMapping(value = "/order-list", method = RequestMethod.POST)
    public String delete(@ModelAttribute("deleteOrderTO") ListFOrders orderList, Map<String, Object> model)
    {
        List<String> orderIds = orderList.getCheckedOrders();
        try
        {
            orderService.delete(orderIds);
        }
        catch (ServiceException e)
        {
            return "admin/error-admin";
        }
        return orderList(model);
    }

}
