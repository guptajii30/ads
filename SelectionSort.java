	package adsJva;
	import java.util.Scanner;
	
	public class SelectionSort {
		public static void selectionSort(long list[]) {
		
			int size=list.length;
			
			for(int hold=0; hold<size; hold++) {
				int pos=hold;
				 int flag=0;
				
				//finding the index smallest element
				for(int walker=hold+1; walker<size; walker++) {
					if(list[walker]<list[pos]) {
						pos=walker;
					}
				}
				//swapping the smallest element with the element at the hold position
				if(hold !=pos) {
					long temp=list[pos];
					list[pos]=list[hold];
					list[hold]=temp;
					
					flag= 1;
				}
				//if no swap occured, the array is already sorted
				if(flag==0) {
					break;
				}
				//printing the array after each pass
				System.out.print("\nPass: "+(hold+1)+": ");
				for(int i =0; i<size; i++) {
					System.out.print(list[i]+" ");
				}
				//System.out.println(); // Move to a new line after each pass
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			
			System.out.print("Enter the array size: ");
	        int size = sc.nextInt();
	
	        long[] list = new long[size];
	        System.out.println("\nEnter the array elements: ");
	        for (int i = 0; i < size; i++) {
	            list[i] = sc.nextLong();
	        }
	        System.out.print("\nUnsorted Array: ");
	        for (long item : list) {
	            System.out.print(item + " ");
	        }
	        System.out.println("\n\nSorting array using selection sort :");
	        selectionSort(list);
	
	        System.out.print("\n\nSorted Array: ");
	        for (long item : list) {
	            System.out.print(item + " ");
	        }
	        sc.close();
		}
	
	}