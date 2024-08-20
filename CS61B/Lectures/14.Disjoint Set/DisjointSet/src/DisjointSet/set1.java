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

        if(id1==id2)
            return true;

        return false;
    }
}
