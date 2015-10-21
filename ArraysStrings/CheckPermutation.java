package com.ArraysStrings;


/*
 * Given two strings find if they are permutations of each other 
 * */

import java.util.Arrays;
//import java.util.HashMap;

public class CheckPermutation {
	public static void main(String[]args){
//		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String str = "ThisisAmoghAstronaut";
		String str1 = "isThisAstronautAmogh";
		char[] s = str.toCharArray();
		//		System.out.println("Work in progress");
		char[] m = str1.toCharArray();
		CheckPermutation test = new CheckPermutation();
		System.out.println(test.isPermutation(s,m));
		test.isPermutation2(s, m);
		CheckPermutation run = new BestImplementation(); // Note here the sub class is BestImplementation and super class is CheckPermutation
		System.out.println(run.isPermutation(s, m));
	}
	public boolean isPermutation(char[]s1, char[] s2){
		if(s1.length == s2.length){
			Arrays.sort(s1);
			Arrays.sort(s2);
			for(int i = 0; i< s1.length;i++){
				if(s1[i] != s2[i]){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/* inefficient as i could have just sorted the charArray and using constructor String(char[] array)
	 * Also to note hear is the use of str1.equals(str2) method(). 
	 * Sort both string using above constructor
	 * However to reduce the code i could use equals methods 
	 */
	public void isPermutation2(char[] s1,char[]s2){
		String s = new String(s1);
		String m = new String(s2);
		System.out.println(s.equals(m));
	}

	/*
	 * Could have been so small code as equals methods actually performs logical comparison. I found  
	 * http://stackoverflow.com/a/16194428/4250322  extremely great to grasp the concept of how equals() method works.
	 * */
	/*Both of the implementations described above will take nlogn time for sorting and extra space for two arrays and N + N comparisons*/

}

class BestImplementation extends CheckPermutation{           // Note the use of Inheritance here.. 
	public boolean isPermutation(char[] s1,char[]s2){
		if(s1.length != s2.length){ // char array so length static variable
			return false;
		}else{
			int[] charStatus = new int[128]; // using int[] will initialize it automatically with 0. 128 for all ascii values.
			for(char value: s1){
				charStatus[value]++;
			}
			for(char value: s2){
				charStatus[value]--;
			}
			for(int i: charStatus){
				if(i!=0){
					return false;
				}
			}
			return true;
		}
	}
}

/**Summary: This would probably be best implementation with O(128) space required and couple of o(n) traversals.
 */