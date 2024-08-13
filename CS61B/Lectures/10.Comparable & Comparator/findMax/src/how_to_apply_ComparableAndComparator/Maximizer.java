package how_to_apply_ComparableAndComparator;

import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] x){
        /*因为传入的d类型为Dog，那么x的动态类型就Dog，
        后面的compareTo方法就会用Dog中的compareTo。
         */
        int maxid=0;
        int i;

        for(i=0;i<x.length;i++){
            int cmp=x[i].compareTo(x[maxid]);

            if(cmp>0)
                maxid=i;
        }

        return x[maxid];
    }

    public static void main(String[] args) {
        Dog d1=new Dog("Corgi",15);
        Dog d2=new Dog("Chihuahua",6);
        Dog d3=new Dog("Blonde",23);
        Dog d4=new Dog("Husky",9);

        Dog[] d={d1,d2,d3,d4};

        Dog maxDog=(Dog)max(d);
        //max的类型是Comparable，需要用到强制类型转换为Dog。
        System.out.println(maxDog.name);

    //--手动分割线，以上为comparable，以下为comparator。----------------

        Dog d5=new Dog("Oski",100);
        Dog d6=new Dog("Cerebus",99999);
        Comparator<Dog> nc=Dog.getNameComparator();
        //Dog.getNameComparator得到nameComparator类型，是Comparator的一种。
        //定义nc是为了使用nameComparator的compare方法，如下所示。
        int cmp=nc.compare(d5,d6);


        if(cmp>0)
            System.out.println(d5.name);
        else if(cmp<0)
            System.out.println(d6.name);
        else
            System.out.println("Both are the same.");
    }
}
