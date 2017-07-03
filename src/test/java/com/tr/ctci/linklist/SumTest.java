package com.tr.ctci.linklist;

import java.util.ArrayList;
import java.util.List;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidLinkedListInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SumTest {
    LinkedListService linkedListService = new LinkedListService();
    SumList sumList = new SumList();

    @Test
    public void canSum() throws InvalidLinkedListInput {
        int a = 25, b= 500;
        LinkedListNode<Integer> listAHead = createReverseList(a);
        LinkedListNode<Integer> listBHead = createReverseList(b);

        LinkedListNode<Integer> sumListHead = sumList.sum(listAHead, listBHead);

        validateSum(sumListHead, a, b);
    }

    @Test
    public void canSumWithCarry() throws InvalidLinkedListInput {
        int a = 525, b= 500;
        LinkedListNode<Integer> listAHead = createReverseList(a);
        LinkedListNode<Integer> listBHead = createReverseList(b);

        LinkedListNode<Integer> sumListHead = sumList.sum(listAHead, listBHead);

        validateSum(sumListHead, a, b);
    }

    @Test
    public void canSumWithCarryAndMoreElementsInTheInput() throws InvalidLinkedListInput {
        int a = 5, b= 505;
        LinkedListNode<Integer> listAHead = createReverseList(a);
        LinkedListNode<Integer> listBHead = createReverseList(b);

        LinkedListNode<Integer> sumListHead = sumList.sum(listAHead, listBHead);

        validateSum(sumListHead, a, b);
    }

    private void validateSum(LinkedListNode<Integer> sumListHead, int a, int b) {
        int sumValue = 0;
        LinkedListNode<Integer> current = sumListHead;
        while (current != null) {
            sumValue *= 10;
            sumValue += current.getData();
            current = current.getNext();
        }

        assertEquals((a+b), sumValue);
    }

    private LinkedListNode<Integer> createReverseList(int number) {
        List<Integer> values = new ArrayList<Integer>();
        while (number > 0) {
            values.add(number % 10);
            number /= 10;
        }

        return linkedListService.create(values.toArray());
    }
}
