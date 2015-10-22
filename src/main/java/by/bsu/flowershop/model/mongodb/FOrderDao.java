package by.bsu.flowershop.model.mongodb;

import by.bsu.flowershop.model.entities.FOrder;

import java.util.List;

public interface FOrderDao
{
    String create(FOrder order);

    List<FOrder> getAll();

    FOrder getById(String orderId);
}
