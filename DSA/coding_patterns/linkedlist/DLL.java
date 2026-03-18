class Node {
    Node next;
    Node prev;
    int val;
}

class DDLMethods {
    Node head;
    Node tail;

    void insertFront(int val) {
        Node newNode = new Node();
        newNode.val = val;

        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertLast(int val) {
        Node newNode = new Node();
        newNode.val = val;

        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void deleteFront() {
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        if (head != null) {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast() {

        if (tail != null) {
            if (tail.prev == null) {
                tail = null;
                head = null;
                return;
            }
            Node prev = tail.prev;
            prev.next = null;
            tail.prev = null;
            tail = prev;
        }
    }

    void printDLLForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    void printDLLBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }

    void arrayToDLL(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insertLast(arr[i]);
        }
    }

    void reverseDDL() {
        // thought from swap two var concept
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            prev = cur.prev;
            cur.prev = cur.next;
            cur.next = prev;
            cur = cur.prev;
        }
        head = prev.prev;
    }

    void insertBeforeTail(int val) {

        if (tail == null) {
            insertFront(val);
            return;
        }

        Node newNode = new Node();
        newNode.val = val;

        if (tail.prev == null) {
            head = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            return;
        }

        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        tail.prev = newNode;
        newNode.next = tail;
    }

    void insertBeforeHead(int val) {

        if (tail == null) {
            insertFront(val);
            return;
        }

        Node newNode = new Node();
        newNode.val = val;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void deleteKthNode(int k) {
        Node temp = head;
        int cnt = 1;
        if (head == null) {
            return;
        }

        if (head != null && head.next == null && head.prev == null) {
            head = null;
            tail = null;
            return;
        }

        while (temp != null) {
            if (k == cnt) {
                break;
            }
            cnt++;
            temp = temp.next;
        }

        Node prev = temp.prev;
        Node next = temp.next;

        if (prev != null)
            prev.next = next;

        if (next != null)
            next.prev = prev;

        if (prev == null) {
            next.prev = null;
            temp.next = null;
            head = next;
        }
    }

    void deleteTheNode(Node node) {
        Node temp = node;
        Node prev = null;

        // 1 3 2 4

        while (temp != null && temp != node) {
            prev = temp;
            temp = temp.next;
        }

        Node next = temp.next;

        prev.next = next;
        next.prev = prev;

    }
}

public class DLL {
    public static void main(String[] args) {
        DDLMethods ddlMethods = new DDLMethods();
        int arr[] = new int[] { 2,2,3,3,4,5,6,7,7};

        ddlMethods.arrayToDLL(arr);
        // ddlMethods.deleteFront();
        // ddlMethods.deleteLast();
        // ddlMethods.deleteLast();
        // ddlMethods.deleteLast();
        // ddlMethods.deleteLast();
        // ddlMethods.deleteKthNode(2);
        // ddlMethods.insertBeforeHead(6);
        // ddlMethods.reverseDDL();
        ddlMethods.deleteTheNode(ddlMethods.head);
        ddlMethods.printDLLForward();
        // ddlMethods.printDLLBackward();
    }
}