package ms;

/**
 * Created by wz on 2019/9/17.
 */

import java.util.*;
public class stoint{
    public static void main(String[]args){
        String str="-1b2";
        boolean t=false;
        int sum=0;
        char[]ch=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[0]=='-')t=true;
            if(ch[i]>='0'&&ch[i]<='9'){
                sum+=(ch[i]-48)*Math.pow(10,ch.length-1-i);
            }
        }
        if(t==true)
            System.out.println(-sum);
        else
            System.out.println(sum);
    }

    class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;


}
