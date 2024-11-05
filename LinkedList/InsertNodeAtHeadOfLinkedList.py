def insertNodeAtHead(head, data):
    node = SinglyLinkedListNode(data)
    
    if head:
        node.next = head
    
    return node