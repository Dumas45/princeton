package study.algs4;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The Queue example from the book.
 *
 * <p>How to run the example from the CLI with parameters using the Maven (run it from the project root directory):
 * <pre>{@code
 *   mvn compile exec:java -Dexec.mainClass="study.algs4.Queue" < target/classes/test_queue_input.txt
 * }</pre>
 *
 */
public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public List<Item> list() {
        List<Item> res = new ArrayList<>(this.N);
        Node node = this.first;
        do {
            if (node != null) {
                res.add(node.item);
                node = node.next;
            }
        } while (node != null);
        return res;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);

                StdOut.println("+ " + ("" + item + "          ").substring(0, 10) + " " + q.size() + "  " + q.list());
            }
            else if (!q.isEmpty()) {
                String del_item = q.dequeue();

                StdOut.println("- " + ("" + del_item + "          ").substring(0, 10) + " " + q.size() + "  " + q.list());
            }
        }

        StdOut.println("(" + q.size() + " left on queue: " + q.list() + ")");
    }
}
