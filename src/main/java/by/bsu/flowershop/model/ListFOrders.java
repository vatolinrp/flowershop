package by.bsu.flowershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ListFOrders implements Serializable
{
  private static final long serialVersionUID = -947971027161487557L;

  private List<Order> orderTOList;

  public List<String> getCheckedOrders()
  {
    List<String> orderIds = new ArrayList<String>();
    for (Order order : getOrderTOList())
    {
      if (order.isCheck())
      {
        orderIds.add(order.getOrderId());
      }
    }
    return orderIds;
  }
}
