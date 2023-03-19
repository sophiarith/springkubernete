package com.kshrd.registration.utillity;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecodeCryptoJS {
    public static String getDecode(String encodeStr){
        try
        {
            /** GET IT FROM FRONT_END */
            String cryptoPassword = "MOIpGIotGPLdXMmL";

            String data = encodeStr ;
            String key = cryptoPassword;
            String iv = cryptoPassword;

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encrypted1 = decoder.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            System.out.println("DECODE FROM CRYPTOJS: "+originalString.trim());
            return originalString.trim();
        }
        catch (Exception ex) {
            System.out.printf("getDecode error: "+ex.getMessage());
            return null;
        }
    }
}
