package bl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

 Please note that both secret number and friend's guess may contain duplicate digits.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if(map.containsKey(secret.charAt(i))){
                int count = map.get(secret.charAt(i));
                count++;
                map.put(secret.charAt(i),count);
            }
            else {
                map.put(secret.charAt(i), 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                if(map.containsKey(secret.charAt(i))) {
                    int count = map.get(guess.charAt(i));
                    count--;
                    if (count == 0) {
                        map.remove(guess.charAt(i));
                    } else {
                        map.put(secret.charAt(i), count);
                    }
                }
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            if (map.containsKey(guess.charAt(i))) {
                int count = map.get(guess.charAt(i));
                count--;
                if (count == 0) {
                    map.remove(guess.charAt(i));
                } else {
                    map.put(guess.charAt(i), count);
                }
                cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
