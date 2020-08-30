import java.util.*;
public class Question2{
	static final int MAX_SIZE = 21;
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void count_sort(int arr[]){
		int counts[] = new int[MAX_SIZE];
		for(int x:arr){
			if(x>20||x<0){
				print("Array elements out of range\n");
				System.exit(0);
			}
			counts[x]++;
		}
		int k = 0,i = 0;
		while(k<21&&i<arr.length){
			if(counts[k]<1) k++;
			else{
				arr[i++] = k;
				counts[k]--;
			}
		}
	}
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	print("Enter array size:\n");
		int n = sc.nextInt();
		print("Enter elements between 1 to 20:\n");
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		count_sort(arr);
		print("Array after Sorting:\n"+Arrays.toString(arr)+"\n");
    }   
                             
}