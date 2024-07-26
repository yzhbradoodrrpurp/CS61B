//Recursion version of Hailstone.

import java.util.Scanner;

public class Hailstone_ {
    public static class Node{
        public int num;
        public Node cnct;

        public Node(int x,Node y){
            num = x;
            cnct = y;
        }
    }


    public Node chain;
    public int size=1;

    public Hailstone_(int x){
        chain=new Node(x,null);
    }


    public void AddLast(int x){
        Node p=chain;

        while(p.cnct!=null){
            p=p.cnct;
        }

        size++;
        p.cnct=new Node(x,null);
    }


    public void NextNum(int x){
        if(x!=1){
           if(x%2==0){
                AddLast(x/2);
                NextNum(x/2);
           }else{
               AddLast(3*x+1);
               NextNum(3*x+1);
           }
       }
    }


    public int SeeSomething(int x){
        Node p=chain;
        int i;

        for(i=0;i<x-1;i++){
            p=p.cnct;
        }

        return p.num;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int start=sc.nextInt();
        int x=start;
        Hailstone_ l=new Hailstone_(x);

        l.NextNum(x);
        l.AddLast(1);

        int i;

        for(i=1;i<l.size;i++){
            if(i!=l.size-1)
                System.out.print(l.SeeSomething(i)+", ");
            else
                System.out.print(l.SeeSomething(i)+".");
        }

    }

}
