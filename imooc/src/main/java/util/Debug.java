// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Debug.java

package com;


public class Debug
{
	private Debug(){};

    public static void print(String s1)
    {
    	if (isDebug) System.out.println(s1);
    }

    static final boolean isDebug = true;
}