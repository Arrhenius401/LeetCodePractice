package Classic150.Sort;

public class QuickSort {
    // 主方法：用于排序数组
    public static void sort(int[] arr){
        if(arr == null || arr.length <= 0){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    // 递归方法：对指定范围的数组进行快速排序
    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            // 获取分区索引，将数组分区并返回基准元素的最终位置
            int pi = partition(arr, low, high);

            // 递归排序基准元素左边的子数组
            quickSort(arr, low, pi-1);
            // 递归排序基准元素右边的子数组
            quickSort(arr, pi+1, high);
        }
    }

    // 分区方法：选择一个基准元素，将小于基准的元素放在左边，大于基准的元素放在右边
    private static int partition(int[] arr, int low, int high){
        // 选择最右边的元素作为基准
        int pivot = arr[high];
        // i是小于基准区域的边界索引
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准，则将其放入小于基准的区域
            if(arr[j] <= pivot){
                i++;

                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准元素放到它的最终位置
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    // 测试方法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
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
