package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.entities.ListFOrders;
import by.bsu.flowershop.model.service.FOrderService;
import by.bsu.flowershop.model.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class AdminPageController
{
    private ListFOrders deleteOrders;

    @Autowired
    private FOrderService fOrderService;

    @RequestMapping(value = { "/order-list" }, method = RequestMethod.GET)
    public String orderList(Map<String, Object> model)
    {
        List<FOrder> list = null;
        deleteOrders = new ListFOrders();
        try
        {
            list = fOrderService.getAllOrders();
        }
        catch (ServiceException e)
        {
            return "admin/error-admin";
        }
        deleteOrders.setOrderTOList(list);
        model.put("deleteOrderTO", deleteOrders);
        return "admin/order-list";
    }
}
