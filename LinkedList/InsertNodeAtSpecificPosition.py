def insertNodeAtPosition(head, data, position):
    node = head
    if position == 0:
        newNode = SinglyLinkedListNode(data)
        newNode.next = head
        return newNode
    count = 1
    while count < position and node:
        count += 1
        node = node.next
    newNode = SinglyLinkedListNode(data)
    newNode.next = node.next
    node.next = newNode
    return head