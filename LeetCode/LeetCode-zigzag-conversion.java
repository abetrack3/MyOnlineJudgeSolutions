import java.util.Scanner;

class Solution {

    // public static String[] spaces;

    // public Solution() {
    //     buildSpace();
    // }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int indexIncrement = (numRows - 1) * 2;

        //first row
        sb.append(c[0]);
        for(int i = 1; indexIncrement * i < s.length(); i++) {
            // sb.append(spaces[numRows - 2]);
            sb.append(c[indexIncrement * i]);
        }

        //middle rows
        for(int row = 1; row < numRows - 1; row++) {
            //row - first character
            if(row >= s.length()) return sb.toString();
            sb.append(c[row]);
            // System.out.println(sb.toString());
            for(int i = 0, pos = indexIncrement - row; true; i++) {
                if (pos + indexIncrement * i >= s.length()) break;
                //row - space before
                // sb.append(spaces[numRows - 2 - row]);
                //row - character
                sb.append(c[pos + indexIncrement * i]);
                // System.out.println(sb.toString());

                if (row + indexIncrement * (i + 1) >= s.length()) break;
                //row - space after
                // sb.append(spaces[row - 1]);
                //row - column character
                sb.append(c[row + indexIncrement * (i + 1)]);
                // System.out.println(sb.toString());
            }
        }

        //last row
        if (numRows - 1 >= s.length()) return sb.toString();
        sb.append(c[numRows - 1]);
        for(int i = 1; (numRows - 1) + indexIncrement * i < s.length(); i++) {
            // sb.append(spaces[numRows - 2]);
            sb.append(c[(numRows - 1) + indexIncrement * i]);
        }

        return sb.toString();
    }

    // public static void buildSpace() {
    //     if (spaces != null) return;
    //     spaces = new String[501];
    //     spaces[0] = "";
    //     // StringBuilder s = new StringBuilder();
    //     // for (int i = 1; i < spaces.length; i++) {
    //     //     s.append(" ");
    //     //     spaces[i] = s.toString();
    //     // }
    //     for (int i = 1; i < spaces.length; i++) {
    //         spaces[i] = " " + spaces[i-1];
    //     }
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int rows = scanner.nextInt();
        System.out.println(new Solution().convert(s, rows));
        scanner.close();
    }
}