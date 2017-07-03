package com.tr.ds.services;

import com.tr.ds.LinkedListNode;
import com.tr.exceptions.InvalidLinkedListInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class LinkedListServiceTest {
    private LinkedListService linkedListService = new LinkedListService();

    @Test
    public void canCreate() {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};

        LinkedListNode head = linkedListService.create(inputData);

        assertNotNull(head);
        verifyInputWithList(inputData, head);
    }

    @Test
    public void canAppend() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        linkedListService.append(6, head);

        verifyInputWithList(new Integer[] {1, 2, 3, 4, 5, 6}, head);
    }

    @Test(expected = InvalidLinkedListInput.class)
    public void cannotAppendWithInvalidInput() throws InvalidLinkedListInput {
        linkedListService.append(6, null);
    }

    @Test
    public void canRemoveFirstNode() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        head = linkedListService.remove(1, head);

        assertNotNull(head);
        verifyInputWithList(new Integer[] {2, 3, 4, 5}, head);
    }

    @Test
    public void canRemoveCenterNode() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        head = linkedListService.remove(3, head);

        assertNotNull(head);
        verifyInputWithList(new Integer[] {1, 2, 4, 5}, head);
    }

    @Test
    public void canRemoveLastNode() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        head = linkedListService.remove(5, head);

        assertNotNull(head);
        verifyInputWithList(new Integer[] {1, 2, 3, 4}, head);
    }

    @Test(expected = InvalidLinkedListInput.class)
    public void cannotRemoveWithInvalidInput() throws InvalidLinkedListInput {
        linkedListService.remove(5, null);
    }

    @Test
    public void canRemoveFirstElementWhenOnlyElement() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1};
        LinkedListNode head = linkedListService.create(inputData);

        head = linkedListService.remove(1, head);

        assertNull(head);
    }

    @Test
    public void canReverse() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        LinkedListNode newHead = linkedListService.reverse(head);

        verifyInputWithList(new Integer[] {5, 4, 3, 2, 1}, newHead);
    }

    @Test
    public void canReverseOnlyOneElement() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1};
        LinkedListNode head = linkedListService.create(inputData);

        LinkedListNode newHead = linkedListService.reverse(head);

        assertEquals(newHead, head);
    }

    @Test(expected = InvalidLinkedListInput.class)
    public void cannotReverseWithInvalid() throws InvalidLinkedListInput {
        linkedListService.reverse(null);
    }

    @Test
    public void canFindMiddleNodeForOddSizeList() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListService.create(inputData);

        LinkedListNode middleNode = linkedListService.findMiddleNode(head);

        assertNotNull(middleNode);
        assertEquals(3, middleNode.getData());
    }

    @Test
    public void canFindMiddleNodeForEvenSizeList() throws InvalidLinkedListInput {
        Integer[] inputData = new Integer[] {1, 2, 3, 4};
        LinkedListNode head = linkedListService.create(inputData);

        LinkedListNode middleNode = linkedListService.findMiddleNode(head);

        assertNotNull(middleNode);
        assertEquals(2, middleNode.getData());
    }

    private <T> void verifyInputWithList(Integer[] inputData, LinkedListNode<T> head) {
        int count = 0;
        LinkedListNode<T> current = head;
        while (current != null) {
            assertEquals(inputData[count], current.getData());
            count++;
            current = current.getNext();
        }
        assertEquals(count, inputData.length);
    }
}
