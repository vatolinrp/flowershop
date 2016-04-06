package by.bsu.flowershop.service;

import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.exceptions.ServiceException;
import java.util.List;

public interface OrderService
{
  String create( Order order ) throws ServiceException;

  List<Order> getAll() throws ServiceException;

  Order getById( String orderId ) throws ServiceException;

  void delete( List<String> ids ) throws ServiceException;
}
