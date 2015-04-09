package com.dlut.sorts.quick;

public class QuickSort {


     private QuickSort() {}

     public static void sort(int[] A) {
          sort(A, 0, A.length - 1);
     }

     private static void sort(int[] A, int low, int high) {

          /*
          if (low < high) {
               int key = partition(A, low, high);
               sort(A, low, key - 1);
               sort(A, key + 1, high);
          }
          */

          // this method is better
          int key = 0;
          while (low < high) {
               key = partition(A, low, high);
               sort(A, low, key - 1);
               low = key + 1;
          }
     }

    /**
     * TODO 目前的partition算法是不支持选择key值的，key只能为A[high],保留key的形参是为了后期扩展
     * @param A
     * @param low
     * @param high
     * @return
     */
     private static int partition(int[] A, int low, int high) {
         int key = A[high];
         int i = low - 1;
         for (int j = low; j < high; j++) {
             if (A[j] <= key) {
                 i++;
                 swap(A, i, j);
             }
         }
         swap(A, i+1, high);
         return i+1;
     }


     public static void swap(int[] A, int i, int k) {
          int temp = A[i];
          A[i] = A[k];
          A[k] = temp;
     }


     public static void main(String[] args) {

          int[] A = new int[]{22,1,65,122,6,2,55,22,66,33,5,9,22,65,79,90,0,101,120,22};
          QuickSort.sort(A);

          for (int i = 0; i < A.length; i++) {
               System.out.print(A[i] + ",");
          }
     }

}
