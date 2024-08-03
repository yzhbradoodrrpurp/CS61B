package VarianceWorks;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class VarianceTest {

    @Test
    /*
    * @Test是一个注解，用于标记一个方法为单元测试方法。
    * 这个注解是JUnit测试框架的一部分，所以必须import org.junit.Test;
    * JUnit是一个用于编写和运行单元测试的测试框架。
    *加上@Test过后就能够运行一个单独的方法，而不用编写main函数，再进行调用。
    * */
    public void normalTest(){
        double[] input={10,20,30,40};
        double expected=125;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
        /*
        * assertThat().isEqualTo()是一个流式断言语法，用于编写单元测试(测试代码)。
        * 这个是由Google Truth断言库提供的，需要import static com.google.common.truth.Truth.assertThat;
        * 如果断言通过，测试继续进行；如果断言失败，测试框架会抛出一个断言错误。
        * 运行成功就会显示绿色的勾勾，失败就会显示红色叉叉，有漏洞就会显示红色感叹号。
        * */
    }


    @Test
    public void testEmpty(){
        double[] input=null;
        double expected=0;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testRepeated(){
        double[] input={50,50,50,50,50,5};
        double expected=281.25;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testTottallyRepeated(){
        double[] input={50,50,50,50,50};
        double expected=0;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testZero(){
        double[] input={0};
        double expected=0;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testMultipleZero(){
        double[] input={0,0,0,0,0,0};
        double expected=0;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testNegative(){
        double[] input={-1,-3,-5,-7,-9};
        double expected=8;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void testDecimal(){
        double[] input={1.2, 3.4, 5.5, 6.7};
        double expected=4.395;
        double actual=Variance.doTheMath(input);

        assertThat(actual).isEqualTo(expected);
    }


}
