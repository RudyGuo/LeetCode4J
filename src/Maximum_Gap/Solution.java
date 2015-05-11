package Maximum_Gap;

import java.util.Arrays;

public class Solution {
	class Pair{
		int min;
		int max;
		Pair(int min,int max){
			this.min = min;
			this.max = max;
		}
	}
    public int maximumGap(int[] num) {
    	if(num.length<=1) return 0;
    	int mn = num[0],mx = num[0];
    	int len = num.length;
    	for(int n:num){
    		mn = Math.min(mn, n);
    		mx = Math.max(mx, n);
    	}
    	if(mn== mx) return 0;
    	//Ͱ��ļ��
    	int dist = (mx-mn)/len+1;
    	//ÿ��pair����һ��Ͱ�������洢ӳ�䵽��Ͱ���������С��
    	Pair[]buck = new Pair[len];
    	for(int n:num){
    		//ӳ���Ͱ�±�
    		int index = (n-mn)/dist;
    		if(buck[index]==null) {
    			buck[index]= new Pair(n,n);
    			continue;
    		}
    		Pair p = buck[index];
    		p.min = Math.min(n,p.min);
    		p.max = Math.max(n,p.max);
    	}
    	int preMax = buck[0].max;
    	int res = preMax-buck[0].min;
    	for(int i=1;i<buck.length;i++){
    		Pair p = buck[i];
    		if(p==null) continue;
    		res = Math.max(p.min-preMax, res);
    		preMax = p.max;
    	}
    	return res;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	int num[] ={36,9,1};
    	System.out.println(so.maximumGap(num));
    }
}
