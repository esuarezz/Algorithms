package frequentphrase;

public class FrequentPhrase {
    final String sentence;
    final long ocurrences;

    public FrequentPhrase(String sentence, long ocurrences) {
        this.sentence = sentence;
        this.ocurrences = ocurrences;
    }

    public String getSentence() {
        return sentence;
    }

    public long getOcurrences() {
        return ocurrences;
    }
}
