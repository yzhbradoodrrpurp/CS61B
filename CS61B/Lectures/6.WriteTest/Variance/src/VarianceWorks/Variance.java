package VarianceWorks;

public class Variance{

    public static double doTheMath(double[] input){
        if(input==null)
            return 0;

        double sum=0;
        int i,j;

        for(i=0;i<input.length;i++){
            sum+=input[i];
        }

        double average=sum/input.length;
        double sum1=0;

        for(j=0;j<input.length;j++){
            sum1+=Math.pow((input[j]-average),2);
        }

        return sum1/input.length;
    }

}