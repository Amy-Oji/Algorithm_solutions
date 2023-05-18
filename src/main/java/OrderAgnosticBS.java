public class OrderAgnosticBS {


    public static int orderAgnosticBS(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while(start <=end ){

            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            if(arr[start] == target){
                return start;
            }
            if(arr[end] == target){
                return end;
            }
            if(isAsc){
                if(target<arr[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }else{
                if (target>arr[mid]){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    public static int bSearch2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[start] <= arr[mid]) { // Ascending order
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // Descending order
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int [] arrA = {1, 2, 3, 4, 5, 6};
        int [] arrD = {6, 5, 4, 3, 2, 1};
        System.out.println(orderAgnosticBS(arrD, 1));
    }
}
