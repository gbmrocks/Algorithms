package com.prady.algorithms.tree;

import java.util.*;

public class NAryTree {
	
	Node root;
	
	class Node{
		String data;
		ArrayList<Node> childList;
		boolean isLeaf = false;
		
		public Node(String _data){
			this.data 		= _data;
		}
		
		public Node addNode(String data, Node node){
			return new Node(data);
		}
	}
	
	
	int maxheight = 0;
	public int getHeight(Node node, int height){
		if(node == null)
			return height;
		height++;
		ArrayList<Node> children = node.childList;
		for(Node child: children){
			int tempHeight = getHeight(child, height);
			if(tempHeight>maxheight)
				maxheight = tempHeight;
		}
		return height;
	}
}
