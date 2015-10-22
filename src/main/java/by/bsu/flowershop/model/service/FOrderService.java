package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;

public interface FOrderService
{
    Integer getCost(String flowers) throws ServiceException;

    void create(FOrder fOrder) throws ServiceException;
}
