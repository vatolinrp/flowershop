package by.bsu.flowershop.dao;

import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.model.TopRated;

import java.util.List;

public interface OrderDao
{
  String create( Order order );

  List<Order> getAll();

  Order getById( String orderId );

  void delete( List<String> ids );

  void deleteCompletely( List<String> ids );

  List<Order> getHistoryByPhone( Long phoneNumber );

  List<TopRated> getTopRated( String celebrationType );

  String getPlacementFromTopRated( String id );
}
