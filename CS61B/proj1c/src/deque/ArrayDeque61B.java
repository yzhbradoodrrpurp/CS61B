package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private  int size;

    public ArrayDeque61B(){
        items=(T[])new Object[8];
        nextFirst=3;
        nextLast=4;
        size=0;
    }

    @Override
    public void addFirst(T x) {
        if(x==null)
            return;

        if(size==items.length)
            resize(2*items.length);

        items[nextFirst]=x;

        if(nextFirst==0)
            nextFirst=items.length-1;
        else
            nextFirst--;

        size++;
    }

    @Override
    public void addLast(T x) {
        if(x==null)
            return;

        if(size==items.length)
            resize(2*items.length);

        items[nextLast]=x;

        if(nextLast==items.length-1)
            nextLast=0;
        else
            nextLast++;

        size++;
    }

    private void resize(int newLength){
        T[] newItems=(T[])new Object[newLength];

        if(nextFirst<nextLast){
            System.arraycopy(items,0,newItems,0,nextLast);
            System.arraycopy(items,nextFirst+1,newItems,newLength-(size-1-nextFirst),size-1-nextFirst);
            nextFirst=newLength-(size-1-nextFirst)-1;
        }else if(nextLast<nextFirst){
            System.arraycopy(items,0,newItems,0,size);
            nextFirst=newLength-1;
            nextLast=size;
        }

        items=newItems;
    }

    @Override
    public List<T> toList() {
        if(size==0)
            return null;

        List<T> returnValue=new ArrayList<>();
        int i;

        for(i=0;i<size;i++)
            returnValue.add(get(i));

        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        if(size==0)
            return true;

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        int removedId;

        if(nextFirst== items.length-1) {
            removedId = 0;
            nextFirst=0;
        }else {
            removedId = nextFirst + 1;
            nextFirst++;
        }

        T returnValue=items[removedId];

        size--;

        if(size<=items.length/4 && items.length>8)
            resizeDown();

        return returnValue;
    }

    @Override
    public T removeLast() {
        int removedId;

        if(nextLast== 0) {
            removedId=items.length-1;
            nextLast=items.length-1;
        }else{
            removedId=nextLast-1;
            nextLast--;
        }

        T returnValue=items[removedId];

        size--;

        if(size<=items.length/4 && items.length>8)
            resizeDown();

        return returnValue;
    }

    private void resizeDown(){
        T[] newItems=(T[])new Object[items.length/2];

        if(nextFirst<nextLast){
            System.arraycopy(items,nextFirst+1,newItems,0,nextLast-nextFirst-1);
            nextLast=nextLast-nextFirst;
            nextFirst=newItems.length-1;
        }else if(nextFirst>nextLast){
            System.arraycopy(items,0,newItems,0,nextLast);
            System.arraycopy(items,nextFirst+1,newItems,newItems.length-(items.length-nextFirst-1),items.length-nextFirst-1);
            nextFirst=newItems.length-(items.length-nextFirst-1)-1;
        }

        items=newItems;
    }

    @Override
    public T get(int index) {
        if(index<0||index>=size)
            return null;

        int start=nextFirst+1;
        int id=start+index;

        if(id>=items.length){
            int distanceToEnd=items.length-1-start;
            id=index-distanceToEnd-1;
        }

        return items[id];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    @Override
    public boolean equals(Object x){
        if(x instanceof ArrayDeque61B other){
            if(this.size!=other.size)
                return false;

            for(int i=0;i<size;i++){
                if(this.get(i)!=other.get(i))
                    return false;
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        if(size==0)
            return null;

        StringBuilder returnValue=new StringBuilder();
        int cnt=0;
        returnValue.append("[");

        for(int i=0;i<size;i++){
            returnValue.append(get(i));

            if(i<size-1)
                returnValue.append(", ");
        }

        returnValue.append("]");

        return returnValue.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int presentPos;

        public ArrayListIterator(){
            presentPos=0;
        }

        @Override
        public boolean hasNext(){
            if(presentPos<size)
                return true;
            else
                return false;
        }

        @Override
        public T next(){
            T returnValue=items[presentPos];
            presentPos++;

            return returnValue;
        }
    }

}
