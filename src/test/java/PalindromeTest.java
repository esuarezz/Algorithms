import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

    private Palindrome palindrome;


    @Before
    public void init(){
          palindrome = new Palindrome();

    }


    @Test
    public void isPalindromeEfficient() throws Exception {

        Assert.assertTrue(palindrome.isPalindrome("Anna"));
        Assert.assertTrue(palindrome.isPalindrome("A new order began, a more Roman age bred Rowena."));
        Assert.assertTrue(palindrome.isPalindrome("Able was I ere I saw Elba."));
        Assert.assertTrue(palindrome.isPalindrome("A car, a man, a maraca."));
        Assert.assertTrue(palindrome.isPalindrome("12321"));
        Assert.assertTrue(palindrome.isPalindrome("Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era."));
        Assert.assertTrue(palindrome.isPalindrome(""));

        Assert.assertFalse(palindrome.isPalindrome("A car, a man, a mmaraca."));

    }
}