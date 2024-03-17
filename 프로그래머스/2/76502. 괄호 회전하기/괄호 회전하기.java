import java.util.Stack;
class Solution {
    public int solution(String s) {
       int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str1 = new StringBuilder(s);
            String rotation = str1.substring(0, i);
            str1.delete(0,i);
            str1.append(rotation);
            String str = str1.toString();
            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else if (c == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
            }
             //         System.out.println(stack);

            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}