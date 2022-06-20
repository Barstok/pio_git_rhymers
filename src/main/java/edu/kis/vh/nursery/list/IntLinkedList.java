package edu.kis.vh.nursery.list;


public class IntLinkedList {

	private class Node {

		private int value;
		protected Node prev;
		protected Node next;
	
		public Node(int i) {
			value = i;
		}
	
		public int getValue() {
			return value;
		}
	
		public Node getPrev() {
			return prev;
		}
	
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	
		public Node getNext() {
			return next;
		}
	
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

	private Node last;
	private int i;

	/**
	 * dodaj element na koniec listy
	 * @param i - element do dodania
	 */
	public void push(int i) {
		if (getLast() == null)
			setLast(new Node(i));
		else {
			getLast().setNext(new Node(i));
			getLast().getNext().setPrev(getLast());
			setLast(last.getNext());
		}
	}

	/**
	 * metoda sprawdza czy lista jest pusta
	 * @return true - lista jest pusta
	 */
	public boolean isEmpty() {
		return getLast() == null;
	}

	/**
	 * sprawdza czy lista jest pusta
	 * @return false
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * metoda zwraca wartość ostatniego elementu z listy
	 * @return wartość ostatniego elementu lub -1 jeśli lista jest pusta
	 */
	public int top() {
		if (isEmpty())
			return -1;
		return getLast().getValue();
	}

	/**
	 * metoda zwraca wartość i usuwa ostatni element z listy
	 * @return wartość ostatniego elementu lub -1 jeśli lista jest pusta
	 */
	public int pop() {
		if (isEmpty())
			return -1;
		int ret = getLast().getValue();
		setLast(getLast().getPrev());
		return ret;
	}

	/**
	 * @return zwraca ostatni węzeł listy
	 */
	public Node getLast() {
		return last;
	}

	/**
	 * @param last
	 */
	public void setLast(Node last) {
		this.last = last;
	}

	/**
	 * @return pozycja iteratora
	 */
	public int getI() {
		return i;
	}

}
