package indexList;

import java.lang.reflect.Array;

import linkedLists.LinkedList;
import linkedLists.Node;

public class LLIndexList<E> implements IndexList<E> {
	private LinkedList<E> internalLL;  

	/**
		Creates an empty instance of a list. 
	 **/ 
	public LLIndexList(LinkedList<E> theList) 
	{ 
		internalLL = theList;
	}

	/**
		Determines the size of the list. 
		@return size of the list � number of elements. 
	 **/
	public int size() { 
		return internalLL.length(); 
	} 

	/** 	
		Determines if the list is empty. 	
		@return true if empty, false if not. 
	 **/ 
	public boolean isEmpty() { 
		return this.size() == 0; 
	} 
	
	/**
	Private method to access the data node at the
    position given in the internal linked list. 
    If the list is not empty, he first data node 
    has position 0, the following data node (if any)
    has position 1, and so on. 
    @param posIndex the index of the position being 
           accessed. 
    @return reference to the data node in the given
           position of the internal linked list. 
	 **/
	private Node<E> getDataNodeAtPosition(int posIndex)
	{ 
		
		Node<E> target = internalLL.getFirstNode(); 
		for (int p=1; p<= posIndex; p++)
			target = internalLL.getNodeAfter(target); 
		return target; 
	} 

	/** 
		Adds a new element to the list. 
		@param i the index of the position where the 
			new element is to be inserted. 
		@param e the new element to insert. 
		@throws IndexOutOfBoundsException if the index
			i does not corresponds to the index 
			of a valid position to insert�
	 **/ 
	public void add(int index, E e) 
	throws IndexOutOfBoundsException 
	{
		if (index < 0  ||  index > internalLL.length()) 
			    throw new IndexOutOfBoundsException("add: " 
				+ "index=" + index + " is out of bounds. size = " + 
				internalLL.length());

     	Node<E> nuevoNodo = internalLL.createNewNode();
     	nuevoNodo.setElement(e); 
		if (index==0) 
       		internalLL.addFirstNode(nuevoNodo); 
		else { 
			Node<E> nodoPrevio = 
				getDataNodeAtPosition(index-1); 
			internalLL.addNodeAfter(nodoPrevio, 
				nuevoNodo); 
		}
	}

	public void add(E e) { 
     	Node<E> nuevoNodo = internalLL.createNewNode();
     	nuevoNodo.setElement(e); 
		Node<E> nodoPrevio = 
			internalLL.getLastNode(); 
		internalLL.addNodeAfter(nodoPrevio, 
			nuevoNodo); 
    	
	}
	
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0  ||  index >= internalLL.length()) 
		    throw new IndexOutOfBoundsException("get: " 
			+ "index=" + index + " is out of bounds.");

		Node<E> targetINode = this.getDataNodeAtPosition(index);
		return targetINode.getElement(); 
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0  ||  index >= internalLL.length()) 
		    throw new IndexOutOfBoundsException("remove: " 
			+ "index=" + index + " is out of bounds.");

		Node<E> ntr = this.getDataNodeAtPosition(index); 
		E etr = ntr.getElement(); 
		this.internalLL.removeNode(ntr); 

		return etr;
	}

	public E set(int index, E e) throws IndexOutOfBoundsException {
		if (index < 0  ||  index >= internalLL.length()) 
		    throw new IndexOutOfBoundsException("set: " 
			+ "index=" + index + " is out of bounds.");

		Node<E> ntc = this.getDataNodeAtPosition(index); 
		E etr = ntc.getElement(); 
		ntc.setElement(e); 
		return etr; 
	}

	public Object[] toArray() {
		Object[] newArray=new Object[size()];
		for (int i=0; i<size(); i++) {	
			newArray[i] = get(i);
		}
		return newArray;
	}
	
	public <T1> T1[] toArray(T1[] array) {
		if(array.length<size()){
			array = (T1[])Array.newInstance(array.getClass().getComponentType(), size());
		} 
		else {
			for (int j=0; j<array.length; j++) {
				array[j] = null;
			}
		}
		for(int i=0;i<size(); i++) {
			array[i] = (T1) get(i);
		}
		return array;
	}
	

}
