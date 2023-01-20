package first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void find() {
        BinarySearch binarySearch = new BinarySearch();
        int[] test_array1 = {};
        int actual1 = BinarySearch.find(test_array1, 1);
        int expected1 = -2;
        assertEquals(actual1, expected1);

        int[] test_array2 = {1};
        int actual2 = BinarySearch.find(test_array2, 1);
        int expected2 = 0;
        assertEquals(actual2, expected2);

        int[] test_array3 = {1, 2};
        int actual3 = BinarySearch.find(test_array3, 1);
        int expected3 = 0;
        assertEquals(actual3, expected3);

        int[] test_array4 = {1, 2};
        int actual4 = BinarySearch.find(test_array4, 2);
        int expected4 = 1;
        assertEquals(actual4, expected4);

        int[] test_array5 = {1, 2, 3, 2};
        int actual5 = BinarySearch.find(test_array5, 1);
        int expected5 = -3;
        assertEquals(actual5, expected5);

        int[] test_array6 = {3, 2, 1, 2, 3};
        int actual6 = BinarySearch.find(test_array6, 1);
        int expected6 = -3;
        assertEquals(actual6, expected6);

        int[] test_array7 = {1, 2, 3, 4, 5};
        int actual7 = BinarySearch.find(test_array7, 3);
        int expected7 = 2;
        assertEquals(actual7, expected7);

        int[] test_array8 = {1, 2, 3, 4, 5};
        int actual8 = BinarySearch.find(test_array8, 7);
        int expected8 = -1;
        assertEquals(actual8, expected8);

        int[] test_array9 = {1, 1, 1, 1, 1};
        int actual9 = BinarySearch.find(test_array9, 1);
        int expected9 = 0;
        assertEquals(actual9, expected9);
    }
}