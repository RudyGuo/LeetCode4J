package LRU_Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	class Node{
		int key;
		int val;
		Node pre;
		Node next;
		Node(int key,int val){
			this.key = key;
			this.val = val;
		}
	}
	
	Node head = new Node(-1,-1);
	Node tail = new Node(-1,-1);
	private void moveToTail(Node no){
		this.removeNode(no);
		no.pre = tail.pre;
		no.next = tail;
		tail.pre.next = no;
		tail.pre = no;
	}
	
	private void addNode(Node no){
		no.pre = tail.pre;
		no.next = tail;
		tail.pre.next = no;
		tail.pre = no;
	}
	
	private void removeNode(Node no){
		no.pre.next = no.next;
		no.next.pre = no.pre;
	}
	
	private Node getHead(){
		return head.next;
	}
	Map<Integer,Node> map = new HashMap<>();
    int cap;
    int count = 0;
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
    	Node res = map.get(key);
        if(res == null) {
        	return -1;
        }else{
        	int val = res.val;
        	this.moveToTail(res);
        	return val;
        }
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		Node res = map.get(key);
    		res.val = value;
    		this.moveToTail(res);
    	}else{
    		count++;
    		if(count>cap){
    			Node rem = this.getHead();
    			map.remove(rem.key);
    			rem.val = value;
    			this.moveToTail(rem);
    			map.put(key, rem);
    		}else{
    			Node nod = new Node(key,value);
				this.addNode(nod);
				map.put(key, nod);
    		}
    	}
    }
    
    public static void main(String args[]){
    	LRUCache lc = new LRUCache(1);
    	lc.set(2, 1);
    	System.out.println(lc.get(1));
    }
}
