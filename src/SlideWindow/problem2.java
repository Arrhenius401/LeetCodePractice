package SlideWindow;

import java.util.*;

public class problem2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int slen = s.length();
        int plen = p.length();
        int rightPointer = -1;

        if(slen < plen){
            return result;
        }

        for(int i=0; i<plen; i++){
           pCount[p.charAt(i) - 'a']++;
           sCount[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<slen; i++){
            if(Arrays.equals(sCount,pCount)){
                result.add(i);
            }

            if(i+plen < slen){
                sCount[s.charAt(i+plen) - 'a']++;
                sCount[s.charAt(i) - 'a']--;
            }else {
                break;
            }

        }

        return result;
    }
}
