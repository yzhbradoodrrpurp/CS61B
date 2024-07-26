public class ListNestedClass{
    private static class Node{
        /*
        如图所示，类可以被定义在类之中。
        类Node可以被视作类ListNestedClass的特性，只能在ListNestedClass之中被访问，
        所以可以加上private。
        注意：private的含义是被定义的类，函数，变量只能在这个类中被访问。
        在这种情况下，类Node只能在ListNestedClass中被访问。
        */
        //如果类Node不访问Node以外的实例变量和函数的话，就加上static前缀。
        public int data;
        public Node cnct;

        public Node(int d,Node c){
            data=d;
            cnct=c;
        }
    }


    public Node chain;

    public ListNestedClass(int num){
        chain=new Node(num,null);
    }
    //此构造体充当初始化ListNestedClass类型变量的作用。


    public void AddFront(int x){
        chain= new Node(x,chain);
    }


    public int GetFirst(){
        return chain.data;
    }


    public void AddBack(int x){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        p.cnct=new Node(x,null);
    }


    public int GetLast(){
        Node p=chain;

        while(p.cnct!=null)
            p=p.cnct;

        return p.data;
    }


    public int LenOfList(){
        Node p=chain;
        int cnt=1;

        while(p.cnct!=null) {
            p=p.cnct;
            cnt++;
        }


        return cnt;
    }


    public static void main(String[] args){
        ListNestedClass l=new ListNestedClass(10);

        l.AddFront(15);
        l.AddFront(20);
        l.AddFront(25);

        int first=l.GetFirst();
        System.out.println("链表的第一个数值为："+first);

        l.AddBack(33);
        l.AddBack(78);
        l.AddBack(27);

        int last=l.GetLast();
        System.out.println("链表的最后一个数值为："+last);

        int len=l.LenOfList();
        System.out.println("链表的长度为："+len);
    }

}