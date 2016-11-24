package com.prady.algorithms.tree;

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree(){
		root = null;
	}
	// Recursive Method
	public Node find(int data, Node node){
		if(node == null)
			return null;
		if(node.data == data)
			return node;
		else if(data < node.data)
			find(data, node.left);
		else
			find(data, node.right);
		return node;
	}

	//Non-Recursive Method
	public Node find(int data){
		Node node = root;
		boolean found = false;
		while(!found){
			if(node == null)
				break;
			if(node.data == data){
				found = true;
			}else if(data < node.data){
				node = node.left;
			}else{
				node = node.right;
			}
		}
		return node;
	}

	// Recursive
	/*public void add(int data, Node node){
		if (node == null){
			node = new Node(data);
		}else if(node.data > data){
			add(data, node.left);
		}else{
			add(data, node.right);
		}
	}*/
	
	//Recursive
	public Node add(Node node, int data){
		if(node == null){
			return new Node(data);
		}
		
		if(node.data > data)
			node.left= add(node.left, data);
		else
			node.right = add(node.right, data);
		return node;
	}
	
	// Recursive
	public void add(int data, Node node){
		if (root == null){
			root = new Node(data);
		}else if(node.data > data){
			if(node.left == null)
				node.left = new Node(data);
			else
				add(data, node.left);
		}else{
			if(node.right == null)
				node.right = new Node(data);
			else
				add(data, node.right);
		}
	}

	// Non-Recursive
	public void add(int data){
		boolean isAdded = false;
		Node node = root;
		while(!isAdded){
			if(root == null){
				root = new Node(data);
				isAdded = true;
			}
			else if(node.data > data){
				if(node.left != null)
					node = node.left;
				else{
					node.left = new Node(data);
					isAdded = true;
				}
			}
			else
				if(node.right != null)
					node = node.right;
				else{
					node.right = new Node(data);
					isAdded = true;
				}
		}        
	}

	//Recursive Traversal
	public void inOrderTraversal(Node node){
		if(node== null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}

	//Recursive
	public void preOrderTraversal(Node node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	//Recursive
		public void postOrderTraversal(Node node){
			if(node == null)
				return;
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
		
	class  Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 12, 14, 15};
		BinarySearchTree bst = new BinarySearchTree();
		for(int i :input)
			bst.root = bst.add(bst.root,i);
		System.out.println("InOrder");
		bst.inOrderTraversal(bst.root);
		System.out.println("\nPreOrder");
		bst.preOrderTraversal(bst.root);
		System.out.println("\nPostOrder");
		bst.postOrderTraversal(bst.root);
	}

}
