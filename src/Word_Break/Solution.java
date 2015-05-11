package Word_Break;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Solution {
	boolean f[];
	int maxLen = Integer.MIN_VALUE;
	List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, Set<String> dict) {
    	f = new boolean[s.length()];
    	maxLength(dict);
    	wordBreak(s,dict,0,new StringBuilder());
    	return res;
    }
    private void wordBreak(String s, Set<String> dict,int index,StringBuilder path){
    	if(index>=s.length()) {
    		res.add(path.substring(0, path.length()-1));
    		return;
    	}
    	for(int i=index;i<maxLen+index;i++){
    		if(i<s.length()&&dict.contains(s.substring(index,i+1))&&f[i]==false){
    			StringBuilder nextPath = new StringBuilder(path); 
    			nextPath.append(s.substring(index,i+1)+" ");
    			wordBreak(s,dict,i+1,nextPath);
    		}
    	}
    }
    private void maxLength(Set<String> dict){
    	Iterator<String> it = dict.iterator();
    	while(it.hasNext()){
    		maxLen = Math.max(maxLen, it.next().length());
    	}
    }
}
