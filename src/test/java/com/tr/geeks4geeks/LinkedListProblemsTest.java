package com.tr.geeks4geeks;

import java.util.ArrayList;
import java.util.List;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class LinkedListProblemsTest {
    LinkedListProblems linkedListProblems = new LinkedListProblems();
    LinkedListService linkedListService = new LinkedListService();

    @Test
    public void canMergeWithEqualLengths() throws InvalidInputException {
        Integer[] input1 = new Integer[] {1, 3, 5, 7};
        LinkedListNode list1 = linkedListService.create(input1);

        Integer[] input2 = new Integer[] {2, 4, 6, 8};
        LinkedListNode list2 = linkedListService.create(input2);

        LinkedListNode newList2Head = linkedListProblems.mergeAtAlternatePos(list1, list2);

        assertNull(newList2Head);
        validateMergedList(list1, new Integer[] {1, 2, 3, 4, 5, 6, 7 ,8});
    }

    @Test
    public void canMergeWithGreaterSourceLength() throws InvalidInputException {
        Integer[] input1 = new Integer[] {1, 3, 5, 7};
        LinkedListNode list1 = linkedListService.create(input1);

        Integer[] input2 = new Integer[] {2, 4};
        LinkedListNode list2 = linkedListService.create(input2);

        LinkedListNode newList2Head = linkedListProblems.mergeAtAlternatePos(list1, list2);

        assertNull(newList2Head);
        validateMergedList(list1, new Integer[] {1, 2, 3, 4, 5, 7});
    }

    @Test
    public void canMergeWithGreaterDestinationLength() throws InvalidInputException {
        Integer[] input1 = new Integer[] {1, 3};
        LinkedListNode list1 = linkedListService.create(input1);

        Integer[] input2 = new Integer[] {2, 4, 6, 8};
        LinkedListNode list2 = linkedListService.create(input2);

        LinkedListNode newList2Head = linkedListProblems.mergeAtAlternatePos(list1, list2);

        assertNotNull(newList2Head);
        validateMergedList(list1, new Integer[] {1, 2, 3, 4});
        validateMergedList(newList2Head, new Integer[] {6, 8});
    }

    private void validateMergedList(LinkedListNode list1, Integer[] expectedDataValues) {
        List<Integer> list1Values = new ArrayList<Integer>();

        LinkedListNode<Integer> current = list1;
        while (current != null) {
            list1Values.add(current.getData());
            current = current.getNext();
        }

        assertArrayEquals(expectedDataValues, list1Values.toArray());
    }
}
