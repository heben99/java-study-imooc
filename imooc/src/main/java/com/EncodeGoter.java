// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   EncodeGoter.java

package com;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncodeGoter
{

    public EncodeGoter()
    {
    }

    public static String getEncode(URL url)
    {
        String charset = null;
        Pattern pattern = Pattern.compile("charset.*=.*>?", 2);
        try
        {
            String contentType = url.openConnection().getContentType();
            charset = doGetEncode(pattern, contentType);
            if(charset == null)
            {
                InputStream is = url.openStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int count = 0;
                byte bytes[] = new byte[1024];
                while((count = bis.read(bytes)) != -1) 
                {
                    bos.write(bytes, 0, count);
                    bos.flush();
                    charset = doGetEncode(pattern, bos.toString());
                    if(charset != null)
                        break;
                    bos.reset();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("getEncode error");
        }
        return charset;
    }

    private static String doGetEncode(Pattern pattern, String str)
    {
        Matcher matcher = null;
        String matchStr = null;
        String charset = null;
        matcher = pattern.matcher(str);
        if(matcher.find())
        {
            matchStr = matcher.group();
            charset = matchStr.substring(matchStr.indexOf("=") + 1).replaceAll("[\"|\\|/|\\s].*[/>|>]", "");
        }
        return charset;
    }

    public static void main(String args[])
        throws Exception
    {
        List list = new LinkedList();
        list.add("http://baidu.com/");
        list.add("http://army.news.tom.com/");
        list.add("http://slides.army.tom.com/vw/163740-1.html#picchange");
        list.add("http://dl.it.21cn.com/");
        list.add("http://www.pcgames.com.cn/");
        list.add("http://www.bliao.com/");
        list.add("http://www.pchome.net/");
        list.add("http://www.amazon.cn/");
        list.add("http://chengdu.anjuke.com/");
        list.add("http://www.xcar.com.cn/");
        list.add("http://mobile.pcpop.com/");
        list.add("http://www.chinahr.com/index.htm");
        list.add("http://www.ccb.com/cn/home/index.html");
        list.add("http://eladies.sina.com.cn/");
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            String string = (String)iterator.next();
            System.out.print(string);
            String charset = getEncode(new URL(string));
            if(charset != null)
                System.out.println((new StringBuilder("\u9875\u9762\u7684\u5B57\u7B26\u7F16\u7801\u5E94\u8BE5\u4E3A\uFF1A")).append(charset).toString());
            else
                System.out.println("\u65E0\u6CD5\u627E\u5230\u5230\u9875\u9762\u5B57\u7B26\u7F16\u7801\u8BBE\u5B9A");
        }

    }
}