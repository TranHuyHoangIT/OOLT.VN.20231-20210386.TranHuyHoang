import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap so phan tu cua array: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		int sum = 0;
		System.out.print("Nhap cac phan tu: ");
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		double avg = (double)sum/size;
		for(int i = 0; i < size-1; i++) {
			for(int j = i+1; j < size; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.print("Sorted array: "); 
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nSum: " + sum);
		System.out.print("Average: " + avg);
	}
}
