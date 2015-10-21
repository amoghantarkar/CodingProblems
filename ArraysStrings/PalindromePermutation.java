package com.ArraysStrings;
import java.util.*;
public class PalindromePermutation {
	public static void main(String[]args){
		PalindromePermutation test = new PalindromePermutation();
		String str = "tac act";
		System.out.println(test.isPermutationOfPalindrome(str));
	}

	public boolean isPermutationOfPalindrome(String str){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] array = str.toCharArray();
		for(char key: array){
			if(map.containsKey(key)){
				Integer value = map.get(key);
				value++;
				map.put(key, value);
			}else{
				map.put(key,1);
			}
		}
		return checkPalindrome(array,map);
	}
	
	public boolean checkPalindrome(char[]array, HashMap<Character,Integer> map){
	
		/*for(Character key: map.keySet()){
			System.out.println("key: "+key+" value:"+map.get(key));
		}*/
		if(array.length % 2 == 0){ // check for even length
			int flag;
			for(Character key: map.keySet()){
				flag = map.get(key);
				if(flag % 2 != 0){
					return false;
				}
			}
			return true;
		}
		else{ // check for odd length
			boolean trigger = false;
			for(Character key: map.keySet()){
			int	flag = map.get(key);
//			System.out.println("key: "+key+" value:"+map.get(key));
				if(flag % 2 != 0){
					if(trigger == false){
						trigger = true;
					}else if(trigger == true){
						return false;
					}
				}
			}return true;
		}
	}
}
