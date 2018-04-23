package stack;

public class ImplUsingArray {

	public static final int MAX_SIZE = 50;
	int[] array = new int[MAX_SIZE];
	int top = -1;
	
	public void push(int x) {
		if(top == MAX_SIZE - 1)
			return; // "array is full. can't push anything!";
		array[++top] = x;
	}
	
	public void pop() {
		if(top == -1)
			return; // "array is empty. can't pop!"
		top--;
	}
	
	public int top() {
		return array[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void print() {
		for(int i = 0; i<=top; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	
	public static void main(String[] args) {
		ImplUsingArray imAr = new ImplUsingArray();
		imAr.push(10);
		imAr.push(100);
		imAr.push(1000);
		imAr.push(10000);
		imAr.push(100000);
		System.out.println("After pushes");
		//here top element comes last in display
		System.out.println("current_top:"+imAr.top());

		imAr.print();

		System.out.println();
		imAr.pop();
		imAr.pop();
		System.out.println("After pop");
		imAr.print();
		
		int top = imAr.top();
		System.out.println();
		System.out.println("current_top:"+top);
		
		System.out.println("isEmpty:"+imAr.isEmpty());
	}
}
