package com.dlut.sorts.bubble;

public class BubbleSort {

     private BubbleSort() {}

     public static void sort(int[] A) {
          boolean flag = true;
          for (int i = 0; i < A.length && flag; i++) {
               flag = false;
               for (int k = A.length - 1; k > i; k--) {
                    if (A[k] < A[k-1]) {
                         flag = true;
                         swap(A, k, k-1);
                    }
               }
          }
     }

     public static void swap(int[] A, int i, int k) {
          int temp = A[i];
          A[i] = A[k];
          A[k] = temp;
     }

     public static void main(String[] args) {
          int[] A = new int[]{4, 1, 122, 6, 2, 55, 22};
          BubbleSort.sort(A);

          for (int i = 0; i < A.length; i++) {
               System.out.println(A[i]);
          }
     }
}
