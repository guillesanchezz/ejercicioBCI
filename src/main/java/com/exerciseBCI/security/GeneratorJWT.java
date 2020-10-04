package com.exerciseBCI.security;

import java.util.Date;

import com.exerciseBCI.dto.RegistroDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GeneratorJWT {

	
	
	public String generarToken(String email, String pass) {
		
		String key = pass;
		long tiempo = System.currentTimeMillis();
		String jwt = Jwts.builder()
							.signWith(SignatureAlgorithm.HS256, key)
							.setSubject(email)
							.setIssuedAt(new Date(tiempo))
							.setExpiration(new Date(tiempo+900000))
							.claim("email", email)
							.compact();
		
		
		return jwt;
		
	}
	
}
