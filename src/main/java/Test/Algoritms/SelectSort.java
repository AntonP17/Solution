package Test.Algoritms;

public class SelectSort {
    public static void main(String[] args) {

        int[] array = new int[]{2,20,1,33,543,22,8};
        selectSort(array);

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }

    public static void selectSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++){ // внешний цикл начинаем с 1 позиции ( со след иттерации будет отсортированная часть)
            int minIndex = i; // устанавливаем минимальный индекс номер иттерации
            for (int j = i + 1; j < array.length; j++){ // внутренний цикл начинаем со следующего элемент (неотсортированная часть)
                if (array[j] < array[minIndex]){ // если этот эелемент меньше нашего минимального то меняем
                    minIndex = j;
                }
                 // обмен элементами
                int temp = array[minIndex]; // временные данные наш мин индекс в неотсортированной части
                array[minIndex] = array[i]; // // подмена местами: минимальный элемент перемещается на позицию i(начало неотсортированной части)
                array[i] = temp; //  подмена местами: элемент, который был на позиции i, перемещается на место минимального
            }
        }
    }
}
