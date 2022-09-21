public class SongGenerator {

    String generateLyrics() {
        StringBuffer sb = new StringBuffer();

        sb.append(firstStanza());
        sb.append(secondStanza());
        sb.append(thirdStanza());
        sb.append(fourthStanza());
        String song =
                "There was an old lady who swallowed a dog;\n" +
                "What a hog, to swallow a dog!\n" +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a cow;\n" +
                "I don't know how she swallowed a cow!\n" +
                "She swallowed the cow to catch the dog,\n" +
                "She swallowed the dog to catch the cat,\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n";
        sb.append(song);
        sb.append(lastStanza());

        return sb.toString();
    }

    private String firstStanza() {
        return firstLineOfStanza("fly", ".") +
                lastLineOfStanza();
    }

    private String secondStanza() {
        return firstLineOfStanza("spider", ";") +
                secondLineOfStanza(2) +
                middleLinesOfStanza(2) +
                lastLineOfStanza();
    }

    private String thirdStanza() {
        return firstLineOfStanza("bird", ";") +
                secondLineOfStanza(3) +
                middleLinesOfStanza(3) +
                lastLineOfStanza();
    }

    private String fourthStanza() {
        return firstLineOfStanza("cat", ";") +
                secondLineOfStanza(4) +
                middleLinesOfStanza(4) +
                lastLineOfStanza();
    }

    private String lastStanza() {
        return firstLineOfStanza("horse", "...") +
                lastLineLastStanza();
    }

    private String firstLineOfStanza(String animal, String punc){
        return String.format("There was an old lady who swallowed a %s%s\n", animal, punc);
    }

    private String secondLineOfStanza(int stanzaNumber) {
        String[] secondLines = new String[] {
                "That wriggled and wiggled and tickled inside her.\n",
                "How absurd to swallow a bird.\n",
                "Fancy that to swallow a cat!\n"
        };
        return secondLines[stanzaNumber - 2];
    }

    private String middleLinesOfStanza(int stanzaNumber) {
        String[] animals = new String[] {
                "fly", "spider", "bird", "cat"
        };
        StringBuffer middleLines = new StringBuffer();
        for (int currentStanza = stanzaNumber; currentStanza >= 2; currentStanza--) {
            String punc = currentStanza == 2 ? ";" : ",";
            middleLines.append(
                    String.format("She swallowed the %s to catch the %s%s\n",
                            animals[currentStanza - 1],
                            animals[currentStanza - 2],
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
