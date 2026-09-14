class Solution {
    public String countAndSay(int n) {

        String str = "1";

        for (int i = 2; i <= n; i++) {

            String result = "";
            int count = 1;

            for (int j = 1; j < str.length(); j++) {

                if (str.charAt(j) == str.charAt(j - 1)) {
                    count++;
                } 
                else {
                    result = result + count + str.charAt(j - 1);
                    count = 1;
                }
            }

            // Add the last group
            result = result + count + str.charAt(str.length() - 1);

            str = result;
        }

        return str;
    }
}