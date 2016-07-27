import org.junit.Test;

import static org.junit.Assert.*;


public class FrequentPhrasesTest {

    private static final String PATH_FILE = "C:/test.txt";


    @Test
    public void getMostFrequentPhrases() throws Exception {
            FrequentPhrases frequentPhrases = new FrequentPhrases();

            frequentPhrases.getMostFrecuentPhrases(PATH_FILE);
    }

}