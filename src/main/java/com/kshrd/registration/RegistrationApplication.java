package com.kshrd.registration;

import com.kshrd.registration.utillity.DecodeCryptoJS;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootApplication
public class RegistrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(RegistrationApplication.class, args);
		//DecodeCryptoJS.getDecode("wEFgv603kC3aJfpeLNKPqgBGyzN7hsVMcBKgynTafu8=");

	}



}
