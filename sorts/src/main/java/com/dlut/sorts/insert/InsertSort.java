package com.dlut.sorts.insert;

public class InsertSort {

    private InsertSort() {}

    public static <T extends Comparable> void sort(T[] A) {
        sort(A, 0, A.length-1);
    }

    /**
     *
     * @param A
     * @param low
     * @param high
     */
     public static <T extends Comparable>void sort(T[] A, int low, int high) {

          int k = 0;
          T guard;
          for (int i = low+1; i <= high; i++) {
               if (A[i].compareTo(A[i-1]) < 0) {
                    k = i - 1;
                    guard = A[i];
                    while (k >= low && A[k].compareTo(guard) > 0) {
                         A[k+1] = A[k];
                         k--;
                    }
                    A[k+1] = guard;
               }
          }
     }

     public static void main(String[] args) {
         Integer[] A = new Integer[]{4, 1, 122, 6, 2, 55, 22};
         InsertSort.sort(A);
         for (int i = 0; i < A.length; i++) {
             System.out.println(A[i]);
         }
     }
}
