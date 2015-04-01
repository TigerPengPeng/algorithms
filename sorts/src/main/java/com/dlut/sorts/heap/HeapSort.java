package com.dlut.sorts.heap;

public class HeapSort {

     private int capacity;

     private int size;

     private int[] A;

     // do not use space A[0]
     public HeapSort(int capacity) {
          this.capacity = capacity + 1;
          this.size = 0;
          A = new int[this.capacity];
     }

     public HeapSort(int capacity, int[] A) {
          if (capacity < A.length) {
               throw new RuntimeException(" the value of capacity can not be less than length of A ");
          }
          this.capacity = capacity + 1;
          this.size = A.length;
          this.A = new int[this.capacity];
          for (int i = 0; i < A.length; i++) {
               this.A[i+1] = A[i];
          }
     }

     // pay attention to java constructor: use "this" to invoke other constructor
     public HeapSort(int[] A) {
          this(A.length * 2, A);
     }

     private static int parent(int i) {
          return i >> 1;
     }

     private static int left(int i) {
          return i << 1;
     }

     private static int right(int i) {
          return (i << 1) + 1;
     }

     public static void swap(int[] A, int i, int k) {
          int temp = A[i];
          A[i] = A[k];
          A[k] = temp;
     }

     private static void adjust(int[] A, int i, int size) {
          if (i < 1) {
               throw new RuntimeException(" the value of i can not be less than 1 ");
          }
          int max = i;
          if (left(i) <= size) {
               max = A[left(i)] > A[i] ? left(i) : i;
          }
          if (right(i) <= size) {
               max = A[right(i)] > A[max] ? right(i) : max;
          }
          if (max != i) {
               swap(A, max, i);
               adjust(A, max, size);
          }

     }

     public void build() {
          for (int i = size / 2; i >= 1; i--) {
               adjust(this.A, i, size);
          }
     }

     public int[] sort() {
          int[] array = this.clone();
          for (int i = array.length-1; i >= 2; i--) {
               swap(array, i, 1);
               adjust(array, 1, i-1);
          }
          return array;
     }

     // adjust up
     private void modify(int i, int value) {

          if (value < A[i]) {
               A[i] = value;
               adjust(A, i, size);
          } else {
               A[i] = value;
               while (parent(i) >= 1 && A[parent(i)] < value) {
                    swap(A, parent(i), i);
                    i = parent(i);
               }
          }
     }

     private void expand() {

          System.out.println("expand");
          this.capacity = 2 * this.capacity;
          int[] ori = this.A;
          this.A = new int[this.capacity];
          for (int i = 1; i <= size; i++) {
               A[i] = ori[i];
          }

     }


     public void add(int value) {
          if (size == capacity - 1) {
               this.expand();
          }
          size++;
          A[size] = Integer.MIN_VALUE;
          modify(size, value);

     }

     public int getMax() {
          return A[1];
     }

     public int removeMax() {
          if (size == 0) {
               throw new RuntimeException(" the heap is empty ");
          }
          int max = A[1];
          A[1] = A[size];
          size--;
          adjust(A, 1, size);
          return max;
     }

     public int[] clone() {
          int[] array = new int[this.size+1];
          for (int i = 1; i <= size ; i++) {
               array[i] = A[i];
          }
          return array;
     }


     public void print() {
          System.out.println("---------------------------");
          for (int i = 1; i <= size; i++) {
               System.out.println(A[i]);
          }
          System.out.println("---------------------------");
     }

     public int getSize() {
          return this.size;
     }

     public int getCapacity() {
          return this.capacity;
     }


     public static void main(String[] args) {

          int[] A = new int[]{230, 1, 122, 6, 2, 55, 22, 66, 33, 5, 9, 65, 79, 90, 0, 101, 120, 4};

          HeapSort heap = new HeapSort(A);

          //heap.print();

          heap.build();

          System.out.println("size: " + heap.getSize());

          for (int i = 0; i < 20; i++) {
               System.out.println(i);
               heap.add(10 * i + 5);
          }
          System.out.println("size: " + heap.getSize());

          heap.print();

          int[] sortArray = heap.sort();

          for (int i : sortArray) {
               System.out.println(i);
          }

          heap.print();

          System.out.println("size: " + heap.getSize());

          int max = heap.removeMax();
          System.out.println("max = " + max);
          System.out.println("size: " + heap.getSize());

          heap.print();

     }
}
