public class KthSmallestNumber {
    public int KSmall(int[] arr, int l, int r, int k){
        int idxPivot = partition(arr, l, r);
        if(k == idxPivot){
            return arr[idxPivot];
        }
        else if(k < idxPivot){
            return KSmall(arr, l, idxPivot - 1, k);
        }
        else{
            return KSmall(arr, idxPivot + 1, r, k);
        }
    }
    int partition(int[] arr, int l, int r) {
        int i = l, j = r;
        int pivot = arr[l];
     
        while(i < j) {
            while (i <= arr.length - 1 && arr[i] <= pivot) {
                i++;
            }
     
            while (arr[j] > pivot) {
                j--;
            }
     
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
     
        return j;
    }
    void swap(int[] array, int i, int j) {
        int swapSpot = array[i];
        array[i] = array[j];
        array[j] = swapSpot;
    }

}
