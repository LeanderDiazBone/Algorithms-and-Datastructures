package Datenstrukturen;

public class AVLTree {
	private Node root;
	public AVLTree(){
		root = null;
	}
	public void insert(int value) {
		if(root == null){
			Node n = new Node(null, value);
			root = n;
		}else{
			Node parrent = insertSearch(value);
			Node n = new Node(parrent, value);
			if(parrent.value < value){
				parrent.left = n;
			}else{
				parrent.right = n;
			}
			rebalance(n);
		}
	}
	public Node search(int value) {
		Node current = root;
		while(current != null){
			if(current.value == value){
				return current;
			}else if(current.value < value){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return null;
	}
	//returns the parrent of the the new Node we want to insert and adjusts the balances on the way
	public Node insertSearch(int value){
		if(root == null) return null;
		Node current = root;
		Node parrent = current;
		while(current != null){
			parrent = current;
			if(current.value < value){
				current = current.left;
				current.balance--;
			}else{
				current = current.right;
				current.balance++;
			}
		}
		return parrent;
	}
	public void delete(int value) {
		
	}
	public void rebalance(Node n) {
		
	}
	public void leftRotation(Node n) {
		
	}
	public void rightRotation(Node n) {
		
	}
	
}
class Node{
	Node parrent;
	Node right;
	Node left;
	int value;
	int balance;
	public Node(Node parrent, int value) {
		this.parrent = parrent;
		this.value = value;
		right = null;
		left = right;
		balance = 0;
	}
}