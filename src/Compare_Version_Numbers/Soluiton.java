package Compare_Version_Numbers;

public class Soluiton {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(String s:v1){
        	System.out.println(s);
        }
        for(int i=0;i<v1.length&&i<v2.length;i++){
        	int n1 = Integer.parseInt(v1[i]),n2 = Integer.parseInt(v2[i]);
        	if(n1>n2){
        		return 1;
        	}else if(n1<n2){
        		return -1;
        	}
        }
        if(v1.length<v2.length){
        	for(int i=v1.length;i<v2.length;i++){
        		if(Integer.parseInt(v2[i])>0) return -1;
        	}
        }else if(v1.length>v2.length){
        	for(int i=v2.length;i<v1.length;i++){
        		if(Integer.parseInt(v1[i])>0) return 1;
        	}
        }
        return 0;
    }
    
    public static void main(String args[]){
    	Soluiton so = new Soluiton();
    	System.out.println(so.compareVersion("1", "0.0"));
    }
}
