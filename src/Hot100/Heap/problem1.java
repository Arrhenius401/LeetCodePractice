package Hot100.Heap;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

public class problem1 {

    // 基于快速排序的做法
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, nums.length-k);
    }

    public int quickSort(int[] nums, int l, int r, int k) {
        if(l == r){
            return nums[k];
        }
        int partition = nums[l], i = l-1, j = r+1;
        while (i<j){
            do i++; while (nums[i] < partition);
            do j++; while (nums[j] > partition);

            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if(k<=j){
            return quickSort(nums, l, j, k);
        }else {
            return quickSort(nums, j+1, r, k);
        }
    }

    // 基于堆排序的做法
    public int heapKindKthLargest(int[] nums, int k) {
        int n = nums.length;
        int heapSize = n;
        buildMaxHeap(nums, heapSize);
        for(int i=n-1; i >= n+1-k; i--){
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    // 自底向上的检验和排序，最终将无序数组调整为最大堆
    public void buildMaxHeap(int[] a, int heapSize){
        for(int i=heapSize/2-1; i>=0; i--){
            maxHeapify(a, i, heapSize);
        }
    }

    // 检验父子结点是否遵循规则
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i*2+1, r = l+1, largest = i;
        if(l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if(r < heapSize && a[r] > a[largest]){
            largest = r;
        }
        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
