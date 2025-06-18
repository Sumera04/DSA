/**
 * Implements a stack using two queues (Push-efficient).
 * 
 * In this implementation:
 * - The `push()` operation is efficient (O(1)).
 * - The `pop()` operation is more expensive (O(n)).
 * 
 * This simulates Last-In-First-Out (LIFO) behavior using two FIFO queues.
 *
 * Time Complexity:
 * - push(x): O(1)
 * - pop(): O(n)
 * - top(): O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n), for storing elements in two queues.
 */

class MyStack {
    Queue<Integer> q1, q2;
    int top;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
        top = x; // update the top element
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        int size = q1.size();

        // Move all but the last element to q2
        for (int i = 0; i < size - 1; i++) {
            top = q1.poll(); // update top to the second-last inserted element
            q2.add(top);
        }

        int ans = q1.poll(); // last inserted = top of stack

        // Swap q1 and q2 to reuse q1 as main queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    // Get the top element
    public int top() {
        return top;
    }

    // Return whether the stack is empty
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}