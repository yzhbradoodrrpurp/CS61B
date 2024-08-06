public class AList<Unsigned>{

    private Unsigned[] items;
    private int size;

    public AList(){
        items=(Unsigned[])new Object[100];
        //数组的范型定义如上所示，比一般的范型定义更为复杂。
        size=0;
    }


    public void addLast(Unsigned x){
        if(size==items.length)
            expandArray(2*size);

        items[size]=x;
        size++;
    }


    private void expandArray(int capacity){
        Unsigned[] a=(Unsigned[])new Object[capacity];

        System.arraycopy(items,0,a,0,size);
        //将items的内容复制给a。
        items=a;
        //将a的地址给items。
    }


    public Unsigned getLast(){
        return items[size-1];
    }


    public Unsigned removeLast(){
        Unsigned x=items[size-1];
        size--;

        return x;
    }


    public Unsigned getOne(int x){
        if(x>size-1)
            return null;

        return items[x];
    }


    public static void main(String[] args){
        AList<String> l=new AList<>();

        l.addLast("letsgooo");
        l.addLast("whatswrong");
        l.addLast("yepright");

        System.out.println("The removed item is \""+l.removeLast()+"\".");
        System.out.println("The last item after removal is \""+l.getLast()+"\".");
        System.out.println("The first item after removal is \""+l.getOne(0)+"\".");
    }

}