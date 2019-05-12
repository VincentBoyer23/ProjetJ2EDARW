/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.utils;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TokenManagement {
        
    public TokenManagement(){
        
    }
   
    public static String generateToken(int userID,String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
    {
        JSONObject jsonToken = new JSONObject();
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(toDate(LocalDateTime.now().plusMinutes(15L)));
        jsonToken.put("userID", Integer.toString(userID));
        jsonToken.put("uuid", uuid.toString());
        jsonToken.put("dateExp", date);
        String strtoken = jsonToken.toString();
        String crypte= "";
        for (int i=0; i<strtoken.length();i++)  {
            int c=strtoken.charAt(i)^5;  
            crypte=crypte+(char)c; 
        }
        return crypte;
        
        
    }
   
    
    public static JSONObject DecryptToken(String token, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ParseException, UnsupportedEncodingException
    {
        
        
        String aCrypter= "";
        for (int i=0; i<token.length();i++)  {
            int c=token.charAt(i)^5;  
            aCrypter=aCrypter+(char)c; 
        }
        
        JSONParser parser = new JSONParser(); 
        JSONObject jsonToken = (JSONObject) parser.parse(aCrypter);
        return jsonToken;
        
    }
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

       
}
