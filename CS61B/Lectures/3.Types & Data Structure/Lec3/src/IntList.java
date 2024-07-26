import java.util.Scanner;
import java.util.Arrays;

public class IntList {
    public int data;
    public IntList next;

    public IntList(int d,IntList n) {
        data = d;
        next = n;
    }


//区别以下几种函数的构建方式：
    public static int SizeOfList1(IntList l) {
        int size=1;

       if(l.next==null)
           return size;
       else
           return SizeOfList1(l.next)+1;
    }
    //用静态函数的构建方式，变量的传入用function(NAME);


    public int SizeOfList2(){
        int size=1;

        if(next==null)
            return size;
        else
            return next.SizeOfList2()+1;

    }
    //用非静态函数的构建方式，变量的传入用NAME.function();
    //变量的传入步骤中的括号里也可以有内容，具体取决于定义时有无内容。


    public static int SizeOfList3(IntList l) {
        int size=1;
        IntList p=l.next;

        while(p!=null){
            p=p.next;
            size++;
        }

        return size;
    }
    //前面两种方式都是用递归的方法，这一种方式是遍历。


    public static int GetNum(IntList l,int addr) {
        IntList p=l;
        int i;

        for(i=0;i<addr;i++){
            p=p.next;
        }

        int num=p.data;

        return num;
    }

    public static void main(String[] args) {
        IntList l1=new IntList(1,null);
        l1.next=new IntList(2,null);
        l1.next.next=new IntList(3,null);
        //链表的第一种方式。

        IntList l2=new IntList(3,null);
        l2=new IntList(2,l2);
        l2=new IntList(1,l2);
        //链表的第二种方式。

        //两种链表的区别在于构建的顺序不一样。
        //第一种是按照顺序的方式构建1，2，3。
        //第二种是按照逆序的方式构建1，2，3。

        int size11= SizeOfList1(l1);
        int size12= SizeOfList1(l2);

        int size21=l1.SizeOfList2();
        int size22=l2.SizeOfList2();

        int size31=SizeOfList3(l1);
        int size32=SizeOfList3(l2);

        System.out.println(size11+" "+size21+" "+size31);
        System.out.println(size12+" "+size22+" "+size32);

        Scanner sc=new Scanner(System.in);

        int addr1=sc.nextInt();
        int addr2=sc.nextInt();

        int num1=GetNum(l1,addr1);
        int num2=GetNum(l2,addr2);

        System.out.println(num1);
        System.out.println(num2);

        int[] arr1=new int[]{1,2,3};
        int[] arr2=new int[]{4,5,6};

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
