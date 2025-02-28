package Test.Algoritms;

public class InsertionSort {
    public static void main(String[] args) {

        int[] array = new int[]{2,20,1,33,543,22,8};
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) { // почему с 1 начинается потому что первый элемент с индексом 0 уже попадает в отсортированную последовательность

            int current = array[i]; // текущий элемент запомниаем
            int j = i; // для внутреннего цикла

            while (j > 0 && array[j - 1] > current) { // пока не дошли до конца и пока предыдущий элемент больше текущего элемента
                array[j] = array[j - 1]; // сдвигаем элементы вправо если он больше вставленного
                j--;
            }
            array[j] = current; // вставляем элемент в нужное место
        }
    }
}
