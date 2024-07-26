import java.util.Scanner;

public class HelloWorld{
    //Java中的所有代码都必须写在class, interfaces以内。
    //定义一个class的方式是public class CLASSNAME。

    public static int FindTheMax(int x,int y){
        //目前来说，所有的函数包括主函数，前面都必须加上public static+TYPE+NAME。
        //必须加上public static的原因后面会解释。
        if(x>y){
            return x;
        }else{
            return y;
        }
    }


    public static String Greeting(String name){
        return "Hello,"+name;
        //注意：在print或者返回时，不同部分之见要用+连接起来。
    }


    public static void main(String[] args){
        //Java和C语言一样也有一个main函数。
        //main的定义方式如图所示，注意String中的S必须大写。

        System.out.println("Hello World!");
        System.out.print("不换行。");
        //Java中的输出如图所示，注意System中的S必须大写。
        //如果输出一段话，要在话的两端加上双引号；如果输出一个变量，则直接在括号内打上变量名。
        //输出的时候会自动换行，println的意思是print line。
        //如果想要不换行，则用System.out.print("...");

        System.out.println(5+"Hello World!");

        int x=0;
        while(x<=10){
            System.out.println(x);
            x++;
        }
        //如图所示，Java是强类型语言，一个变量在使用之前必须被定义类型并且不能被转换，和C语言一样。
        //while的用法和C语言一样，x++,x+=1等等都可以使用。
        //Java中，if,else,while,for的用法都和C语言完全一样。

// Java中函数的使用：
        int a=40,b=50;
        System.out.println(FindTheMax(a,b));
        /*
        如图所示，我在class里，main函数的前方定义了一个int类型的FindTheMax函数，
        定义函数时用public static+类型+名称+(类型+传入数据名称)。
        在main函数中将a，b传入FindTheMax函数里比较大小并返回结果，
        语法和C语言完全一样。
        */

//Java中变量的类型：
        int num1=10;
        double num2=4.5;
        //如图所示，Java中大致上有4个类型的变量，整数int，浮点数double，字符串String，字符char，判断类型boolean。
        //int有最大和最小值的限定，double也有最大和最小值的限定。

        String sentence="What's up?";
        char ch='A';
        // String的内容用双引号括起来，可以是任意文本；char只表示单个字符，用单引号括起来。
        //注意区别：Java中的字符串String不带[]，C语言中的字符串定义为char a[]。
        // 同时，Java中的字符串是不能像C语言那样直接遍历的。我们要么使用charAT()函数，要么就将其转换为数组。

        int[] array=new int[]{1,2,3,4,5,6,7,8,9,10};
        double[] array2=new double[]{1,2,3,4,5,6,7,8,9,10};
        char[] array3=new char[]{'f','u','c','k'};
        String[] array4=new String[]{"a","b","c","d","e","f"};
        boolean[] array5=new boolean[]{true,false};
        //如图所示：数组的定义方式是这样的，引用时就用array[NUM}。
        /*
        数组的另一种定义方式：
        int[] array=new int[NUM];
        array[NUM1]=...;
        array[NUM2]=...;
        array[NUM3]=...;
        注意在定义时，NUM必须要有。
        */

        boolean test=true;
        //boolean类型变量只有两个值，true和false。

        System.out.println(Greeting("Zhihangyi"));
        //如图所示，我在前文中定义了一个Greeting函数，输入名字就可以对这个人进行打招呼。
        //在main函数中引用时，要对字符串打上双引号。

//Java中字符串的补写和相关函数：
        sentence+=" How are you?";
        System.out.println(sentence);
        //能直接通过+的方式对字符串进行补写，不要用-,*,/等符号，因为没有意义。

        int len=sentence.length();
        System.out.println(len);
        //NAME.length()这个函数表示字符串NAME的长度，类型为int。

        String subsentence=sentence.substring(1,4);
        System.out.println(subsentence);
        //NAME.substring(num,num’)这个函数能够表示NAME字符串中从第num到num‘-1个字符串。
        //注意：字符串和C语言一样从0开始计数。

        ch=sentence.charAt(6);
        System.out.println(ch);
        //正如前文所提及到的一样，NAME.charAt(num)函数能够将字符串NAME中第num个字符传输出来。

        num1=sentence.indexOf("you");
        System.out.println(num1);
        //NAME.indexOf("...")表示...第一个字母在NAME中的位置，返回类型为int。
        //indexOf()可以查找单个字符的位置，要打上单引号。
        // indexOf()也可以通过变量名查找位置，这时就不需要单双引号了。
        //如果指定的字符串或者字符没有在NAME中出现，则返回-1.

        num1=sentence.indexOf('a',3);
        System.out.println(num1);
        //indexOf()函数也可以从指定的位置开始查找，比如从第2个位置开始查找a，那么就会返回15.

//Java中的标准输入(scanf)：
        Scanner sc=new Scanner(System.in);
        //创建了一个Scanner对象sc，用于从控制台输入。
        //System.in表示标准输入，即键盘。

        int n=sc.nextInt();
        double d=sc.nextDouble();
        String st=sc.next();
        //如图进行输入。
        //注意：没有直接从标准输入得到一个字符的方法。可以先得到一个字符串再得到字符。


        sc.close();
        //最后关闭输入对象。
        //关闭输入对象的原因：释放资源，防止内存泄露。


    }
}
