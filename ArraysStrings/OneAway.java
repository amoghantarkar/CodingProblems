package com.ArraysStrings;

public class OneAway {
	public static void main(String[]args){
		OneAway test = new OneAway();
		String str1 = "bake";
		String str2 = "pale";
		boolean isOneAway = test.isOneEditAway(str1, str2);
		System.out.println(isOneAway);
	}
	public boolean isOneEditAway(String str1,String str2){
		StringBuilder sb1 = new StringBuilder(str1); // initial capacity is 16 + length of argument
		StringBuilder sb2 = new StringBuilder(str2);
		int len = sb1.length() - sb2.length();
		System.out.println("len: "+ len);
		if(len == 0){
			System.out.println("sb1:"+sb1+" sb2:"+sb2);
			boolean status = sb1.toString().equals(sb2.toString());
			
			if(status){ 
				// Can't use : sb1.equals(sb2) http://stackoverflow.com/a/18565731/4250322 
				// Can Use : sb1.toString().equals(sb2.toString()); either two different objects referencing two different things
				return true;
			}else{
				int flag = 0;
				for(int i= 0;i<sb1.length();i++){
					if(sb1.charAt(i)!=sb2.charAt(i)){
						flag++;
						if(flag > 1){
							return false;
						}
					}
				}
			}
			return true;
		}
		else{
			if(len == 1){ // the first string sb1 is longer by 1.. need to find if more than 1 characters need to be removed 
				return getAwayCount(sb1,sb2);
			}else if(len == -1){ // // the second string sb2 is longer by 1.. need to find if more than 1 characters need to be removed
				return getAwayCount(sb2,sb1);
			}
			else{
				return false; // length difference exceeds 1
			}
		}
	}
	
	
	public boolean getAwayCount(StringBuilder sb1,StringBuilder sb2){
		int deleteCount = 0; 
		for(int s1 = 0,s2 = 0; s1<sb2.length();s1++){
			if(sb1.charAt(s1)==sb2.charAt(s2)){
				s2++;
			}else{
				deleteCount++;
			}
		}
		if(deleteCount > 1){
			return false;
		}
		return true;
	}
}
