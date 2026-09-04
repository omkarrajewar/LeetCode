import java.util.*;

class Solution {

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapS.containsKey(a) && mapS.get(a) != b) {
                return false;
            }

            if (mapT.containsKey(b) && mapT.get(b) != a) {
                return false;
            }

            mapS.put(a, b);
            mapT.put(b, a);
        }

        return true;
    }
}