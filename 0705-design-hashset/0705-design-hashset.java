class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return Math.abs(key) % SIZE;
    }

    public void add(int key) {
        int index = hash(key);

        // Check if key already exists
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return;
            }
            current = current.next;
        }

        // Insert at the beginning of the chain
        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public boolean contains(int key) {
        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void remove(int key) {
        int index = hash(key);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {

                if (previous == null) {
                    // Removing the first node
                    buckets[index] = current.next;
                } else {
                    // Removing a node from the middle/end
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }
}
