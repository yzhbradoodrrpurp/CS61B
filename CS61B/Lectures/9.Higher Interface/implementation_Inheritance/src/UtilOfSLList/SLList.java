package UtilOfSLList;

public class SLList<Unsigned> {

    private class Node{
        public Unsigned data;
        public Node cnct;

        public Node(Unsigned x,Node y){
            data=x;
            cnct=y;
        }
    }


    private Node chain;
    private int size;

    public SLList(){
        chain=new Node(null,null);
        size=0;
    }

    public SLList(Unsigned x){
        chain=new Node(x,null);
        size=1;
    }


    public void addLast(Unsigned x){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;


        if(size==0)
            chain=new Node(x,null);
        else
            p.cnct=new Node(x,null);

        size++;
    }


    public void addFirst(Unsigned x){
        if(size==0)
            chain=new Node(x,null);
        else
            chain=new Node(x,chain);

        size++;
    }


    public Unsigned getLast(){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        return p.data;
    }



    public Unsigned removeLast(){
        Node p=chain;
        int i;

        for(i=0; i< size -2; i++){
            p=p.cnct;
        }

        Unsigned result=p.cnct.data;
        p.cnct=null;
        size--;

        return result;
    }



    public Unsigned getOne(int x){
        Node p=chain;
        int i;

        for(i=0;i<x;i++)
            p=p.cnct;

        return p.data;
    }


    public int getSize(){
        return size;
    }



    public void print(){
        Node p=chain;

        while(p.cnct!=null){
            System.out.println(p.data);
            p=p.cnct;
        }

        System.out.println(p.data);
    }


    public static void main(String[] args){
        SLList<String> l=new SLList<>();

        l.addLast("Natural high.");
        l.addLast("What a wonderful world.");
        l.addLast("I'm on a trip to Beihai.");
        l.addFirst("It won't take a long time before I finish the project.");

        System.out.println("The size of the list is: "+l.getSize()+".");
        System.out.println("The whole list is as follows:");
        l.print();
        System.out.println("The last item of the list is \""+l.getLast()+"\".");


        System.out.println();

        System.out.println("\""+l.removeLast()+"\" is removed from the list.");
        System.out.println("The current size of the list is: "+l.getSize()+".");

        System.out.println();

        System.out.println("The first item is \""+ l.getOne(0)+"\".");
    }

}