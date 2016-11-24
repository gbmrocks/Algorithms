package com.prady.algorithms.tree;

public class AVLTree{
	
	Node root;
	
	public Node add(Node node, int data){
		if(node == null){
			return new Node(data); 
		}
		if(node.data>data){
			node.left = add(node.left, data);
		}else{
			node.right = add(node.right, data);
		}
		node.height = Math.max(height(node.left), height(node.right))+1;
		return balance(node);
//		return node;
	}
	
	public int height(Node node){
		return node==null? 0: node.height;
	}
	
	//TODO
	public Node balance(Node node){
		int heightDiff = height(node.left) - height(node.right);
		if(Math.abs(heightDiff)>1){
			if(heightDiff>0){									//Longer left
				Node child = node.left;
				if(height(child.left)- height(child.right) > 0){ //Need right right balance(single rotate)
					child = rightRotation(child);
				}else{											//Need Left right balance (double rotate)
					child = leftRotation(child);
					child = rightRotation(child);
				}
				node.left = child;
			}else{												//Longer Right 
				Node child = node.right;
				if(height(child.left)-height(child.right) < 0){ 	// right right longer(single rotate)
					child = leftRotation(child);
				}else{ 											// right left longer(double rotate)
					child = rightRotation(child);
					child = leftRotation(child);
				}
				node.right = child;
			}
			node.height = Math.max(height(node.left), height(node.right)) + 1;
		}
		return node;
	}
	
	public Node leftRotation(Node pivot){
		
		Node newRoot 	= pivot.right;
		pivot.right		= newRoot.left;
		pivot 			= newRoot;
		
		pivot.left.height = Math.max(height(pivot.left.left), height(pivot.left.left.right));
		pivot.height	= Math.max(height(pivot.left), height(pivot.right))+1;		
		return pivot;
	}
	
	public Node rightRotation(Node pivot){
		Node newRoot	= pivot.left;
		pivot.right 	= newRoot.left;
		pivot 			= newRoot;

		pivot.right.height = Math.max(height(pivot.right.right), height(pivot.right.left));
		pivot.height	= Math.max(height(pivot.left), height(pivot.right))+1;
		return pivot;
	}
	
	public void traverse(Node node){
		if(node == null)
			return;
		traverse(node.left);
		System.out.println(node.data);
		traverse(node.right);
	}
	
	class Node{
		int height;
		Node left, right;
		int data;
		public Node(int _data){
			this.data 	= _data; 
			this.height = 1;
		}
	}
	
	public static void main(String[] args){
		AVLTree avl = new AVLTree();
		int[] input = {44,70,11,93,56,67,23,68,69};
		for(int i:input)
			avl.root = avl.add(avl.root, i);
		avl.traverse(avl.root);
		System.out.println("height: " + avl.root.height);
	}
}
