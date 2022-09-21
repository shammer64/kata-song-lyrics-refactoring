public class SongGenerator {

    String generateLyrics() {
        StringBuffer sb = new StringBuffer();

        sb.append(firstStanza());
        sb.append(secondStanza());
        sb.append(thirdStanza());
        String song = "There was an old lady who swallowed a cat;\n" +
                "Fancy that to swallow a cat!\n" +
                "She swallowed the cat to catch the bird,\n" +
                "She swallowed the bird to catch the spider,\n" +
                "She swallowed the spider to catch the fly;\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
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
                thirdLineOfStanza("spider", "fly", ";") +
                lastLineOfStanza();
    }

    private String thirdStanza() {
        return firstLineOfStanza("bird", ";") +
                secondLineOfStanza(3) +
                thirdLineOfStanza("bird", "spider", ",") +
                thirdLineOfStanza("spider", "fly", ";") +
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
                "How absurd to swallow a bird.\n"
        };
        return secondLines[stanzaNumber - 2];
    }

    private String thirdLineOfStanza(String animal1, String animal2, String punc) {
        return String.format("She swallowed the %s to catch the %s%s\n", animal1, animal2, punc);
    }

    private String lastLineOfStanza() {
        return "I don't know why she swallowed a fly - perhaps she'll die!\n\n";
    }

    private String lastLineLastStanza() {
        return "...She's dead, of course!";
    }

}
