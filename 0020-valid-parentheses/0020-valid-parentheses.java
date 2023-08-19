class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() < 2)    return false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) =='{' || s.charAt(i) == '(' || s.charAt(i) == '[')   stack.push(s.charAt(i));
            else{
                if(stack.isEmpty()) return false;
                else{
                    char top = stack.pop();
                    if(s.charAt(i) == '}' && top != '{')    return false;
                    if(s.charAt(i) == ']' && top != '[')    return false;
                    if(s.charAt(i) == ')' && top != '(')    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}