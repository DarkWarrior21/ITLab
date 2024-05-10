public class PostfixToPrefix {
    
    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }

    static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                stack.push(Character.toString(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = c + op2 + op1;
                stack.push(exp);
            }
        }
        return stack.pop();
    }

    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }
    static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                stack.push(Character.toString(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String exp = "(" + op2 + c + op1 + ")";
                stack.push(exp);
            }
        }
        return stack.pop();
    }}

    public class InfixToPostfix {
    
        static int precedence(char operator) {
            switch (operator) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }
    
        static String infixToPostfix(String infix) {
            StringBuilder postfix = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);
                
                if (Character.isLetterOrDigit(c)) {
                    postfix.append(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }
                    stack.pop(); 
                } else { 
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
            
          
            while (!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    return "Invalid infix expression"; 
                }
                postfix.append(stack.pop());
            }
            
            return postfix.toString();
        }}


        public class InfixToPrefix {
    
            static int precedence(char operator) {
                switch (operator) {
                    case '+':
                    case '-':
                        return 1;
                    case '*':
                    case '/':
                        return 2;
                    case '^':
                        return 3;
                }
                return -1;
            }
        
            static String reverse(String str) {
                StringBuilder reversed = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; i--) {
                    reversed.append(str.charAt(i));
                }
                return reversed.toString();
            }
        
            static String infixToPrefix(String infix) {
                StringBuilder prefix = new StringBuilder();
                Stack<Character> stack = new Stack<>();
                
                String reversedInfix = reverse(infix);
                
                for (int i = 0; i < reversedInfix.length(); i++) {
                    char c = reversedInfix.charAt(i);
                    
                    if (Character.isLetterOrDigit(c)) {
                        prefix.append(c);
                    } else if (c == ')') {
                        stack.push(c);
                    } else if (c == '(') {
                        while (!stack.isEmpty() && stack.peek() != ')') {
                            prefix.append(stack.pop());
                        }
                        stack.pop(); 
                    } else { 
                        while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                            prefix.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
                
                while (!stack.isEmpty()) {
                    prefix.append(stack.pop());
                }
                
                return reverse(prefix.toString());
            }}


            public class PrefixToInfix {
    
                static boolean isOperand(char x) {
                    return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
                }
            
                static String prefixToInfix(String prefix) {
                    Stack<String> stack = new Stack<>();
                    
                    for (int i = prefix.length() - 1; i >= 0; i--) {
                        char c = prefix.charAt(i);
                        
                        if (isOperand(c)) {
                            stack.push(Character.toString(c));
                        } else { 
                            String operand1 = stack.pop();
                            String operand2 = stack.pop();
                            String exp = "(" + operand1 + c + operand2 + ")";
                            stack.push(exp);
                        }
                    }
                    
                    return stack.pop();
                }}

                public class PrefixToPostfix {
    
                    static boolean isOperand(char x) {
                        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
                    }
                
                    static String prefixToPostfix(String prefix) {
                        Stack<String> stack = new Stack<>();
                        
                        for (int i = prefix.length() - 1; i >= 0; i--) {
                            char c = prefix.charAt(i);
                            
                            if (isOperand(c)) {
                                stack.push(Character.toString(c));
                            } else { 
                                String operand1 = stack.pop();
                                String operand2 = stack.pop();
                                String exp = operand1 + operand2 + c;
                                stack.push(exp);
                            }
                        }
                        
                        return stack.pop();
                    }}
                