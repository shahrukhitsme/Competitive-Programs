/*
Question Link:https://leetcode.com/problems/min-stack/
Approach1: Use a stack. When pushing, check if the minimum needs to be updated. If yes, first push the old minimum and then the number, and update the minimum variable.
When popping, check if the minimum element is being popped out, then pop the one below that and store it in min variable as it is the old minimum.
Approach2: Using a List of Lists. The inner list contains the number, and the minimum value uptil that point.
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
//Approach1
class MinStack {
    /** initialize your data structure here. */
	Stack<Integer> stack;
	int min = Integer.MAX_VALUE;
    public MinStack() {
		stack = new Stack<>();
    }
    
    public void push(int x) {
		if(x<=min){
			stack.push(min);
			min = x;
		}
		stack.push(x);
    }
    
    public void pop() {
		if(stack.pop()==min)
			min = stack.pop();
    }
    
    public int top() {
		return stack.peek();
    }
    
    public int getMin() {
		return min;
    }
}

//Approach2
/*
class MinStack {
    List<List<Integer>> nums;
    public MinStack() {
        nums = new ArrayList<>();
    }
    
    public void push(int x) {
        List<Integer> val = new ArrayList<>();
        val.add(x);
        if(nums.size()==0)
            val.add(x);
        else
            val.add(Math.min(x, nums.get(nums.size()-1).get(1)));
        nums.add(val);
            
    }
    
    public void pop() {
        nums.remove(nums.size()-1);
    }
    
    public int top() {
        return nums.get(nums.size()-1).get(0);
    }
    
    public int getMin() {
        return nums.get(nums.size()-1).get(1);
    }
}
*/