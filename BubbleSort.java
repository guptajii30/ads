package adsJva;
import java.util.Scanner;

public class BubbleSort {
	
	public static void bubbleSort(long []list, long size) {
		for(long hold=0; hold<size; hold++) {
			boolean swapped=false;//no swap 

			for(long going=0; going<size-hold-1; going++) {
				if(list[(int) going]>list[(int)(going+1)]){
					//swap element
					long temp=list[(int)going];
					list[(int)going]=list[(int)(going+1)];
					list[(int)(going+1)]=temp;
					swapped=true;	
				}
			}
			if (!swapped) {
				 break;
			}
			System.out.println("\nPass "+(hold+1)+": ");
			for(long item: list) {
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		System.out.println("Enter the Size Of Array: ");
		int size=sc.nextInt();
		
		long[]num =new long[size];
		System.out.println("Enter the UnSorted Array: ");
		for(int i=0; i<size; i++) {
			num[i]=sc.nextLong();
		}
		System.out.println("\nUnsorted Array: ");
		for(long item: num) {
		System.out.print(item+" ");
		}
		bubbleSort(num, size);
		
		System.out.print("\n\nSorted Array: ");
        for (long item : num) {
            System.out.print(item + " ");
        }
        sc.close();
	}

}
