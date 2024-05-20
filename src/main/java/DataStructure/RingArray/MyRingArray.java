package DataStructure.RingArray;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class MyRingArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private  int size;

    public MyRingArray() {
        this(1);
    }
    @SuppressWarnings("unchecked")
    public MyRingArray(int size){
        this.size =size;
        this.arr= (T[]) new Object[size];
        this.start =0;
        this.end = 0;
        this.count   = 0;
    }

    public void resize(int newSize){
        T[] newArr = (T[]) new Object[newSize];
        for (int i =0;i<count;i++){
            newArr[i] =arr[i];
        }
        arr = newArr;
        end = count;
        size = newSize;
    }
    public void addFirst(T val){
        if(isFull()){
            resize(size*2);
        }
        start = (start-1+size)%size;
        arr[start] =val;
        count++;
    }
    public void removeFirst(){
        if(isEmpty()){
            throw  new IllegalStateException();
        }
        arr[start]=null;
        start = (start+1)%size;
        count--;
        if(count>0&&count==size/4){
            resize(size/2);
        }
    }
    public void addLast(T val){
        if(isFull()){
            resize(size*2);
        }
        arr[end] = val;
        end = (end+1)%size;
        count++;
    }
    public void removeLast(){
        if(isEmpty()){
            throw   new IllegalStateException();
        }
        end = (end-1+size)%size;
        arr[end] = null;
        count--;
        if(count>0&&count==size/4){
            resize(size/2);
        }
    }
    public T getFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }
    public T getLast(){
        if(isEmpty()){
            throw new IllegalStateException("Array is empty");
        }
        return arr[(end-1+size)%size];
    }

    private boolean isFull() {
        return count==size;
    }
    public boolean isEmpty(){
        return count==0;
    }
}
