package algorithm.leetCode.hashtable.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个思路是 记录一个flag 如果遍历下来整个字母没有其他行 就返回true
 * @author ltw
 * on 2019-10-16.
 */
public class Solution2 {
    public String[] findWords(String[] words) {

        List<String> str = new ArrayList<String>();
        int p=0;
        List<Character> ch1 = new ArrayList<Character>(Arrays.asList('Q','W','E','R','T','Y','U','I','O','P','q','w','e','r','t','y','u','i','o','p'));
        List<Character> ch2 = new ArrayList<Character>(Arrays.asList('A','S','D','F','G','H','J','K','L','a','s','d','f','g','h','j','k','l'));
        List<Character> ch3 = new ArrayList<Character>(Arrays.asList('Z','X','C','V','B','N','M','z','x','c','v','b','n','m'));
        for(int i=0;i<words.length;i++)
        {
            int flag1=0;
            int flag2=0;
            int flag3=0;
            for(int j=0;j<words[i].length();j++)
            {
                if(ch1.contains(words[i].charAt(j)))
                    flag1=1;
                if(ch2.contains(words[i].charAt(j)))
                    flag2=1;
                if(ch3.contains(words[i].charAt(j)))
                    flag3=1;
            }
            if(flag1+flag2+flag3==1)
                str.add(words[i]);
        }
        String[] strs1=str.toArray(new String[str.size()]);
        return strs1;
    }
}
