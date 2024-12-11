package adsJva;
import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int[]list, int n) {
		int hold, walker;
		boolean swapped=false;
		
		for(int key=0; key<n; key++) {
			walker=key-1;
			hold=list[key];
			swapped=false;
			
			//find the correct position for'hold'
			while(walker>=0 && list[walker] > hold) {
				list[walker+1]=list[walker];
				walker--;
				//swapped=true;
			}
			list[walker+1]=hold;
			
			System.out.println("\nPass "+key+": ");
			for(int item: list) {
				System.out.print(item+" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the array size: ");
        int size = sc.nextInt();

        int[] list = new int[size];
        System.out.println("\nEnter the array elements: ");
        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }
        System.out.print("\nUnsorted Array: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println("\n\nSorting array:");
        insertionSort(list, size);

        System.out.print("\n\nSorted Array: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
        sc.close();
	}

}
