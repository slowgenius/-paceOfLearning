package com.slowgenius.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author slowgenius
 * @date 2/8/2020 2:06 PM
 * @description
 */
public class Lisp {

    /**
     * 支持(add 1 2 (sub 1 3))这样的运算共有add sub mul div 四种运算 都是整数 除数为0则直接error
     * */
    public static String calculator(List<Integer> params,String type){
        String result = "";
        if ("add".equals(type)) {
            result = add(params);
        }
        if ("sub".equals(type)) {
            result = sub(params);
        }
        if ("mul".equals(type)) {
            result = mul(params);
        }
        if ("div".equals(type)) {
            result = div(params);

        }
        return result;
    }

    public static String add(List<Integer> param) {
        Integer result = param.get(0);
        for (int i = 1; i < param.size(); i++) {
            result += param.get(i);
        }
        return result.toString();
    }
    public static String sub(List<Integer> param) {
        Integer result = param.get(0);
        for (int i = 1; i < param.size(); i++) {
            result -= param.get(i);
        }
        return result.toString();
    }
    public static String mul(List<Integer> param) {
        Integer result = param.get(0);
        for (int i = 1; i < param.size(); i++) {
            result *= param.get(i);
        }
        return result.toString();
    }

    public static String div(List<Integer> param) {
        Integer result = param.get(0);
        boolean zeroMark = false;
        for (int i = 1; i < param.size(); i++) {
            if (param.get(i) == 0) {
                zeroMark = true;
                break;
            }
            result /= param.get(i);
        }
        return zeroMark ? "error" : result.toString();
    }

    public static List<Integer> getParams(String str) {
        Pattern pattern = Pattern.compile("\\s-?\\d*");
        Matcher matcher = pattern.matcher(str);
        ArrayList<Integer> params = new ArrayList<>();
        while (matcher.find()) {
            params.add(Integer.parseInt(matcher.group().trim()));
        }
        return params;
    }

    public static String getType(String exp){
        Pattern pattern = Pattern.compile("(?<=\\()[\\w]*");
        Matcher matcher = pattern.matcher(exp);
        String type = "";
        while (matcher.find()) {
            type = matcher.group();
        }
        return type;
    }

    public static String parseStr(String str) {
        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher = pattern.matcher(str);
        boolean mark = false;
        while (matcher.find()) {
            mark = true;
            String temp = matcher.group();
            String tempResult = calculator(getParams(temp), getType(temp));
            if ("error".equals(tempResult)) {
                return "error";
            }
            str = str.replace(temp, tempResult);
        }
        if (mark) {
            return parseStr(str);
        } else {
            return str;
        }
    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
       // System.out.println(calculator(getParams(str), getType(str)));
        String test = "(add 1 (sub 3 2) (mul 4 5) (div 6 3))";
        System.out.println(parseStr(test));
    }
}
