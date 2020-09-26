import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
//모의고사
public class Lessons42840 {
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        class Supoja {
        	int name;
        	int[] pattern;
        	int collect = 0;
        	public Supoja(int name, int[] pattern) {
				this.name = name;
				this.pattern = pattern;
				this.collect = 0;
			}
        	
        	@Override
        	public String toString() {
        		
        		return "name = " + name + ", collect = " + collect; 
        	}
        }

        Supoja supo1 = new Supoja(1, new int[] {1, 2, 3, 4, 5});
        Supoja supo2 = new Supoja(2, new int[] {2, 1, 2, 3, 2, 4, 2, 5});
        Supoja supo3 = new Supoja(3, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        List<Supoja> supoList = new ArrayList<Supoja>();
        supoList.add(supo1);
        supoList.add(supo2);
        supoList.add(supo3);
        
        //알고리즘
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == supo1.pattern[i % 5])
        		supo1.collect++;
        	if(answers[i] == supo2.pattern[i % 8])
        		supo2.collect++;
        	if(answers[i] == supo3.pattern[i % 10])
        		supo3.collect++;
        }
        
        
        System.out.println(supo1.collect + ", " + supo2.collect + ", " + supo3.collect);
        
        //정답 갯수대로 내림차순 정렬
        supoList.sort(new Comparator<Supoja>() {
        	@Override
        	public int compare(Supoja o1, Supoja o2) {
        		int c1 = o1.collect;
        		int c2 = o2.collect;
        		
        		if(c1 == c2) return 0;
                else if(c1 < c2) return 1; //collect 기준 내림차순
                else return -1;
        	};
		});
        
        for(Supoja s : supoList)
        	System.out.println(s);
        
        if(supoList.get(0).collect == supoList.get(1).collect && supoList.get(1).collect == supoList.get(2).collect) {
        	answer = new int[3];
        	answer[0] = supoList.get(0).name;
        	answer[1] = supoList.get(1).name;
        	answer[2] = supoList.get(2).name;
        } else if (supoList.get(0).collect == supoList.get(1).collect) {
        	answer = new int[2];
        	answer[0] = supoList.get(0).name;
        	answer[1] = supoList.get(1).name;
		} else {
			answer = new int[1];
        	answer[0] = supoList.get(0).name;
		}
        
        return answer;
    }
}
