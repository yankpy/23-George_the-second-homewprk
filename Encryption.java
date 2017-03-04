package encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryption {
	private KeyGenerator keygen;
	private SecretKey deskey;
	private Cipher c;
	private byte[] cipherByte;
	public  Encryption() throws NoSuchAlgorithmException,NoSuchPaddingException{
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		keygen = KeyGenerator.getInstance("DESede");
		deskey = keygen.generateKey();
		c= Cipher.getInstance("DESede");
	}
	public byte[] Encrytor(String str) throws InvalidKeyException,IllegalBlockSizeException,BadPaddingException
	{
		c.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] src=str.getBytes();
		cipherByte = c.doFinal(src);
		return cipherByte;
	}
	public byte[] Decryptor(byte[]buff)throws InvalidKeyException,IllegalBlockSizeException,BadPaddingException{
		c.init(Cipher.DECRYPT_MODE,deskey);
		cipherByte=c.doFinal(buff);
		return cipherByte;
		}
  public static void main(String[] args) throws Exception{
	  
Encryption des=new Encryption();
String msg ="Hello,design pattern";
byte[] encontent=des.Encrytor(msg);
byte[] decontent=des.Decryptor(encontent);
System.out.println("明文是:"+msg);
System.out.println("加密后:"+new String(encontent));
System.out.println("解密后:"+new String(decontent));
  }
}
