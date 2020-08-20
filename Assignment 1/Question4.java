import java.util.*;
public class Question4{
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter 1st String:\n");
        char str1[] = sc.next().toCharArray();
        char str2[] = sc.next().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        print(Arrays.equals(str1,str2)+"\n");    	
    }   
                             
}