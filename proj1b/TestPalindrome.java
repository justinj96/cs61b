import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalidrome() {
        assertTrue(palindrome.isPalindrome("anna"));
        assertFalse(palindrome.isPalindrome("me"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("tasdft"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeOverload() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("axayb", offByOne));
        assertTrue(palindrome.isPalindrome("#&a%$", offByOne));
        assertFalse(palindrome.isPalindrome("axaya", offByOne));
        assertFalse(palindrome.isPalindrome("true", offByOne));
    }

    @Test
    public void testOffByN() {
        assertTrue(palindrome.isPalindrome("adxad", new OffByN(3)));
        assertTrue(palindrome.isPalindrome("gxbze", new OffByN(2)));
        assertFalse(palindrome.isPalindrome("qwerty", new OffByN(2)));
    }
}     // Uncomment this class once you've created your Palindrome class. */
