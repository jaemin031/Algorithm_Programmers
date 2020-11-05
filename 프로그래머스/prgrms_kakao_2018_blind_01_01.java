class Solution {
    public int solution(String dartResult) {
        int score = 0;
        int len = dartResult.length();
        int[] partScore = {0,0,0};
        int part = 0;
        int point = 0;
        char ch;
        String temp ="";
        
        while(point<len) {
        	ch = dartResult.charAt(point);
        	if(Character.isDigit(ch)) {
        		temp += ch;
        	}else {
        		if(ch == 'S')
    	        	partScore[part++] = (int) Math.pow(Integer.parseInt(temp),1);
    	        if(ch == 'D')
    	        	partScore[part++] = (int) Math.pow(Integer.parseInt(temp),2);
    	        if(ch == 'T')
    	        	partScore[part++] = (int) Math.pow(Integer.parseInt(temp),3);
        	
    	        temp = "";
    	        
    	        if(ch == '*') {
    	        	partScore[part-1] *= 2;
    	        	if(part>1) 
        	        	partScore[part-2] *= 2;
    	        }
    	        if(ch == '#')
    	        	partScore[part-1] *= -1;
    	        	
        	}
        	point++;
        }
        
        for(int num : partScore) {
        	score += num;
        }
        return score;
    }
}
