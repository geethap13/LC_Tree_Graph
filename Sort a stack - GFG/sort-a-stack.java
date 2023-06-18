//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
// 	public Stack<Integer> sort(Stack<Integer> s)
// 	{
// 		//add code here.
// 	}
	 public void insert(Stack<Integer> s,int temp){
        if(s.size()==0 || s.peek()<=temp){
            s.push(temp);
            return;
        }
        int val = s.pop();
        insert(s,temp);
        s.push(val);
    }
    public void sortstack(Stack<Integer> s){
        if(s.size()== 1) return;
        int val = s.pop();
        sortstack(s);
        insert(s,val);
    }
    public  Stack<Integer> sort(Stack<Integer> s)
    {
        // add your code here
        sortstack(s);
        return s;
        
    }
}