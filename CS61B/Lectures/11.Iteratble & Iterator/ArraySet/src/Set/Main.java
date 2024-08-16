package Set;

import java.util.Iterator;

public class Main{
    public static void main(String[] args) {
        arraySet<String> s1=new arraySet<>();

        s1.add("haha");
        s1.add("Good");
        s1.add("morning");


        /*
        以下四行就是增强型for循环的底层原理。
         */
        Iterator<String> see=s1.iterator();

        while(see.hasNext())
            System.out.println(see.next());

        System.out.println();

        /*
        如果arraySet类不实现Iterable，那么就不能使用增强型for循环。
         */
        for(String i:s1)
            System.out.println(i);

        System.out.println();

        System.out.println(s1);
    }
}
