import java.util.*;
public class Question4{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String args[]){
		int limit = Integer.MAX_VALUE;
		long n = 1;
		long sum = 1;
		while(n<limit){
			long prod = n*n;
			if(prod==sum){
				print("Value of i: "+n+"\n");
			}
			n++;
			sum+=n;
		}
	}   
                             
}