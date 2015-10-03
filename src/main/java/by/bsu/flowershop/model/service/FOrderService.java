package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;

public interface FOrderService
{
    Integer getCost(String flowers) throws ServiceException;

    String create(FOrder fOrder) throws ServiceException;
}
