package com.bridgeit.ObjectOrientedPrograms.utility;

import java.util.LinkedList;

/**
 * @author bridgeit
 *
 * @param <T>Generic Type
 */
public class QueueLinkedList<T> {
		
		public LinkedList<T> queue;
		
		public int topOfElement;
		
		public QueueLinkedList() {
			queue=new LinkedList<T>();
			topOfElement=-1;
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
		public void enqueue(T element) {
				topOfElement++;
				queue.add(topOfElement, element);
		}
		
		public void dequeue() {
			if(queue.isEmpty())
				System.out.println("Queue Empty");
			else
				queue.removeFirst();
		}
		
		public int size() {
			return queue.size();
		}
		
		public void print() {
			System.out.println(queue);
		}
		
		public T get(int index){
			return queue.get(index);
		}
}
