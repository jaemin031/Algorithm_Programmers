import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static class fileVo{
		String name;
		String head;
		String number;
		String tail;

		public fileVo(String name, String head, String number, String tail) {
			this.name = name;
			this.head = head;
			this.number = number;
			this.tail = tail;
		}
	}

	public String[] solution(String[] files) {
		ArrayList<fileVo> list = new ArrayList<fileVo>();
		ArrayList<String> answer = new ArrayList<>();

		for(int i=0;i<files.length;i++) {
			String s = files[i];
			String head = "";
			String number = "";
			String tail = "";

			int p = 0;
			for(;p<s.length();++p) {
				if(s.charAt(p)<'0'||s.charAt(p)>'9')
					head += s.charAt(p);
				else
					break;
			}

			for(;p<s.length();++p) {
				if(s.charAt(p) >= '0' && s.charAt(p) <= '9')
					number += s.charAt(p);
				else
					break;
			}
			tail = s.substring(p);
			list.add(new fileVo(s,head.toLowerCase(),number,tail));

		}

		Collections.sort(list, new Comparator<fileVo>() {
			@Override
			public int compare(fileVo arg0, fileVo arg1) {
				if(arg0.head.compareTo(arg1.head)!=0)
					return arg0.head.compareTo(arg1.head);
				else {
					if(Integer.parseInt(arg0.number)>Integer.parseInt(arg1.number)) {
						return 1;
					}else if(Integer.parseInt(arg0.number)<Integer.parseInt(arg1.number)) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});

		for(fileVo vo : list)
			answer.add(vo.name);

		return answer.toArray(new String[answer.size()]);

	}
}
