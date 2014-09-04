package basicDataStruct;

public class SingleLinkList {
	SingleNode head;
	SingleNode nextAddress;
	
	public SingleLinkList(){
		head = new SingleNode();
		// Java 对类型的要求比较严格，无法实现
		// 由于Java无法取出引用的地址，所以无法实现
//		head.prevXORnext = head ^ null;
		nextAddress = new SingleNode();
	}
	
	public void SingleLinkListInsert(SingleNode sNode){
		// TODO 
		
	}
}