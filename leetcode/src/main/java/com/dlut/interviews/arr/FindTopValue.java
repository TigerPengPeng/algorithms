package com.dlut.interviews.arr;



/**
 * 一个数组是这样的规律（递增然后递减）： 3, 5, 6, 8, 44, 43, 32, 3。用时间复杂度最低的方法找出最大值
 * 利用二分查找法，找到一个数满足条件：这个数左边的值比它小，右边的值也比它小
 * 时间复杂度 O(logN)
 *
 */
public class FindTopValue {

    public static void main(String[] args) {
//        int arr[] = new int[] {3, 5, 6, 8, 44, 43, 32, 23};
        int arr[] = new int[] {3, 5, 6, 8, 44, 63, 72, 83};

        int maxValueIndex = findTopValue(arr);
        System.out.println(arr[maxValueIndex]);

    }

    public static int findTopValue(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("arr can not be null");
        }

        if (arr.length == 1) {
            return 0;
        }

        int beginIndex = 0;
        int endIndex = arr.length - 1;

        while (beginIndex <= endIndex) {
            int middleIndex = calMiddle(beginIndex, endIndex);
            int compareResult = getCompareResult(arr, middleIndex);

            // 计算出下一轮要计算的 [beginIndex, endIndex]
            if (compareResult == 1) {
                beginIndex = middleIndex + 1;

            } else if (compareResult == 2) {
                endIndex = middleIndex - 1;

            } else if (compareResult == 0) {
                return beginIndex;

            } else {
                throw new IllegalStateException("unexpected condition");
            }
        }

        // 如果没有找到符合条件的最大值，则返回最后beginIndex停留的index
        return beginIndex;

    }

    private static int calMiddle(int beginIndex, int endIndex) {
        return (beginIndex + endIndex) >> 1;
    }

    /**
     * 查看 index 下标 在 int[] arr 中的位置　
     * @param arr
     * @param index
     * @return
     *          0:  find target value index
     *          1:  target value is on the right side
     *          2:  target value is on the left side
     */
    private static int getCompareResult(int[] arr, int index) {
        if (index > 0 && index < arr.length - 1) {

            if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
                return 0;

            } else if (arr[index] > arr[index - 1] && arr[index] < arr[index + 1]) {
                return 1;

            } else if (arr[index] < arr[index - 1] && arr[index] > arr[index + 1]) {
                return 2;

            } else {
                throw new IllegalStateException("FindTopValue#getCompareResult unexpected condition");
            }

        } else if (index == 0) {
            return 1;

        } else {
            return 2;
        }
    }
}
