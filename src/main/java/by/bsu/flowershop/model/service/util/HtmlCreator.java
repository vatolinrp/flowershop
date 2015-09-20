package by.bsu.flowershop.model.service.util;

import java.util.ArrayList;
import java.util.List;

public class HtmlCreator
{
    public static String getHTMLPositions(String flowers)
    {
        String[] strings = flowers.split("#flower");
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
                + "<div class=#></div>"
                + "<div class=#></div>"
                + "<div class=#></div></div><div class=row>"
                + "<div class=#></div>"
                + "<div class=#></div>"
                + "<div class=#></div></div><div class=row>"
                + "<div class=#></div>"
                + "<div class=#></div>"
                + "<div class=#></div></div>";
        StringBuilder sb;
        for (int i = 0; i < 9; i++)
        {
            sb = new StringBuilder();
            pos = pos.replaceFirst("#", (sb.append("flower").append(String.valueOf(positions.get(i)))).toString());
        }
        return pos;
    }
}
