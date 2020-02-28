/**
 * @author slowgenius
 * @date 2/27/2020 3:31 PM
 * @description
 */
public class Main {
    //一个数组 中间一个元素ak  ak之前的元素是递增的  ak之后的元素是递增 最后一个比第一个小


    public static int find(int[] arr) {
        if (arr.length % 2 == 0) {
            if (arr[arr.length / 2] > arr[0]) {
                return findResult(arr.length / 2, arr.length - 1, arr);
            } else {
                return findResult(0, arr.length / 2, arr);
            }
        } else {
            if (arr[(arr.length + 1) / 2] > arr[0]) {
                return findResult((arr.length + 1) / 2, arr.length - 1, arr);
            } else {
                return findResult(0, (arr.length + 1) / 2, arr);
            }

        }
    }

    public static int findResult(int start, int end, int[] arr) {
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        System.out.println(find(arr));

    }
}
