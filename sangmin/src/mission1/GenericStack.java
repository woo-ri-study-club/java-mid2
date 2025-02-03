package mission1;

import java.util.ArrayList;

public class GenericStack <T>{
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Peek: " + intStack.peek()); // 20
        System.out.println("Pop: " + intStack.pop()); // 20
        System.out.println("Size: " + intStack.size()); // 1

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Peek: " + stringStack.peek()); // World
    }
}
