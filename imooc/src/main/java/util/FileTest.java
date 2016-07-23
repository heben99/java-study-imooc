// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FileTest.java

package com;

import java.io.File;
import java.io.PrintStream;

public class FileTest
{

    public FileTest()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
//        System.out.println(ClassLoader.getResource(""));
//        System.out.println(ClassLoader.getResource("/"));
        System.out.println((new File("/")).getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
}