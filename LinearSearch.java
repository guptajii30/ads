package adsJva;
import java.util.Scanner;

public class LinearSearch {

	public static int linearSearch(int []num, int size, int key) {
		for (int i=0; i<size; i++) {
			if(num[i]==key)	{
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter The Array Size: ");
		int size=sc.nextInt();
		
		int []num=new int[size];
		System.out.println("Enter The Array Element: ");
		for(int i=0; i<size; i++) {
			num[i]=sc.nextInt();
		}
		System.out.println("Enter Target OR Key: ");
		int key= sc.nextInt();
		
		int output= linearSearch(num, size, key);
		if(output==1) {
			System.out.println("The "+ key+" is not found!! ");
		}else {
			System.out.println("The "+key+" is found at Index: "+output);
		}
		sc.close();
	}

}
