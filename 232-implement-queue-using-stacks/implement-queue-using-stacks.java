/**
 * Implements a Queue using two Stacks.
 * 
 * This simulates First-In-First-Out (FIFO) behavior using two LIFO stacks.
 *
 * Approach:
 * - `stack1` is used for enqueue operations (push).
 * - `stack2` is used for dequeue operations (pop/peek).
 * - Elements are only transferred from stack1 to stack2 when stack2 is empty.
 *
 * Time Complexity:
 * - push(x): O(1)
 * - pop(): Amortized O(1)
 * - peek(): Amortized O(1)
 * - empty(): O(1)
 *
 * Space Complexity: O(n), where n is the number of elements in the queue.
 */

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2 to reverse order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Get the front element
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer elements only if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Return whether the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
