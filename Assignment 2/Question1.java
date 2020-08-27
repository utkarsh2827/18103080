import java.util.*;
public class Question1{
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
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	print("Enter first string:\n");
    	String first = sc.nextLine();
    	print("Enter second string:\n");
    	String second = sc.nextLine();
    	print("Strings in Lexicographical Order:\n");
    	if(compareTo(first, second)<0){
    		print(first+" "+second);
    	}
    	else{
    		print(second + " "+ first);
    	}
    	print("\n");
    }   
                             
}