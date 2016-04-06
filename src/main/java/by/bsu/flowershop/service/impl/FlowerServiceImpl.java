package by.bsu.flowershop.service.impl;

import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.dao.FlowerDao;
import by.bsu.flowershop.service.FlowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService
{
  @Resource
  private FlowerDao flowerDao;

  @Override
  public List<Flower> getAllTypes()
  {
    return flowerDao.getAllTypes();
  }
}
