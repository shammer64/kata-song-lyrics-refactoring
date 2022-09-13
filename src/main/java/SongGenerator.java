public class SongGenerator {
    String generateSongLyrics() {
        StringBuffer sb = new StringBuffer();

        sb.append(firstVerse());
        sb.append(middleVerse(1));
        sb.append(middleVerse(2));
        sb.append(middleVerse(3));

        String song = "There was an old lady who swallowed a dog;\n" +
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
        sb.append(lastVerse());
        return sb.toString();
    }

    private String firstVerse() {
        return firstLineEarlyVerses("fly", ".") + lastLineEarlyVerses();
    }

    private String middleVerse(int verseIndex) {
        String[] animals = new String[] {"fly", "spider", "bird", "cat"};
        String verse = firstLineEarlyVerses(animals[verseIndex], ";") +
                exclamationMiddleVerses(verseIndex);
        for (int i = verseIndex; i >= 1; i--) {
            String punctuation = (i != 1) ? "," : ";";
            verse = verse + transitionLineMiddleVerses(animals[i], animals[i - 1], punctuation);
        }
        verse = verse + lastLineEarlyVerses();
        return verse;
    }

    private String firstLineEarlyVerses(String animal, String punctuation) {
        return String.format("There was an old lady who swallowed a %s%s\n", animal, punctuation);
    }

    private String lastLineEarlyVerses() {
        return "I don't know why she swallowed a fly - perhaps she'll die!\n\n";
    }

    private String exclamationMiddleVerses(int verseIndex) {
        String[] exclamations = new String[] {
                "That wriggled and wiggled and tickled inside her.\n",
                "How absurd to swallow a bird.\n",
                "Fancy that to swallow a cat!\n"
        };
        return exclamations[verseIndex - 1];
    }

    private String transitionLineMiddleVerses(String animal1, String animal2, String punctuation) {
        return String.format("She swallowed the %s to catch the %s%s\n", animal1, animal2, punctuation);
    }

    private String lastVerse() {
        return firstLineLastVerse() + finalLine();
    }

    private String firstLineLastVerse() {
        return "There was an old lady who swallowed a horse...\n";
    }

    private String finalLine() {
        return "...She's dead, of course!";
    }

}
