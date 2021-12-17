package com.dataStructures.hashTables;

public class HashTable {

	public static void main(String[] args) throws Exception {
		HashTable table = new HashTable();
		table.insert("Suraj", "Me");
		table.insert("Punam", "Me");
		System.out.println(table.size());
		table.insert("Suraj", "Myself");
		System.out.println(table.size());
		System.out.println(table.get("Suraj"));
		System.out.println(table.get("Punam"));
		System.out.println(table.delete("Punam"));
		System.out.println(table.size());
		System.out.println(table.get("Punam"));
		
		for(int i=0;i<15;i++) {
			table.insert(Integer.valueOf(i), "Test");
		}
		System.out.println(table.size());
		table.insert("Punam", "Me");
	}

	int size = 0;
	int threshold = 16;
	Object[] bucket;

	public HashTable() {
		bucket = new Object[threshold];
	}

	public HashTable(int size) {
		this.threshold = size;
		bucket = new Object[size];
	}

	public int size() {
		return size;
	}

	public void insert(Object key, Object value) throws Exception {
		if (size < threshold) {
			int hash = hashFunction(key);
			int index = getIndex(hash);
			Node nodeToInsert = new Node(hash, key, value, null);
			if (bucket[index] == null) {
				bucket[index] = nodeToInsert;
				size++;
			} else {
				boolean replaced = false;
				Node traveseNode = (Node) bucket[index];
				if (traveseNode.getNext() == null) {
					if (traveseNode.getKey().equals(key)) {
						traveseNode.setValue(value);
						replaced = true;
					}
				} else {
					while (traveseNode.getNext() != null) {
						if (traveseNode.getKey().equals(key)) {
							traveseNode.setValue(value);
							replaced = true;
							break;
						} else {
							traveseNode = traveseNode.getNext();
						}
					}
				}
				if (!replaced) {
					traveseNode.setNext(nodeToInsert);
					size++;
				}
			}
		} else {
			throw new Exception("Dynamic Nature needs to be implimented");
		}
	}

	public Object get(Object key) {
		Object value = null;
		int hash = hashFunction(key);
		int index = getIndex(hash);
		if (bucket[index] == null) {
			return value;
		} else {
			Node traveseNode = (Node) bucket[index];
			while (traveseNode.getNext() == null) {
				if (traveseNode.getKey().equals(key)) {
					value = traveseNode.getValue();
					break;
				}
			}
		}
		return value;
	}

	public Object delete(Object key) {
		Object value = null;
		int hash = hashFunction(key);
		int index = getIndex(hash);
		if (bucket[index] == null) {
			return value;
		} else {
			Node currentNode = (Node) bucket[index];
			if (currentNode.getNext() == null) {
				if (currentNode.getKey().equals(key)) {
					value = currentNode.getKey();
					bucket[index] = null;
					size--;
				}
			} else {
				Node previous = currentNode;
				while (currentNode.getNext() != null) {
					if (currentNode.getKey().equals(key)) {
						Node temp = currentNode;
						currentNode = currentNode.getNext();
						previous.setNext(currentNode);
						value = temp.getKey();
						size--;
						break;
					} else {
						previous = currentNode;
						currentNode = currentNode.getNext();
					}
				}
			}
		}
		return value;
	}

	public int getIndex(int hash) {
		return hash % threshold;
	}

	private int hashFunction(Object key) {
		int hash = 0;
		if (key == null) {
			return hash;
		}
		int h = key.hashCode();
		hash = h ^ (h >>> 16);
		return hash;
	}

	private class Node {
		final int hash;
		final Object key;
		Object value;
		Node next;

		Node(int hash, Object key, Object value, Node next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getHash() {
			return hash;
		}

		public Object getKey() {
			return key;
		}
	}
}
