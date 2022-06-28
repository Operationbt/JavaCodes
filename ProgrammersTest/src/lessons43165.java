//https://programmers.co.kr/learn/courses/30/lessons/43165
//코딩테스트 연습 깊이/너비 우선 탐색(DFS/BFS) 타겟 넘버
/*
numbers			target	return
[1, 1, 1, 1, 1]	3		5
[4, 1, 2, 1]	4		2
*/

public class lessons43165 {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        //numbers에 있는 수들에 +-기호 붙여서 포화이진트리(배열구현)에 집어넣기
        int maxSize = (int)Math.pow(2, numbers.length + 1) - 1;       
        int[] arr = new int[maxSize];
        int level = 1;
        int index = 1;
        arr[0] = 0;
        while(level <= numbers.length) {
        	int num = numbers[level - 1];
        	for(int i = (int)Math.pow(2, level); i > 0 ; i--) {
        		arr[index] = num;
        		num *= -1;
        		index++;
        	}
        	level++;
        }
        System.out.println(arr);
        
        
        return answer;
    }
}
