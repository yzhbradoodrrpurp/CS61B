package ListAndNode;

import java.util.Scanner;

public class List{
    public Node chain;
    /*
    Node这个构造体放在package中的另一个Java文件中，
    包括了具体的数值data和用于连接的cnct。
     */
    //然后创建了一个Node类型的实例变量chain。

    public List(int x){
        chain=new Node(x,null);
    }
    //这是关于List的构造体，描述了chain是如何被初始化的。
    //这样的方式间接地将IntList中那种递归的形式隐藏了起来。
    /*
    整个这一套的逻辑就是，List类型下有一个Node类型变量chain，
    Node类型下有一个int类型变量data和Node类型变量cnct。
    NAME.chain.data表示具体的数值，
    NAME.chain.cnct表示连接或者null。
     */


    public void AddFront(int x){
        chain=new Node(x,chain);
    }


    public int GetFirst(){
        int result=chain.data;

        return result;
    }


    public void AddBack(int x){
        Node p=chain;

        while(p.cnct!=null)
            p = p.cnct;

        p.cnct=new Node(x,null);
    }


    public int GetLast(){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        return p.data;
    }


    public int LenOfList(){
        int cnt=1;
        Node p=chain.cnct;

        while(p!=null) {
        p=p.cnct;
        cnt++;
        }

        return cnt;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("输入链表的第一个数值：");
        int num=sc.nextInt();
        List l= new List(num);
        //如图所示，可以通过直接输入一个数字的方式构建链表，而不用像上次一样一直null。
        //相当于l.chain==(num,null);

        System.out.println("添加一个数值到链表的首位：");
        int num1=sc.nextInt();
        l.AddFront(num1);
        //此函数用于添加一个数值到链表的最前面。

        System.out.println("添加一个数值到链表的末位：");
        int num2=sc.nextInt();
        l.AddBack(num2);

        int first=l.GetFirst();
        int last=l.GetLast();
        System.out.println("链表的第一个数值为"+first+"。");
        System.out.println("链表的最后一个数值为"+last+"。");

        int len=l.LenOfList();
        System.out.println("链表的长度为"+len+"。");

        sc.close();
    }

}
