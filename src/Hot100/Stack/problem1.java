package Hot100.Stack;

import java.util.Stack;

public class problem1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        char c;

        for(int i=0;i<len;i++){
            boolean pass = false;

            switch (s.charAt(i)){
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c == '('){
                        pass = true;
                    }else {
                        return false;
                    }
                    break;

                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c == '{'){
                        pass = true;
                    }else {
                        return false;
                    }
                    break;

                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c == '['){
                        pass = true;
                    }else {
                        return false;
                    }
                    break;

                case '(':
                    pass = true;
                    stack.push('(');
                    break;

                case '{':
                    pass = true;
                    stack.push('{');
                    break;

                case '[':
                    pass = true;
                    stack.push('[');
                    break;

            }

            if (!pass){
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
