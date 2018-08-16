package lRUCache;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

class Node{
	int pageNumber;
	Node next;
	Node prev;
	
	Node(int pageNumber){
		this.pageNumber = pageNumber;
		this.prev = this.next = null;
	}
	
	 public String toString() {
	        return pageNumber + "  ";
	    }
}
class DoublyLinkedList{

	Node head;
	Node tail;
	int size;
	int currentSize;
	
	DoublyLinkedList(int size) {
		this.size = size;
		this.currentSize = 0;
	}
	
	public Node addPage(int pageNumber){
		// if head is null then inserted node will be the first node 
		if(head==null){
			Node new_node = new Node(pageNumber);
			head = new_node;
			tail = new_node;
			currentSize = 1;
			return new_node;
		}else if(currentSize<size){
			currentSize++;
		}else{
			tail = tail.prev;
			tail.next = null;
		}
		Node new_node = new Node(pageNumber);
		new_node.next = head;
		head.prev = new_node;
		head=new_node;
		
		return new_node;
		
	}

	public void setHeadTolatestNode(Node pageNode) {
		if(pageNode == null || pageNode==head){
			return;
		}
		
		if(pageNode == tail){
			tail = tail.prev;
			tail.next = null;
		}
		
		Node prev = pageNode.prev;
		Node next = pageNode.next;
		
		prev.next = next;
		
		if(next!=null){
			next.prev = prev;
		}
		
		pageNode.prev = null;
		pageNode.next = head;
		head.prev = pageNode;
		head = pageNode;
		
	}
	
	public void printList() {
        if(head == null) {
            return;
        }
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
    }
}
public class LRUCache {
	
	Map<Integer, Node> cacheMap;
	DoublyLinkedList list;
	
	public LRUCache(int size) {
		this.cacheMap = new HashedMap<Integer, Node>();
		this.list = new DoublyLinkedList(size);
	}

	public void getPage(int pageNumber){
		Node pageNode = null;
		if(cacheMap.containsKey(pageNumber)){
			pageNode = cacheMap.get(pageNumber);
			list.setHeadTolatestNode(pageNode);
		}else{
			pageNode = list.addPage(pageNumber);
			cacheMap.put(pageNumber, pageNode);
		}
		
	}
	
	   public void printCacheState() {
	       list.printList();
	        System.out.println();
	    }

	public static void main(String[] args) {
		int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.getPage(4);
        cache.printCacheState();
        cache.getPage(2);
        cache.printCacheState();
        cache.getPage(1);
        cache.printCacheState();
        cache.getPage(1);
        cache.printCacheState();
        cache.getPage(4);
        cache.printCacheState();
        cache.getPage(3);
        cache.printCacheState();
        cache.getPage(7);
        cache.printCacheState();
        cache.getPage(8);
        cache.printCacheState();
        cache.getPage(3);

	}

}
