class LinkedListLength { 
  /* Returns count of nodes in linked list */
  public static int lengthOfList(Node head) {

    // if head is null, then return 0
    if(head == null)
    {
      return 0;
    }

    // else add 1 and get the length of list from list with head.next head
    return 1 + lengthOfList(head.next);

  }// end of fucntion

}// end of class

// Head is null
// List has only one node, which is head
// List having more than 1 node