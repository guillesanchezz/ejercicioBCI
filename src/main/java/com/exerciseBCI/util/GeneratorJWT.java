package com.exerciseBCI.util;

import java.util.Date;

import com.exerciseBCI.dto.RegistroDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GeneratorJWT {

	
	
	public String generarToken(RegistroDTO usuario) {
		
		String key = usuario.getPassword();
		long tiempo = System.currentTimeMillis();
		String jwt = Jwts.builder()
							.signWith(SignatureAlgorithm.HS256, key)
							.setSubject(usuario.getName())
							.setIssuedAt(new Date(tiempo))
							.setExpiration(new Date(tiempo+900000))
							.claim("email", usuario.getEmail())
							.compact();
		
		
		return jwt;
		
	}
	
}
