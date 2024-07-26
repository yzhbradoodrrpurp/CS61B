public class Walrus {
    public String name;
    public double weight;
    public double height;

    public Walrus(String name1, double weight1, double height1){
        name=name1;
        weight=weight1;
        height=height1;
    }

    public static void main(String[] args) {
        Walrus a=new Walrus("Tommy",34,23);
        Walrus b;
        b=a;

        //Java中主要有两大类型的变量，一种是primitive variable(原始变量)，另一种是reference variable(引用变量)。
        //原始变量储存的就是对象(数据本身)，引用变量储存的是对象在内存中的地址。
        /*
        如图所示，new可以表示新分配了一个地址用来储存a的数据，那么a本身就表示地址类型。
        将a的值赋给b，就相当于将同一个地址给了b，那么a，b都指向同一个地址。
        在a，b地址下面的name，weight，height才存储的是具体的对象。
        */
        //注意：String不是原始变量，而是引用变量。

        a.name="Josh";
        a.weight=64;
        a.height=44;

        System.out.println(a.name+":"+a.weight+", "+a.height);
        System.out.println(b.name+":"+b.weight+", "+b.height);

        int[] array1=new int[]{1,2,3,4,5,6,7,8,9};
        int[] array2;
        array2=array1;
        //数组实际上也是一种引用变量，数组名储存的就是地址。
        //如图所示，在这种情况下，a、b指向的是同一块地址。

        array2[8]=0;
        array1[0]=9;

        int j,k;

        System.out.println("array1:");

        for(j=0;j<array1.length;j++){
            if(j!=array1.length-1)
                System.out.print(array1[j]+",");
            else
                System.out.print(array1[j]);

        }

        System.out.println();
        System.out.println("array2:");

        for(k=0;k<array2.length;k++){
            if(k!=array2.length-1)
                System.out.print(array2[k]+",");
            else
                System.out.print(array2[k]);

        }

    }
}