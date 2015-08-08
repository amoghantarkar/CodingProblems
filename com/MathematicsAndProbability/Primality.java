package com.MathematicsAndProbability;

/**
 * @author Amogh Antarkar 
 * @email antarkar.amogh@gmail.com
 */

/*
 * This program checks for primality of the number. A simple solution is described.
*/

public class Primality{

    public static void main(String[] args){
    
    int number = 127;
    boolean ans =primeCheck(number);    
    System.out.println(ans);
    }
    public static boolean primeCheck(int num){
    boolean prime =false;
    
    if(num < 2){
        return prime;
    }
    else{
         for(int i=2;i<num-1;i++){
         
         if(num%i == 0){
         prime = false;
         return prime;
         } 
    }
    prime = true;    
    
    return prime;
    }
    }

}