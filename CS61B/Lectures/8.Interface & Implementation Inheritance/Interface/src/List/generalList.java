package List;

public interface generalList<Unsigned> {
/*
interface是子类具有什么功能的蓝图，重点在于有什么而不是怎么做。
也可以写出怎么做，在最前方加上default就行。
 */
   public void addLast(Unsigned x);
   public Unsigned getLast();
   public Unsigned removeLast();
   public Unsigned getOne(int x);
   public int getSize();

   default public void print(){
   //default的函数在子类里也可以重写，优先级高于default。
   //函数的特征不能变，只是执行方式改变了。
       int i;

       for(i=0;i<getSize();i++)
           System.out.println(getOne(i));

   }

   //interface里的函数在子类里必须都有，并且一摸一样(default除外)。
   //public其实是多余的，但是还没有解释为什么。
}
/*
Override(重写):
当子类提供了一个与父类在方法签名（方法名、参数类型、参数数量）完全相同的方法实现时，就称为重写。
重写通常用于修改或扩展父类的方法行为。

Overload(重载):
当一个类中有多个方法名相同但参数不同（参数类型、参数数量或顺序不同）的方法时，就称为重载。
重载通常用于提供同一操作的不同实现方式。
 */