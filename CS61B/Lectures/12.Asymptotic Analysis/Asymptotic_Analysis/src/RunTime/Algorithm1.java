package RunTime;

public class Algorithm1 {

    public static boolean testIfReplicate(int[] x){
        int[] a=rankUp(x);

        boolean result=testAdjacent(a);

        return result;
    }

    private static int[] rankUp(int[] x){
        int[] a=new int[x.length];
        System.arraycopy(x,0,a,0,x.length);

        int maxid=0;
        int cnt=0;
        int i;

        while(cnt!=a.length-1){
            for(i=1;i<a.length;i++)
                maxid=a[i]>a[maxid]?i:maxid;

            int mid=a[maxid];
            a[maxid]=a[a.length-1-cnt];
            a[a.length-1]=mid;
            cnt++;
        }

        return a;
    }

    private static boolean testAdjacent(int[] a){
        int i;

        for(i=0;i<a.length-1;i++){
            if(a[i]==a[i+1])
                return true;
        }

        return false;
    }
}