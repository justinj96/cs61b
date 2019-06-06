public class Palindrome {

    /** takes in a word and puts into an ArrayDeque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }

    /** takes in word and calls wordToDeque then uses helper method */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word.toLowerCase());
        return isPalindromeHelper(deque);
    }

    /** helper method takes in deque
     * (public method must take word)
     * and checks for palindrome
     */
    private boolean isPalindromeHelper(Deque<Character> deque) {
        while (deque.size() > 1) {
            return deque.removeFirst() == deque.removeLast() && isPalindromeHelper(deque);
        }
        return true;
    }

    /** takes in word and CC and calls wordToDeque then uses helper method */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word.toLowerCase());
        return isPalindromeHelper(deque, cc);
    }

    /** checks for palindrome that's off by one */
    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        while (deque.size() > 1) {
            return cc.equalChars(deque.removeFirst(), deque.removeLast())
                    && isPalindromeHelper(deque, cc);
        }
        return true;
    }
}
