import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BubbleSortAssignment {

    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101);  
        }
        return array;
    }


    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }


    public static int[] readFileToArray(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            return new int[0];
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of elements for the array:");
        int arrayLength = scanner.nextInt();
        
        int[] randomArray = createRandomArray(arrayLength);
        
        System.out.println("Enter the filename to write the array:");
        String filename = scanner.next();
        writeArrayToFile(randomArray, filename);
        
        int[] fileArray = readFileToArray(filename);
        System.out.println("Array read from file:");
        for (int num : fileArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        bubbleSort(fileArray);
        System.out.println("Sorted array:");
        for (int num : fileArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.println("Enter the filename to save the sorted array:");
        String sortedFilename = scanner.next();
        writeArrayToFile(fileArray, sortedFilename);
        
        scanner.close();
    }
}
