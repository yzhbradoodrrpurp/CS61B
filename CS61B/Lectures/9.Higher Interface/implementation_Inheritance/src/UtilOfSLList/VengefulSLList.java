package UtilOfSLList;

public class VengefulSLList<Unsigned> extends SLList<Unsigned>{

    private SLList<Unsigned> removedOnes;

    public VengefulSLList(){
        removedOnes = new SLList<>();
    }

    public VengefulSLList(Unsigned x){
        super(x);
        /*
        有两种方式来重载VengefulSLList，这一种必须要加super(x)，
        否则就仍然会像第一种方式一样初始化没有数值的SLList。
         */

        removedOnes = new SLList<>();
    }


    @Override
    public Unsigned removeLast(){
        Unsigned x=super.removeLast();
        //super的作用是去到这个类的母类，再找到removeLast()函数。

        /*
        之所以要用super而不把SLList里removeLast()直接复制过来，
        是因为SLList里的chain,size,Node都是private的，无法被SLList以外的类所访问。
        这样的思想被称作封装。
         */

        removedOnes.addLast(x);

        return x;
    }


    public void printRemovedOnes(){
        removedOnes.print();
    }


    public static void main(String[] args){
        VengefulSLList<Integer> l=new VengefulSLList<>();
        //不能定义为SLList，因为SLList类型没有记录删除内容的功能。

        l.addFirst(48);
        l.addLast(1);
        l.addLast(4);
        l.addFirst(6);
        l.addLast(8);
        l.addLast(99);
        l.addFirst(34);
        l.addLast(55);

        System.out.println("Before removal:");
        l.print();


        l.removeLast();
        l.removeLast();
        l.removeLast();

        System.out.println("Before removal:");
        l.print();

        System.out.println("Before removal:");
        l.print();

        System.out.println("Removed ones:");
        l.printRemovedOnes();
    }

}
