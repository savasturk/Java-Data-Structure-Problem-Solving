
import java.util.ArrayList;
import java.util.*;


public class Main
{
    public static int getDistance(String input, String search ){
        
        int horizontal = search.length();
        int vertical = input.length();
        
        int [][] distanceControl = new int[horizontal+1][vertical+1];
        
        for(int i = 0; i < horizontal + 1; i++){
            distanceControl[i][0] = 0;
        }
        
        for(int i = 0; i < vertical + 1; i++){
            distanceControl[0][i] = 0;
        }
        
        for(int i = 0; i < horizontal; i++){
            for(int j = 0; j < vertical; j++){
                
                char inputElement = input.charAt(j);
                char searchElement = search.charAt(i);
                if(inputElement == searchElement){
                    distanceControl[i+1][j+1] = distanceControl[i][j] + 1;
                }
                else{
                    distanceControl[i+1][j+1] = Math.max(distanceControl[i+1][j], distanceControl[i][j+1]);
                }
            }
        }
        
      /*  for(int i = 0; i<horizontal+1; i++)
    {
        for(int j = 0; j<vertical+1; j++)
        {
            System.out.print(distanceControl[i][j]);
        }
        System.out.println();
    }
      */  
        return distanceControl[horizontal][vertical];
    }
    
    public static List<Object> partialSubString(String input, String search){
        
       	boolean fullMatch = false;
	    boolean deletionMatch = false;
	    boolean insertionMatch = false;

	    ArrayList<Integer> deletionMatchListIndex = new ArrayList<Integer>();
	    ArrayList<Integer> insertionMatchListIndex = new ArrayList<Integer>();
	    ArrayList<Integer> fullMatchListIndex = new ArrayList<Integer>();

        ArrayList<String> deletionMatchList = new ArrayList<String>();
	    ArrayList<String> insertionMatchList = new ArrayList<String>();
	    ArrayList<String> fullMatchList = new ArrayList<String>();

        int searchLength = search.length() ;
	    for(int i = 0; i <= input.length() - searchLength ; i++){
	        String inputParse = input.substring(i, i + searchLength );
	        int distance = getDistance( inputParse, search);
	        if(distance  == searchLength ){
	            fullMatch = true;
	            fullMatchListIndex.add(i);
	            fullMatchList.add(inputParse);
	        }
	        else if(distance  == searchLength - 1){
	            deletionMatch = true;
	            deletionMatchListIndex.add(i);
	            deletionMatchList.add(inputParse);
	        }
	        else if(distance  == searchLength + 1){
	            insertionMatch = true;
	            insertionMatchListIndex.add(i);
	            insertionMatchList.add(inputParse);
	        }
	    }
	    
	    int searchLengthInsertion = search.length() + 1 ;
	    for(int i = 0; i <= input.length() - searchLengthInsertion ; i++){
	        String inputParse = input.substring(i, i + searchLengthInsertion );
	        int distance = getDistance( inputParse, search);

	         if(distance  == searchLengthInsertion - 1){
	            insertionMatch = true;
	            insertionMatchListIndex.add(i);
	            insertionMatchList.add(inputParse);
	        }
	    }
	    int searchLengthDeletion = search.length() - 1 ;
	    for(int i = 0; i <= input.length() - searchLengthDeletion ; i++){
	        String inputParse = input.substring(i, i + searchLengthDeletion );
	        int distance = getDistance( inputParse, search);
	        if(distance  == searchLengthDeletion){
	           	deletionMatch = true;
	            deletionMatchListIndex.add(i);
	            deletionMatchList.add(inputParse);
	        }
	    }
	    
	    if(fullMatch){
	        return Arrays.asList(fullMatch, fullMatchListIndex, fullMatchList, "Exact Match");
	    }
	    else if(insertionMatch){
	        return Arrays.asList(insertionMatch, insertionMatchListIndex, insertionMatchList, "1 deletion");
	    }
	    else if(deletionMatch){
	        return Arrays.asList(deletionMatch, deletionMatchListIndex, deletionMatchList, "1 insertion");
	    }
	    else{
	        return Arrays.asList(false, null , null);
	    }
    }
	public static void main(String[] args) {
	    String input = "helloworlditstimetoleetcodebyeworld";

	    String[] searchElements = {"world", "byewrld", "timetwoleetcode", "wrld", "notinit"};
	    for(String search : searchElements){
	        System.out.println("\nSubstring: "+ search +" -> "+partialSubString(input, search));
	    }
	    
	}
}
