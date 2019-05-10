/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.utils;

import com.restowa.bl.concrete.UserAccountManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinceduroc
 */

public class TokenManagement {
        
    public TokenManagement(){
        
    }
   
    public static String generateToken(int userID,String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
    {
        /*SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes("ISO-8859-1"),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);*/
        JSONObject jsonToken = new JSONObject();
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(toDate(LocalDateTime.now().plusMinutes(15L)));
        jsonToken.put("userID", Integer.toString(userID));
        jsonToken.put("uuid", uuid.toString());
        jsonToken.put("dateExp", date);
        String strtoken = jsonToken.toString();
        /*byte[] encrypted=cipher.doFinal(strtoken.getBytes("ISO-8859-1"));*/
        /*String token = new String(encrypted);*/
        String crypte= "";
        for (int i=0; i<strtoken.length();i++)  {
            int c=strtoken.charAt(i)^5;  
            crypte=crypte+(char)c; 
        }
        System.out.println(crypte);
        return crypte;
        
        
    }
    
    /*public boolean verifyToken(String token, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ParseException, java.text.ParseException
    {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted=cipher.doFinal(token.getBytes());
	String strtoken=new String(decrypted);
        JSONParser parser = new JSONParser(); 
        JSONObject jsonToken = (JSONObject) parser.parse(strtoken);
        /*String strtokenFromBdd = uamanager.getTokenById((int) jsonToken.get("userID"));
        if(strtokenFromBdd==null)
        {
            return false;
        }
        JSONObject jsonTokenFromBdd = (JSONObject) parser.parse(strtokenFromBdd);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(jsonTokenFromBdd.get("uuid").equals(jsonToken.get("uuid")))
        {
            Date dateexp = sdf.parse((String) jsonToken.get("dateExp"));
            if(dateexp.after(new Date()))
            {
                return true;
            }
            return false;
        }*/
        /*return false;
        
    }*/
    
    public static JSONObject DecryptToken(String token, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ParseException, UnsupportedEncodingException
    {
        
        /*SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes("ISO-8859-1"),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted=cipher.doFinal(token.getBytes("ISO-8859-1"));
	String strtoken=new String(decrypted);*/
        
        String aCrypter= "";
        for (int i=0; i<token.length();i++)  {
            int c=token.charAt(i)^5;  
            aCrypter=aCrypter+(char)c; 
        }
        
        System.out.println( aCrypter );
        JSONParser parser = new JSONParser(); 
        JSONObject jsonToken = (JSONObject) parser.parse(aCrypter);
        /*String strtokenFromBdd = uamanager.getTokenById((int) jsonToken.get("userID"));
        if(strtokenFromBdd==null)
        {
            return false;
        }
        JSONObject jsonTokenFromBdd = (JSONObject) parser.parse(strtokenFromBdd);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(jsonTokenFromBdd.get("uuid").equals(jsonToken.get("uuid")))
        {
            Date dateexp = sdf.parse((String) jsonToken.get("dateExp"));
            if(dateexp.after(new Date()))
            {
                return true;
            }
            return false;
        }*/
        return jsonToken;
        
    }
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

       
}
