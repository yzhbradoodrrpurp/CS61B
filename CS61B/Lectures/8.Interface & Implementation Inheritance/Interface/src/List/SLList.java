package List;

public class SLList<Unsigned> implements generalList<Unsigned>{
    //Unsigned是一个自定义符号，表示范型。
    //其表达的意思是，Unsigned是暂时不确定的一个类型。
    public class Node{
        //因为用了Unsigned占位符，所以不能在类Node前加上static。
        //Unsigned定义在类Node外面。
        public Unsigned data;
        public Node cnct;

        public Node(Unsigned x,Node y){
            data=x;
            cnct=y;
        }
    }


    public Node chain;
    public int size;

    public SLList(Unsigned x){
        chain=new Node(x,null);
        size=1;
    }


    @Override
    public void addLast(Unsigned x){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        p.cnct=new Node(x,null);
        size++;
    }


    @Override
    public Unsigned getLast(){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        return p.data;
    }


    @Override
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


    @Override
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


    @Override
    public void print(){
    //对于interface中default print的重写，优先级高于default。
        Node p=chain;

        while(p.cnct!=null){
            System.out.println(p.data);
            p=p.cnct;
        }
    }


    public static void main(String[] args){
        generalList<String> l2=new SLList<>("Hello");

        l2.addLast("how do you do");
        l2.addLast("win");

        System.out.println("The longest part is \""+WordUtils.findLongest(l2)+"\".");
        System.out.println();

        System.out.println("The contents of l2 are as follows:");
        l2.print();
    }

}