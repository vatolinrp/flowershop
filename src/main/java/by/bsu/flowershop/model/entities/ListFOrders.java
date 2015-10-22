package by.bsu.flowershop.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ListFOrders
{

    private List<FOrder> orderTOList;

    public List<FOrder> getOrderTOList()
    {
        return orderTOList;
    }

    public void setOrderTOList(List<FOrder> orderTOList)
    {
        this.orderTOList = orderTOList;
    }

    public List<String> getCheckedOrders()
    {
        List<String> orderIds = new ArrayList<String>();

        for (FOrder order : getOrderTOList())
        {
            if (order.isCheck())
            {
                orderIds.add(order.getOrderId());
            }
        }
        return orderIds;
    }

}
