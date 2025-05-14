package Day8;

class PeakElement {
    public int peakIndexInMountainArray(int[] arr) {

        int s = 0;
        int e = arr.length-1;

        // while(s < e){
        //     int mid = (s + e)/2;
        //     // agr mid element ka next element bda hai that means hmaara peak element right
        //     // mai pda hai
        //     if(arr[mid] < arr[mid+1]){
        //         s = mid + 1;
        //     }
        //     // peak element left mai hai
        //     else{
        //         e = mid;
        //     }
        // }
        // // start is the index for that element jo abhi peak pr hoga
        // return s;

        return BinarySearch(arr, s, e);
    }

    public static int BinarySearch(int arr[], int s, int e){
        if(s == e){
            return s;
        }
        int mid = (s+e)/2;

        if(arr[mid] < arr[mid+1]){
            return BinarySearch(arr, mid+1, e);
        }
        else{
            return BinarySearch(arr, s, mid);
        }
    }
}
