package frequentphrase;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class FrequentPhraseService {

    private static final int TOP_FREQUENT_PHRASES = 100000;

    /**
     * Gets the List sorted with Sentences and ocurrences
     * Split everyline and save a new key,value if the sentence(key) is not saved with direct access optimizing
     * if it was saved, the value will be incremented
     * The result map will return a list with the object created(Sentence and ocurrences) in descending order
     * and limited by the user input
     * @param pathFile
     */

    public final List<FrequentPhrase> getMostFrecuentPhrases(String pathFile){

        BufferedReader  reader = getBufferedReader(pathFile);
        Map<String,Long> results = new HashMap<>();
        try
        {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(results, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.closeReader(reader);
        }

        return results.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_FREQUENT_PHRASES)
                .map(item -> new FrequentPhrase(
                        item.getKey(),
                        item.getValue()))
                .collect(Collectors.toList());
    }

    private void processLine(Map<String, Long> results, String line) {
        String trimKey;
        Long count;
        String[] sentenceSplitted = line.split("\\|");

        for (String key : sentenceSplitted) {
            trimKey =key.trim();
            count = results.get(trimKey);
            if (count == null) {
                results.put(trimKey, 1l);
            } else {
                results.put(trimKey, count + 1);
            }
        }

    }


    private BufferedReader getBufferedReader(String pathFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }


    private void closeReader(BufferedReader reader){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
