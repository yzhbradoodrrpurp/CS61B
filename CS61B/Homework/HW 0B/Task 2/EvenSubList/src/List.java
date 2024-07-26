//This method takes a list List<Integer> L and returns a new list containing the even numbers of the given list.
// If there are no even elements, it should return an empty list.
//原链表的数值内容由Hailtone改编而来。

import java.util.Scanner;

public class List {
    public static class Node{
        public int num;
        public Node cnct;

        public Node(int x,Node y){
            num=x;
            cnct=y;
        }
    }


    public Node chain;
    public int size=1;

    public List(int x){
        chain=new Node(x,null);
    }


    public void AddLast(int x){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        p.cnct=new Node(x,null);
        size++;
    }


    public static boolean TestOfOne(int x){
        if(x==1)
            return true;
        else
            return false;
    }


    public static boolean TestOfEven(int x){
        if(x%2==0)
            return true;
        else
            return false;
    }


    public int SeeSomething(int x){
        Node p=chain;
        int i;

        for(i=0;i<x;i++)
            p=p.cnct;

        return p.num;
    }


    public List FindEven(List l1){
        Node p=chain;

        while(p.cnct!=null){
            if(p.num%2==0){
                if(l1==null)
                    l1=new List(p.num);
                else
                    l1.AddLast(p.num);
            }

            p=p.cnct;
        }

        if(p.num%2==0)
            l1.AddLast(p.num);

        return l1;
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the initial number:");
        int start=sc.nextInt();

        List l=new List(start);
        int next=start;

        while(!TestOfOne(next)){
            if(TestOfEven(next))
                next/=2;
            else
                next=next*3+1;

            l.AddLast(next);
        }

        int i;
        System.out.println("The whole list is:");

        for(i=0;i<l.size;i++){
            if(i!=l.size-1)
                System.out.print(l.SeeSomething(i)+",");
            else
                System.out.print(l.SeeSomething(i)+".");
        }

        //The first list is shown above.
        //To find the even numbers of the first list is as followed.

        List l1=null;
        l1=l.FindEven(l1);

        if(l1!=null){
            int j;
            System.out.println("\nThe even numbers of list are:");

            for(j=0;j<l1.size;j++){
                if(j!=l1.size-1)
                    System.out.print(l1.SeeSomething(j)+",");
                else
                    System.out.print(l1.SeeSomething(j)+".");
            }
        }else{
            System.out.println("\nThe even sublist is empty.");
        }

    }

}