import java.util.*;

public class ParenthesisMatching {
    
    // Function to check if the given string has balanced parentheses
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            // If the character is an opening parenthesis, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the character is a closing parenthesis
            else if (c == ')' || c == '}' || c == ']') {
                // If the stack is empty, or the top of the stack does not match the closing parenthesis, return false
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        // If the stack is empty after iterating through the string, return true (balanced)
        return stack.isEmpty();
    }
    
    // Function to check if the given opening and closing parentheses are matching
    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '{' && closing == '}') || (opening == '[' && closing == ']');
    }
    
    public static void parenthesis(String[] args) {
        String str1 = "{[()]}"; // Balanced string
        String str2 = "{[(])}"; // Unbalanced string
        
        System.out.println("String 1 is balanced: " + isBalanced(str1));
        System.out.println("String 2 is balanced: " + isBalanced(str2));
    }
}
