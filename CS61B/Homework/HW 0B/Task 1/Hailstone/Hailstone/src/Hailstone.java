/*
This method takes an int n as input and returns its hailstone sequence as a list of integers.
The hailstone sequence is defined by the following procedure: pick a positive integer n as the start.
If n is even, divide n by 2. If n is odd, multiply n by 3 and add 1. Continue this process until n is 1.
*/

import java.util.Scanner;

public class Hailstone{
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

    public Hailstone(int x){
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


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the initial number:");
        int start=sc.nextInt();

        Hailstone l=new Hailstone(start);
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

    }


}