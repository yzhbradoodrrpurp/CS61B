package RunTime;

import org.junit.Test;
import java.util.Random;

public class RunTimeTest {

    @Test
    public void testRunTime1(){
        int[] x=new int[10];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime2(){
        int[] x=new int[100];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime3(){
        int[] x=new int[1000];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime4(){
        int[] x=new int[10000];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime5(){
        int[] x=new int[100000];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime6(){
        int[] x=new int[1000000];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }

    @Test
    public void testRuntime7(){
        int[] x=new int[10000000];
        Random r=new Random();
        int i;

        for(i=0;i<x.length;i++){
            int input=r.nextInt(100);
            x[i]=input;
        }

        long startTime=System.nanoTime();
        Algorithm1.testIfReplicate(x);
        long endTime=System.nanoTime();
        long nanoseconds=endTime-startTime;
        double seconds=(double)nanoseconds/1000000000;

        System.out.println("For length: "+x.length+", the required time is "+seconds+" seconds.");
    }
}
