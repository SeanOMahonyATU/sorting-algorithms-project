

public class BubbleSortStep1 {

    public static void main(String[] args) {

    int[] sizes = {15342, 487, 19201, 8347, 120, 17654, 9021, 45, 19998, 6310};
    int runs = 10;
    

    System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s%n",
            "N", "Bubble", "Select", "Insert", "Merge", "Count");

    for (int size : sizes) {

        long bubbleTotal = 0;
        long selectionTotal = 0;
        long insertionTotal = 0;
        long mergeTotal = 0;
        long countingTotal = 0;

        for (int i = 0; i < runs; i++) {

            int[] base = randomArray(size);

            bubbleTotal += timeSort(() -> bubbleSort(base.clone()));
            selectionTotal += timeSort(() -> selectionSort(base.clone()));
            insertionTotal += timeSort(() -> insertionSort(base.clone()));
            mergeTotal += timeSort(() -> mergeSort(base.clone()));
            countingTotal += timeSort(() -> countingSort(base.clone()));
        }

        System.out.printf("%-8d %-10.3f %-10.3f %-10.3f %-10.3f %-10.3f%n",
                size,
                bubbleTotal / (double) runs,
                selectionTotal / (double) runs,
                insertionTotal / (double) runs,
                mergeTotal / (double) runs,
                countingTotal / (double) runs
        );
    }
}

    // Bubble Sort method
    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {

                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
// Selection Sort method
public static void selectionSort(int[] numbers) {

    int n = numbers.length;

    for (int i = 0; i < n - 1; i++) {

        int minIndex = i;

        // Find the index of the smallest element
        for (int j = i + 1; j < n; j++) {
            if (numbers[j] < numbers[minIndex]) {
                minIndex = j;
            }
        }

        // Swap the smallest element with the current position
        int temp = numbers[minIndex];
        numbers[minIndex] = numbers[i];
        numbers[i] = temp;
    }
}
// Insertion Sort method
public static void insertionSort(int[] numbers) {

    for (int i = 1; i < numbers.length; i++) {

        int key = numbers[i];
        int j = i - 1;

        // Move elements greater than key to one position ahead
        while (j >= 0 && numbers[j] > key) {
            numbers[j + 1] = numbers[j];
            j--;
        }

        numbers[j + 1] = key;
    }
}

// Merge Sort main method
public static void mergeSort(int[] numbers) {
    if (numbers.length < 2) {
        return; // base case
    }

    int mid = numbers.length / 2;

    int[] left = new int[mid];
    int[] right = new int[numbers.length - mid];

    for (int i = 0; i < mid; i++) {
        left[i] = numbers[i];
    }

    for (int i = mid; i < numbers.length; i++) {
        right[i - mid] = numbers[i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(numbers, left, right);
}
// Merge helper method
private static void merge(int[] numbers, int[] left, int[] right) {

    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            numbers[k++] = left[i++];
        } else {
            numbers[k++] = right[j++];
        }
    }

    while (i < left.length) {
        numbers[k++] = left[i++];
    }

    while (j < right.length) {
        numbers[k++] = right[j++];
    }
}
// Counting Sort method (non-comparison sort)
public static void countingSort(int[] numbers) {

    // Find the maximum value in the array
    int max = numbers[0];
    for (int num : numbers) {
        if (num > max) {
            max = num;
        }
    }

    // Create count array
    int[] count = new int[max + 1];

    // Count occurrences of each number
    for (int num : numbers) {
        count[num]++;
    }

    // Rebuild the sorted array
    int index = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            numbers[index++] = i;
            count[i]--;
        }
    }
}

// Generates an array of n random integers between 0 and 99
public static int[] randomArray(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
        array[i] = (int)(Math.random() * 100);
    }
    return array;
}

// Measures execution time of a sorting method (in milliseconds)
public static double timeSort(Runnable sort) {
    long startTime = System.nanoTime();
    sort.run();
    long endTime = System.nanoTime();
    return (endTime - startTime) / 1_000_000.0;
}

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}