import java.util.*;
public class Question1{
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	String st1 = sc.next();
    	String st2 = sc.next();
    	if(st2.length()>st1.length()){
    		print("0\n");
    		return;
    	}
    	char st[] = st2.toCharArray();
    	Arrays.sort(st);
    	st2 = new String(st);
    	int k= st2.length();
    	int ans = 0;
    	for(int i = 0;i<=st1.length()-k;){
    		String sub = st1.substring(i,i+k);
    		st = sub.toCharArray();
    		Arrays.sort(st);
    		sub = new String(st);
    		if(sub.equals(st2)){
    			ans++;
    			// print(i+"\n");
    			i+=k;
    		}
    		else{
    			i++;
    		}
    	}
    	print("Answer(Each character included in 1 substring only): "+ans+"\n");
    }   
                             
}