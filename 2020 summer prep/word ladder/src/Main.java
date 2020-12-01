import java.util.*;

public class Main {

    public static void main(String[] args) {
        // make dictionary
//       Set D = new HashSet<>();
//       // List<String> D = new ArrayList<>();
//        D.add("poon");
//        D.add("plee");
//        D.add("same");
//        D.add("poie");
//        D.add("plie");
//        D.add("poin");
//        D.add("plea");
//
//        String start = "loon";
//        String target = "plea";
//        System.out.print("Length of shortest chain is: "
//                + wordLadder(start, target, D));


    }

    public static int wordLadder(String start, String end, Set Dict){
        LinkedList<String> finalList = new LinkedList<>();
        //check if end exists in dict
        if(!Dict.contains(end)) return 0;
        //add start to queue
        Queue<String> wordQueue = new LinkedList<>();

        int length = 0;
        wordQueue.add(start);
        finalList.add(start);
        //while queue is not empty
        while(!wordQueue.isEmpty()){
            length++;
            int size = wordQueue.size();
            while(size>0){
                //remove word from queue
                char[] word = wordQueue.peek().toCharArray();
                wordQueue.remove();

                size--;
                //make new combination of the word with one letter changed
                for(int i=0; i<word.length;i++){
                    char orig = word[i];
                    for(char j='a'; j<='z';j++){
                        word[i] = j;
                        //check if that new word is the target then return length
                        if(String.valueOf(word).equals(end)) {
                            finalList.add(String.valueOf(word));
                            return length+1;
                        }
                        //check if that new word is in the dictionary, if yes remove it and add new word to queue
                        if(Dict.contains(String.valueOf(word))) {
                            Dict.remove(String.valueOf(word));
                            wordQueue.add(String.valueOf(word));
                            finalList.add(String.valueOf(word));
                        }
                    }
                    word[i] = orig;

                }
            }
        }
        return 0;
    }
}
