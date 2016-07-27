/**
 * Definition and kind of palindromes:
 * Palindrome: a word, phrase, number, or other sequence of symbols or elements,
 * whose meaning may be interpreted the same way in either forward or reverse direction.
 * Famous examples include “Amore, Roma“
 *
 * After reading the definition, we will define/limit our domain
 * We will consider the most complicated domain.

 *
 */

public class Palindrome {



    /**
     * Remove the characters we dont want to check, it will match Upper and Lowercase
     * it will loop till half of list evaluating both sides.
     *
     * @param stringToCheck
     * @return
     */
    public final boolean isPalindromeEfficient(String stringToCheck){
        stringToCheck = stringToCheck.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = stringToCheck.length();
        stringToCheck = stringToCheck.toLowerCase();
        int limitSuperior = n-1;
        int stopCondition = (n / 2) + 1;
        for (int i = 0; i < stopCondition; ++i) {
            if (stringToCheck.charAt(i) != stringToCheck.charAt(limitSuperior - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Taking advantage of Java functions, but if we interprete the hood, we know we can do it simpler because
     * we just need to know if it is palindrome
     * @param stringToCheck
     * @return
     */
    public final boolean isPalindrome(String stringToCheck){
        return stringToCheck.replaceAll("[^A-Za-z]", "").toLowerCase().equals(
                new StringBuilder(stringToCheck.replaceAll("[^A-Za-z]", "").toLowerCase()).reverse().toString());
    }

    /**
     public AbstractStringBuilder reverse() {
     boolean hasSurrogates = false;
     int n = count - 1;
     for (int j = (n-1) >> 1; j >= 0; j--) {
     int k = n - j;
     char cj = value[j];
     char ck = value[k];
     value[j] = ck;
     value[k] = cj;
     if (Character.isSurrogate(cj) ||
     Character.isSurrogate(ck)) {
     hasSurrogates = true;
     }
     }
     if (hasSurrogates) {
     reverseAllValidSurrogatePairs();
     }
     return this;
     }

     **/
    /** Outlined helper method for reverse()
     private void reverseAllValidSurrogatePairs() {
     for (int i = 0; i < count - 1; i++) {
     char c2 = value[i];
     if (Character.isLowSurrogate(c2)) {
     char c1 = value[i + 1];
     if (Character.isHighSurrogate(c1)) {
     value[i++] = c1;
     value[i] = c2;
     }
     }
     }
     }*/
}


