package com.neonid0.springboottraining.service;

//@Component
//public class JWTUtil {
//    private final String secretKey = "yourSecretKeyHere";
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(secretKey.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(secretKey.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//    }
//}
//
