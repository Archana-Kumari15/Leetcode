class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        // st.push(x);

        if(st.size() == 0) st.push(x);
        else{
            while(st.size()>0){
                helper.push(st.pop());
            }
            st.push(x);
            while(helper.size() > 0){
                st.push(helper.pop());
            }
        }
    }
    
    public int pop() {
        // while(st.size() > 1){
        //     helper.push(st.pop());
        // }
        // int val = st.pop();
        // while(helper.size() > 0){
        //     st.push(helper.pop());
        // }
        // return val;

        return st.pop();
    }
    
    public int peek() {
        // while(st.size() > 1){
        //     helper.push(st.pop());
        // }
        // int val = st.peek();
        // while(helper.size() > 0){
        //     st.push(helper.pop());
        // }
        // return val;

        return st.peek();
    }
    
    public boolean empty() {
        if(st.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */