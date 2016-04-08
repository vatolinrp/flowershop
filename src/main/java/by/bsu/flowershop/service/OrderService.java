package by.bsu.flowershop.service;

import by.bsu.flowershop.model.ChoiceVO;
import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.model.TopRated;

import java.util.List;

public interface OrderService
{
  String create( Order order );

  List<Order> getAll();

  Order getById( String orderId );

  void delete( List<String> ids );

  ChoiceVO getHistoryByPhone( Long phoneNumber, List<Flower> flowerList );

  ChoiceVO getTopRated( String celebrationType, List<Flower> flowerList );

  String getPlacementFromTopRated( String id );

  public String findPlacement( String id ) throws ServiceException;
}
