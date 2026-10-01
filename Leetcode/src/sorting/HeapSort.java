package sorting;

public class HeapSort {
    public static void main(String[] args) {
        //                        0, 1, 2, 3, 4, 5,  6,7
        int[] array1 = new int[]{50,70,60,90,80,10,100,5};
        /*
                     50
                 70      60
               90  80  10  100
             5
                    100
                90          60
            70      80  10      50
        5
         */
        heapSort(array1);
        for (int n: array1){
            System.out.print(n+ " ");
        }

    }

    public static void heapSort(int array[]){
        int n = array.length;
        for(int i = (n-1)/2; i >= 0; i--){
            heapify(array, n, i);
        }

        for(int i = n-1; i > 0; i--){
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }

    }

    public static void heapify(int[] array, int arrayLength, int parentIndex){
        int largestIndex = parentIndex;
        int leftChild = (parentIndex * 2) + 1;
        int rightChild = (parentIndex * 2) + 2;

        if(leftChild < arrayLength && array[largestIndex] < array[leftChild]){
            largestIndex = leftChild;
        }
        if(rightChild < arrayLength && array[largestIndex] < array[rightChild]){
            largestIndex = rightChild;
        }
        if(largestIndex != parentIndex){
            int tmp = array[largestIndex];
            array[largestIndex] = array[parentIndex];
            array[parentIndex] = tmp;

            heapify(array, arrayLength, largestIndex);
        }
    }
}
