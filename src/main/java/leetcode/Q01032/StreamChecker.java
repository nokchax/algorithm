package leetcode.Q01032;

/**
 * https://twpower.github.io/187-trie-concept-and-basic-problem
 *
 * need to use trie
 */
public class StreamChecker {
    protected class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1 ; i >= 0 && node != null ; --i) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord)
                return true;
        }
        return false;
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1 ; i >= 0 ; --i) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
/*    private String[] words;
    private Queue<String> candidates;
    private Queue<Integer> targetChar;

    public StreamChecker(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        this.words = new String[set.size()];
        set.toArray(this.words);
        this.candidates = new LinkedList<>();
        this.targetChar = new LinkedList<>();
    }

    public boolean query(char letter) {
        checkCandidates(letter);
        checkWords(letter);
        return checkIsEnd();
    }

    public void checkWords(char letter) {
        for(String word : words) {
            if(word.charAt(0) != letter)
                continue;

            targetChar.add(1);
            candidates.add(word);
        }
    }

    public void checkCandidates(char letter) {
        int checkCount = targetChar.size();

        while(checkCount-- > 0) {
            Integer targetPosition = targetChar.poll();
            String targetString = candidates.poll();

            if(targetString.charAt(targetPosition) == letter) {
                targetChar.add(targetPosition + 1);
                candidates.add(targetString);
            }
        }
    }

    public boolean checkIsEnd() {
        boolean answer = false;

        int checkCount = targetChar.size();
        while(checkCount-- > 0) {
            Integer targetPosition = targetChar.poll();
            String targetString = candidates.poll();

            if(targetPosition == targetString.length()) {
                answer = true;
            } else {
                targetChar.add(targetPosition);
                candidates.add(targetString);
            }
        }

        return answer;
    }*/
}
