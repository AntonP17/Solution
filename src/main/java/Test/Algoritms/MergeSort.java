package Test.Algoritms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,20,1,33,543,22,8};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // деление
    private static void mergeSort(int[] arr) {


        int n = arr.length;
        if (n == 1) return;// base state

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) { // copy to new array left
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) { // copy to new array right
            right[i - mid] = arr[i];
        }
        mergeSort(left); // мерджим пока не останется по 1 элементу
        mergeSort(right);
        merge(arr, left, right);

    }

    private static void merge(int[] arr, int[] left, int[] right) {

      int l = left.length;
      int r = right.length;
      int i = 0;
      int j = 0;
      int idx = 0;

      while (i < l && j < r) { // пока не дошли до конца
          if(left[i] < right[j]) {
              arr[idx] = left[i];
              i++;
              idx++;
          } else {
              arr[idx] = right[j];
              j++;
              idx++;
          }
      }

      for (int ll = i; ll < l; ll++) {
          arr[idx++] = left[ll];
      }
      for (int rr = j; rr < r; rr++) {
          arr[idx++] = right[rr];
      }
    }


}
