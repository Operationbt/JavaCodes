
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
//기능개발
public class Lessons42586 {
    public int[] solution(int[] progresses, int[] speeds) {
    	int[] answer = {};
    	int days = 0;
    	int count = 0;
    	ArrayList<Integer> counts = new ArrayList<Integer>();
    	
    	
    	LinkedList<Integer> linkedProgresses = new LinkedList<Integer>();
    	for(int e : progresses)
    		linkedProgresses.add(e);
    	
    	
    	LinkedList<Integer> linkedSpeeds = new LinkedList<Integer>();
    	for(int e : speeds)
    		linkedSpeeds.add(e);
    	
    	while(true) {
    		if(linkedProgresses.isEmpty())
    			break;
    		days++;
    		while(true) {
	    		if((linkedProgresses.element().intValue() + (linkedSpeeds.element().intValue() * days)) >= 100) {	
	    			//System.out.println("1: " + linkedProgresses);
	    			linkedProgresses.removeFirst();
	    			linkedSpeeds.removeFirst();
	    			//System.out.println("2: " + linkedProgresses);
	    			count++;
	    			System.out.println("count : " + count);
	    		}
	    		else {
	    			if(count != 0) {
		    			counts.add(count);
			    		count = 0;
	    			}
		    		break;
	    		}
    			if(linkedProgresses.isEmpty()) {
    				counts.add(count);
    				break;
    			}
    		}
    		
    	}
    	System.out.println("counts : " + counts);
        
    	answer = counts.stream().mapToInt(i -> i).toArray();
        return answer;
    }

}
