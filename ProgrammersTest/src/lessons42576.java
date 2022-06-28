import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42576
//코딩테스트 연습 > 해시 > 완주하지 못한 선수

/*
 participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 */
public class lessons42576 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> partiMap = new HashMap<>();
		//map에 participant목록을 넣는다. 중복이름이면 value 증가
		for(String s : participant) {
			if(partiMap.get(s) != null) {
				partiMap.put(s, partiMap.get(s) + 1);
			} else {
				partiMap.put(s, 1);
			}
		}
		System.out.println(partiMap);
		
		//completion목록을 key로 map을 조회한다. 있으면 value 감소
		for(String s : completion) {
			if(partiMap.get(s) != null) {
				partiMap.replace(s, partiMap.get(s) - 1);
			}
		}
		System.out.println(partiMap);
		
		//map에서 value가 0이 아닌 걸 출력한다
		for(String key : partiMap.keySet()) {
			if(partiMap.get(key) != 0) {
				answer = key;
			}
		}
		System.out.println(answer);
        
        return answer;
    }
}
