import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen=new HashSet<>();
        while(n !=1 && !seen.contains(n)){
            seen.add(n);
            n=squareOfNum(n);

        }
        return n==1;
    
    }
    private int squareOfNum(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum=sum+rem*rem;
            n=n/10;
        }
        return sum;
    }
}