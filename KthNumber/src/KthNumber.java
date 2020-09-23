import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
//프로그래머스 코딩테스트 연습 > 정렬 > K번째 수 

public class KthNumber {
	
    
	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
	    int[][] commands = {{2, 5, 4}, {4, 4, 1}, {1, 7, 3}};
		
	    Solution s = new Solution();
		
		System.out.println(Arrays.toString(s.solution(array, commands)));
	}

}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        //1) for-each로 각 커맨드 분리
        for (int[] c : commands) {
        	//System.out.println(Arrays.toString(i));
        	
        	//2) 잘라낸 배열을 저장할 임시 배열 선언
			int len = c[1] - c[0] + 1;
			int[] temp = new int[len];
			
			for(int i = 0; i < len; i++) {
				temp[i] = array[i + c[0] - 1]; //3) c[0]가 오프셋이고 0부터 len까지 임시배열에 넣는다
			}
			//System.out.println(Arrays.toString(temp));
			
			Arrays.sort(temp); //4) 잘라낸 배열을 정렬
			//System.out.println(Arrays.toString(temp));
			answer[index++] = temp[c[2] - 1];
			
			//System.out.println(ans.toString());
		}

        return answer;
    }
    
    //Integer리스트를 int배열로 변환
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}


