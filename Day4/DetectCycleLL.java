package Day4;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

static boolean DetectCycleLL(SinglyLinkedListNode head) {
    if(head == null || head.next == null) return false;

    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(fast == slow) return true;
    }

    return false;

}
