package List;

public class AList<Unsigned> implements generalList<Unsigned>{

    private Unsigned[] items;
    private int size;

    public AList(){
        items=(Unsigned[])new Object[100];
        //数组的范型定义如上所示，比一般的范型定义更为复杂。
        size=0;
    }


    @Override
    //@Override标识符起到一个提示作用，如果不加也没关系。
    //但如果不是重写函数但却加了@Override标识符，则会报错。
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


    @Override
    public Unsigned getLast(){
        return items[size-1];
    }


    @Override
    public Unsigned removeLast(){
        Unsigned x=items[size-1];
        size--;

        return x;
    }


    @Override
    public Unsigned getOne(int x){
        if(x>size-1)
            return null;

        return items[x];
    }


    @Override
    public int getSize(){
        return size;
    }


    public static void main(String[] args){
        generalList<String> l1=new AList<>();
        //可以定义为AList也可以定义为generalList。

        l1.addLast("Hello");
        l1.addLast("good morning");
        l1.addLast("letsgoo");

        System.out.println("The longest part is \""+WordUtils.findLongest(l1)+"\".");
        System.out.println();

        System.out.println("The contents of l1 are as follows:");
        l1.print();
    }

}