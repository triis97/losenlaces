package org.losenlaces.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieExample {

    public static void main(String[] args) {
        insert("prueba");
        insert("los");
        insert("enlaces");
        insert("demostracion");

        boolean result1 = find("losEnlaces");
        boolean result2 = find("enlaces");
        boolean result3 = find("enla");
        boolean result4 = find("enlacesz");
    }


    private static TrieNode root = new TrieNode();

    private static void insert(String word){
        TrieNode current = root;
        for(char l: word.toCharArray()){

            current = current.getChildren().compute( l, (k, v) -> {
                if (v == null){
                    return  new TrieNode(word);
                }
                v.setContent(word);

                return v;
            });

        }
        current.setIsWord(true);
    }

    private static boolean find(String word){
        TrieNode current = root;

        for(int i =0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public static class TrieNode{
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private List<String> content = new ArrayList<>();
        private boolean isWord;

        public TrieNode(String content){
            this.content.add(content);
        }
        public TrieNode(){
        }

        public HashMap<Character, TrieNode> getChildren(){
            return children;
        }

        public boolean getIsWord(){
            return isWord;
        }
        public void setIsWord(boolean isWord){
            this.isWord = isWord;
        }

        public List<String> getContent(){
            return this.content.subList(0, this.content.size()>=3?3:this.content.size());
        }

        public void setContent(String content){
            this.content.add(content);
//            this.content.sort();
        }
    }
}
