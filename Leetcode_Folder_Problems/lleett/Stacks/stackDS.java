import java.util.Stack;

public class stackDS {
    
    public static void main(String[] args) {
        String ourString = "{}{}[]()";

        System.out.println(stackSolution(ourString) + " and the contents of the String 's' is: " + s);
    }


    public static  boolean stackSolution(String nameOfOurString){
        //making a Stack ( think of a stack of plates) and goes LIFO last in first out
        Stack<Character> bracketStack = new Stack<>();

        //looping through out String object with parameter name of nameOfOurString
        for(int i = 0; i < nameOfOurString.length(); i++) {
            //making a character variable name bracketTypes, stores the bracket type based on which index were at
            char bracketTypes = nameOfOurString.charAt(i);
            //First check a condition that if the String given contains '(' or '{' or '['
                // we then push whatever bracket type it found that we allow and pushes it to our stack called bracketStack
            if(bracketTypes == '(' || bracketTypes == '[' || bracketTypes == '{') {
                //pushing (basically we are putting / storing whatever bracket we accept to the stack object we made)
                bracketStack.push(bracketTypes);

                System.out.println(bracketStack);
            }
            else {
                // else if we dont find a bracket we accept we hen go to the ELSE statement 
                //      else statement then checks IF our stack object is empty and returns FALSE if it is EMPTY
                if(bracketStack.isEmpty()) {
                    System.out.println(bracketStack);

                    return false;
                }
                // creating a character variable that stores each time we pop ( remove ) the latest bracket
                // If the stack object IS NOT EMPTY we then check IF any of the conditons we put are true
                char top = bracketStack.pop();
                if(top == ')' && top != '(' || top == ']' &&
                 top != '[' || top == '}' && top != '{') {
                    System.out.println(bracketStack);

                    //returns false if the stack doesnt contain a valid bracket that matches
                    return false;
                }
            }
        }
        // returns true if stack is empty after checking all conditions , false if not
        return bracketStack.isEmpty();
    }
}
