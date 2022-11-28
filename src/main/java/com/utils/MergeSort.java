package com.utils;

/**
 * @Description
 * @date 2022-11-22 20:40
 * @Author fanxg
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2022,0,6,4,1,3,7,8,5,9};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    public static void sort(int[] arr,int left,int right) {
        if (left == right) {
            return;
        }
        //分成两半
        int mid = left +(right-left)/2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid +1, right);

        merge(arr, left, mid+1, right);
    }
    //leftPtr 指数组最左边
    //rightPtr 指数组中间
    //rightBound 数组最右边

    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // 将右边剩余的归并
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //将左边剩余的归并
        while (j <= rightBound) {
            temp[k++] = arr[j++];

        }

        for(int m = 0; m < temp.length;m++) arr[leftPtr+m] = temp[m];
    }
    //排序
    static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //打印
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
