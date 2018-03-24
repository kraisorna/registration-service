/**
 * 
 */
package com.kraisorn.registration.controllers;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraisorn.registration.dto.UserManager;
import com.kraisorn.registration.dto.User;

/**
 * @author kraisorn
 *
 */
@RestController
@RequestMapping(RegistrationController.REGISTRATION_BASE_URI)
public class RegistrationController {
	
	public static final String REGISTRATION_BASE_URI = "svc/v1/registrations";
	
	@RequestMapping(value = "{id}")
	public User getUserInfo(@PathVariable final int id) {
		UserManager manager = new UserManager();
	    manager.setup();
	    
	    User user = manager.read(id);
	 
	    manager.exit();
		return user;
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public User postUser(@RequestBody User user) throws Exception {
		//business logic //Registration Process
		//Reference Code
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		user.setReference_code(dateFormat.format(date)+user.getPhone().substring(user.getPhone().length()-4));
		
		//Member Type //Salary
		if(user.getSalary()>50000) {
			//Platinum
			user.setMember_type_id(1);
		}
		else if(user.getSalary()>=30000 && user.getSalary()<=50000) {
			//Gold
			user.setMember_type_id(2);
		}
		else if(user.getSalary()>=15000 && user.getSalary()<30000) {
			//Silver
			user.setMember_type_id(3);
		}
		else {
			throw new Exception("error code: 9999 rejected if salary less than 15,000"); 
		}
		
		//hash password with salt
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec(user.getPassword().toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = f.generateSecret(spec).getEncoded();
		Base64.Encoder enc = Base64.getEncoder();
		user.setSalt(enc.encodeToString(salt));
		user.setPassword(enc.encodeToString(hash));
		
		UserManager manager = new UserManager();
	    manager.setup();
	    
	    manager.create(user);
	 
	    manager.exit();
		return user;
	}
}