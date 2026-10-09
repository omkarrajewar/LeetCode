class Solution {
    public int minInsertions(String s) {
        int open=0;
        int insertion=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                open++;
            }
            else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    insertion++;
                }
                if(open>0){
                    open--;
                }
                else{
                    insertion++;
                }
            }
        }
        insertion=insertion+open*2;
        return insertion;
    }
}