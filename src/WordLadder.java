import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * @author zhang
 *
 */
public class WordLadder{
    
    class Chain {
        
        private class Node{
            private String str;
            private Node next;
            
            public Node(String s, Node n){
                str = s;
                next = n;
            }
            
            public String getStr(){
                return str;
            }
            
            public Node getNext(){
                return next;
            }
        }
        
        private int size;
        private Node first;
        private Node last;
        
        public Chain(){
        }
        
        public Chain(String beginning){
            first = new Node(beginning, null);
            last = first;
            size = 1;
        }
    
        public int size(){
            return size;
        }
        
        public String getLast(){
            return first.getStr();
        }
        
        public Chain extend(String next){
            Chain newChain = new Chain();
            newChain.first = new Node(next, first);
            newChain.last = last;
            newChain.size = size + 1;
            return newChain;
        }
        
        public List<String> toList(){
            LinkedList<String> ls = new LinkedList<>();
            Node n = first;
            while (n != null){
                ls.addFirst(n.getStr());
                n = n.getNext();
            }
            return ls;
        }
    }
    
    private boolean linked(String  a, String b){
        if (a.length() != b.length())
            return false;
        boolean diff = false;
        for (int i = 0 ; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                if (diff){
                    return false;
                } else {
                    diff = true;
                }
            }
        }
        return diff;
    }
    
    public List<List<String>> findLadders(String beginWord, final String endWord, Set<String> wordList) {
        HashMap<String, Set<String>> links = new HashMap<>();
        for (String a : wordList){
            links.put(a, new HashSet<String>());
        }
        for (String a : wordList){
            for (String b : wordList){
                if (linked(a, b)){
                    links.get(a).add(b);
                }
            }
        }
        
        
        HashMap<String, Integer> diffs = new HashMap<>();
        for (String a : wordList){
            int c = 0;
            for (int i = 0 ; i < endWord.length(); i++){
                if (a.charAt(i) == endWord.charAt(i))
                    c++;
            }
            diffs.put(a, c);
        }

        HashMap<String, Integer> shortestLens = new HashMap<>();
        for (String a : wordList){
            shortestLens.put(a, Integer.MAX_VALUE);
        }
        shortestLens.put(beginWord, 0);
        
        PriorityQueue<Chain> pq = new PriorityQueue<>(new Comparator<Chain>(){
            public int compare(Chain a, Chain b){
                return diffs.get(a.getLast()) + a.size()
                -( diffs.get(b.getLast()) + b.size() );
            }
        });
        
        pq.add(new Chain(beginWord));
        List<List<String>> rst = new ArrayList<>();
        while(!pq.isEmpty()){
            Chain chain = pq.poll();
            String nextStr = chain.getLast();
            for (String s : links.get(nextStr)){
                if (chain.size() >= shortestLens.get(s))
                    continue;
                Chain reached = chain.extend(s);
                shortestLens.put(nextStr, reached.size());
                if (endWord.equals(s)){
                    List<String> reachedList = reached.toList();
                    if (rst.isEmpty()){
                        rst.add(reachedList);
                    } else {
                        if (rst.get(0).size() == reached.size()){
                            rst.add(reachedList);
                        } else {
                            return rst;
                        }
                    }
                }
                pq.add(reached);
            }
        }
        return rst;
    }
    
}