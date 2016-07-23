package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;


import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class RSAManager {

	public final static String strRSA = "RSA";
	
	
    public static KeyPair getKeyFromPemFile(String file) {
    	KeyPair kp = null;
       	try {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	    	Security.addProvider(new BouncyCastleProvider());
	    	PEMParser pp = new PEMParser(br);
			PEMKeyPair pemKeyPair = (PEMKeyPair) pp.readObject();
			kp = new JcaPEMKeyConverter().getKeyPair(pemKeyPair);
			pp.close();
		} catch (Exception e) {
			// TODO: handle exception
			Debug.print("getKeyFromPemFile error");
		}
    	return kp;
    }
    
    
    // file: der file or pem file, only contain public key
    // file begin like follow:
    // -----BEGIN PUBLIC KEY-----
    
	public static PublicKey getPubKeyFromFile(String file) {
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			// Using bcpkix-jdk15-1.51
			PEMParser pemParser = new PEMParser(new FileReader(file));
			Object object = pemParser.readObject();
			pemParser.close();
			JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
			SubjectPublicKeyInfo kp=null;
			
			if (object instanceof SubjectPublicKeyInfo) {
				Debug.print("get SubjectPublicKeyInfo ok");
				kp = (SubjectPublicKeyInfo)object;
			}
			else {
				String err = "get SubjectPublicKeyInfo failed!";
				Debug.print(err);
				throw new Exception(err);
			}
	    	return converter.getPublicKey(kp);
		} catch (Exception e) {
			// TODO: handle exception
			Debug.print("getPubkey error");
			return null;
		}
	}
    
    public static String encryptBase64RSA(String msg, String pemFile)
    {
    	return Base64.encodeBase64URLSafeString(encrypt(msg.getBytes(), getPubKeyFromFile(pemFile)));
    }


    
	public static byte[] encrypt(byte[] data, PublicKey publicKey)
	{
		try
		{
			assert(null!=publicKey);
			Cipher cipher = Cipher.getInstance(strRSA);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			System.err.print("encrypt error");
			return null;
		}
	}
	
	public static byte[] decrypt(byte[] data, PrivateKey privateKey)
	{
		try
		{
			assert(null!=privateKey);
			Cipher cipher = Cipher.getInstance(strRSA);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			System.err.print("decrypt error");
			return null;
		}
	}

	//sha-1 digest algo: return capital case like "12AB", but not "12ab"
	public static String SHA1(String msg) {
		return DigestUtils.sha1Hex(msg).toUpperCase();
	}
	
	public static String SHA1withRSA(String msg, PrivateKey privateKey) {
		
		try {
			Signature rsa = Signature.getInstance("SHA1withRSA");
			rsa.initSign(privateKey);
			rsa.update(msg.getBytes("UTF-8"));
			byte[] signature = rsa.sign();
			return Base64.encodeBase64URLSafeString(signature);
		} catch (Exception e) {
			// TODO: handle exception
			return "SHA1withRSA error";
		} 
	}

	/*
	 * 1. SHA1
	 * 2. SHA1withRSA
	 * 3. Base64
	 */
	public static String SHA1_SHA1withRSA_Base64(String msg, PrivateKey privateKey) {
		
		try {
			msg = SHA1(msg);
			Signature rsa = Signature.getInstance("SHA1withRSA");
			rsa.initSign(privateKey);
			rsa.update(msg.getBytes("UTF-8"));
			byte[] signature = rsa.sign();
			msg = Base64.encodeBase64URLSafeString(signature);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			
			return "SHA1_SHA1withRSA_Base64 error!";
		} 
	}
	
	public static String SHA1_SHA1withRSA_Base64(String msg, String pemFile) {
		KeyPair kp = getKeyFromPemFile(pemFile);
		PrivateKey privateKey = kp.getPrivate();
		return SHA1_SHA1withRSA_Base64(msg, privateKey);
	}

	public static String encodeBase64(String msg)
	{
		return new String( Base64.encodeBase64URLSafe(msg.getBytes()) );
	}
	
	public static String decodeBase64(String msg)
	{
		return new String( Base64.decodeBase64(msg));
	}
	
}
