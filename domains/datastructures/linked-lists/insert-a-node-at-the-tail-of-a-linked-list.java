/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

Node Insert(Node head,int x) {
// This is a "method-only" submission.
// You only need to complete this method.
    Node n = new Node();
    n.data = x;
    n.next = null;

    if(head == null){
        head = n;
        return head;
    }

    else
    {
        Node c = head;
        while(c.next != null){
            c = c.next;
        }

        c.next = n;

        return head;

    }

}
