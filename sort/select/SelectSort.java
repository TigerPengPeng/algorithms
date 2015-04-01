

public class SelectSort {

     private SelectSort() {}

     public static void swap(int[] A, int i, int k) {
          int temp = A[i];
          A[i] = A[k];
          A[k] = temp;
     }
    

     public static void sort(int[] A) {

          int minIndex = 0;

          for (int i = 0; i < A.length; i++) {
               minIndex = i;
               for (int k = i+1; k < A.length; k++) {
                    if (A[k] < A[minIndex]) {
                         minIndex = k;
                    }
               }
               if (minIndex != i) {
                    swap(A, i, minIndex);
               }
          }
     }

     public static void main(String[] args) {

          int[] A = new int[]{4, 1, 122, 6, 2, 55, 22};
          SelectSort.sort(A);

          for (int i = 0; i < A.length; i++) {
               System.out.println(A[i]);
          }
     }
}
