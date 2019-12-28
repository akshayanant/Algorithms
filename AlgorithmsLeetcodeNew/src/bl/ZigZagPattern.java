package bl;

/**
 * Created by Akshay Hegde on 3/17/2019.
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class ZigZagPattern {

    public String convert(String s, int numRows) {
        if(numRows==1){
        return s;
    }
    int i=0;
    int j=0;
    int count=0;
    int col =0;
    char[][] mat = new char[numRows][s.length()];
    boolean inc = true;
        while(count<s.length()){
        char ch = s.charAt(count++);
        mat[i][j] =ch;
        if(inc) {
            i++;
            if (i >= numRows) {
                i -= 2;
                inc = false;
                if (i < 0) {
                    i = 0;
                    inc = true;
                } else {
                    j++;
                    col++;
                }
            }
        }
        else{
            i--;
            if(i<0){
                i = 1;
                inc = true;
            }
            else{
                j++;
                col++;
            }
        }
    }
    StringBuilder res =new StringBuilder();
        for (int r = 0; r <numRows ; r++) {
        for (int c =0; c<=col;c++){
            if(mat[r][c]!='\u0000'){
                res.append(mat[r][c]);
            }
        }
    }
        return res.toString();
}

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZigZagPattern().convert(s,3));
    }

}
