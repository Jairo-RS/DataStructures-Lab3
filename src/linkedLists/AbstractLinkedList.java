package linkedLists;

/* Public clones methods are usually not specified on interfaces.Abstract types
 * do not make it possible to access clone method.
 * The error (Object.clone() cannot hide the public abstract method) appears.
 */
public abstract class AbstractLinkedList implements LinkedList<Object>{

	public Object clone() throws CloneNotSupportedException {
		return super.clone();		
	}

}
