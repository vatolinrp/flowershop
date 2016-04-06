package by.bsu.flowershop.service.impl;

import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.dao.OrderDao;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.service.OrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
  @Resource
  private OrderDao orderDao;

  @Override
  public String create( Order order ) throws ServiceException
  {
    return orderDao.create( order );
  }

  @Override
  public List<Order> getAll() throws ServiceException
  {
    return orderDao.getAll();
  }

  @Override
  public Order getById( String orderId ) throws ServiceException
  {
    return orderDao.getById( orderId );
  }

  @Override
  public void delete( List<String> ids ) throws ServiceException
  {
    orderDao.delete( ids );
  }

}
