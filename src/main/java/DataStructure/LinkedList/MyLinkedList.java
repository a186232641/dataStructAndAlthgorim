package DataStructure.LinkedList;

import java.util.NoSuchElementException;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class MyLinkedList<E> {


    private static class Node<E>{

        E val;
        Node<E> next;
        Node<E> prev;
        Node(E val){
            this.val = val;
        }
    }
    private int size;
    final  private  Node<E> head,tail;
    public MyLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev=head;
        this.size = 0;
    }
    public void addLast(E e){
        Node<E> x= new Node<>(e);
        Node<E> temp = tail.prev;
        temp.next = x;
        x.prev = temp;
        x.next = tail;
        tail.prev = x;
        size++;
    }
    public void addFrist(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        temp.prev = x;
        x.next = temp;
        x.prev = head;
        head.next = x;
        size++;
    }
    public void add(int index,E element){
        checkPositionIndex(index);
        if(index == size){
            addFrist(element);
            return;
        }
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        Node<E> x = new Node<>(element);
        p.prev = x;
        temp.next =x;
        x.prev = temp;
        x.next = p;
        size++;

    }
    public E removeFirst(){
        if(size<1){
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        Node<E> temp = x.next;
      head.next = temp;
      temp.prev = head;
      x.prev =null;
      x.next =null;
      size--;
      return x.val;
    }

    public E removeLast(){
        if(size<1){
            throw new NoSuchElementException();
        }
        Node<E> x = tail.prev;
        Node<E> temp = x.prev;
        temp.next =tail;
        tail.prev =temp;
        x.next=null;
        x.prev = null;
        size --;
        return x.val;
    }
    public E remove(int index){
        checkElementIndex(index);
        Node<E> x = getNode(index);
        Node<E> temp = x.prev;
        temp.next = x.next;
        x.next.prev = temp;
        x.next =null;
        x.prev = null;
        size--;
        return  x.val;
    }
    public E get(int index){
        checkElementIndex(index);
        Node<E> node = getNode(index);
        return  node.val;
    }
    public E getFrist(){
        if(size<1){
            throw  new NoSuchElementException();
        }
        return head.next.val;
    }
    public E getLast(){
        if(size<1){
            throw  new NoSuchElementException();
        }
        return  tail.prev.val;
    }
    public E set(int index,E e){
        checkElementIndex(index);
        Node<E> node = getNode(index);
        E oldVal = node.val;
        node.val = e;
        return oldVal;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = head.next; p != tail; p = p.next) {
            System.out.print(p.val + " -> ");
        }
        System.out.println("null");
        System.out.println();
    }
    private Node<E> getNode(int index) {
        Node<E> p =head.next;
        for(int i =0;i<index;i++){
            p =p.next;
        }
        return p;
    }

    private void checkPositionIndex(int index) {
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + "Size:"+ size);
        }
    }

    private boolean isElementIndex(int index) {
        return index>=0&&index<size;
    }
    private void checkElementIndex(int index) {
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + "Size:"+ size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index>=0&&index<size;
    }
}
