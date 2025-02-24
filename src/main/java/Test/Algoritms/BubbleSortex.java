package Test.Algoritms;

public class BubbleSortex {
    public static void main(String[] args) {

        int[] array = new int[]{2,20,1,33,543,22,8};
        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length; // устанавливаем длину
        for (int i = 0; i < n - 1; i++) { // начинаем внешний цикл с 1 по предпоследний элемент чтобы набибульший выплыл на ружу то есть в конец
            int minIndex = i; // устанавливаем индекс минимальный = итерация
            for (int j = i + 1; j < n; j++) { // внутренний цикл со следующего элемента соседнего
                if (arr[j] < arr[minIndex]){ // если этот эелемент меньше нашего минимального то - >
                    minIndex = j; // устанавливаем новый минимальный
                }
            }
            int temp = arr[minIndex]; // подмена элементов местами, временная переменная дял удобства
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
