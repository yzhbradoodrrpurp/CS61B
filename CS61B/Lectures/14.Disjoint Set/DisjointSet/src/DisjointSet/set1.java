package DisjointSet;

public class set1 implements disjointSet{
    int[] items;

    public set1(){
        items =new int[8];
        int i;

        for(i=0;i<8;i++)
            items[i]=-1;
    }

    /*
    连接0～7之间的数。
     */
    @Override
    public void connect(int p, int q) {
        int id1=q;
        int id2=p;

        int height1=0;
        int height2=0;

        while(items[id1]!=-1) {
            id1 = items[id1];
            height1++;
        }

        while(items[id2]!=-1) {
            id2 = items[id2];
            height2++;
        }

        if(height1>height2)
            items[id2]=id1;
        else
            items[id1]=id2;
    }

    @Override
    public boolean isConnected(int p, int q) {
        int id1=q;
        int id2=p;

        while(items[id1]!=-1)
            id1=items[id1];

        while(items[id2]!=-1)
            id2=items[id2];

        connectToRoot(id1,id2,p,q);

        if(id1==id2)
            return true;

        return false;
    }

    /*
    用于优化连接结构的方法，当使用isConnected的次数越多，查找速度会越快。
     */
    private void connectToRoot(int rootID1,int rootID2,int p, int q){
        while(items[q]!=-1){
            int mid=q;
            q=items[q];
            items[mid]=rootID1;
        }

        while(items[p]!=-1){
            int mid=p;
            p=items[p];
            items[mid]=rootID2;
        }
    }


}
