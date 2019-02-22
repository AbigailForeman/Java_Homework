public class LinkedArrayQueue<E> {
  //don't forget the member data


  private int front = 0;
  private int back = 0;

  private SinglyLinkedList<E> list;


  //the default constructor
  @SuppressWarnings("unchecked")
  public LinkedArrayQueue(
  ) {
    list = new SinglyLinkedList<> ();
  }

  //return the number of elements in the queue
  public int size() {
    if (list.size() == 0) return 0;
    return back - front;
  }

  //return the number of arrays currently storing elements
  public int numArrays() {
    return list.size ( );
  }

  //test if the queue is empty
  public boolean isEmpty() {
    return list.isEmpty ( );
  }

  //return the element at the front of the queue. return null if queue is empty
  public E first() {
    if (list.isEmpty ()) return null;
    return list.first ()[front%8];

  }

  //return the element at the back of the queue. return null if queue is empty
  public E last() {
    if(list.isEmpty ()) return null;
    return list.last ()[back%8-1];
  }

  //push e to the back of the queue.
  public void enqueue(E e) {
    // adds element e to the end of the list
    if (back%8 ==0) {
      list.addLast ();
    }
    list.last()[back%8]= e;
    back++;
  }

  //pop and return the element at the front of the queue. return null if queue is empty
  public E dequeue() {
      E ans = list.first ()[front%8];
    list.first()[front%8] = null;
    front++;
    if(front%8==0)
    {
      list.removeFirst ();
    }
    return ans;
  }
}