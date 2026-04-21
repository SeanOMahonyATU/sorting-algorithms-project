public class BubbleSortStep1 {

    public static void main(String[] args) {

        int[] numbers = {5, 3, 8, 1, 7, 11, 25, 99};

        // test commit
        System.out.println("Before:");
        printArray(numbers);

        
        //bubbleSort(numbers);
        //selectionSort(numbers);
        insertionSort(numbers);


        System.out.println("After:");
        printArray(numbers);
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
    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}