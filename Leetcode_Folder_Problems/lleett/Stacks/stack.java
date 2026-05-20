
import java.util.Stack; // import Stack class to store characters in LIFO order

class stack { // define class StackSolution containing methods


    //we are given a string s containing 
    // just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    
    //so    s = object so  we can use 
    // stack to push the opening brakets and pop when we see a closing braket
    //  and check if they match
    public boolean isValid(String s) { // method that returns true if s has valid matching brackets

        //making a stack   that contains characters and name it charBrakets
        Stack<Character> charBraketsStack = new Stack<>();
         // create a Stack to hold opening bracket characters
       

        for(int i = 0; i < s.length(); i++) { // iterate over each character index in the string s
            char braketType = s.charAt(i); 
            //making a char variable called brakets and assign it the value 
            // of the character at index i in string s
            
            // get the character at position i as iterate through the string s, and store it  
            
            if(braketType == '(' || braketType == '[' || braketType == '{') { 
                // if the char is an opening bracket as the for loop iterates through the String s,
                //  check if the character is an opening bracket

                //we use .pop and .push as we are using the DS 'Stack' which goes LIFO (Last In First Out)

                charBraketsStack.push(braketType); // push the opening bracket onto the stack
                //aka place the opening bracket on top of the stack for later matching with a closing bracket
            }
            else { // else the character is a closing bracket
                if (charBraketsStack.isEmpty()){ // if there is no matching opening bracket available
                    return false; // invalid string, closing bracket without matching opening
                } 
                
                char topBraket = charBraketsStack.pop(); // pop the last opening bracket from the stack
                if(topBraket == ')' && topBraket != '(' || topBraket == ']' && topBraket != '[' || topBraket == '}' && topBraket != '{') { // check if popped bracket matches closing bracket
                    return false; // if brackets don't match, string is invalid
                }
        }
             
     }
    
       return charBraketsStack.isEmpty(); // return true if no unmatched opening brackets remain

    }

} // end of class StackSolution