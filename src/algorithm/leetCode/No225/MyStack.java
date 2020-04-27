package algorithm.leetCode.No225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> storeQueue;
    Queue<Integer> popQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        storeQueue = new LinkedList();
        popQueue = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        storeQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int x;
        while (storeQueue.size() != 1) {
            popQueue.add(storeQueue.poll());
        }
        x = storeQueue.poll();
        while (!popQueue.isEmpty()) {
            storeQueue.add(popQueue.poll());
        }
        return x;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int x;
        while (storeQueue.size() != 1) {
            popQueue.add(storeQueue.poll());
        }
        x = storeQueue.peek();
        popQueue.add(storeQueue.poll());
        while (!popQueue.isEmpty()) {
            storeQueue.add(popQueue.poll());
        }
        return x;

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return storeQueue.isEmpty() && popQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */