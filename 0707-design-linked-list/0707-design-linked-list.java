class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index >= length || index < 0)
            return -1;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return (temp != null) ? temp.val : -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        length++;
    }

    public void addAtTail(int val) {
        if (length == 0) {
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        length++;
    }

    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index == length) {
            addAtTail(val);
            return;
        }
        if (index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        length++;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length || head == null) {
            return;
        }
        Node temp = head;
        if (index == 0) {
            head = temp.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null)
                temp.next = temp.next.next;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */