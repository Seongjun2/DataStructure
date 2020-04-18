package DataStructure;

public class TrieTest {
    public static void main(String[] args) {

        String[] data = new String[]{"abcd","abcf", "bcd","a", "bcdefg", "defg", "aac", "baz", "foo", "foobar","자바"};

        Trie matcher = new Trie();

        for (int i = 0; i < data.length; i++) {
            matcher.insert(data[i]);
        }

        matcher.printWord();

        System.out.println(matcher.search("ab"));
    }
}
