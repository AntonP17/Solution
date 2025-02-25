package Test.Algoritms;

public class BinarySearc {
    public static void main(String[] args) {

        int[] array = new int[]{1,3,54,66,78,666,52,23};
        int target = 54;
        int result = binarySearch(array, target,0,array.length);
        if (result == -1) {
            System.out.println("Элемент не найден.");
        } else {
            System.out.println("Элемент найден на индексе: " + result);
        }
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {

        if (left > right) {
            return -1; // элемент не найден
        }

        int mid = left + (right - left) / 2; // почему в правой части в скобках вычитание потому что так безопасно от переполнения , например если у нас предел у инта 2млн а справа будет 4

        if (arr[mid] == target) {
            return mid; // элемент найден
        }

        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right); // поиск в правой части если цель боле середины
        } else {
            return binarySearch(arr, target, left, mid - 1);
        }
    }
}
