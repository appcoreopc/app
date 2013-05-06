package com.appCore.Security.Users;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class SecureKeyProvider implements SecureDataKeyProvider {
	
	public PrivateKey reconstructPrivateKey(String eprivateKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
	{
		byte[] reconstructedKey = Base64.decode(eprivateKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		KeySpec privateKeySpec = new PKCS8EncodedKeySpec(reconstructedKey);
		PrivateKey reconstructedPrivateKey = keyFactory.generatePrivate(privateKeySpec);
		return reconstructedPrivateKey;
	
	}
	
	
	public String decrypt(String privateKeyString, String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IOException
	{
		if (privateKeyString == null)
			 return null; 
		
		if (encryptedText == null) 
			return null;
		
		Key privateKey = this.reconstructPrivateKey(privateKeyString);
		
		byte[] decryptedData;
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		try 
		{
			decryptedData = cipher.doFinal(Base64.decode(encryptedText));
			return new String(decryptedData);
		} 
		catch (Exception ex) {
			System.out.println("Decrypt error");
		}
		return "";
	}
	
	
	public String decrypt(Key privateKey, String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
	{
		
		byte[] decryptedData;
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		try 
		{
			decryptedData = cipher.doFinal(Base64.decode(encryptedText));
			return new String(decryptedData);
		} 
		catch (Exception ex) {
			System.out.println("Decrypt error");
		}
		return "";
	}
	
	
	public EncodedKey publishNewSecureKey() throws NoSuchAlgorithmException
	{
		EncodedKey encodedKeyPair = new EncodedKey();
		KeyPairGenerator outKeyPair = KeyPairGenerator.getInstance("RSA");
		KeyPair outKeyPP = outKeyPair.generateKeyPair();
		
		PrivateKey debugPrivateKey = outKeyPP.getPrivate();
		PublicKey  debugPublicKey = outKeyPP.getPublic();
		
		PrivateKey pkeyView = outKeyPP.getPrivate();
		String eprivateKey = Base64.encodeBytes(outKeyPP.getPrivate().getEncoded());
		String epublicKey = Base64.encodeBytes(outKeyPP.getPublic().getEncoded());
		
		encodedKeyPair.setPublicKey(epublicKey);
		encodedKeyPair.setPrivateKey(eprivateKey);
		
		return encodedKeyPair;
	}
}
