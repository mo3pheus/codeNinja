package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphanumericSorting {

    public static void main(String[] args){
        String[] examples = {
                "1some", "2some", "20some", "21some", "3some", "some", "1abc", "abc"
        };

        List<String> temp = new ArrayList<>();
        for(String word:examples){
            temp.add(word);
        }

        Collections.sort(temp);
        for(String word:temp){
            System.out.println(word);
        }
    }
}
