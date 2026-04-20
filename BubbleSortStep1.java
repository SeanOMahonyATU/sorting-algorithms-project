public class BubbleSortStep1 {

    public static void main(String[] args) {

        int[] numbers = {5, 3, 8, 1};

        System.out.println("Before sorting:");
        printArray(numbers);

        // Call Bubble Sort METHOD
        bubbleSort(numbers);

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

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}