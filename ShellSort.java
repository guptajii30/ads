package adsJva;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ShellSort {
	public static void shellSort(int[]arr, int n) {
		int pass=1;
		for(int gap=n/2; gap>0; gap/=2) {
			for(int i= gap; i<n; i++) {
				int temp=arr[i];//sorting gap element in temp
				int j;
				for (j=i; j>=gap && arr[j-gap]>temp; j-=gap) {
					arr[j]=arr[j-gap];
				}
				arr[j]=temp; // Placing temp element at appropriate position
			}
			 // Printing the array after each pass
			System.out.println("\nGap= "+gap+ "\nPass "+pass+": ");
			for(int k=0; k<n; k++) {
				System.out.print(" "+arr[k]+" ");
			}
			pass++;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 15;
		int[] myArray= new int[size];
		
		// Reading data from file
		try {
			File file=new File("num.txt");
			Scanner sc=new Scanner(file);
			
			for (int i = 0; i < size && sc.hasNextInt(); i++) {
                myArray[i] = sc.nextInt();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to Open File For Reading.");
            return;
        }

        // Displaying the array before sorting
        System.out.println("Array before sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        // Sorting the array
        shellSort(myArray, size);

        // Displaying the array after sorting
        System.out.println("\n\nArray after sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}