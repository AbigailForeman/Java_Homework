

//Note that <E extends Comparable>. Therefore you should use Comparable
//instead of Object while creating arrays and casting them to generic type.
//Also use compareTO() instead of < or > while comparing generic elements
public class MaxMinStack<E extends Comparable<E>> {

  private E[ ] data;
  private E[ ] MaxArray;
  private E[ ] MinArray;

  private int t = -1;


  public static final int DEFAULT_CAPACITY=10;
  int capacity;

  //the default constructor
  @SuppressWarnings("unchecked")
  public MaxMinStack() {
   this(DEFAULT_CAPACITY);
  }
  //another constructor which returns a stack of specified size
  @SuppressWarnings("unchecked")
  public MaxMinStack(int sz) {
    data = (E[ ]) new Comparable[sz];
    MaxArray = (E[ ]) new Comparable[sz];
    MinArray = (E[ ]) new Comparable[sz];
    this.capacity = sz;
  }
  //return the element on top of the stack without removing it. return null if stack is empty.
  @SuppressWarnings("unchecked")
  public E top() {
    if (t == -1) return null;
    return data[t];
  }

  //return the number of elements in the stack
  public int size() {
    return (t + 1);
  }

  //test if the stack is empty
  public boolean isEmpty() {
    if(top() == null){
      return true;
    } else {return false;}
  }
  //return the actual capacity of the stack(not the number of elements stored in it).
  public int capacity() {
    return capacity;
  }
  //return the maximum value stored in the stack. return null if stack is empty.
  public E maximum() {
    if (isEmpty( )) return null;
    return MaxArray[t];
  }
  //return the minimum value stored in the stack. return null if stack is empty.
  public E minimum() {
    if (isEmpty( )) return null;
    return MinArray[t];
  }
  //push a new element onto the stack
  public void push(E e) throws IllegalStateException {
    if (size() == data.length) throw new IllegalStateException("Stack is full");
    if (isEmpty()) {
      MaxArray[t + 1] = e;
      MinArray[t + 1] = e;
    } else {
      if (maximum().compareTo(e) < 0) {
        MaxArray[t + 1] = e;
        MinArray[t + 1] = MinArray[t];
      }
      else if (minimum().compareTo(e) > 0) {
        MinArray[t + 1] = e;
        MaxArray[t + 1] = MaxArray[t];
      } else {
        MinArray[t + 1] = MinArray[t];
        MaxArray[t + 1] = MaxArray[t];
      }
    }
      data[++t] = e; // increment t before storing new it
  }

  //pop the element on top of the stack and return it. return null if stack is empty.
  public E pop() {
    if (isEmpty( )) return null;
    E answer = data[t];
    data[t] = null; // dereference to help garbage collection
    MinArray[t] = null;
    MaxArray[t] = null;
    t--;
      return answer;
  }
}