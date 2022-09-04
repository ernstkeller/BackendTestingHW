package lesson3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class PalindromeCheckerTest {

    private PalindromeChecker palindrome;
    private String input;

    @Before
    public void setUp() throws Exception {

        input = null;
        palindrome = new PalindromeChecker();

    }

   @Test
    public void simplePalindromeTest() throws Exception {

        input = "AbbA";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void singleCharacterTest() throws Exception {

        input = "N";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void multipleWordsTest() throws Exception {

        input = "murder for a jar of red rum";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void multipleWhitespacesTest() throws Exception {

        input = "murder        for a       jar of     red rum";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void upperCaseToLowercaseTest() throws Exception {

        input = "MurdEr fOr a jaR Of rEd RUm";

        assertTrue(palindrome.isPalindrome(input));

    }

    @Test
    public void invalidPalindromeTest() throws Exception {

        input = "Not palindrome";

        assertFalse(palindrome.isPalindrome(input));
    }


    @After
    public void tearDown() throws Exception {

    }

}
