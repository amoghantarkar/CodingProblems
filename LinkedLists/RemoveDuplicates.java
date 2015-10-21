/*Problem: Remove duplicates from a LinkedList*/

package com.LinkedLists;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Iterator;
public class RemoveDuplicates {
	public static void main(String[]args){	
		RemoveDuplicates test = new RemoveDuplicates();
		LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(1,2,5,2,1,0,3,6,4));
		System.out.println(test.getUniqueElements(list));
	}

	public LinkedList<Integer> getUniqueElements(LinkedList<Integer> list){
		LinkedHashSet<Integer> newList = new LinkedHashSet<Integer>();
		newList.addAll(list);
		LinkedList<Integer> uniqueElementList = new LinkedList<Integer>(); 
		Iterator<Integer> itr =  newList.iterator();
		while(itr.hasNext()){
			uniqueElementList.offer(itr.next());
		}
		return uniqueElementList;
	}

}
