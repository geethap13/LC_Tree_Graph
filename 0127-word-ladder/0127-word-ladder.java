class Pair{
    String word;
    int step;
    Pair(String _word,int _step){
        word = _word;
        step = _step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        q.add(new Pair(beginWord,1));
         words.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String w = p.word;
            int step = p.step;
            if(w.equals(endWord)) return step;
            char ch[] = w.toCharArray();
            for(int i=0;i<ch.length;i++){
                 ch = w.toCharArray();
                for(char j='a';j<='z';j++){
                    ch[i] = j;
                    String newStr = new String(ch);
                    // System.out.println(newStr);
                    if(words.contains(newStr)){
                        q.add(new Pair(newStr,step+1));
                        words.remove(newStr);
                    }
                }
            }
         }
         return 0;
    }
}