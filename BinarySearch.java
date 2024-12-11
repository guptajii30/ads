package adsJva;
import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int size, int[] num, int key){
		int low=0;
		int high=size-1;
		
		while(low<=high) {
			int mid = low + (high - low) / 2;
			if (num[mid]==key) {
				return mid;
			}else if(num[mid]<key) {
				low=mid+1;
			}else {
				high= mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Size Of Array: ");
		int size=sc.nextInt();
		
		int[]num=new int[size];
		System.out.println("Enter The Array Element: ");
		for(int i=0; i<size; i++) {
			num[i]=sc.nextInt();
		}
		System.out.println("Enter the target or key: ");
		int key=sc.nextInt();
		
		int result=binarySearch(size, num, key);
		if (result==-1) {
			System.out.println("The "+key+" is not found ");
		}else {
			System.out.println("The "+key+" is found at Index "+result);
		}
		sc.close();
	}

}
