package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.service.FlowerService;
import by.bsu.flowershop.service.OrderService;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.util.HtmlCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ClientPageController
{
  @Resource
  private OrderService orderService;

  @Resource
  private FlowerService flowerService;

  @RequestMapping( value = "/create-by-yourself", method = RequestMethod.GET )
  public String clearFields( Map<String, Object> model )
  {
    Order order = new Order();
    List<Flower> list = flowerService.getAllTypes();
    model.put( "possible_flowers", HtmlCreator.getPossibleFlowers( list ) );
    model.put( "order", order );
    return "client/order-add";
  }

  @RequestMapping(value = "/save-order", method = RequestMethod.POST )
  public String saveOrder( @ModelAttribute( "order" ) Order order, Map<String, Object> model )
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


  @RequestMapping( value = "/create-by-choosing", method = RequestMethod.GET )
  public String clearVariety( Map<String,Object> model )
  {
    return "client/order-choose";
  }
}
