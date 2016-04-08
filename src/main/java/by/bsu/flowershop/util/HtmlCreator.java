package by.bsu.flowershop.util;

import by.bsu.flowershop.controller.ClientPageController;
import by.bsu.flowershop.model.Flower;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlCreator
{
  private final static int FIELD_NUMBER = 9;

  private static final Logger logger = Logger.getLogger( ClientPageController.class );

  private final static String style = "float:left;" +
                                      "width:80px;" +
                                      "height:80px;" +
                                      "background-image:url('#');";

  public static String getPossibleFlowers( List<Flower> list )
  {
    StringBuilder sb = new StringBuilder();
    String styleForInsert;
    for(int i=0; i<list.size();i++)
    {
      String str = "<div class=flower-wrapper>" +
                   "  <div class=flower-cost>" + list.get(i).getCost() + "</div>" +
                   "    <div class=column draggable=true>" +
                   "     <div style=# class=" + list.get(i).getFlowerCode() + "></div>" +
                   "    </div>" +
                   "    </div>";
      styleForInsert = style.replaceFirst( "#", list.get(i).getImgUrl() );
      str = str.replaceFirst( "#", styleForInsert );
      sb.append(str);
    }
    sb.append("<div id=blank>" +
              "      <div class=column draggable=true></div>" +
              "    </div>");
    return sb.toString();
  }

  public static String getHTMLPositions( String flowers, List<Flower> possible )
  {
    logger.info("We in getHTMLPositions method");
    logger.info(flowers);
    Map<String,String> flowerMap = new HashMap<String, String>();
    for( Flower flower: possible )
    {
      flowerMap.put( flower.getFlowerCode(), flower.getImgUrl() );
    }
    flowerMap.put( "flower8", "" );

    String[] strings = flowers.split("#flower");
    String style       = "float:left;" +
                         "width:80px;" +
                         "height:80px;" +
                         "background-image:url('#');";
    List<Integer> positions = new ArrayList<Integer>();
    for ( String str : strings )
    {
      for (int i = 1; i <= 8; i++)
      {
        if (str.equals( String.valueOf( i ) ) )
        {
          positions.add( i );
        }
      }
    }
    logger.info( positions );
    String pos = "<div class=row>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "</div>"
               + "<div class=row>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "</div>"
               + "<div class=row>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "<div style=#></div>"
               + "</div>";
    int size = positions.size();
    for (int i = 0; i < FIELD_NUMBER; i++)
    {
      if( i < size )
      {
        Integer numb = positions.get( i );
        String key = "flower" + String.valueOf( numb );
        String url = flowerMap.get( key );
        String newStyle = style.replaceFirst( "#", url );
        pos = pos.replaceFirst( "#", newStyle );
      }
    }
    logger.info( pos );
    logger.info("getHTMLPositions has finished");
    return pos;
  }

  public static String fillDynamocBouquet( String flowers, List<Flower> possible )
  {
    String bouquet =
        "  <div id=\"bouquet\">\n" +
        "    <div class=\"destination\" style=\"overflow: hidden;\">\n" +
        "      <div id=\"columns\">\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "    <div class=\"destination\" style=\"overflow: hidden;\">\n" +
        "      <div id=\"columns\">\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "    <div class=\"destination\" style=\"overflow: hidden;\">\n" +
        "      <div id=\"columns\">\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "        <div class=\"column\" draggable=\"true\">#</div>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "  </div>";
    if( flowers == null || possible == null )
    {
      bouquet = bouquet.replaceAll( "#", " " );
      return bouquet;
    }
    String[] strings = flowers.split("#flower");
    Map<String,String> flowerMap = new HashMap<String, String>();
    for(Flower flower: possible)
    {
      flowerMap.put(flower.getFlowerCode(),flower.getImgUrl());
    }
    List<Integer> positions = new ArrayList<Integer>();
    for (String str : strings)
    {
      for (int i = 1; i <= 8; i++)
      {
        if (str.equals(String.valueOf(i)))
        {
          positions.add(i);
        }
      }
    }
    String style = "<div style=\"float:left;width:80px;height:80px;background-image:url('#');\" class=\"#\"></div>";
    logger.info(positions);
    int size = positions.size();
    for (int i = 0; i < FIELD_NUMBER; i++)
    {
      if( i < size)
      {
        Integer numb = positions.get( i );
        String key = "flower" + String.valueOf( numb );
        String newStyle = style.replaceFirst( "#", flowerMap.get( key ) );
        newStyle = newStyle.replaceFirst( "#", key );
        bouquet = bouquet.replaceFirst("#", newStyle);
      }
    }
    logger.info(bouquet);
    return bouquet;
  }
}
