package Largest_Number;

import java.util.PriorityQueue;
  
public class Solution {
	  public String largestNumber(int[] num) {
	        PriorityQueue<Cmp> pq = new PriorityQueue<>();
	        for(int i=0;i<num.length;i++){
	        	pq.add(new Cmp(num[i]));
	        }
	        StringBuilder sb = new StringBuilder();
	        while(!pq.isEmpty()){
	        	sb.append(pq.poll().str);
	        }
	        int z = 0;
	        while(z<sb.length()&&sb.charAt(z)=='0'){
	        	z++;
	        }
	        if(z==sb.length()) return "0";
	        return sb.substring(z);
	    }
	    
	    class Cmp implements Comparable{
	    	String str;
	    	Cmp(int str){
	    		this.str = str+"";
	    	}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				Cmp other = (Cmp)o;
				String oStr = other.str;
				return compare(oStr,str);

			}
			
			private int compare(String a,String b){
				for(int i=0;i<a.length()&&i<b.length();i++){
					if(a.charAt(i)==b.charAt(i)) continue;
					return a.charAt(i)-b.charAt(i);
				}
				if(a.length()==b.length()){
					return 0;
				}else if(a.length()>b.length()){
					return compare(a.substring(b.length()),b);
				}
				return compare(a,b.substring(a.length()));
			}
	    }
	    
	    public static void main(String args[]){
	    	Solution so= new Solution();
	    	int []num = {121,12};
	    	System.out.println(so.largestNumber(num));
	    }
	}
