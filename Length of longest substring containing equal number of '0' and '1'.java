import java.util.*;

public class Length of longest substring containing equal number of '0' and '1' {
   public static int findMaxLength(String s) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        int currSum = 0;

        for (int i = 0; i < s.length(); i++) {

            currSum += (s.charAt(i) == '1') ? 1 : -1;

            if (map.containsKey(currSum)) {
                maxLen = Math.max(maxLen, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(findMaxLength(s));
    }
}