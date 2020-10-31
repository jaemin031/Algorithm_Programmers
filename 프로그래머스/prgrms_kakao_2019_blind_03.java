import java.util.HashMap;
import java.util.Map;

class Solution {
    public static class page{
		int index;
		int wordCount;
		String content;
		int hrefCount;
		String[] hrefs;
		double score=0;
		
		page(int index,int wordCount,String content,int hrefCount,String[] hrefs){
			this.index = index;
			this.wordCount = wordCount;
			this.content = content;
			this.hrefCount = hrefCount;
			this.hrefs = hrefs;
		}
		public void linkpoint(double s){
			score += s;
		}
		public void basicpoint() {
			score +=wordCount;
		}
	}
    public int solution(String word, String[] pages) {
        int answer = 0;
        double maxScore = 0;
        int word_len = word.length();
        word = word.toLowerCase();
        Map<Integer,page> map = new HashMap<>();
        Map<String,Integer> web = new HashMap<>();
        
        for(int i=0;i<pages.length;i++) {
        	int wordCount = 0;
        	String content;
        	int hrefCount;
        	
        	// wordCount 워드 갯수
        	String[] st = pages[i].split("<body>|</body>");
        	st[1] = st[1].toLowerCase();
        	for(int j=0;i<st[i].length();j++) {
            	j = st[1].indexOf(word,j+1);
            	if(j==-1)
            		break;
            	if(!Character.isLetter(st[1].charAt(j-1)) && !Character.isLetter(st[1].charAt(j+word_len))) {
            		wordCount++;
                    j += word_len;
                }
            }
        	// content 웹 제목
        	content = pages[i].substring(pages[i].indexOf("content=")+17, pages[i].indexOf("/>")-1);
        	web.put(content.trim(),i);
        	
        	// hrefCount 링크 갯수 hrefs[] 링크 웹 제목들
        	String[] hrefs2 = pages[i].trim().split("</a>");       	
        	hrefCount = hrefs2.length-1;
        	String[] hrefs = new String[hrefCount];
        	
        	for(int j=0;j<hrefs2.length-1;j++) {
        		hrefs[j] = hrefs2[j].split("<a href=\"https://")[1].split("\">")[0];
        	}
        	map.put(i,new page(i,wordCount,content,hrefCount,hrefs));
        
        }
        
        for(int i=0;i<map.size();i++) {
        	page p = map.get(i);
        	double linkbonus = (double)p.wordCount/p.hrefCount;
        	for(String s : p.hrefs) {
        		if(web.containsKey(s))
        			map.get(web.get(s)).linkpoint(linkbonus);
        	}
        	
        	p.basicpoint();
        }
        
        for(int i=0;i<map.size();i++) {
        	if(maxScore<map.get(i).score) {
        		maxScore = map.get(i).score;
        		answer = i;
        	}
        }

        return answer;
    }
}
