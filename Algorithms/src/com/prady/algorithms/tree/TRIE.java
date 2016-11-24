package com.prady.algorithms.tree;

public class TRIE {
	
	Node root;
	
	public void add(String input){
		char[] inputArray = input.toCharArray();
		if(root == null){
			root = new Node(null, null);
		}
		addChildren(inputArray, 0, root);
	}
	
	public Node addChildren(char[] inputArr, int pointer, Node currentNode){
		char c = (Character) inputArr[pointer];
		int index = (((int)c) - 65)%32;
		if(index>25)
			return null;
		if(currentNode.children[index]== null)
			currentNode.children[index] = new Node(c, currentNode);
		return (inputArr.length-1)==pointer?currentNode:addChildren(inputArr, pointer+1, currentNode.children[index]);
	}
	
	public void print(Node node){
		if(node == null)
			return;
		Node[] children = node.children;
		for(Node child:children){
			if(child !=null){
				System.out.println(child.value);
				print(child);
			}
		}
	}
	
	class Node<V>{
		int height = -1;
		V value;
		Node<V>[] children;
		
		public Node(V value, Node parent){
			this.value = value;
			this.children = new Node[26];
			height = (parent!=null)?parent.height+1 : 0;
		}
	}

	public void search(String value){
		System.out.println(value + ": " + (find(root, 0, value.toCharArray())?"Found":"Not found"));
	}
	
	public boolean find(Node node, int pointer, char[] input){
		if(pointer > input.length-1)
			return false;//System.out.println("Not found");
		char c 		= input[pointer];
		int index 	= ((int)c-65)%32;
		Node child = node.children[index];
		if(index>25 || child==null)
			return false;//System.out.println("Not found");
		else if(pointer == input.length-1){
			return true;
		}else{
			return find(child, pointer+1, input);
		}
	}
	
	public static void main(String[] args){
		String[] inputArr = {"hello", "hat", "hen", "hair"};
		TRIE trie = new TRIE();
		for(String input:inputArr){
			trie.add(input);
		}
//		trie.print(trie.root);
		trie.search("hello");
		trie.search("cat");
		trie.search("hair");
	}
}
