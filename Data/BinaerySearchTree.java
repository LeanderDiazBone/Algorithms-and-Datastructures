package Datenstrukturen;

@SuppressWarnings("rawtypes")
public class BinaerySearchTree<T extends Comparable> {
	public static void main(String[] args){
		System.out.println("Hallo");
	}
	BSTNode<T> root;
	public BinaerySearchTree() {
		root = null;
	}
	public boolean search(T value) {
		return searchRec(root, value);
	}
	@SuppressWarnings("unchecked")
	public boolean searchRec(BSTNode<T> n, T value) {
		if(n == null) {
			return false;
		}
		if(n.value.equals(value)) {
			return true;
		}else if(n.value.compareTo(value) < 0) {
			return searchRec(n.right, value);
		}else {
			return searchRec(n.left, value);
		}
		
	}
	@SuppressWarnings("unchecked")
	public void insert(T value) {
		BSTNode<T> par = searchParrent(value);
		BSTNode<T> n = new BSTNode<T>(value);
		if(par == null) {
			root = n; return;
		}
		n.parrent = par;
		if(par.value.compareTo(value) < 0) {
			par.right = n;
		}else {
			par.left = n;
		}
	}
	@SuppressWarnings("unchecked")
	public BSTNode<T> searchParrent(T value){
		if(root == null) {
			return null;
		}
		BSTNode<T> par = root;
		BSTNode<T> current;
		if(par.value.compareTo(value) > 0) {
			current = par.left;
		}else {
			current = par.right;
		}
		while(current != null) {
			par = current;
			if(par.value.compareTo(value) > 0) {
				current = par.left;
			}else {
				current = par.right;
			}
		}
		return par;
	}
	public String toString() {
		return DFSPostorder(root);
	}
	public boolean isBinearySearchTree() {
		if(root == null) {
			return true;
		}
		return isBSTRec(root);
	}
	public boolean isBSTRec(BSTNode<T> n) {
		if(n.left == null && n.right == null) {
			return true;
		}
		if(n.left != null &&(!isBSTRec(n.left) || !n.left.compare(n))) {
			return false;
		}
		if(n.right != null &&(!isBSTRec(n.right) || n.right.compare(n))) {
			return false;
		}
		return true;
	}
	public String DFSPostorder(BSTNode<T> n) {
		String s = "";
		if(n == null) {
			return s;
		}else {
			String s1 = DFSPostorder(n.left);
			String s2 = DFSPostorder(n.right);
			s = s1 + " " + n.value + " "+ s2;
		}
		return s;
	}
}
@SuppressWarnings("rawtypes")
class BSTNode<T extends Comparable>{
	BSTNode<T> left;
	BSTNode<T> right;
	BSTNode<T> parrent;
	T value;
	public BSTNode(T value){
		this.value = value;	
		this.parrent = null;
		this.left = null;
		this.right = null;
	}
	//true wenn kleiner gleich
	@SuppressWarnings("unchecked")
	public boolean compare(BSTNode<T> n) {
		if(this.value.compareTo(n.value) <= 0) {
			return true;
		}else {
			return false;
		}
	}
}