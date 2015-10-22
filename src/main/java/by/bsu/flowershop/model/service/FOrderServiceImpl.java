package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FOrder;
import by.bsu.flowershop.model.mongodb.FOrderDao;
import by.bsu.flowershop.model.mongodb.LogRepositoryDao;
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
    public Integer getCost(String flowers) throws ServiceException
    {
        String[] strings = flowers.split("#flower");
        int cost = 0;
        List<Integer> positions = new ArrayList<Integer>();

        for (String str : strings)
        {
            for (int i = 1; i <= 8; i++)
            {
                if (str.equals(String.valueOf(i)))
                {
                    positions.add(i);
                    if (i != 8)
                    {
                        cost = cost + 10000 * i;
                    }

                }
            }
        }
        return cost;
    }

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
