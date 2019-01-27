//Implement stacks using Queues
import java.util.Queue;

class Stack {
	
	Queue q1;
	Queue q2;
	int size;

	Stack(){
		q1 = new Queue<Integer>();
		q2 = new Queue<Integer>();
		size = 0;
	}

	public void push(int x){

		//Add most recent element to empty queue
		q2.add(x);
		size++;

		//Add older elements from old queue to empty queue
		while(	q1.size()!=0 ){
			q2.add(q1.remove());
		}

		//Swap the names of queue to so that q2 is always empty
		Queue qq = q2;
		q2 = q1;
		q1 = qq;


	}

	public int pop(){
		if(size != 0){
			size--;
			return (int)(q1.remove());
		}
		return -1;

	}

	public int top(){
		if(size != 0){
			return (int)(q1.peek());
		}
		return -1;

	}

	public static void main(String[] args){
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		System.out.println(s.pop());
		System.out.println(s.top());
	}

};
