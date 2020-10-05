package com.exerciseBCI.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GeneratorJWT {

	
	
	public String generarToken(String email) {
		
		String key = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROL_USUARIO");
		long tiempo = System.currentTimeMillis();
		String jwt = Jwts.builder()
							.signWith(SignatureAlgorithm.HS512, key.getBytes())
							.setSubject(email)
							.claim("authorities",
									grantedAuthorities.stream()
											.map(GrantedAuthority::getAuthority)
											.collect(Collectors.toList()))
							.setIssuedAt(new Date(tiempo))
							.setExpiration(new Date(tiempo+900000))
							.compact();
		
		
		return jwt;
				
	}
	
}
