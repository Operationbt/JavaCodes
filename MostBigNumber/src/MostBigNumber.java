import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
//가장 큰 수

//테스트케이스 7개 실패
//아직도 모르겠다 ㅎㅎ

public class MostBigNumber {

	public static void main(String[] args) {
		//int[] numbers = {5, 51, 56, 571, 59, 9, 8, 0};
		//int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers = {0,0,0,0,0};
	    Solution s = new Solution();
	    String zero = "0000";
	    
	    System.out.println(Integer.parseInt(zero));
	  
	    System.out.println(s.solution(numbers));
	}

}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        
//        List<Integer> nums = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        List<Integer> nums = new ArrayList<Integer>();
        for (Integer n : numbers) {
			nums.add(n);
		}
        
        for(int i = numbers.length - 1; i >= 0; i--) {
        	int winner = nums.get(0);
        	for(int j = 1; j <= i; j++) {
        		winner = compare(winner, nums.get(j));
        	}
        	answer += Integer.toString(winner);
        	nums.remove(nums.indexOf(winner));
        }

        return answer;
    }
    
    //두 수중 우선순위가 큰 수를 반환하는 함수
    public static int compare(int a, int b) {
    	String sa;
    	String sb;
    	
    	//sa가 더 긴 숫자가 되도록 한다
    	if(a > b) {
    		sa = Integer.toString(a);
        	sb = Integer.toString(b);
    	} else {
    		sa = Integer.toString(b);
    		sb = Integer.toString(a);
    	}
    	
    	//sb의 길이만큼 잘라서 정수 변환후 크기 비교 
    	int ca = Integer.parseInt(sa.substring(0, sb.length()));
    	int cb = Integer.parseInt(sb); //sb는 sub안해도 될듯
    	
    	if(ca > cb)
    		return Integer.parseInt(sa);
    	else if(cb > ca)
    		return Integer.parseInt(sb);
    	else {
        	//잘라낸 sa의 뒷부분을 sb의 첫번째 숫자와 비교
        	for(int i = 0; i < sa.length() - sb.length(); i++) {
        		if(sa.charAt(sb.length() + i) > sb.charAt(0))
        			return Integer.parseInt(sa);
        		else if(sa.charAt(sb.length() + i) < sb.charAt(0))
        			return Integer.parseInt(sb);
        	}
    	}

    	return Integer.parseInt(sa);
    }
    
    
    //비교 결과를 boolean으로 받으면 다른 정렬방법에 적용시킬 수 있을거 같은데 안되네
    public boolean compareb(int a, int b) {
    	String sa;
    	String sb;
    	
    	//sa가 더 긴 숫자가 되도록 한다
    	if(a > b) {
    		sa = Integer.toString(a);
        	sb = Integer.toString(b);
    	} else {
    		sa = Integer.toString(b);
    		sb = Integer.toString(a);
    	}
    	
    	//sb의 길이만큼 잘라서 정수 변환후 크기 비교
    	int ca = Integer.parseInt(sa.substring(0, sb.length()));
    	int cb = Integer.parseInt(sb); //sb는 sub안해도 될듯
    	
    	if(ca > cb)
    		return true;
    	else if(cb > ca)
    		return false;
    	else {
    		
    	}
    	
    	//잘라낸 sa의 뒷부분을 sb의 첫번째 숫자와 비교
    	for(int i = 0; i < sa.length() - sb.length(); i++) {
    		if(sa.charAt(sb.length() + i) > sb.charAt(0))
    			return true;
    		else if(sa.charAt(sb.length() + i) < sb.charAt(0))
    			return false;
    	}

    	return false;
    }
}