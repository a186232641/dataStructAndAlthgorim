package DataStructure.queue;

import java.util.LinkedList;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class MyQueue<E>{
    private LinkedList<E> list = new LinkedList<>();
    public void push(E e){
        list.add(e);
    }
    public E pop(){
        return  list.removeFirst();
    }
    public E peek(){
        return list.getFirst();
    }
    public int size(){
        return list.size();
    }
}
