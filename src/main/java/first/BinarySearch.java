package first;

public class BinarySearch {
    public static int find(int[] array, int element){
        // return values:
        // >= 0 - index of search element
        // -1 - not found element
        // -2 - zero len
        // -3 - not sorting

        int first_element;
        int second_element;
        int search_index = -1;
        int len_array = array.length;
        int current_index = 1;
        boolean is_increasing = true;
        boolean is_sorted = true;
        int left, right, middle;

        // проверка длины - start
        if (len_array == 0){
            return -2;
        }
        // проверка длины - end

        first_element = array[0];

        // проверка массива единичной длины - start
        if (len_array == 1){
            if (element == first_element){
                return 0;
            }
            else{
                return -1;
            }
        }
        // проверка массива единичной длины - end

        second_element = array[1];

        // проверка отсортированности - start
        while (first_element == second_element){
            current_index++;
            if (current_index == len_array){
                break;
            }
            second_element = array[current_index];
        }
        if (current_index == len_array){
            if (element == first_element){
                return 0;
            }
            else{
                return -1;
            }
        }
        if (!(second_element > first_element)){
            is_increasing = false;
        }
        if (is_increasing){
            for (int i = current_index; i < len_array; i++){
                if (array[i] < array[i - 1]){
                    is_sorted = false;
                    break;
                }
            }
        }
        else{
            for (int i = current_index; i < len_array; i++){
                if (array[i] > array[i - 1]){
                    is_sorted = false;
                    break;
                }
            }
        }
        if (!is_sorted){
            return -3;
        }
        // проверка отсортированности - end

        // алгоритм бинарного поиска - start
        left = 0;
        right = len_array - 1;
        while (left <= right){
            middle = left + (right - left) / 2;
            if (is_increasing){
                if (array[middle] > element){
                    right = middle - 1;
                }
                if (array[middle] < element){
                    left = middle + 1;
                }
                if (array[middle] == element){
                    return middle;
                }
            }
            else{
                if (array[middle] > element){
                    left = middle + 1;
                }
                if (array[middle] < element){
                    right = middle - 1;
                }
                if (array[middle] == element){
                    return middle;
                }
            }
        }
        // алгоритм бинарного поиска - end;
        return search_index;
    }
}
