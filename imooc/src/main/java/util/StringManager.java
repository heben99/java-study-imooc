// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:21
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   StringManager.java

package util;


// Referenced classes of package com:
//            Debug

public class StringManager
{

    public StringManager()
    {
    }

    public static void diff(String s1, String s2)
    {
        if(s1 == null || s2 == null)
        {
            Debug.print("diff: null String");
            return;
        }
        if(s1.length() != s2.length())
        {
            Debug.print("len(s1) != len(s2) ;  s1, s2 will be trimed");
            s1 = s1.trim();
            s2 = s2.trim();
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for(int i = 0; i < s1.length() && i < s2.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                Debug.print((new StringBuilder("Diff at pos ")).append(i).append(" with {").append(s1.charAt(i)).append("} ").append(s1.charAt(i)).append(" and {").append(s2.charAt(i)).append("} ").append(s2.charAt(i)).toString());

        Debug.print((new StringBuilder("len(s1):")).append(s1.length()).toString());
        Debug.print((new StringBuilder("len(s2):")).append(s2.length()).toString());
    }

    public static boolean equalsHtml(String s1, String s2)
    {
        if(s1 == null || s2 == null)
        {
            Debug.print("htmlCompare: null String");
            return false;
        } else
        {
            s1 = s1.trim().toLowerCase();
            s2 = s2.trim().toLowerCase();
            return s1.equals(s2);
        }
    }

    public static String removeSpace(String s)
    {
        if(s == null)
        {
            Debug.print("removeSpace: null String");
            return s;
        } else
        {
            return s.replace(" ", "");
        }
    }

    public static void main(String args[])
    {
        diff(" abc ", "    a?c    ");
    }

    public static final char ansiSpace = 32;
}