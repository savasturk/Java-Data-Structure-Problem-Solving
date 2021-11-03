import java.util.*;
import java.util.regex.*;


public class Main
{
    public static boolean IsCheckedBracketWithStack(String input){
        
        HashMap<Character, Character> paranthesesPairs = new HashMap<>();
        paranthesesPairs.put('(', ')');
        paranthesesPairs.put('{', '}');
        paranthesesPairs.put('[', ']');
        
        Stack<Character> paranthesesControl = new Stack<Character>();
        for(char character : input.toCharArray()){
            if(paranthesesPairs.containsKey(character)){
                paranthesesControl.push(character);
            }
            else if(paranthesesPairs.containsValue(character)){
                Character check = (Character)paranthesesControl.pop();
                if(paranthesesPairs.get(check) != character){
                    return false;
                }
            }
        }
        if(paranthesesControl.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean IsCheckedBracketWithRegex(String input) {
        
		Matcher matchElement = Pattern.compile("(\\{})|(\\[])|(\\(\\))").matcher(input);
		while(matchElement.find()) {
			input = matchElement.replaceAll("");
			matchElement.reset(input);
		}
		return input.length() == 0;
	}
	
	public static void main(String[] args) {
	    
	    String testInput = "[{}]{{{[[[]]]}}}[]()";//"{[[([[])]]]}";
	    System.out.println(IsCheckedBracketWithStack(testInput));
	    System.out.println(IsCheckedBracketWithRegex(testInput));
		
	}
}
