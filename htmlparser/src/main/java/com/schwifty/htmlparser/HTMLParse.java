package com.schwifty.htmlparser;

public class HTMLParse {

    public static String getInnerHTML(String HTML, String TAG)
    {
        if(HTML.contains(TAG))
        {
            return HTML.split("<"+TAG+"")[1].split(">")[1].split("</"+TAG+"")[0];
        }

        return null;
    }

    public static String [] getInnerHTMLs(String HTML, String TAG)
    {
        if(HTML.contains(TAG))
        {
            String[] content = HTML.split("<"+TAG);
            int size = content.length;
            String [] result = new String[size];

            for (int i=0;i<size;i++)
            {
                result[i] = content[i].split(">")[1].split("</"+TAG)[0];
            }

            return result;
        }

        return null;
    }
}
