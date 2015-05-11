package Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> reMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	char rc = t.charAt(i);
        	if(map.containsKey(c)){
        		if(rc!=map.get(c)) return false;
        	}else{
        		if(reMap.containsKey(rc)) return false;
        		map.put(c, rc);
        		reMap.put(rc, c);
        	}
        }
        return true;
    }
    
    public static void main(String args[]){
    	Solution main = new Solution();
    	System.out.println(main.isIsomorphic("egd","add"));
    }
}
