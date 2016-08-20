// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FileManager.java

package util;

import java.io.*;

// Referenced classes of package com:
//            Const, Debug

public class FileManager {

	public FileManager() {
	}

	public static String FileToString(String path) {
		String errorCode = "FileToString Error";
		try {
			File f = new File((new StringBuilder(String.valueOf(Const.dir))).append(path).toString());
			byte tmp[] = new byte[(int) f.length()];
			FileInputStream is = new FileInputStream(f);
			is.read(tmp);
			is.close();
			return new String(tmp);
		} catch (Exception e) {
			Debug.print(errorCode);
		}
		return errorCode;
	}

	public static String InputSteamToString(InputStream is) {
		String errorCode = "InputSteamToString Error";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i = -1;
			if ((i = is.read()) != -1) {
				baos.write(i);
				baos.close();
				return baos.toString();
			}
		} catch (Exception e) {
			Debug.print(errorCode);
		}
		return errorCode;
	}

	public static void StringToFile(String str, String path) {
		String errorCode = "StringToFile Error";
		try {
			FileWriter w = new FileWriter((new StringBuilder(String.valueOf(Const.dir))).append(path).toString());
			w.write(str);
			w.close();
		} catch (Exception e) {
			Debug.print(errorCode);
		}
	}

	public static void main(String args[]) {
		Debug.print(System.getProperty("user.dir"));
		Debug.print(FileToString("http/1-\u4F59\u7968\u67E5\u8BE2.txt"));
	}
}