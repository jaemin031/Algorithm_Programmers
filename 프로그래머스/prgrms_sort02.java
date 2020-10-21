import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder stb = new StringBuilder();
        String[] num = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++)
        	num[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(num, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return (arg1+arg0).compareTo(arg0+arg1);
			}
        });
        
        if(num[0].startsWith("0")) { 
    		stb.append("0");
    	} else {
    		for(int j=0; j<num.length; j++) {
    			stb.append(num[j]);
    		}
    	}
        
        
        return stb.toString();
    }
}
