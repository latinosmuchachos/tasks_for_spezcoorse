package second;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort1() {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {1, 1, 1, 1};
        Integer[] copy_of_array = Arrays.copyOf(array, array.length);
        QuickSort.sort(array);
        Arrays.sort(copy_of_array);
        assertEquals(array.length, copy_of_array.length);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i], copy_of_array[i]);
        }
    }

    @Test
    void sort2() {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {1, 2, 1, 1};
        Integer[] copy_of_array = Arrays.copyOf(array, array.length);
        QuickSort.sort(array);
        Arrays.sort(copy_of_array);
        assertEquals(array.length, copy_of_array.length);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i], copy_of_array[i]);
        }
    }

    @Test
    void sort3() {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {1, 2, 3, 4};
        Integer[] copy_of_array = Arrays.copyOf(array, array.length);
        QuickSort.sort(array);
        Arrays.sort(copy_of_array);
        assertEquals(array.length, copy_of_array.length);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i], copy_of_array[i]);
        }
    }

    @Test
    void sort4() {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {-1, 0, 0, 1, 0};
        Integer[] copy_of_array = Arrays.copyOf(array, array.length);
        QuickSort.sort(array);
        Arrays.sort(copy_of_array);
        assertEquals(array.length, copy_of_array.length);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i], copy_of_array[i]);
        }
    }

    @Test
    void sort5() {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {5, 4, 3, 2};
        Integer[] copy_of_array = Arrays.copyOf(array, array.length);
        QuickSort.sort(array);
        Arrays.sort(copy_of_array);
        assertEquals(array.length, copy_of_array.length);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i], copy_of_array[i]);
        }
    }

}