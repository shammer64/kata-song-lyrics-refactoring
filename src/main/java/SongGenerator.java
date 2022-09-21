public class SongGenerator {

    public static final String[] SECOND_LINES = new String[]{
            "That wriggled and wiggled and tickled inside her.\n",
            "How absurd to swallow a bird.\n",
            "Fancy that to swallow a cat!\n",
            "What a hog, to swallow a dog!\n",
            "I don't know how she swallowed a cow!\n"
    };
    public static final String[] ANIMALS = new String[]{
            "fly", "spider", "bird", "cat", "dog", "cow", "horse"
    };

    String generateLyrics() {
        StringBuffer sb = new StringBuffer();

        sb.append(firstStanza());
        for (int stanzaNumber = 2; stanzaNumber <= 6; stanzaNumber++) {
            sb.append(middleStanza(stanzaNumber));
        }
        sb.append(lastStanza());

        return sb.toString();
    }

    private String firstStanza() {
        return firstLineOfStanza(1, ".") +
                lastLineOfStanza();
    }

    private String middleStanza(int stanzaNumber) {
        return firstLineOfStanza(stanzaNumber, ";") +
                secondLineOfStanza(stanzaNumber) +
                middleLinesOfStanza(stanzaNumber) +
                lastLineOfStanza();
    }

    private String lastStanza() {
        return firstLineOfStanza(7, "...") +
                lastLineLastStanza();
    }

    private String firstLineOfStanza(int stanzaNumber, String punc){
        return String.format("There was an old lady who swallowed a %s%s\n", ANIMALS[stanzaNumber - 1], punc);
    }

    private String secondLineOfStanza(int stanzaNumber) {
        return SECOND_LINES[stanzaNumber - 2];
    }

    private String middleLinesOfStanza(int stanzaNumber) {
        StringBuffer middleLines = new StringBuffer();
        for (int currentStanza = stanzaNumber; currentStanza >= 2; currentStanza--) {
            String punc = currentStanza == 2 ? ";" : ",";
            middleLines.append(
                    String.format("She swallowed the %s to catch the %s%s\n",
                            ANIMALS[currentStanza - 1],
                            ANIMALS[currentStanza - 2],
                            punc));
        }
        return middleLines.toString();
    }

    private String lastLineOfStanza() {
        return "I don't know why she swallowed a fly - perhaps she'll die!\n\n";
    }

    private String lastLineLastStanza() {
        return "...She's dead, of course!";
    }

}
