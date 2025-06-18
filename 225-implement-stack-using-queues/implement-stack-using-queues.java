/**
 * Implements a stack using two queues (Pop-efficient version).
 * 
 * In this implementation:
 * - The `push()` operation is expensive (O(n)) — rearranges queue to keep top at front.
 * - The `pop()` and `top()` operations are efficient (O(1)).
 * 
 * This simulates Last-In-First-Out (LIFO) behavior using two FIFO queues.
 *
 * Time Complexity:
 * - push(x): O(n)
 * - pop(): O(1)
 * - top(): O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n), for storing elements in queues.
 */

class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element onto stack (costly push)
    public void push(int x) {
        // Step 1: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Step 2: Add new element to q1
        q1.add(x);

        // Step 3: Add back all elements to q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    // Removes the element on top of the stack
    public int pop() {
        return q1.poll();
    }

    // Get the top element
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}