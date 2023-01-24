package second;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] array){
        quicksort(array, 0, array.length, new MyComparator<T>());
    }

    public static <T> void sort(T[] array, Comparator<T> comparator){
        quicksort(array, 0, array.length, comparator);
    }

    private static <T> void quicksort(T[] array, int left, int right, Comparator<T> comparator){
        if (left < right){
            int pivot = partition(array, left, right, comparator);

            quicksort(array, left, pivot, comparator);
            quicksort(array, pivot + 1, right, comparator);
        }
    }

    private static <T> int partition(T[] array, int left, int right, Comparator<T> comparator ){
        median3(array, left, right, comparator);
        T pivot = median3(array, left, right, comparator);
        int pivot_ind = left;

        if (comparator.compare(pivot, array[left]) == 0){
            pivot_ind = left;
        }
        else if (comparator.compare(pivot, array[left + (right - left) / 2]) == 0){
            pivot_ind = left + (right - left) / 2;
        }
        else{
            pivot_ind = right - 1;
        }

        swap(array, pivot_ind, left);

        int ind = left + 1;
        for (int j = left + 1; j < right; j++){
            if (comparator.compare(array[j], pivot) < 0){
                swap(array, ind, j);
                ind++;
            }
        }
        swap(array, ind - 1, left);

        return ind - 1;

    }

    private static <T>  T median3(T[] array, int left, int right, Comparator<T> comparator){
        T left_value = array[left];
        T right_value = array[right - 1];
        T middle_value = array[left + (right - left) / 2];

        if (comparator.compare(left_value, middle_value) <= 0 && comparator.compare(middle_value, right_value) <= 0){
            return middle_value; // left, middle, right
        }
        if (comparator.compare(left_value, right_value) <= 0 && comparator.compare(right_value, middle_value) <= 0){
            return right_value; // left right middle
        }
        if (comparator.compare(middle_value, left_value) <= 0 && comparator.compare(left_value, right_value) <= 0){
            return left_value; // middle left right
        }
        if (comparator.compare(middle_value, right_value) <= 0 && comparator.compare(right_value, left_value) <= 0){
            return right_value; // middle right left
        }
        if (comparator.compare(right_value, left_value) <= 0 && comparator.compare(left_value, middle_value) <= 0){
            return left_value; // right left middle
        }
        return middle_value; // right middle left

    }

    private static <T> void swap(T[] array, int l_ind, int r_ind){
        T temp = array[l_ind];
        array[l_ind] = array[r_ind];
        array[r_ind] = temp;
    }

    public static <T> boolean isSorted(T[] array, Comparator<T> comparator){
        if (array.length <= 1){
            return true;
        }
        for (int i = 1; i < array.length; i++){
            if (comparator.compare(array[i], array[i-1]) < 0){
                return false;
            }
        }
        return true;
    }
}
