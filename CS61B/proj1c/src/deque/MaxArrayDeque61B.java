package deque;

import java.util.Comparator;

public class MaxArrayDeque61B<T> extends ArrayDeque61B<T> {
    private Comparator<T> comparator;
    private ArrayDeque61B<T> arrayDeque;

    public MaxArrayDeque61B(Comparator<T> x){
        comparator=x;
        arrayDeque=new ArrayDeque61B<>();
    }

    public T max(){
        if(this.isEmpty())
            return null;

        T maxItem=get(0);

        for(int i=1;i<size();i++){
            int cmp=comparator.compare(get(i),maxItem);
            if(cmp>0)
                maxItem=get(i);
        }

        return maxItem;
    }

    public T max(Comparator<T> x){
        if(this.isEmpty())
            return null;

        T maxItem=get(0);

        for(int i=1;i<size();i++){
            int cmp=x.compare(get(i),maxItem);
            if(cmp>0)
                maxItem=get(i);
        }

        return maxItem;
    }

}
