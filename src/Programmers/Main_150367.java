package Programmers;

public class Main_150367 {

	static class Solution {
	    public int[] solution(long[] numbers) {
	    	
	    	int[] answer = new int[numbers.length];
	    	
	    	for (int i = 0; i < numbers.length; i++) {
				long num = numbers[i];
				answer[i] = bt(num);
			}
	        
	        return answer;
	    }
	    
	    static int bt(long num) {
	    	
	    	String bi = Long.toBinaryString(num);
	    	
//	    	System.out.println(bi);
		    
//	    	double tmp = Math.pow(10, 15);	    	
//	    	double e = Math.log10(tmp) / Math.log10(2L);	    	
//	    	System.out.println(e); // => 50
	    		
	    	int biL = bi.length();
	    	
	    	int treeL = 1;
	    	while(treeL < biL) {
	    		treeL = treeL * 2 + 1;
	    	}
	    	
	    	int dif = treeL-biL;
	    	
	    	
	    	StringBuilder pohwa = new StringBuilder();
	    	for (int i = 0; i < dif; i++) {
	    		pohwa.append('0');
			}
	    	pohwa.append(bi);
	    	
	    	String pS = pohwa.toString();
	    	
	    	if(check(pS, 0, pS.length() - 1)) {
	    		return 1;
	    	}else {
	    		return 0;
	    	}
	    }
	    
	    static boolean check(String pTree, int s, int e) {
	    	
	    	if(s == e) {
	    		return true;
	    	}
	    	
	    	int mid = (s + e) / 2;
	    	char root = pTree.charAt(mid);
	    	
	    	int left = (s + mid - 1) / 2;
	    	int right = (mid + 1 + e) / 2;
	    	
	    	if(root == '0' && ( pTree.charAt(left) == '1' || pTree.charAt(right) == '1')) {
	    		return false;
	    	}
	    	
	    	return check(pTree, s, mid - 1) & check(pTree, mid + 1, e);
	    	
//	    	int pL = p.length();
//	    	
//	    	if(pL == 1) {
//	    		return true;
//	    	}
//	    	
//	    	int mid = pL / 2;
//	    	char root = p.charAt(mid);
//	    	
//	    	String left = p.substring(0, mid);
//	    	String right = p.substring(mid+1);
//	    	
//	    	char lRoot = left.charAt(left.length() / 2);
//	    	char rRoot = right.charAt(right.length() / 2);
//	    	
//	    	if(root == '0' && (lRoot == '1' || rRoot == '1')) {
//	    		return false;
//	    	}
//	    	
//	    	return check(left) && check(right);
	    }
	    
	}
}