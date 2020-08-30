import java.util.*;
class ArraySet{
	private ArrayList<Integer> arr;
	ArraySet(){
		arr = new ArrayList<Integer>();
	}
	public boolean add(int key){
		if(arr.contains(key)) return false; //O(n) operation
		arr.add(key); //O(1) amortized complexity
		return true;
	}
	public boolean remove(int key){
		if(!arr.contains(key)) return false;
		arr.remove(key); //O(n)
		return true;
	}
	public boolean contains(int key){
		return arr.contains(key); //O(n)
	}
	public void addAll(ArrayList<Integer> obj){
		for(int x: obj){
			this.add(x);
		}
	}
	public String toString(){
		return arr.toString();
	}
	public static ArraySet union(ArraySet set1, ArraySet set2){ //O(n^2)
		ArraySet ans = new ArraySet();
		for(int x : set2.arr){
			ans.add(x);
		}
		for(int x : set1.arr){
			ans.add(x);
		}
		return ans;
	}
	public static ArraySet intersection(ArraySet set1, ArraySet set2){ //O(n^2)
		if(set1.arr.size()<set2.arr.size()){
			return intersection(set2,set1);
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int x:set1.arr){
			if(set2.contains(x)){
				temp.add(x);
			}
		}
		ArraySet ans = new ArraySet();
		ans.addAll(temp);
		return ans;
	}
	public static ArraySet difference(ArraySet set1, ArraySet set2){ //O(n^2)
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int x: set1.arr){
			if(!set2.contains(x)){
				temp.add(x);
			}
		}
		ArraySet ans = new ArraySet();
		ans.addAll(temp);
		return ans;
	}
}
public class Question5{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		print("Enter set A size:\n");
		int a = sc.nextInt();
		ArrayList<Integer> set1_ele = new ArrayList<Integer>(a);
		print("Enter set A elements:\n");
		for(int i = 0;i<a;i++){
			set1_ele.add(sc.nextInt());
		}
		print("Enter set B size:\n");
		int b = sc.nextInt();
		ArrayList<Integer> set2_ele = new ArrayList<Integer>(b);
		print("Enter set B elements:\n");
		for(int i = 0;i<b;i++){
			set2_ele.add(sc.nextInt());
		}
		long startTime, endTime, duration;

		print("\n\n\n");
		print("********Array Set Implementation********\n");
		ArraySet A = new ArraySet();
		ArraySet B = new ArraySet();
		startTime = System.nanoTime();
		A.addAll(set1_ele);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		print("Insertion operation performed in: "+duration+"ns.\n");
		B.addAll(set2_ele);
		print("Set A: "+A.toString()+"\n");
		print("Set B: "+B.toString()+"\n");

		startTime = System.nanoTime();
		ArraySet union_set = ArraySet.union(A,B);
		endTime = System.nanoTime();
		duration = -startTime + endTime;
		print("Union operation performed in: "+duration+"ns.\n");
		print("Resulting Union Set: "+ union_set.toString()+"\n");

		startTime = System.nanoTime();
		ArraySet inter_set = ArraySet.intersection(A,B);
		endTime = System.nanoTime();
		duration = -startTime + endTime;
		print("Intersection operation performed in: "+duration+"ns.\n");
		print("Resulting Intersection Set: "+ inter_set.toString()+"\n");

		startTime = System.nanoTime();
		ArraySet diffab_set = ArraySet.difference(A,B);
		endTime = System.nanoTime();
		duration = -startTime + endTime;
		print("A-B operation performed in: "+duration+"ns.\n");
		print("Resulting A-B Set: "+ diffab_set.toString()+"\n");

		startTime = System.nanoTime();
		ArraySet diffba_set = ArraySet.difference(B,A);
		endTime = System.nanoTime();
		duration = -startTime + endTime;
		print("Intersection operation performed in: "+duration+"ns.\n");
		print("Resulting Intersection Set: "+ diffba_set.toString()+"\n");

		print("\n\n\n");
		print("********Java Util Set Implementation********\n");
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();
		startTime = System.nanoTime();
		setA.addAll(set1_ele);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		setB.addAll(set2_ele);
		print("Insertion operation performed in: "+duration+"ns.\n");
		print("Set A: "+setA.toString()+"\n");
		print("Set B: "+setB.toString()+"\n");

		Set<Integer> unionSet = new HashSet<Integer>(setA);
		startTime = System.nanoTime();
		unionSet.addAll(setB);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		print("Union operation performed in: "+duration+"ns.\n");
		print("Resulting Union Set: "+unionSet.toString()+"\n");

		Set<Integer> interSet = new HashSet<Integer>(setA);
		startTime = System.nanoTime();
		interSet.retainAll(setB);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		print("Intersection operation performed in: "+duration+"ns.\n");
		print("Resulting Intersection Set: "+interSet.toString()+"\n");

		Set<Integer> diffabSet = new HashSet<Integer>(setA);
		startTime = System.nanoTime();
		diffabSet.removeAll(setB);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		print("A-B operation performed in: "+duration+"ns.\n");
		print("Resulting A-B Set: "+diffabSet.toString()+"\n");

		Set<Integer> diffbaSet = new HashSet<Integer>(setB);
		startTime = System.nanoTime();
		diffbaSet.removeAll(setA);
		endTime = System.nanoTime();
		duration = endTime-startTime;
		print("B-A operation performed in: "+duration+"ns.\n");
		print("Resulting B-A Set: "+diffbaSet.toString()+"\n");

		print("\n\n\n");
		print("Conclusion:\nInBuilt HashSet implementation performs better than Array Implementation!\n");
	}
}