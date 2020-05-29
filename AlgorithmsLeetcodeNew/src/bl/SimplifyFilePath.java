package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/20/2019.
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

 In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

 Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory station (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



 Example 1:

 Input: "/home/"
 Output: "/home"
 Explanation: Note that there is no trailing slash after the last directory station.
 Example 2:

 Input: "/../"
 Output: "/"
 Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 Example 3:

 Input: "/home//foo/"
 Output: "/home/foo"
 Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 Example 4:

 Input: "/a/./b/../../c/"
 Output: "/c"
 Example 5:

 Input: "/a/../../b/../c//.//"
 Output: "/c"
 Example 6:

 Input: "/a//b////c/d//././/.."
 Output: "/a/b/c"
 */
public class SimplifyFilePath {
    public String simplifyPath(String path) {
        List<String> tokens = new ArrayList<>();
        boolean start = true;
        StringBuilder token = new StringBuilder();
        for (int i = 1; i < path.length(); i++) {
            if(path.charAt(i)=='/'){
                if(start) {
                    start = false;
                    if (token.length() > 0) {
                        tokens.add(token.toString());
                        token = new StringBuilder();
                    }
                }
            }
            else{
                if(!start){
                    start = true;
                }
                token.append(path.charAt(i));
            }
        }
        if(token.length()>0){
            tokens.add(token.toString());
        }
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for(String tok : tokens){
            if(tok.equals(".")){
                continue;
            }
            if(tok.equals("")) {
                if(stack.size() > 1){
                    stack.pop();
                }
            }
            else{
                stack.push(tok);
            }
        }
        tokens.clear();
        for (; !stack.isEmpty(); ) {
            tokens.add(0,stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        for(String tok : tokens){
            if(!tok.equals("/")) {
                builder.append(tok).append("/");
            }
        }
        if(builder.length()==1){
            return String.valueOf(builder);
        }

        return builder.substring(0,builder.length()-1);

    }

    public static void main(String[] args) {
        System.out.println(new SimplifyFilePath().simplifyPath("/home/"));
    }
}
