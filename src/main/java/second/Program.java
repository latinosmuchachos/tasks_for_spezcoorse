package second;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Integer[] array = {1, 3, 2, 4, 7, 5};
        System.out.println(Arrays.toString(array));

        MyComparator comporator = new MyComparator<Integer>();

        QuickSort.sort(array, comporator);

        System.out.println(Arrays.toString(array));
        System.out.println(comporator.getCount());


    }
}
