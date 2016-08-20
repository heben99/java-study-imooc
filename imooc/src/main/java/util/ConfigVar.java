// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConfigVar.java

package util;

// Referenced classes of package com:
//            Config, Const

public class ConfigVar {

	public ConfigVar() {
	}

	public static void init(String path) throws Exception {
		Config.init(path);
		http = "http";
		expect = Config.getString(Const.expect);
		remote = Config.getString(Const.remote);
		kinds = Integer.parseInt(Config.getString(Const.tradeKinds));
		trade = new String[kinds];
		file = new String[kinds];
		for (int i = 0; i < kinds; i++) {
			trade[i] = Config.getString((new StringBuilder(String.valueOf(Const.tradeName))).append(i).toString());
			file[i] = Config.getString((new StringBuilder(String.valueOf(Const.fileName))).append(i).toString());
		}

	}

	public static void main(String args[]) {
	}

	public static String http;
	public static String expect;
	public static String remote;
	public static String trade[];
	public static String file[];
	public static int kinds = 0;

}