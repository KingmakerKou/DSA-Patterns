class StackQueue {
    private Stack<Integer> st1, st2;

    // Constructor
    public StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // Method to push elements in the queue
    public void push(int x) {
        /* Pop out elements from the first stack 
        and push on top of the second stack */
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        // Insert the desired element
        st1.push(x);

        /* Pop out elements from the second stack 
        and push back on top of the first stack */
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    // Method to pop element from the queue
    public int pop() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }

        // Get the top element
        int topElement = st1.pop(); // Perform the pop operation

        return topElement; // Return the popped value
    }

    // Method to get the front element from the queue 
    public int peek() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }

        // Return the top element
        return st1.peek();
    }

    // Method to find whether the queue is empty
    public boolean isEmpty() {
        return st1.isEmpty();
    }
}
