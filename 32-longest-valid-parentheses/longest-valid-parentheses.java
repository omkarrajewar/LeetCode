class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stc=new Stack<Integer>();
        stc.push(-1);
        int result=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '('){
            stc.push(i);

            
           }
           else{
            stc.pop();

            if(stc.isEmpty()){
                stc.push(i);
            }
            else{
                int len=i- stc.peek();
                result=Math.max(result , len);
            }
           }
        }
        return result;
    }

}