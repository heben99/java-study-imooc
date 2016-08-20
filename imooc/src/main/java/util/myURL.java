// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2014/11/19 10:55:20
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   myURL.java

package util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com:
//            Debug, EncodeGoter

public class myURL {

	public myURL() {
	}

	/**
	 * @deprecated Method sendHttp is deprecated
	 */

	public static String sendHttp(String urlStr) {
		String errorCode = "myURL error";
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.connect();
			charset = connection.getContentEncoding();
			Debug.print((new StringBuilder("charset:")).append(charset).toString());
			if (charset == null || charset.isEmpty())
				charset = "gbk";
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(new String(""));
			out.flush();
			out.close();
			String sCurrentLine = "";
			String sTotalString = "";
			InputStream l_urlStream = connection.getInputStream();
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream, charset));
			while ((sCurrentLine = l_reader.readLine()) != null)
				sTotalString = (new StringBuilder(String.valueOf(sTotalString))).append(sCurrentLine).append("\n")
						.toString();
			String UTFSpace = "";
			UTFSpace = (new StringBuilder(String.valueOf(UTFSpace))).append('\302').toString();
			UTFSpace = (new StringBuilder(String.valueOf(UTFSpace))).append('\240').toString();
			String HtmlStr = sTotalString.replace(UTFSpace, "&nbsp;");
			return HtmlStr;
		} catch (Exception e) {
			Debug.print(errorCode);
		}
		return errorCode;
	}

	public static String getContent(String strUrl) {
		try {
			URL url = new URL(strUrl);
			charset = EncodeGoter.getEncode(url);
			Debug.print((new StringBuilder("charset:")).append(charset).toString());
			if (charset == null || charset.isEmpty())
				charset = "gbk";
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), charset));
			String s = "";
			StringBuffer sb = new StringBuffer("");
			while ((s = br.readLine()) != null)
				sb.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
			br.close();
			return sb.toString();
		} catch (Exception e) {
			return (new StringBuilder("error open url:  ")).append(strUrl).toString();
		}
	}

	public static void main(String args[]) throws IOException {
		String s = sendHttp("http://www.faircanton.com/message/check.asp");
		Debug.print(s);
	}

	private static String charset = "gbk";

}