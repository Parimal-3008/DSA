class MinStack {
    Stack<Integer> st = null;
    TreeMap<Integer,Integer> mp = null;
    public MinStack() {
        st = new Stack<>();
        mp = new TreeMap<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(mp.containsKey(val))
            mp.put(val,mp.get(val)+1);
        else
            mp.put(val,1);
    }
    
    public void pop() {
        int val = st.pop();
         mp.put(val,mp.get(val)-1);
        if(mp.get(val)==0)
            mp.remove(val);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
      return  mp.firstKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */