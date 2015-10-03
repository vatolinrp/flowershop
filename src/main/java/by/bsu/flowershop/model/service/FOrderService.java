package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;

import java.util.List;

public interface FOrderService
{
    Integer getCost(String flowers) throws ServiceException;

    String create(FOrder fOrder) throws ServiceException;

    List<FOrder> getAllOrders() throws ServiceException;
}
