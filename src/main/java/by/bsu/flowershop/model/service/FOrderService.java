package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;

import java.util.List;

public interface FOrderService
{
    String create(FOrder fOrder) throws ServiceException;

    List<FOrder> getAll() throws ServiceException;

    FOrder getById(String orderId) throws ServiceException;

    void delete(List<String> ids) throws ServiceException;
}
