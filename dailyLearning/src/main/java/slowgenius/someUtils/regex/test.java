package slowgenius.someUtils.regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author slowgenius
 * @date 1/6/2020 11:38 AM
 * @description
 */
public class test {
    public static void main(String[] args) {
        String str = "申请人：笨天才 男 ferfo reger";
        String regex = "(?<=申请人：)[^\\s]*";
        System.out.println(pattern(regex, str).get(0));

    }

    public static ArrayList<String> pattern(String regex, String str) {
        ArrayList<String> result = new ArrayList();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String temp = matcher.group();
            result.add(temp);
        }
        return result;
    }
}
