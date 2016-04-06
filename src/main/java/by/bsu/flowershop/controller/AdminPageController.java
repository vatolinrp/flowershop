package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.model.ListFOrders;
import by.bsu.flowershop.service.OrderService;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.util.HtmlCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPageController
{
  private ListFOrders deleteOrders;

  @Resource
  private OrderService orderService;

  @RequestMapping( value = { "/order-list" }, method = RequestMethod.GET )
  public String orderList( Map<String, Object> model )
  {
    List<Order> list;
    deleteOrders = new ListFOrders();
    try
    {
      list = orderService.getAll();
    }
    catch ( ServiceException e )
    {
      return "admin/error-admin";
    }
    deleteOrders.setOrderTOList( list );
    model.put( "deleteOrderTO", deleteOrders );
    return "admin/order-list";
  }

  @RequestMapping( value = "/order-view/{orderId}", method = RequestMethod.GET )
  public String displayOrder( @PathVariable String orderId, Map<String, Object> model )
  {
    Order order;
    try
    {
      order = orderService.getById( orderId );
      model.put( "positions", HtmlCreator.getHTMLPositions( order.getPlacement() ) );
      model.put( "order", order );
    }
    catch ( ServiceException e )
    {
      return "admin/error-admin";
    }
    return "admin/order-view";
  }

  @RequestMapping( value = "/order-list", method = RequestMethod.POST )
  public String delete( @ModelAttribute("deleteOrderTO") ListFOrders orderList, Map<String, Object> model )
  {
    List<String> orderIds = orderList.getCheckedOrders();
    try
    {
      orderService.delete( orderIds );
    }
    catch ( ServiceException e )
    {
      return "admin/error-admin";
    }
    return orderList( model );
  }
}
