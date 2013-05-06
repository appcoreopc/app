package com.appCore.Security.Users;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;

public interface SecureDataKeyProvider {

	PrivateKey reconstructPrivateKey(String eprivateKey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
	
	String decrypt(Key privateKey, String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException;
	
	EncodedKey publishNewSecureKey() throws NoSuchAlgorithmException;
	
	String decrypt(String privateKeyString, String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IOException;
	
	
}
