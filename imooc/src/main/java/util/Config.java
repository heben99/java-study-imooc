// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Config.java

package util;

import java.io.*;
import java.util.Properties;

// Referenced classes of package com:
//            Const

public class Config
{

    public Config()
    {
    }

    public static void init(String path)
        throws Exception
    {
        if(p != null && !filePath.isEmpty() && path.equals(filePath))
            return;
        filePath = path;
        if(r != null)
            r.close();
        if(p != null)
            p.clear();
        if(is != null)
            is.close();
        is = new FileInputStream(filePath);
        r = new InputStreamReader(is, Const.charset);
        p = new Properties();
        p.load(r);
    }

    public static String getString(String key)
    {
        if(key == null || key.equals("") || key.equals("null"))
        {
            return "";
        } else
        {
            String result = "";
            result = p.getProperty(key);
            return result;
        }
    }

    private static InputStream is = null;
    private static Properties p = null;
    private static InputStreamReader r = null;
    private static String filePath = "";

}