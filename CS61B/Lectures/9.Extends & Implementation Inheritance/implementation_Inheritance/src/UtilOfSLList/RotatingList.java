package UtilOfSLList;

public class RotatingList <Unsigned> extends SLList<Unsigned> {
//如果是interface就用implements，是类就用extends。
//extends会将母类(SLList)中的方法，静态变量，实例变量，嵌套类全都继承给子类(RotatingList)。
//但是注意，不能继承母类的构造体，所以要求母类的构造体必须有一个不接收任何变量。

    public void rotateRight(){
        Unsigned x=removeLast();
        addFirst(x);
    }


    public static void main(String[] args){
        RotatingList<String> l=new RotatingList<>();
        //无法像interface inheritance一样，将第一个RotatingList改写为List，必须是一一对应的关系。

        l.addLast("a");
        l.addLast("b");
        l.addLast("c");
        l.addLast("d");
        l.addFirst("0");
        System.out.println("Before rotating the list right:");
        l.print();

        System.out.println();
        l.rotateRight();

        System.out.println("After rotating the list right:");
        l.print();
    }
}
