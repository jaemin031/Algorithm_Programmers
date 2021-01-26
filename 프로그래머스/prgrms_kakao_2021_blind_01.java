class Solution {
    public String solution(String new_id) {
    String answer = "";
        answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9_.-]","");
        
        while(answer.contains("..")) {
        	answer = answer.replaceAll("\\.\\.", "\\.");
        }
        while(true) {
        	if(answer.charAt(0) == '.') {
        		answer = answer.substring(1);
        	}
        	if(answer.length()==0)
        		break;
        	if(answer.charAt(answer.length()-1) == '.') {
        		answer = answer.substring(0,answer.length()-1);
        	}
        	if(answer.length()==0)
        		break;
        	if(answer.charAt(0) != '.' && answer.charAt(answer.length()-1) != '.') {
        		break;
        	}
        	if(answer.length()==0)
        		break;
        }
        
        if(answer.length()==0) {
        	answer = "a";
        }
        
        if(answer.length()>=15) {
        	answer = answer.substring(0,15);
        	while(true) {
        		if(answer.charAt(answer.length()-1) == '.') {
            		answer = answer.substring(0,answer.length()-1);
            	}else
            		break;
        	}
        }
        
        while(true) {
	        if(answer.length()<3) {
	        	answer += answer.charAt(answer.length()-1);
	        }else
	        	break;
        }
        
        return answer;
    }
}
