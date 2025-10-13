package DSA.LinkedList.Leetcode;

public class LC234CheckSLLisPalindromeOrNot {
    Node head = null;
    int size;

    Node convertArrToLL(int[] arr){
        head = new Node(arr[0]);
        Node temp = head;
        for (int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }
    void traverseLL(Node head){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }
    Node reverseLL(Node middleNode){
        if(middleNode == null){
            System.out.println("List is empty cant reverse it.");
            return middleNode;
        }
        if (middleNode.next == null){
            System.out.println("Only 1 element in the list.");
            return middleNode;
        }
        //to reverse connection from forward traversal to backward
        Node temp, prevNode, nextNode;
        temp = middleNode;
        prevNode = null;
        while (temp != null){
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        middleNode = prevNode;
        /*//to print onto the console
        Node temp2 = prevNode;
        while(temp2 != null){
            System.out.print(temp2.data +" ");
            temp2 = temp2.next;
        }
         */
        return middleNode;
    }
    Node findMiddle(Node head){
        //Approach 1: Bruteforce
        /*int n=0;
        Node temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int pos = (n/2)+1;
        temp = head;
        for(int i=1; i<pos; i++){
            temp = temp.next;
        }
        return temp;
         */



        //Approach 2: Optimal (Two-pointer approach)
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    boolean checkPalindromeOrNot(Node head){
        Node middleNode = findMiddle(head);
        Node secondHalfHead = reverseLL(middleNode);
        Node tempFirst = head;
        Node tempSecond = secondHalfHead;
        while (tempSecond != null){
            if (tempFirst.data != tempSecond.data){
                return false;
            }
            tempFirst = tempFirst.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        Node head;
        LC234CheckSLLisPalindromeOrNot obj = new LC234CheckSLLisPalindromeOrNot();
        head = obj.convertArrToLL(arr);
        obj.traverseLL(head);
        System.out.println(obj.checkPalindromeOrNot(head));
    }

}
