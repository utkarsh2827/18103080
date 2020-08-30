import java.util.*;
public class Question6{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		print("Enter the number:\n");
		int n = sc.nextInt();
		int temp = n;
		print("HailStone Sequence:\n");
		do{
			print(n+"\n");
			if((n&1)==0){
				n = n/2;
			}
			else{
				n = n*3+1;
			}
		}while(n>1);
		print(n+"\n");
	}   
                             
}