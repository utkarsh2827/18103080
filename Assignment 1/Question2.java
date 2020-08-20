import java.util.*;
public class Question2{
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter size of word vector:\n");
    	int n = sc.nextInt();
    	print("Enter words needed to be reduced: \n");
    	Set<String> set = new HashSet<String>();
    	for(int i = 0;i<n;i++){
    		set.add(sc.next());
    	}
    	print("Enter word 'paraend' to mark the end of paragraph\n");
    	print("Enter the paragraph:\n");
    	String word = sc.next();
    	StringBuffer para = new StringBuffer();
    	while(!word.equals("paraend")){
    		if(set.contains(word)){
    			para.append(word.charAt(0)+"");
    			for(int i = 1;i<word.length();i++){
    				para.append("*");
    			}
    			para.append(" ");
    		}
    		else{
    			para.append(word);
    			para.append(" ");
    		}
    		word = sc.next();
    	}
    	print("Answer:\n");
    	print(para.toString().trim());
    	print("\n");
    	
    }   
}