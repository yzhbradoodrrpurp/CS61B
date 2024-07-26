public class SList<Unsigned>{
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
    public int len=1;

    public SList(Unsigned x){
        chain=new Node(x,null);
    }


    public void AddFirst(Unsigned x){
        chain=new Node(x,chain);
        len++;
    }


    public void AddLast(Unsigned x){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        p.cnct=new Node(x,null);
        len++;
    }


    public Unsigned GetFirst(){
        return chain.data;
    }


    public Unsigned GetLast(){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        return p.data;
    }


    public void RemoveFirst(){
        chain=chain.cnct;
        len--;
    }


    public void RemoveLast(){
        Node p=chain;
        int i;

        for(i=0;i<len-2;i++){
            p=p.cnct;
        }

        p.cnct=null;
        len--;
    }

    public static void main(String[] args){
        SList<String> l=new SList<>("What's up, my dawg?");
        //如图所示，Unsigned被String所替代，那么就对x输入String类型的变量。

        l.AddFirst("Hahaha, I'm fine. By the way, how do you do?");
        l.AddFirst("Really fine, thanks.");

        l.AddLast("Yepppp");
        l.AddLast("Ahhaaaaaa");

        System.out.println(l.GetFirst());
        System.out.println(l.GetLast());

        l.RemoveFirst();
        l.RemoveLast();

        System.out.println(l.GetFirst());
        System.out.println(l.GetLast());
    }

}