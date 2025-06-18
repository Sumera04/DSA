/**
 * Implements a stack using a single queue (Pop-efficient / Costly Push version).
 *
 * In this implementation:
 * - The `push()` operation is expensive (O(n)), as it rearranges elements to simulate stack.
 * - The `pop()` and `top()` operations are efficient (O(1)).
 *
 * This simulates Last-In-First-Out (LIFO) behavior using a single FIFO queue.
 *
 * Time Complexity:
 * - push(x): O(n)
 * - pop(): O(1)
 * - top(): O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n), where n is the number of elements in the stack.
 */

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // Push element onto stack (costly push)
    public void push(int x) {
        queue.add(x);
        int size = queue.size();

        // Rotate the queue to place the new element at the front
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack
    public int pop() {
        return queue.poll(); // Front of the queue = top of the stack
    }

    // Get the top element
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}
