package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/27/2019.
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 Example:

 Input: "25525511135"
 Output: ["255.255.11.135", "255.255.111.35"]

 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return res;
        }
        recursion(s,1,res,"");
        return res;

    }

    private void recursion(String s, int index, List<String> res,String ipPart) {
        if (index == 4) {
            if ((s.length() > 3 || s.length() < 1)) {
                return;
            }
            if(validateID(s)) {
                ipPart = ipPart + s;
                res.add(ipPart);
            }
            return;
        }
        if (s.length() == 0) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(s.length()<i+1){
                return;
            }
            if(index==1){
                ipPart = "";
            }
            String forNext = s.substring(i + 1);
            String ip = s.substring(0, i + 1);
            if(!validateID(ip)){
                continue;
            }
            String newIPPart = ipPart + ip+".";
            recursion(forNext, index + 1, res,newIPPart);
        }
    }

    private boolean validateID(String s) {
        int val = 0;
        int mul = 1;
        for (int i = s.length() - 1; i > -1; i--) {
            val = (s.charAt(i) - 48) * mul + val;
            mul *= 10;
        }
        return !((s.length() == 3 && val < 100) || (s.length() == 2 && val < 10)) && val <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }
}
