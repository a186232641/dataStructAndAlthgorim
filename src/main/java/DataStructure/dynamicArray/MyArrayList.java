package DataStructure.dynamicArray;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class MyArrayList<E> {


    private E[] data;
    private int size;
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    public void addLast(E e) {
        int cap = data.length;
        if (cap == size) {
            resize(2 * cap);
        }
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        int cap = data.length;
        if(size == cap){
            resize(2*size);
        }
        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public E removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }
        int cap = data.length;
        if(size == cap/4){
            resize(cap/2);
        }
        E deletedVal = data[size-1];
        data[size-1] = null;
        size--;
        return  deletedVal;
    }
    public  E remove(int index){
        checkElementIndex(index);
        int cap =data.length;
        if(size == cap/4){
            resize(cap/2);
        }
        E deletedVal = data[index];
        for(int i = index+1;i<size;i++){
            data[i-1] =data[i];
        }
        data[size-1] =null;
        size--;
        return  deletedVal;

    }
    public E removeFirst(){
        return remove(0);
    }
    public E get(int index){
        checkPositionIndex(index);
        return  data[index];
    }
    public E set(int index,E e){
        checkElementIndex(index);
        E oldVal = data[index];
        data[index] = e;
        return oldVal;
    }
    public  int size(){
        return  size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
    }
