class Solution {
    public void reorderList(ListNode head) {
        ListNode thisNode = head;
        int listLength = getListLength(head);
        ListNode beforeLastNode = findBeforeLastNode(head);
        ListNode lastNode = beforeLastNode.next;
        for(int i = 0; i < listLength/2; i ++){
            lastNode.next = thisNode.next;
            thisNode.next = lastNode;
            thisNode = thisNode.next;
            thisNode = thisNode.next;
            beforeLastNode.next = null;
            beforeLastNode = lastNode.next;
            beforeLastNode = findBeforeLastNode(head);
            lastNode = beforeLastNode.next;
        }
    }
    public ListNode findBeforeLastNode (ListNode head){
        ListNode thisNode = head;
        ListNode thisNodeAfter = thisNode.next;
        while (thisNodeAfter.next != null){
            thisNode = thisNode.next;
            thisNodeAfter = thisNode.next;
        }
        return thisNode;
    }
    public int getListLength(ListNode head){
        int length = 0;
        ListNode thisNode = head;
        while (thisNode.next != null){
            length++;
            thisNode = thisNode.next;
        }
        return length;
    }
}