package JavaCollection;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item>
{
	public int compare(Item a, Item b)
	{
		String descrA = a.getDescription();
		String descrB = b.getDescription();
		return descrA.compareTo(descrB);
	}
}

