package com.bridgeit.ObjectOrientedPrograms.utility;

import java.util.LinkedList;

public class StackLinkedList<T> {
		
		public LinkedList<T> link;
		
		public int top;
		
		public StackLinkedList() {
			link=new LinkedList<T>();
			top=-1;
		}
		
		public void push(T element) {
			top++;
			link.add(top, element);
		}
		
		public void pop() {
			if(top==-1)
				System.out.println("Stack is empty");
			else {
				link.removeLast();
				top--;
			}	
		}
		
		public boolean isEmpty() {
			return (top==-1);
		}
		
		public int size() {
			return link.size();
		}
		
		public T getElement(int index) {
			return link.get(index);
		}

}

