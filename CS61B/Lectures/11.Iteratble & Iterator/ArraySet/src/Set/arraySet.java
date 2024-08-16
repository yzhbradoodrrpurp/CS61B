package Set;

import java.util.Iterator;

public class arraySet<T> implements Iterable<T>  {
    /*
    set和list类似，但是加入set中的元素是无序的，而list是有序的。
    另外，set不能重复储存同一个元素。
     */

    /*
    Iterable是一个java自带的interface，有了它就能够识别for(int i:...)的增强for循环。
    Iterable自带一个iterator方法，所以必须重载。
     */

    public T[] items;
    public int size;

    public arraySet(){
        items=(T[]) new Object[10];
        size=0;
    }

    public void add(T x){
        if(isRepeated(x))
            return;

        if(size==items.length)
            resize(2*items.length);

        items[size]=x;
        size++;
    }

    private boolean isRepeated(T x){
        if(contains(x))
            return true;

        return false;
    }

    public boolean contains(T x){
        int i;

        for(i=0;i<size;i++){
            if(items[i].equals(x))
                return true;
        }

        return false;
    }

    private void resize(int newLength){
        T[] newItems = (T[]) new Object[newLength];

        System.arraycopy(items,0,newItems,0,size);
        items=newItems;
    }

    /*
    这就是需要重载Iterable的方法，用于传回一个Iterator类型的变量。
    由于还没有Iterator类型的变量，所以必须再写一个Iterator类型的类，如下所示。
     */
    @Override
    public Iterator<T> iterator() {
        return new arraySetIterator();
    }

    /*
    toString和equals这两个方法都是对象Object所拥有的方法，
    可以对这两个方法进行重写。
     */

    /*
    System.out.print(x)和System.out.println实际上是先将x转化为字符串，
    即x.toString()，然后再对其进行输出。
    所以如果我们想要更改某一类型的输出方法，可以重写toString。
     */
    @Override
    public String toString(){
        //StringBuilder是一种新的数据类型，简单理解为可以追加的字符串，速度更快。
        StringBuilder result=new StringBuilder();

        //追加的方式为sth.append(...);
        result.append("[");

        //增强型for循环，this即s1，每一个都是s1中的元素。
        for(T i:this) {
            //这里的toString是默认的，不是我们正在重写的，下面return的result也一样。
            result.append(i.toString());
            result.append(",");
        }

        result.append("]");

        return result.toString();
    }

    /*
    注意：equals方法中传入的变量类型为Object，变量的名称随意。
     */
    @Override
    public boolean equals(Object x){
        /*
        if中内容的意思是，先判断x的dynamic type是不是arraySet，
        如果是的话，先返回true，然后给x一个新的名称otherArraySet且static type为arraySet；
        如果不是的话，那么就返回false，结束if语句的执行。
         */
        if(x instanceof arraySet otherArraySet){
            if(size!=otherArraySet.size)
                return false;

            for(T i:this){
                /*
                contains的主体是list，set等等数据结构。
                 */
                if(!otherArraySet.contains(i))
                    return false;
            }

            return true;
        }


        return false;
    }

    /*
    这就是属于自定义的arraySet的Iterator，记得实现Iterator。
    注意Iterator也有需要重载的方法，hasNext和next。
    */
   private class arraySetIterator implements Iterator<T>{
       private int presentPos;

       public arraySetIterator(){
           presentPos=0;
       }

       /*
       hasNext返回一个boolean类型的变量，当有下一个元素时返回true，否则返回false。
        */
       @Override
       public boolean hasNext() {
           if(presentPos<size)
               return true;
           else
               return false;
       }

       /*
       next的功能是返回一个当前位置的值并且将位置移动到下一个单元。
        */
       @Override
       public T next(){
           T returnValue=items[presentPos];
           presentPos++;

           return returnValue;
       }
    }
}