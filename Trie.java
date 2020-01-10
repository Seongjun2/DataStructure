package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode('\u0000');
    }


    public void insert(String word){
        if(search(word)) return;

        TrieNode current = root;

        for(char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child != null){
                current = child;
            }
            else{
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.terminal = true;
    }

    public boolean search(String word){
        TrieNode current = root;

        for(char ch: word.toCharArray()){
            if(current.subNode(ch) == null) return false;
            else{
                current = current.subNode(ch);
            }
        }
        if(current.terminal) return true;

        return false;
    }

    public void remove(String word){
        if(search(word) == false){
            System.out.println(word + "는 존재하지 않는 문자열 입니다.");
            return;
        }

        TrieNode current = root;
        for(char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child.count ==1 ){
                current.childList.remove(child);
                return ;
            }
            else{
                child.count--;
                current = child;
            }
        }
        current.terminal=false;
    }

    public Iterator<String> iterator(){
        Set<String> elementsInTrie = new TreeSet<>();

        recursiveCallPrint(root, "", elementsInTrie);
        Iterator<String> elementsInTrieSet = elementsInTrie.iterator();

        return elementsInTrieSet;
    }

    public void recursiveCallPrint(TrieNode currentNode, String key, Set<String> elementsInTrie){
        if(currentNode.terminal){
            elementsInTrie.add(key);
        }

        LinkedList<TrieNode> children = currentNode.childList;
        Iterator<TrieNode> childIter = children.iterator();

        String sKey = key;
        while(childIter.hasNext()){
            TrieNode nextNode = childIter.next();

            String s = sKey + nextNode.nodeChar;

            recursiveCallPrint(nextNode, s, elementsInTrie);
        }
    }

    public void printWord(){
        System.out.println("Elements in thr TRIE are : ");

        Iterator<String> iter = iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    static class TrieNode implements Comparable<TrieNode> {

        char nodeChar;
        boolean terminal;
        int count;
        LinkedList<TrieNode> childList;

        public TrieNode(char c){
            childList = new LinkedList<>();
            terminal = false;
            nodeChar = c;
            count= 0;
        }

        boolean isTerminal(){
            return terminal;
        }

        public TrieNode subNode(char nextChar){

            //순차 탐색
            if(childList != null){
               for(TrieNode eachChild : childList){
                   if(eachChild.nodeChar == nextChar){
                       return eachChild;
                   }
               }
            }
            return null;
        }
        @Override
        public int compareTo(TrieNode o) {
            TrieNode other = o;
            if(this.nodeChar < other.nodeChar)return -1;
            if(this.nodeChar == other.nodeChar) return 0;

            return 1;
        }

        @Override
        public String toString() {
            return this.nodeChar + "(" + this.terminal + ")";
        }

    }
}
