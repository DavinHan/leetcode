package com.test.other;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Codec {
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	return longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	
		return shortUrl;
        
    }
    
    public static void main(String[] args) {
		String fileContent = "JTdCJTIydXNlcm5hbWUlMjI6JTIyZmVua3VfY29yZV8wMTI2JTIyLCUyMmRyaXZlcm5hbWUlMjI6JTIyb3JhY2xlLmpkYmMuZHJpdmVyLk9yYWNsZURyaXZlciUyMiwlMjJ1cmwlMjI6JTIyamRiYzpvcmFjbGU6dGhpbjpAMTAuMTAuMy4yMDE6MTUyMi9vcmExMWclMjIsJTIycGFzc3dvcmQlMjI6JTIyMSUyMiU3RA==";
		try {
			fileContent = new String(Base64.decode(fileContent), "utf-8");
			fileContent = URLDecoder.decode(fileContent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("����������������!");
		}
		System.out.println(fileContent);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
