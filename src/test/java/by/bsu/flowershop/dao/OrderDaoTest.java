package by.bsu.flowershop.dao;

import by.bsu.flowershop.model.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class OrderDaoTest extends AbstractTestNGSpringContextTests
{
  @Resource
  private OrderDao orderDao;

  @Test
  public void getCreateDeleteTest()
  {
    List<Order> before = orderDao.getAll();

    Order order = new Order();
    order.setAddress( "test" );
    order.setCost( 100 );
    order.setCreationDate( new Date() );
    order.setCustomerName( "test" );
    order.setCustomerPhone( 100L );
    order.setPlacement( "test" );

    orderDao.create( order );
    List<Order> afterCreation = orderDao.getAll();
    Assert.assertEquals( afterCreation.size(), before.size() + 1 );
    afterCreation.removeAll( before );
    Assert.assertEquals( afterCreation.size(), 1 );
    String generatedId = afterCreation.get( 0 ).getOrderId();
    orderDao.delete( Arrays.asList( generatedId ) );
    List<Order> afterDeletion = orderDao.getAll();
    Assert.assertEquals( afterDeletion.size(), before.size() );
    orderDao.deleteCompletely( Arrays.asList( generatedId ) );
    List<Order> afterCompleteDeletion = orderDao.getAll();
    Assert.assertEquals( afterCompleteDeletion.size(), before.size() );
    Assert.assertNull( orderDao.getById( generatedId ).getOrderId() );
  }

  @Test
  public void getHistoryByPhoneTest()
  {
    List<Order> before = orderDao.getHistoryByPhone( 88888888888L );
    Order order = new Order();
    order.setAddress( "test" );
    order.setCost( 100 );
    order.setCreationDate( new Date() );
    order.setCustomerName( "test" );
    order.setCustomerPhone( 88888888888L );
    order.setPlacement( "test" );

    orderDao.create( order );
    List<Order> afterCreation = orderDao.getHistoryByPhone( 88888888888L );
    Assert.assertEquals( afterCreation.size(), before.size() + 1 );
    afterCreation.removeAll( before );
    String generatedId = afterCreation.get( 0 ).getOrderId();
    orderDao.delete( Arrays.asList( generatedId ) );
    List<Order> afterDelete = orderDao.getHistoryByPhone( 88888888888L );
    Assert.assertEquals( afterDelete.size(),before.size() + 1 );
    orderDao.deleteCompletely( Arrays.asList( generatedId ) );
    Assert.assertEquals( orderDao.getHistoryByPhone( 88888888888L ).size(), before.size() );
  }

  @Test
  public void getById()
  {
    List<Order> oreds = orderDao.getHistoryByPhone(87878787878L);
    int i = 0+1+1+1;
  }
}
