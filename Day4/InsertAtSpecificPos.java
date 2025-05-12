package Day4;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

public class InsertAtSpecificPos {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        int curr = 1;
        SinglyLinkedListNode currPointer = llist;

        while(curr < position){
            currPointer = currPointer.next;
            curr++;
        }

//        OR
//        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
//        SinglyLinkedListNode nextNode = currPointer.next;
//        currPointer.next = newNode;
//        newNode.next = nextNode;

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = currPointer.next;
        currPointer.next = newNode;

        return llist;
    }
}
