package com.tr.ctci.linklist;

import java.util.HashSet;
import java.util.Set;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidLinkedListInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class RemoveDuplicateTest {
    private RemoveDuplicate removeDuplicate = new RemoveDuplicate();
    private LinkedListService linkedListService = new LinkedListService();

    @Test
    public void canRemoveDupsWithBuffer() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 1, 3, 5, 6, 3, 8, 1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithBuffer(head);

        assertNotNull(head);
        verifyNoDups(head);

    }

    @Test
    public void canRemoveDupsWithBufferWithOnlyOneDuplicate() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithBuffer(head);

        assertNotNull(head);
        assertEquals(1, head.getData());
        assertNull(head.getNext());
    }

    @Test
    public void canRemoveDupsWithBufferWithOnlyOneElement() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithBuffer(head);

        assertNotNull(head);
        assertEquals(1, head.getData());
        assertNull(head.getNext());
    }

    @Test
    public void canRemoveDupsWithoutBuffer() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 1, 3, 5, 6, 3, 8, 1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithoutBuffer(head);

        assertNotNull(head);
        verifyNoDups(head);
    }


    @Test
    public void canRemoveDupsWithoutBufferWithOnlyOneDuplicate() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithoutBuffer(head);

        assertNotNull(head);
        assertEquals(1, head.getData());
        assertNull(head.getNext());
    }

    @Test
    public void canRemoveDupsWithoutBufferWithOnlyOneElement() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1};
        LinkedListNode head = linkedListService.create(input);

        removeDuplicate.removeDupsWithoutBuffer(head);

        assertNotNull(head);
        assertEquals(1, head.getData());
        assertNull(head.getNext());
    }

    private <T> void verifyNoDups(LinkedListNode<T> head) {
        LinkedListNode<T> current = head;

        int count = 0;
        Set<T> buffer = new HashSet<T>();
        while (current != null) {
            buffer.add(current.getData());
            count++;
            current = current.getNext();
        }

        assertEquals(count, buffer.size());
    }
}
