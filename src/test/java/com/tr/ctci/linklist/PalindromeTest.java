package com.tr.ctci.linklist;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidLinkedListInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PalindromeTest {
    private Palindrome palindrome = new Palindrome();
    private LinkedListService linkedListService = new LinkedListService();

    @Test
    public void isPalindromeWithOddSize() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 2, 3, 2, 1};
        LinkedListNode head = linkedListService.create(input);

        assertTrue(palindrome.isPalindrome(head));
    }

    @Test
    public void isPalindromeWithEven() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 2, 2, 1};
        LinkedListNode head = linkedListService.create(input);

        assertTrue(palindrome.isPalindrome(head));
    }

    @Test
    public void isNotPalindromeWithEven() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 2, 4, 1};
        LinkedListNode head = linkedListService.create(input);

        assertFalse(palindrome.isPalindrome(head));
    }

    @Test
    public void isNotPalindromeWithOdd() throws InvalidLinkedListInput {
        Integer[] input = new Integer[] {1, 2, 4, 2, 3};
        LinkedListNode head = linkedListService.create(input);

        assertFalse(palindrome.isPalindrome(head));
    }


}
