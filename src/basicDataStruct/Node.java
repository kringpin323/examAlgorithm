package basicDataStruct;

public class Node {
	int key;
	// default 的访问权限是：同一个包内
	Node next;
	Node prev;
	
	public Node(int key,Node next, Node prev){
		this.key = key;
		this.next = next;
		this.prev = prev;
	}
	
	public Node(int key){
		this.key = key;
	}
	
	public Node(){
		
	}
	
	public int getData() {
		return key;
	}
	public void setData(int key) {
		this.key = key;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	
}
