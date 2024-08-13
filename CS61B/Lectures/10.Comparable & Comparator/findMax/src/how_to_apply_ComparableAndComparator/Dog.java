package how_to_apply_ComparableAndComparator;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    //可以对一个类实现Comparable并加上范型，名字为类的名字。
    public String name;
    public int size;

    public Dog(String a,int b){
        name=a;
        size=b;
    }


    //如果一个类实现了Comparable，那就必须写一个compareTo的方法。
    /*
    Comparable实际上是一种inteface，不过是Java库中自带的。
    compareTo是Comparable中唯一个方法，用于比较两个物体的大小。
     */
    @Override
    public int compareTo(Dog x){
        /*
        传入变量的类型为Dog，与类的名称相同。
        实际上是一个范型。
         */
        return this.size-x.size;
    }


    private static class nameComparator implements Comparator<Dog> {
    //用private是因为封装思想。
    //nameComparator是静态的，因为每个Dog都有一个nameComparator，属于每个Dog的固有属性。
    //Comparator有一个范型为Dog，compare中的Dog也是范型。

        @Override
         public int compare(Dog d1,Dog d2){
            return d1.name.compareTo(d2.name);
            /*
            这里用的不是我们自己写的compareTo方法，而是自带的。
            因为我们自己写的compareTo方法传入的变量类型是Dog，而这里是String。
             */
        }
    }


    public static Comparator<Dog> getNameComparator(){
        //因为nameComparator子类被封装了，所以需要这个方法。
        return new nameComparator();
    }

}
