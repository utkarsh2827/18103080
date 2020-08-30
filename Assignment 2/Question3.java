import java.util.*;
public class Question3{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int compareTo(String first, String second){
		int n1 = first.length();
		int n2 = second.length();
		int k = 0;
		while(k<n1&&k<n2){
			char c1 = first.charAt(k), c2 = second.charAt(k); 
			if(c1!=c2){
				return c1-c2;
			}
			k++;
		}
		return n1-n2;
	}
	public static void merge(String arr[], int start, int mid, int end){
		int m = mid-start+1;
		int n = end-mid;
		String left[] = new String[m];
		String right[] = new String[n];
		int i,j,k;
		for(i=0;i<m;i++){
			left[i] = arr[start+i];
		}
		for(i=0;i<n;i++){
			right[i] = arr[mid+1+i];
		}
		i = 0;j=0;k=start;
		while(i<m&&j<n){
			if(compareTo(left[i].toLowerCase(),right[j].toLowerCase())<=0){
				arr[k++] = left[i++];
			}
			else{
				arr[k++] = right[j++];
			}
		}
		while(i<m){
			arr[k++] = left[i++];
		}
		while(j<n){
			arr[k++] = right[j++];
		}
	}
	public static void sort(String arr[], int start, int end){
		if(start<end){
			int mid = start + (end-start)/2;
			sort(arr,start,mid);
			sort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
		print("Enter array size:\n");
		int n = sc.nextInt();
		print("Enter elements:\n");
		String arr[] = new String[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.next();
		}
		sort(arr,0,n-1);
		print("Sorted Array:\n"+Arrays.toString(arr)+"\n");
    }   
                             
}