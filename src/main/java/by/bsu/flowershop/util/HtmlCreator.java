package by.bsu.flowershop.util;

import by.bsu.flowershop.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class HtmlCreator
{
  private final static int FIELD_NUMBER = 9;

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
      styleForInsert = style.replaceFirst("#", list.get(i).getImgUrl());
      str = str.replaceFirst("#",styleForInsert);
      sb.append(str);
    }
    sb.append("<div id=blank>" +
              "      <div class=column draggable=true></div>" +
              "    </div>");
    return sb.toString();
  }

  public static String getHTMLPositions(String flowers)
  {
    String[] strings = flowers.split("#flower");
    String style       = "float:left;" +
                         "width:80px;" +
                         "height:80px;" +
                         "background-image:url('../resources/images/flower#.png');";
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
    for (int i = 0; i < FIELD_NUMBER; i++)
    {
      style = style.replaceFirst( "#", String.valueOf( positions.get( i ) ) );
      pos = pos.replaceFirst( "#", style );
    }
    return pos;
  }
}
