public class BubbleSortStep1 {

    public static void main(String[] args) {

        int[] numbers = {5, 3, 8, 1};

        System.out.println("Before sorting:");
        printArray(numbers);

        
        //bubbleSort(numbers);
        selectionSort(numbers);


        System.out.println("After sorting:");
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
    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}