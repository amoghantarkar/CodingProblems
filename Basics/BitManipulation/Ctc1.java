package com.BitManipulation;

/**
 * @author Amogh Antarkar 
 * @email antarkar.amogh@gmail.com
 *	 
 * 
 * 
5.1 You are given two 32-bit numbers, N andM, and two bit positions, i and j. Write a
method to insert M into Nsuch that M starts at bit j and ends at bit i. You can assume
that the bits j through i have enough space to fit all ofM. That is, if M= 10011,
you can assume that there are at least 5 bits between j and i. You would not, for
example, have j-3 and i=2, because M could not fully fit between bit 3 and bit 2.
EXAMPLE:
Input: N = 16000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100

 */
public class Ctc1 {

		public static void main(String[]args){
			
			int n = 32;
			int m = 3;
			int j = 4;
			int i = 2;
			
			MergeBitNumbers solve = new MergeBitNumbers();
			solve.makeBits(n,m,j,i);
			
		}
}

class MergeBitNumbers{

	void makeBits(int n,int m,int j,int i){
	
		int ones = ~0; // 11111111
		//masking right and left
		int right = ones << j+1; // 1111111 -> 11110000
		int left = (1 << i) - 1; //    1111111 -> 0000001
		int mask = right | left; // 1110001
		
		int N = mask & n; // fill out all the numbers leaving the j to i range
		int M = m << i;
		int ans = N|M;
		System.out.println(Integer.toBinaryString(ans));
			
	}
	
	
	
}

