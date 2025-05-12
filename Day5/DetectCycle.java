package Day5;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}
class DetectCycle {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }
}
