import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter an input: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        parenthesesBalanced(input);
    }
    public static boolean parenthesesBalanced(String input) throws Exception {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[') stack.push(curr);
            else if(curr == ')' || curr == '}' || curr ==']') {
                try {
                    if ( !(matchedParentheses(stack.pop(), curr)) ) {
                        System.out.println("Parentheses aren't balanced");
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("Parentheses aren't balanced");
                    return false;
                }
            }
        }
        if(stack.size() != 0)
            System.out.println("Parentheses aren't balanced");
        else
            System.out.println("Parentheses are balanced");
        return false;
    }
    // For extra credit
    public static boolean matchedParentheses(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        return false;
    }
}
class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T d) {
        data = d;
    }

    public void setNext(Node<T> n) {
        next = n;
    }
}
class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addHead(Character d) {
        Node<T> n = new Node<T>((T) d, head);
        head = n;
        size++;
    }

    public Character removeHead() throws Exception {
        if (head == null)
            throw new Exception("Empty List");
        Node<T> n = head;
        head = head.getNext();
        size--;
        return (Character) n.getData();
    }

    public String toString() {
        String ans = "";
        Node n = head;
        while (n != null) {
            ans += n.getData();
            ans += "-->";
            n = n.getNext();
        }
        return ans;
    }
}
class Stack<T> {
    private LinkedList data;

    public Stack() {
        data = new LinkedList();
    }

    public T pop() throws Exception {
        return (T) data.removeHead();
    }

    public void push(T x) {
        data.addHead((Character)x);
    }

    public int size() {
        return data.size();
    }
}
