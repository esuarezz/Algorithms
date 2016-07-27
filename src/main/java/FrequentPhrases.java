import sun.security.pkcs11.wrapper.Functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequentPhrases {

    private static final int TOP_FREQUENT_PHRASES = 100000;
    private static final int PHRASES_PER_LINE = 50;

    /**
     * Remember if the sentence is not finished, to remember the beginning of the next sentence
     *
     * @param pathFile
     */

    public final String[] getMostFrecuentPhrases(String pathFile){

        BufferedReader  reader = getBufferedReader(pathFile);
        Map<String,Long> results = new HashMap<>();
        try
        {
            String line;
            Long count;
            String trimKey;
            while ((line = reader.readLine()) != null) {
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.closeReader(reader);
        }

        Map<String,Long> resultArray = new HashMap();

    //TODO: get the map and return and completed
       results.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_FREQUENT_PHRASES)
               .forEach(System.out::println);


                //.collect(Collectors.toSet()); // or any other terminal method

       /* Map mapSorted =  MapUtils.sortByValue(results);

        List firstHundredRecords = new ArrayList<>(mapSorted.entrySet());*/
        return new String[3];
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
