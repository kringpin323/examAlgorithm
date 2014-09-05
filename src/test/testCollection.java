package test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import JavaCollection.Item;
import JavaCollection.ItemCom;
import JavaCollection.ItemComparator;
import JavaCollection.MyEnumerator;

public class testCollection {
//	@Test
//	public void tstIterator(){
//		List<String> a = new LinkedList<>();
//		a.add("Amy");
//		a.add("Carl");
//		
//		List<String> b = new LinkedList<>();
//		b.add("bob");
//		b.add("Doug");
//		
//		ListIterator<String> aIter = a.listIterator();
//		Iterator<String> bIter = b.iterator();
//		
//		while(bIter.hasNext()){
//			// 
//		}
//	}
	
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
	
	@Test
	public void tstShuffleAndSort(){
		List<Integer> numbers = new ArrayList<>();
		for(int i=1;i<=49;i++)
			numbers.add(i);
		numbers.add(Integer.MAX_VALUE);
		System.out.println(Collections.binarySearch(numbers, 10));
		
		Collections.swap(numbers, 1, 2);
		
		
		Collections.shuffle(numbers);
		// shuffle 以后的排序，你知道会出现什么的
		System.out.println(Collections.binarySearch(numbers, 10));
		
		System.out.println(Collections.min(numbers));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		
		List<Integer> winningCombination = numbers.subList(0,6);
		System.out.println("unsort winningCombination: "+winningCombination);
		System.out.println("unsort numbers: "+numbers);
		Collections.sort(winningCombination);
		System.out.println("winningCombination: "+winningCombination);
		System.out.println("numbers: "+numbers);
		
		Collections.shuffle(numbers);
		System.out.println("shuffle winningCombination: "+winningCombination);
		System.out.println("shuffle numbers: "+numbers);
		
		System.out.println("分割线： ------------------");
		System.out.println("winningCombination: "+winningCombination);
		System.out.println("winningCombination: "+winningCombination);
		Collections.shuffle(numbers);
		System.out.println("shuffle winningCombination: "+winningCombination);
		
		System.out.println("winningCombination==numbers: "+(winningCombination.equals(numbers)));
	}
	
	@Test
	public void tstEnumeration(){
		String[] abc= {"one","second","three"};
		MyEnumerator me = new MyEnumerator(0,abc.length,abc);
		Enumeration en = me;
		while(en.hasMoreElements())
			System.out.println(en.nextElement());
	}
	
	@Test
	public void tstProperties(){
		Map z = new Properties();
		z.put("String", "Stinee~~~");
		z.put("1", "youni");
		System.out.println(z.toString());
		Properties p = (Properties)z;
		System.out.println(p.getProperty("2", "找不到"));
	}
	
	@Test
	public void tstBitSet(){
		BitSet bs = new BitSet(100);
		System.out.println(bs);
		bs.set(0);
		bs.set(1);
		bs.set(2);
		System.out.println(bs);
		bs.clear(2);
		System.out.println(bs);
	}
}
