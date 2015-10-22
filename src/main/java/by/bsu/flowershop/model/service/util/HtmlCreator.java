package by.bsu.flowershop.model.service.util;

import java.util.ArrayList;
import java.util.List;

public class HtmlCreator
{
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
        for (int i = 0; i < 9; i++)
        {
            style = style.replaceFirst("#", String.valueOf(positions.get(i)));
            pos = pos.replaceFirst("#", style);
        }
        return pos;
    }
}
