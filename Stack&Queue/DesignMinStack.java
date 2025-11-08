//design a min stack that does the push , pop , top , GetMin() -> always returns the min value in the stack  .. all these in O(1) constant time

//brute force
class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val , val});
        }else{
            int min = Math.min(val , st.peek()[1]);
            st.push(new int[]{val , min});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}

//time -> O(1)
//space --> O( 2 * N)

//optimized approach
