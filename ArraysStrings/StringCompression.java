package com.ArraysStrings;

public class StringCompression {
	public static void main(String[]args){
		StringCompression test = new StringCompression();
		String strOriginal = "aabbbbscssssfffsssss";
		String strCompressed = test.getCompressedString(strOriginal);
		if(strCompressed.length()>=strOriginal.length()){
			System.out.println(strOriginal);
			System.out.println(strCompressed);
		}else{
			System.out.println(strCompressed);
		}
	}

	public String getCompressedString(String str){
		StringBuilder strCompressed = new StringBuilder(); // Note: Use of str.concate operate would have cost O(n^2) time.
		int index1 = 0,index2 = 0, charCount = 0;
		while(index2 < str.length()){
			while(str.charAt(index1) == str.charAt(index2) && index2 < str.length()){
				charCount++;
				index2++;
				if(index2 == str.length()){
					break;
				}
			}
			strCompressed.append(addToCode(str.charAt(index1),charCount));		
//			System.out.println("code: "+strCompressed+"index1: "+index1+"index2:"+index2+"string:"+str);
			index1 = index2;
			charCount = 0;
			if(index2 == str.length()){
				break;
			}
		}		
		return strCompressed.toString();
	}
	
	public String addToCode(char c, int count){
		StringBuilder strCode = new StringBuilder();
		strCode = strCode.append(c);
		strCode = strCode.append(count);	
		return strCode.toString();
	}
}
