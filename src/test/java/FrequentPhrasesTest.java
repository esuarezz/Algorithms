import frequentphrase.FrequentPhrase;
import frequentphrase.FrequentPhraseService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FrequentPhrasesTest {

    private static final String NAME_FILE = "test.txt";


    //TODO: add more test cases
    @Test
    public void getMostFrequentPhrases() throws Exception {
        FrequentPhraseService frequentPhrases = new FrequentPhraseService();
        ClassLoader classLoader = getClass().getClassLoader();
        List<FrequentPhrase> result = frequentPhrases.getMostFrecuentPhrases(classLoader.getResource(NAME_FILE).getFile());
        assertEquals(result.size(),5);
    }

}