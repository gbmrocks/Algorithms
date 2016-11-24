package com.prady.algorithms.hashtable;

import java.util.*;

public class HashMap<K,V> {

	private float loadFactor;
	private Entry<K,V>[] table;
	private int elementCount;
	
	
	public HashMap(){
		table 			= new Entry[3];
		elementCount 	= 0;
		loadFactor 		= 0.75f;
	}
	/**
	 * Hashing Method
	 * @param h
	 * @return
	 */
	private int hash(int h){
		h ^= (h>>>20)^(h>>>12);
		return h^(h>>>7)^(h>>>4);
	}

	private void resize(){
		int newLength 		= (int) (table.length * 1.5);
		Entry<K,V>[] newTable 	= new Entry[newLength];
		for(int i=0; i<table.length; i++){
			newTable[i]		= table[i];
		}
		table = newTable;
	}

	public void put(K key, V value){
		if(elementCount>table.length*loadFactor)
			resize();
		int index = hash(key.hashCode())%table.length;
		if(table[index] == null){
			table[index]	= new Entry<K,V>(key, value);
			elementCount++;
		}else{
			Entry<K, V> currentEntry = table[index];
			while(currentEntry != null){
				if(currentEntry.getKey().equals(key)){
					currentEntry.setValue(value);
					elementCount++;
					break;
				}
				if(currentEntry.next==null)
					break;
				currentEntry = currentEntry.next;
			}
			currentEntry.setNext(new Entry<K,V>(key,value));
			elementCount++;
		}
	}

	public V get(K key){
		int index = hash(key.hashCode())%table.length;
		if(table[index] == null)
			return null;
		Entry<K,V> current = table[index];
		while(current != null){
			if(current.getKey().equals(key)){
				return current.getValue();
			}
			current = current.next;
		}
		return null;
	}


	//TODO
	public Set<K> keySet(){
		return null;
	}

	public class Entry<K,V>{
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K _key, V _value){
			this.key	= _key;
			this.value	= _value;
		}

		public void setKey(K key){
			this.key = key;
		}

		public K getKey(){
			return key;
		}

		public void setValue(V _value){
			this.value = _value;
		}

		public V getValue(){
			return value;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}
	}


}
