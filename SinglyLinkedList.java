public class SinglyLinkedList<E> {
  //---------------- nested Node class ----------------

  private static class Node<E> {
    private E[] element; // Declaring that an element is an Array of type E
    private Node<E> next; // reference to the subsequent node in the list

    @SuppressWarnings("unchecked")
    public Node( Node<E> n) { // constructing a node with element E and location n//
      element = (E[])new Object[8];
      next = n;


    }

    public E[] getElement( ) { //Returns an element within the node.
      return element;
    }


    public Node<E> getNext() {
      return next; //Returns the next node (Array)
    }

    public void setNext(Node<E> n) {
      next = n;
    }
  } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list


    public SinglyLinkedList() {
      // constructs an initially empty list
      //We want to construct a SinglyLinkedList which accepts arrays as arguments.

      }

    // access methods
    public int size() {
      return size;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public E[] first() {
      // returns (but does not remove) the first node
      if (isEmpty()) return null;
      return head.getElement();
    }

    public E[] last() {
      // returns (but does not remove) the last node
      if (isEmpty()) return null;
      return tail.getElement();
    }

    // update methods
    public void addLast() {
      // adds element e to the end of the list
      Node<E> newest = new Node<>( null); // node will eventually be the tail
      if (isEmpty())
        head = newest; // special case: previously empty list
      else
        tail.setNext(newest); // new node after existing tail
      tail = newest; // new node becomes the tail
      size++;
    }

    public void addFirst() {
      // adds node  to the front of the list
      head = new Node<>( head);// create and link a new node
      if (size == 0)
        tail = head; // special case: new node becomes tail also
      size++;
    }

    public E[] removeFirst() { // removes and returns the first node
      if (isEmpty()) return null; // nothing to remove
      E[] answer = head.getElement();
      head = head.getNext(); // will become null if list had only one node
      size--;
      if (size == 0)
        tail = null; // special case as list is now empty
      return answer;
    }
  }
