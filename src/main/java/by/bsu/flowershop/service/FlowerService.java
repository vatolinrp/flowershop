package by.bsu.flowershop.service;

import by.bsu.flowershop.model.Flower;
import java.util.List;

public interface FlowerService
{
  List<Flower> getAllTypes();

  String getPossibleFlowersHtml();

  String getDynamicBouquetHtml( String placement );
}
