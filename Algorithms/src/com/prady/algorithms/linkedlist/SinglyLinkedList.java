package com.prady.algorithms.linkedlist;

class SinglyLinkedList{

	private static Node head;

	public static void main(String[] args){

		SinglyLinkedList linkedList = new SinglyLinkedList();
		int[] inputArray    = {5, 12, 43, 99, 1, 20};
		for(int i = 0; i < inputArray.length; i++){
			linkedList.addLast(inputArray[i], head);
		}

		Node list = head;
		if(head == null)
			System.out.println("Null Head");
		while(list != null && list.next != null){
			System.out.println(list.data);
			list = list.next;
		}
	}

	//Recursive Implementation
	public void addLast(int i, Node node){

		/*if(node == null)
			head = new Node(i);
		else if(node.next == null)
			node.next = new Node(i);
		else
			addLast(i, node.next);*/
		
		if(node == null)
			node = new Node(i);
		else
			addLast(i,node.next);

	}

	// Loop Implementation
	public void addLast(int i){
		if(head == null){
			head = new Node(i);        
		}else{
			Node next    = new Node(i);
			Node  tail    = head;
			while(tail.next != null){
				tail= tail.next;
			}
			tail.next = next;
		}
	}
	
	
	
	class Node{
		int data;
		Node next;

		public    Node(int data){
			this.data = data;    
		}

		public void setNext(Node next){
			this.next = next;
		}

		public Node getNext(){
			return next;
		}
	}
}

