package by.bsu.flowershop.model.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FOrderServiceImpl implements FOrderService
{

    @Override
    public Integer getCost(String flowers) throws ServiceException {
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
}
