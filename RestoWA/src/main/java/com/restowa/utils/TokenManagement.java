/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.utils;

import com.restowa.bl.concrete.UserAccountManager;
import static io.jsonwebtoken.Jwts.parser;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author vinceduroc
 */
public class TokenManagement {
    
    UserAccountManager uamanager;
    
    public String generateToken(int userID,String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        JSONObject jsonToken = new JSONObject();
        UUID uuid = UUID.randomUUID();
        jsonToken.put("userID", userID);
        jsonToken.put("uuid", uuid);
        jsonToken.put("dateExp", toDate(LocalDateTime.now().plusMinutes(15L)));
        String strtoken = jsonToken.toString();
        uamanager.SetToken(userID);
        byte[] encrypted=cipher.doFinal(strtoken.getBytes());
        String token = new String(encrypted);
        return token;
        
        
    }
    
    public boolean verifyToken(String token, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ParseException, java.text.ParseException
    {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted=cipher.doFinal(token.getBytes());
	String strtoken=new String(decrypted);
        JSONParser parser = new JSONParser(); 
        JSONObject jsonToken = (JSONObject) parser.parse(strtoken);
        String strtokenFromBdd = uamanager.getToken(jsonToken.get("userID"));
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
        }
        return false;
        
    }
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public boolean verifyToken(String headerString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
