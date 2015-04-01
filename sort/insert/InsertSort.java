

public class InsertSort {

     private InsertSort() {}

     public static void sort(int[] A) {

          int k = 0;
          int guard = 0;
          for (int i = 1; i < A.length; i++) {
               if (A[i] < A[i-1]) {
                    k = i - 1;
                    guard = A[i];
                    while (k >= 0 && A[k] > guard) {
                         A[k+1] = A[k];
                         k--;
                    }
                    A[k+1] = guard;
               }
          }
     }

     public static void main(String[] args) {
          int[] A = new int[]{4, 1, 122, 6, 2, 55, 22};
          InsertSort.sort(A);

          for (int i = 0; i < A.length; i++) {
               System.out.println(A[i]);
          }
     }
}
