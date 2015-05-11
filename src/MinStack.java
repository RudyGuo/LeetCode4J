import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> list = new ArrayList<>();
    public void push(int x) {
    	list.add(x);
    }

    public void pop() {
        if(list.size()>0){
        	list.remove(list.size()-1);
        }
    }

    public int top() {
        if(list.size()>0){
        	return list.get(list.size()-1);
        }
        return -1;
    }

    public int getMin() {
        if(list.size()>0){
        	int res = list.get(0);
        	for(int i:list){
        		res = Math.min(i, res);
        	}
        	return res;
        }
        return -1;
    }
}
