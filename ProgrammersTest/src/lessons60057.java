import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/60057
//문자열 압축

/*
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17
 */
public class lessons60057 {
	private class Result {
		String str;
		int len;
		public Result(String str, int len) {
			super();
			this.str = str;
			this.len = len;
		}
		@Override
		public String toString() {
			return "Result [str=" + str + ", len=" + len + "]";
		}
		
	}
	private String Compression(String s, int splitSize) {
		
		int beginIndex = 0;
		int endIndex = splitSize;
		int cnt = 0;
		
		String token = s.substring(beginIndex, endIndex);
		String temp = "";	
		boolean flag = true;
		
		while(endIndex <= s.length() && flag) {
			if(token.equals(s.substring(beginIndex, endIndex))) {
				cnt++;
				if(endIndex + splitSize <= s.length()) {
					beginIndex += splitSize;
					endIndex += splitSize;
				} else {
					flag = false;
				}
			} else {
				if(cnt != 1)
					temp += cnt + token;
				else
					temp += token;
				token = s.substring(beginIndex, endIndex);
				cnt = 0;
			}
		}
		if(!flag)
			endIndex = s.length();
		if(cnt != 1)
			temp += cnt + s.substring(beginIndex, endIndex);
		else
			temp += s.substring(beginIndex, endIndex);
		
		return temp;
		
		
	}
	public int Solution(String s) {
		int minSize = s.length();
		String temp;
		List<Result> results = new ArrayList<>();
		s="a";
		for(int splitSize = 1; splitSize <= (s.length()/2) ; splitSize++) {
			//splitSize 크기대로 s를 자르면서 압축표현
			temp = Compression(s, splitSize);
			results.add(new Result(temp, temp.length()));
			
			if(temp.length() < minSize) {
				minSize = temp.length();
			}
		
		}
		System.out.println(results.toString());
		System.out.println("minSize : " + minSize);
		return minSize;
	}
	
}
