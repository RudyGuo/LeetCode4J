package Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i=0,len = 0,strLen = 0;
        while(i<words.length){
        	int wLen = words[i].length();
        	if(len ==0){
        		len += wLen;
        	}else{
        		len +=wLen+1;
        	}
        	strLen += wLen;
        	list.add(words[i]);
        	if(i<words.length-1&&len<L){
        		i++;
        		continue;
        	}else if(i==words.length-1&&len<=L){
        		StringBuilder sb = new StringBuilder();
        		sb.append(list.get(0));
        		for(int j=1;j<list.size();j++){
        			sb.append(" "+list.get(j));
        		}
        		for(int j=0;j<L-sb.length();i++){
        			sb.append(" ");
        		}
        		res.add(sb.toString());
        		break;
        	}
        	if(len==L){
        		res.add(help(list,L,strLen));
        		list.clear();
            	len = 0;
            	strLen = 0;
            	i++;
            	continue;
        	}
        	list.remove(list.size()-1);
        	res.add(help(list,L,strLen-wLen));
        	list.clear();
        	len = 0;
        	strLen = 0;
        }
        return res;
    }
    
    private String help(List<String> list,int L,int strLen){
    	if(list.size()==1){
    		StringBuilder sb = new StringBuilder();
    		for(int i=0;i<L-strLen;i++){
    			sb.append(" ");
    		}
    		return list.get(0)+sb;
    	}
    	int bLen = (L-strLen)/(list.size()-1);
    	int mod = (L-strLen)%(list.size()-1);
    	StringBuilder res = new StringBuilder();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<bLen;i++){
    		sb.append(" ");
    	}
    	res.append(list.get(0));
    	for(int i=1;i<=mod;i++){
    		res.append(sb+" "+list.get(i));
    	}
    	for(int i=mod+1;i<list.size();i++){
    		res.append(sb+list.get(i));
    	}
    	return res.toString();
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	String words[] ={"a","b","c","d","e"};
    	List<String> res = so.fullJustify(words, 1);
    	for(int i=0;i<res.size();i++){
    		System.out.println(res.get(i));
    	}
    }
}