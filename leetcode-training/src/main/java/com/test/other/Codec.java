package com.test.other;

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
		Codec codec = new Codec();
		String url = "https://leetcode.com/problems/design-tinyurl";
		System.out.println(codec.decode(codec.encode(url)));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
