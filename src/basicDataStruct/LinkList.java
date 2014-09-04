package basicDataStruct;

/**
 * 带哨兵的linkList
 * */
public class LinkList {
//	Node head;
	Node temp; // 临时游标
	Node nil; // 哨兵
	// L.nil.next  <-->  L.nil.next
	// L.nil.prev  <-->  尾部
	
	// constructor 初始化哨兵
	public LinkList(){
		/**-----------------
		 * 以下是错误构造法
		 * nil.next = nil.prev;
		 * nil.prev = nil.next;
		 * */
		nil = new Node();
		nil.next = nil;
		nil.prev = nil;// 都是null吧，那么 这个构造函数还有意义么。。。
	}
	
	public void OutputList(LinkList L){
		temp = L.nil.next;
		while(temp.next!=L.nil){
			System.out.print(temp.key+" ");
			temp = temp.next;
		}
		System.out.println(temp.key);
	}
	
	// 线性搜索
	public Node listSearch(LinkList L , int k){
		temp = L.nil.next; // 这个不用变
		while((temp != L.nil) && (temp.key!=k)){
			temp = temp.next;
		}
		if(temp == L.nil)
			return null;
		return temp;
	}
	
	public void listInsert(LinkList L ,Node x){
		// 是循环代码语句简洁
		// 谨慎使用哨兵，占据位置，衡量优缺点
		x.next = L.nil.next;// 表明是插入到开头甚至取代了 head...
		// 第二句一定在第三句前
		L.nil.next.prev = x; // 现在本来开头那个也指向了x，接下来就是讲 L的指向改为X
		L.nil.next = x; // 这句必须 第三
		// 只有第四句顺序随意。。。
		x.prev = L.nil; // 表头必备
	}
	
	// 一般通过 listSearch 找到这个元素看，再使用 listDelete 删除
	public void listDelete(LinkList L, Node x){
		
		if(x.prev!=L.nil)// 这样就不是表头
			x.prev.next = x.next; // 
		else
			L.nil.next = x.next;
		if(x.next != null)
			x.next.prev = x.prev;
		// 是不是应该释放一下 x？
		x = null; // 提醒JVM释放x
	}
	
	
	
	
	
	
}
