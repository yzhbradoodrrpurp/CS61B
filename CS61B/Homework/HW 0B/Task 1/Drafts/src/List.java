
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


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the initial number for the first list:");
        int start1=sc.nextInt();
        List l1=new List(start1);
        int next1=start1;

        System.out.println("Enter the initial number for the second list:");
        int start2=sc.nextInt();
        List l2=new List(start1);
        int next2=start2;

        while(!TestOfOne(next1)){
            if(TestOfEven(next1))
                next1/=2;
            else
                next1=next1*3+1;

            l1.AddLast(next1);
        }

        while(!TestOfOne(next2)){
            if(TestOfEven(next2))
                next2/=2;
            else
                next2=next2*3+1;

            l2.AddLast(next2);
        }

        int i,j;
        System.out.println("The whole first list is:");

        for(i=0;i<l1.size;i++){
            if(i!=l1.size-1)
                System.out.print(l1.SeeSomething(i)+",");
            else
                System.out.print(l1.SeeSomething(i)+".");
        }

        System.out.println("\n");
        System.out.println("The whole second list is:");

        for(j=0;j<l2.size;j++){
            if(j!=l2.size-1)
                System.out.print(l2.SeeSomething(j)+",");
            else
                System.out.print(l2.SeeSomething(j)+".");
        }

    }


}