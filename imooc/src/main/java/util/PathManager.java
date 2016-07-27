// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FileTest.java

package util;

import java.io.File;

public class PathManager
{

    public PathManager()
    {
    }

    public static String getDirClasspath(Class<?> c)
    {
    	return c.getPackage().getName().replace('.', '/');
    }
    
    public static void main(String args[])
        throws Exception
    {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("./"));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println((new File("/")).getAbsolutePath());
        System.out.println((new File("./")).getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(PathManager.class.getCanonicalName());
        System.out.println(PathManager.class.getSimpleName());
        System.out.println(getDirClasspath(PathManager.class));
    }

}