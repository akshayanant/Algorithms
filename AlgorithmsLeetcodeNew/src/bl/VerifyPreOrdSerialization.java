package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Akshay Hegde on 10/1/2019.
 * 331. Verify Preorder Serialization of a Binary Tree
 Medium

 571

 34

 Favorite

 Share
 One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

 _9_
 /   \
 3     2
 / \   / \
 4   1  #  6
 / \ / \   / \
 # # # #   # #
 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 Example 1:

 Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Output: true
 Example 2:

 Input: "1,#"
 Output: false
 Example 3:

 Input: "9,#,#,1"
 Output: false

 */
public class VerifyPreOrdSerialization {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")){
            return true;
        }
        int prev = preorder.length();
        StringTokenizer tokenizer  = new StringTokenizer(preorder,",");
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreElements()){
            String token = tokenizer.nextToken();
            if(!token.equals("#")){
                token = "X";
            }
            tokens.add(token);
        }
        StringBuilder builder = new StringBuilder();
        for (String token : tokens) {
            builder.append(token);
        }
        preorder = builder.toString();
        while (true){
            StringBuilder st = new StringBuilder();
            for (int i = 0; i <preorder.length(); i++) {
                if(getChar(preorder,i)=='#'){
                    return false;
                }
                if(getChar(preorder,i+1)=='#'){
                    if(getChar(preorder,i+2)=='#'){
                       st.append('#');
                       st.append(preorder.substring(i+3));
                       break;
                    }
                    else{
                        st.append(getChar(preorder,i));
                        st.append(getChar(preorder,i+1));
                        i++;

                    }
                }
                else{
                   st.append(getChar(preorder,i));
                }
            }
            if(st.length()==prev){
                return false;
            }
            prev = st.length();
            preorder = st.toString();
            if(preorder.equals("#")){
                return true;
            }
        }
    }

    private char getChar(String st, int i){
        if(i>st.length()-1){
            return ' ';
        }
        return st.charAt(i);
    }
}
