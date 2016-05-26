package by.bsu.flowershop.service.impl;

import by.bsu.flowershop.model.ChoiceVO;
import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.dao.OrderDao;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.model.PlacementVO;
import by.bsu.flowershop.model.TopRated;
import by.bsu.flowershop.service.OrderService;
import by.bsu.flowershop.util.HtmlCreator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
  @Resource
  private OrderDao orderDao;

  @Override
  public String create( Order order )
  {
    order.setCreationDate( new Date() );
    return orderDao.create( order );
  }

  @Override
  public List<Order> getAll()
  {
    return orderDao.getAll();
  }

  @Override
  public Order getById( String orderId )
  {
    return orderDao.getById( orderId );
  }

  @Override
  public void delete( List<String> ids )
  {
    orderDao.delete( ids );
  }

  @Override
  public ChoiceVO getHistoryByPhone( Long phoneNumber, List<Flower> flowerList )
  {
    List<Order> orderList = orderDao.getHistoryByPhone( phoneNumber );
    List<PlacementVO> placementVOList = new ArrayList<PlacementVO>();
    PlacementVO placementVO;
    for (Order order: orderList)
    {
      placementVO = new PlacementVO();
      placementVO.setCost( order.getCost() );
      placementVO.setHtmlPlacement( HtmlCreator.getHTMLPositions( order.getPlacement(), flowerList ) );
      placementVO.setPlacementId( order.getOrderId() );
      placementVOList.add( placementVO );
    }
    ChoiceVO choiceVO = new ChoiceVO();
    choiceVO.setPlacementVOList( placementVOList );
    return choiceVO;
  }

  @Override
  public ChoiceVO getTopRated( String celebrationType, List<Flower> flowerList )
  {
    List<TopRated> topRatedList = orderDao.getTopRated( celebrationType );
    List<PlacementVO> placementVOList = new ArrayList<PlacementVO>();
    PlacementVO placementVO;
    for (TopRated topRated: topRatedList)
    {
      placementVO = new PlacementVO();
      placementVO.setCost( topRated.getCost() );
      placementVO.setHtmlPlacement( HtmlCreator.getHTMLPositions( topRated.getPlacement(), flowerList ) );
      placementVO.setPlacementId( topRated.getTrId() );
      placementVOList.add( placementVO );
    }
    ChoiceVO choiceVO = new ChoiceVO();
    choiceVO.setPlacementVOList( placementVOList );
    return choiceVO;
  }

  @Override
  public String getPlacementFromTopRated( String id )
  {
    return orderDao.getPlacementFromTopRated( id );
  }

  @Override
  public String findPlacement( String id ) throws ServiceException
  {
    String placement = orderDao.getById( id ).getPlacement();
    if( placement == null )
    {
      placement = orderDao.getPlacementFromTopRated( id );
      if( placement == null )
      {
        placement = orderDao.getPlacementFromQuiz( id );
        if( placement == null)
        {
          throw new ServiceException( "could not find placement (" + id + ")" );
        }
        else
        {
          return placement;
        }
      }
      else
      {
        return placement;
      }
    }
    else
    {
      return placement;
    }
  }

}
