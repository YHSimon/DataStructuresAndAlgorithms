package day14;

import java.util.Arrays;

//堆排序 4ms
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] arr = {5, 3, 2, 4, 1};
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组（二叉树）调整成一个大顶堆

    /**
     *
     * @param arr 待调整数组
     * @param i   非叶子节点在数组中的索引
     * @param length  对多少个元素继续调整，length是在逐渐减少的
     */
    public  void adjustHeap(int[] arr,int i,int length){
        int tmp=arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>tmp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=tmp;
    }

    public void heapSort(int[] arr){
        int tmp=0;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }

        for(int j=arr.length-1;j>0;j--){
            tmp=arr[j];
            arr[j]=arr[0];
            arr[0]=tmp;
            adjustHeap(arr, 0, j);
        }
    }
}
