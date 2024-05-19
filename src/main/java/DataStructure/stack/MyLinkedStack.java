package DataStructure.stack;

import java.util.LinkedList;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class MyLinkedStack <E>{
    private LinkedList<E> list = new LinkedList<>();
    public void push(E e){
        list.add(e);
    }
    public E pop(){
        E e = list.removeLast();
        return e;
    }
    public E peek(){
        return  list.getLast();
    }
    public int size(){
        return  list.size();
    }
}
