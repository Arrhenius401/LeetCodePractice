package Classic150.Sort;

public class MergeSort {
    // 主方法：用于排序数组
    public static void sort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, 0,  n-1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = left + (right - left)/2;

            // 递归排序左半部分
            mergeSort(arr, left, mid, temp);
            // 递归排序右半部分
            mergeSort(arr, mid+1, right, temp);

            // 合并已排序的两部分
            merge(arr, left, mid, right, temp);
        }
    }

    // 合并方法：将两个已排序的子数组合并成一个新数组
    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        // 将元素复制到临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;   // 左子数组的起始索引
        int j = mid+1;  // 右子数组的起始索引
        int k = left;   // 合并后数组的起始索引

        // 合并两个子数组
        while (i <= mid && j<=right){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // 复制左子数组的剩余元素
        while (i <= mid){
            arr[k] = temp[i];
            i++;
            k++;
        }

        // 复制右子数组的剩余元素
        while (j <= right){
            arr[k] = temp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
