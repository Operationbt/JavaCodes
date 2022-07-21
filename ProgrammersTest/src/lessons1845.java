import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
//코딩테스트 연습 해시 폰켓몬

public class lessons1845 {
	public int solution(int[] nums) {
		int answer = 0;
		int selCount = nums.length / 2;
          
        HashMap<Integer, Integer> ponkemonMap = new HashMap<>();
        
        for(int k : nums) {
        	if(ponkemonMap.get(k) == null) {
        		ponkemonMap.put(k, 1);
        	}
        	//몇종류 있는지만 알면 되서 종류당 몇마리인지는 안적어도 될듯
        	/*
        	else {
        		ponkemonMap.put(k, ponkemonMap.get(k) + 1);
        	}
        	*/
        }
        
        int keyCount = ponkemonMap.size();
        
        //선택 가능 갯수보다 폰켓몬 종류 수가 크면 선택 가능 갯수 만큼 종류를 취한다
        //선택 가능 갯수보다 폰켓몬 종류 수가 작으면 모든 폰켓몬 종류 수를 가질 수 있다 
        answer = selCount > keyCount ? keyCount : selCount;
        System.out.println(answer);
        
        return answer;
    }
}
/*
 * 몇마리인지 안세도 되는 경우, 종류의 갯수만 알면 되는 경우
 * HashSet이용하면 좋을듯
 */

