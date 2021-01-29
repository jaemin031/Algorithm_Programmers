class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] st = skill.split("");
        
        for(int i=0; i< skill_trees.length; i++) {
        	int point = 21;
        	for(int j=st.length-1; j>=0;j--) {
        		if(skill_trees[i].contains(st[j])) {
        			int num = skill_trees[i].indexOf(st[j]);
        			if(point>num) {
        				point = num;
        			}else
        				break;
        		}else if(point!=21&&!skill_trees[i].contains(st[j])) {
        			break;
        		}
        		if(j==0) {
        			answer++;
        		}
        	}
        	
        }
        
        return answer;
    }
}
