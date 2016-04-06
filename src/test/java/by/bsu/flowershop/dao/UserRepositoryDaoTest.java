package by.bsu.flowershop.dao;

import by.bsu.flowershop.model.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.annotation.Resource;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class UserRepositoryDaoTest extends AbstractTestNGSpringContextTests
{
  @Resource
  private UserRepositoryDao userRepositoryDao;

  @Test
  public void findByUsernameTest()
  {
    User user = userRepositoryDao.findByUsername( "1" );
    Assert.assertNotNull( user );
    Assert.assertEquals( user.getName(),"Rostislav" );
    Assert.assertEquals( user.getSurname(), "Vatolin" );
    Assert.assertEquals( user.getPassword(), "1" );
    Assert.assertEquals( user.getUsername(), "1" );
    Assert.assertEquals( user.getRole(), new Long( 1 ) );
  }

}
