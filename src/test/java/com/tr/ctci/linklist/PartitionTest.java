package com.tr.ctci.linklist;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class PartitionTest {
    Partition partition = new Partition();
    LinkedListService linkedListService = new LinkedListService();

    @Test
    public void canPartition() {
        Integer[] input = new Integer[] {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = linkedListService.create(input);

        LinkedListNode newHead = this.partition.partition(head, 5);

        assertNotNull(newHead);
        verifyPartitionData(newHead, 5, input.length);
    }

    @Test
    public void canPartitionOnlyHigher() {
        Integer[] input = new Integer[] {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = linkedListService.create(input);

        LinkedListNode newHead = this.partition.partition(head, 1);

        assertNotNull(newHead);
        verifyPartitionData(newHead, 1, input.length);
    }

    @Test
    public void canPartitionOnlyLower() {
        Integer[] input = new Integer[] {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = linkedListService.create(input);

        LinkedListNode newHead = this.partition.partition(head, 10);

        assertNotNull(newHead);
        verifyPartitionData(newHead, 10, input.length);
    }

    @Test
    public void cannotPartitionOneElement() {
        Integer[] input = new Integer[] {3};
        LinkedListNode head = linkedListService.create(input);

        LinkedListNode newHead = this.partition.partition(head, 10);

        assertNotNull(newHead);
        assertEquals(head, newHead);
    }

    private <T extends Comparable> void verifyPartitionData(LinkedListNode newHead, T pivot, int size) {
        LinkedListNode<T> current = newHead;

        boolean isLower = false;
        boolean isHigher = false;

        int count =0;
        while (current!=null) {
            if (current.getData().compareTo(pivot) < 0) {
                isLower = true;
                assertFalse(isHigher);
            } else if (current.getData().compareTo(pivot) >= 0) {
                isHigher = true;
            }
            current = current.getNext();
            count ++;
        }
        assertEquals(size, count);
    }
}
