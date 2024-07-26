public class Dog1 {
    public String name;
    public int weight;
    //能在一个类(class)里直接定义变量，被称为实例变量(instance variable)。
    /*
    public的作用：有public修饰符的变量能够被其它包(package)的类访问，
    没有public修饰符的变量只能被同一个包的类访问。
     */

    public static String scientificName="Canis familiaris";
    //类中也能有静态的变量，但这个变量应该避免被更改。同时，在调用的时候写作Dog1.scientificName，而不用具体的对象名。

    public Dog1(String nameOfdog, int weightOfdog){
        name=nameOfdog;
        weight=weightOfdog;
    }
    //这就是构造器(constructor)。
    //构造器的作用是从外部(一般是main函数)中接收变量，并传给某个对象的实例变量。

    public void MakeNoise(){
        //函数里调用了实例变量，所以函数不能有static修饰符。
        if(name=="wolf"){
            if(weight>=30)
                System.out.println("Arrooooo");
            else
                System.out.println("Waaawaaa");
        }else if(name=="chihuahua"){
            if(weight>=15)
                System.out.println("Gigooogiooo");
            else
                System.out.println("Yappppp");
        }
    }
    /*
    具体解释；在 Java 中，静态方法不能直接访问实例变量，
    这是因为静态方法属于类本身，而实例变量属于类的具体对象。

    静态方法在类加载时就存在，而实例变量只有在创建对象时才存在。
    因此，静态方法在没有对象的情况下不能访问实例变量。

    实例变量依赖于具体对象的状态，每个对象都有自己独立的实例变量。
    如果允许静态方法直接访问实例变量，无法确定应该访问哪个对象的实例变量。
    */


    public static void main(String[] args) {
        Dog1 d1 = new Dog1("wolf",30);
        Dog1 d2 = new Dog1("chihuahua",15);
        //正如前文所说，实例变量依赖于具体对象，所以用如图的方法定义具体对象d1，d2.
        //这种方法与之前的上一个方法的不同之处在于使用了构造器。
        //使用了构造器的话，括号里就必须有对应的变量。

        d1.MakeNoise();
        d2.MakeNoise();
        //调用具体对象的非静态函数。
    }
}