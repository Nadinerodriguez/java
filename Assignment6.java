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
