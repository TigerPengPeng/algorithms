package com.dlut.sorts.merge;

public class MergeSort {

     private MergeSort() {}

     public static void sort(int[] A) {
          sort(A, 0, A.length - 1);
     }

     private static void sort(int[] A, int low, int hign) {
          if (low < hign) {
               int middle = (low + hign) / 2;
               sort(A, low, middle);
               sort(A, middle + 1, hign);
               merge(A, low, middle, hign);
          }
     }

     private static void merge(int[] A, int low, int middle, int hign) {
          int len1 = middle - low + 1;
          int len2 = hign - middle;

          // split the array A to array1(range: low-middle) and array2(range: middle+1-hign)
          int[] array1 = new int[len1];
          int[] array2 = new int[len2];

          for (int i = 0; i < len1; i++) {
               array1[i] = A[low+i];
          }
          for (int i = 0; i < len2; i++) {
               array2[i] = A[middle+1+i];
          }

          int index1 = 0;
          int index2 = 0;
          int i = low;
          while (index1 < len1 && index2 < len2) {
               if (array1[index1] <= array2[index2]) {
                    A[i++] = array1[index1++];
               } else {
                    A[i++] = array2[index2++];
               }
          }
          while (index1 < len1) {
               A[i++] = array1[index1++];
          }
          while (index2 < len2) {
               A[i++] = array2[index2++];
          }

     }

     public static void main(String[] args) {

          int[] A = new int[]{230, 1, 122, 6, 2, 55, 22, 66, 33, 5, 9, 65, 79, 90, 0, 101, 120, 4};
          MergeSort.sort(A);

          for (int i = 0; i < A.length; i++) {
               System.out.println(A[i]);
          }
     }
}
