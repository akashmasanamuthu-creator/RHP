import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String c = sc.nextLine();

        int b = a.length();
        int d = c.length();

        String f = "";

        int[][] mat = new int[b + 1][d + 1];

        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= d; j++) {

                if (a.charAt(i - 1) == c.charAt(j - 1)) {

                    mat[i][j] = mat[i - 1][j - 1] + 1;

                    if (mat[i][j] > maxLen) {
                        maxLen = mat[i][j];
                        endIndex = i;
                    }

                } else {
                    mat[i][j] = 0;
                }
            }
        }

        f = a.substring(endIndex - maxLen, endIndex);

        System.out.println(f);
    }
}