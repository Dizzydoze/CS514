import java.util.Random;

/**
 * Implement SortedLinkedList using generic
 */
public class SortedLinkedList <T extends Comparable<T>>{

    Node head;
    boolean ascending;

    /**
     * Any Node instance can only be created with type T which implements Comparable<T>
     */
    class Node{
        T value;
        Node next;
        // any type T value implements Comparable<T> can be sent in
        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * let client specify ascending/descending
     * @param ascending whether the list is ascending or not
     */
    public SortedLinkedList(boolean ascending){
        this.ascending = ascending;
    }

    /**
     * Adds c in sorted order
     * @param c any argument with type T implements Comparable<T>
     */
    public void add(T c){
        Node dummyHead = new Node(c, this.head);
        Node prev = dummyHead;
        Node cur = this.head;
        // sort in ascending order
        if (this.ascending){
            while(cur != null){
                if (c.compareTo(cur.value) > 0){
                    prev = cur;
                    cur = cur.next;
                }
                else{
                    // insert new node: prev -> newNode -> cur
                    prev.next = new Node(c, cur);
                    // KEY: ensure head stays correct position
                    this.head = dummyHead.next;
                    return;
                }
            }
        }
        // sort in descending order
        else{
            while(cur != null){
                if (c.compareTo(cur.value) < 0){
                    prev = cur;
                    cur = cur.next;
                }
                else{
                    // insert new node: prev -> newNode -> cur
                    prev.next = new Node(c, cur);
                    // KEY: ensure head stays correct position
                    this.head = dummyHead.next;
                    return;
                }
            }
        }
        // loop ends, c is biggest num in the list, append to the last
        prev.next = new Node(c, null);
        // head might be changed
        this.head = dummyHead.next;
    }

    /**
     * Find node with input value
     * @param c any argument with type T implements Comparable<T>
     * @return true or false
     */
    public boolean find(T c){
        Node cur = this.head;
        while(cur != null){
            if (cur.value.compareTo(c) == 0){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Removes first occurrence of c
     * @param c any argument with type T implements Comparable<T>
     */
    public boolean delete(T c){
        Node dummyHead = new Node(null, head);
        Node prev = dummyHead;
        Node cur = head;
        while (cur != null){
            if (cur.value.compareTo(c) == 0){
                prev.next = cur.next;   // skip the deleted node
                cur.next = null;        // disconnect
                head = dummyHead.next;  // reassigned the head
                return true;            // delete successfully
            }
            prev = cur;                 // move pointers forward
            cur = cur.next;
        }
        return false;                   // ele not found
    }


    /**
     * Simple list reversal, changes the list from ascending to descending
     */
    public void reverse(){
        Node prev = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;       // save next node
            cur.next = prev;            // redirection
            prev = cur;
            cur = next;
        }
        // KEY: update the new head to the last node which is prev
        this.head = prev;
        // KEY: change ascending to opposite value everytime we reverse
        this.ascending = !this.ascending;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cur = this.head;
        while (cur != null){
            String s = String.format("[%s]->", cur.value);
            sb.append(s);
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    /**
     * Provide a main method that demonstrates use of all the methods.
     */
    public static void main(String[] args) {
        SortedLinkedList<Integer> intSortedLinkedList = new SortedLinkedList<>(true);

        // ADD: add 10 random num into SortedLinkedList
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(99);
            intSortedLinkedList.add(num);
        }
        System.out.println(intSortedLinkedList);

        // REVERSE: reverse the SortedLinkedList into opposite order
        intSortedLinkedList.reverse();
        System.out.println(intSortedLinkedList);

        // DELETE: delete a node with specific input value
        intSortedLinkedList.add(9999);
        intSortedLinkedList.add(8888);
        intSortedLinkedList.add(7777);
        System.out.println("Before Delete: " + intSortedLinkedList);
        boolean deleted = intSortedLinkedList.delete(8888);
        if (deleted){
            System.out.println("Target Successfully Deleted.");
        }
        else{
            System.out.println("Target Not Found");
        }
        System.out.println("After Delete: " + intSortedLinkedList);

        // FIND: find node with input value
        boolean found = intSortedLinkedList.find(9999);
        if (found){
            System.out.println("Target Found");
        }
        else{
            System.out.println("Target NOT Found");
        }
    }
}
