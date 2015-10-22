package by.bsu.flowershop.model.service;

import by.bsu.flowershop.model.entities.FFlower;
import by.bsu.flowershop.model.mongodb.FFlowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FFlowerServiceImpl implements FFlowerService
{

    @Autowired
    FFlowerDao flowerDao;

    @Override
    public List<FFlower> getAllTypes()
    {
        return flowerDao.getAllTypes();
    }
}
