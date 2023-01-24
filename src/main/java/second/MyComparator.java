package second;

import java.util.Comparator;

public class MyComparator <T extends Comparable<T>> implements Comparator<T> {
    private int count;

    MyComparator(){
        count = 0;
    }

    @Override
    public int compare(T o1, T o2){
        this.count++;
        return o1.compareTo(o2);
    }

    public int getCount(){
        return this.count;
    }

    public void reset(){
        this.count = 0;
    }
}
