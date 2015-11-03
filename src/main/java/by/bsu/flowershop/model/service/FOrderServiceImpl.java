package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.mongodb.FOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FOrderServiceImpl implements FOrderService
{

    @Autowired
    private FOrderDao orderDao;

    @Override
    public String create(FOrder order) throws ServiceException
    {
        return orderDao.create(order);
    }

    @Override
    public List<FOrder> getAll() throws ServiceException
    {
        return orderDao.getAll();
    }

    @Override
    public FOrder getById(String orderId) throws ServiceException
    {
        return orderDao.getById(orderId);
    }

    @Override
    public void delete(List<String> ids) throws ServiceException
    {
        orderDao.delete(ids);
    }

}
