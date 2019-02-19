package com.test;

import java.util.HashMap;
import java.util.Map;

public class UniqueEmailAddress {
	public static void main(String[] args) {
		String[] eamils= {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(eamils));
	}
	
	public static int numUniqueEmails(String[] emails) {
		int index = 0;
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		boolean flag = false;
		for (String email : emails) {
			String[] temp = email.split("@");
			if(map2.get(temp[1]) == null) {
				map2.put(temp[1], index);
				flag = false;
				index++;
			}else {
				flag = true;
			}
			email = temp[0];
			
			String[] temp2 = email.split("\\+");
			email = temp2[0];
			
			String[] temp3 = email.split("\\.");
			email = "";
			for (String t : temp3) {
				email+=t;
			}
			if(map1.get(email) == null) {
				map1.put(email, index);
				if(flag == true) {
					index++;
				}
			}
		}
		return index;
	}
}
