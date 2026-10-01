package sorting;

public class QuickSort {

    public static void main(String[] args){
        int[] array1 = new int[]{50,70,60,90,80,10,100,5};
        int[] array2 = new int[]{10,9,8,7,6,5,4,3,2,1,0};
        quickSort(array1,0,array1.length-1);
        quickSort(array2,0,array2.length-1);
        for (int n: array1){
            System.out.print(n+ " ");
        }
        System.out.println();
        for (int n: array2){
            System.out.print(n+ " ");
        }
    }

    public static void quickSort(int[] array, int low, int high){
        if(low<high){
            int index = pivot(array, low, high);

            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }

    }

    private static int pivot(int[] array, int low, int high){

        int pivot = array[low];
        int pi = high+1;

        for(int i = high; i > low; i--){
            if(array[i] > pivot){
                pi--;
                swap(array, i, pi);
            }
        }
        //swap
        pi--;
        swap(array, pi, low);
        return  pi;
    }

    private static void swap(int[] array, int l, int r){
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
