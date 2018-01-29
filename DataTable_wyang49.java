package hw6;

import java.util.ArrayList;

public class DataTable_wyang49<Key extends Comparable<Key>, Value> {
	
	private Node root;

	public DataTable_wyang49(){
		this.root = null;
	}
	
	public class Node{
		public Key k;
		public UserProfile_wyang49 value;  //this is the value
		public Node left;
		public Node right;
		
		public Node(Key k, UserProfile_wyang49 value){
			this.k=k;
			this.value=value;
		}
		
	}

	public UserProfile_wyang49 get(Key k){
		return get(root,k);
	}
	
	private UserProfile_wyang49 get(Node n, Key k){
		if (n==null){
			return null;
		}
		int temp=k.compareTo(n.k);
		if (temp<0){
			return get(n.left,k);
		}
		else if (temp>0){
			return get(n.right,k);
		}
		else 
			return n.value;
	}
	
	public void put(Key k, UserProfile_wyang49 value){
		root=put(root,k,value);
	}
	
	private Node put(Node n, Key k, UserProfile_wyang49 value){
		if (n==null){
			return new Node(k,value);
		}
		int temp=k.compareTo(n.k);
		if (temp<0){
			n.left=put(n.left,k,value);
		}
		else if (temp>0){
			n.right=put(n.right,k,value);
		}
		else{ 
			
			n.value = value;
		}
		
		
		return n;
	
	}
	
	
	public void clearParent(){
		Node curr = root;
		clearParent(root);
	}

	
	private void clearParent(Node curr){
		if(curr == null){
			return;
		}
		curr.value.parent = null;
		clearParent(curr.left);
		clearParent(curr.right);
	}
	

}
	
	
	

