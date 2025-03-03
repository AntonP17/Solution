package Test.Algoritms;


public class QuickSOrt {
    public static void main(String[] args) {
         int[] arr = new int[]{2,20,1,33,543,22,8};
         quickSort(arr,0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) { // базовый случай
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    // выбираем наш опорный элемент
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // опорный желмент последний
        int partitionIndex = left; // это как стена куда будут смещаться элементы меньше опорного
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, right, partitionIndex);
        return partitionIndex;
    }

    // чтобы каждый раз не писать обмен , сделал точно так же как и в о всех алгоритмах сортировки
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
