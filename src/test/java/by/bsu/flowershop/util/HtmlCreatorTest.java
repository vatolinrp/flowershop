package by.bsu.flowershop.util;

import by.bsu.flowershop.model.Flower;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HtmlCreatorTest
{
  @Test
  public void getHTMLPositionsTest()
  {
    String placement = "#flower8#flower8#flower8#flower8#flower5#flower8#flower8#flower8#flower8";
    List<Flower> flowerList = new ArrayList<Flower>();
    Flower flower = new Flower();
    flower.setFlowerCode("flower1");
    flower.setImgUrl("testUrl1");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower2");
    flower.setImgUrl("testUrl2");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower3");
    flower.setImgUrl("testUrl3");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower4");
    flower.setImgUrl("testUrl4");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower5");
    flower.setImgUrl("testUrl5");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower6");
    flower.setImgUrl("testUrl6");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower7");
    flower.setImgUrl("testUrl7");
    flowerList.add(flower);
    flower = new Flower();
    flower.setFlowerCode("flower8");
    flower.setImgUrl("testUrl8");
    flowerList.add(flower);
    String result = HtmlCreator.getHTMLPositions(placement,flowerList);
  }
}
