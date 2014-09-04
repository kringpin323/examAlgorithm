package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import JavaCollection.Item;
import JavaCollection.ItemCom;
import JavaCollection.ItemComparator;

public class testCollection {
	@Test
	public void tstIterator(){
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		
		List<String> b = new LinkedList<>();
		b.add("bob");
		b.add("Doug");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		while(bIter.hasNext()){
			// 
		}
	}
	
	@Test
	public void tstTreeSet(){
		ItemComparator comp = new ItemComparator();
		ItemCom ic1 = new ItemCom(1);
		ItemCom ic2 = new ItemCom(2);
		
		
		
		SortedSet<Item> sortByDescription = new TreeSet<>(comp);
		SortedSet<ItemCom> sortInt = new TreeSet<>();
		sortInt.add(ic1);
		sortInt.add(ic2);
		
		
		
	}
}
