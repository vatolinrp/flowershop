package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.entities.FOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClientPageController
{
    @RequestMapping(value = "/create-by-yourself", method = RequestMethod.GET)
    public String clearFields(Map<String, Object> model)
    {
        FOrder fOrder = new FOrder();
        model.put("fOrder", fOrder);
        return "client/order-add";
    }
}
