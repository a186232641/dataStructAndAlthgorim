package Althgorim.First.ArrayAlthgorim;

/**
 * @author 韩飞龙
 * @version 1.0
 */
public class deleteDuplicates {
    public static void main(String[] args) {




    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy ;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val!=p.val){
                p.next = cur;
                p = p.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
