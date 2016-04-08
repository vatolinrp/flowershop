package by.bsu.flowershop.service.impl;

import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.dao.FlowerDao;
import by.bsu.flowershop.service.FlowerService;
import by.bsu.flowershop.util.HtmlCreator;
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

  @Override
  public String getPossibleFlowersHtml()
  {
    List<Flower> list = flowerDao.getAllTypes();
    return HtmlCreator.getPossibleFlowers( list );
  }

  @Override
  public String getDynamicBouquetHtml( String placement )
  {
    if( placement == null)
    {
      return HtmlCreator.fillDynamocBouquet( null, null );
    }
    else
    {
      List<Flower> list = flowerDao.getAllTypes();
      return HtmlCreator.fillDynamocBouquet( placement, list);
    }
  }
}
