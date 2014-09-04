package JavaCollection;

public class ItemCom implements Comparable<ItemCom>{
	
	int partNumber;
	
	public ItemCom(int pn){
		partNumber = pn;
	}
	
	@Override
	public int compareTo(ItemCom it) {
		return partNumber-it.partNumber;
	}

}
