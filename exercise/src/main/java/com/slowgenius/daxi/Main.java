package com.slowgenius.daxi;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author slowgenius
 * @date 2/18/2020 2:12 PM
 * @description
 */
public class Main {

    //第一题
    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {
                //如果前一位的第二个元素小于后一位的第一个元素则把前一位数组添加进去
                result.add(intervals[i]);
            } else {
                //如果前一位的第二个元素大于后一位的第一个元素,则吧result中最后一位的数组中第二个元素改掉
                int[] temp = result.getLast();
                temp[1] = intervals[i][1];
                result.set(result.size() - 1, temp);
            }
        }
        int[][] a = {{}};
        return result.toArray(a);
    }


    //第二题
    public static boolean valid(String word, String abbr) {
        //下标,用户记录验证进度和最后一步验证长度
        int mark = 0;
        //截取连续的数字或字符串
        Pattern p = Pattern.compile("(\\d+|[a-zA-Z]*)");
        Matcher m = p.matcher(abbr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("\\d+")) {
                //如果是数字则直接跳过
                mark += Integer.parseInt(temp);
            } else {
                //防止数组越界
                if (mark + temp.length() > word.length()) {
                    return false;
                }
                //比对字符串是否相同
                if (!temp.equals(word.substring(mark, mark + temp.length()))) {
                    return false;
                } else {
                    mark += temp.length();
                }
            }
        }
        //防止缩写表达式长度不够
        if (mark != word.length()) {
            return false;
        }
        return true;
    }

    //第三题
    public static int minPath(int n, int[][] edges, int start, int end) {
        //初始化递归数据
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //加入开始节点
        arrayList.add(start);
        map.put("path", arrayList);
        map.put("length", 0);
        map.put("result", 0);
        HashMap<String, Object> result = recursion(map, edges, end, true);

        return (Integer) result.get("result");
    }

    //第三题
    public static HashMap<String, Object> recursion(HashMap<String, Object> map, int[][] edges, int end, boolean first) {
        ArrayList<Integer> pathList = (ArrayList) map.get("path");
        ArrayList finalPathList = null;
        //读取每次的开始节点,开始节点为每次入参中map取出path的最后一位
        int tempStart = pathList.get(pathList.size() - 1);
        //取出上次的总长度和计算结果,因多次用到,所以提出来
        int length = (Integer) map.get("length");
        int result = (Integer) map.get("result");
        //返回结果和长度定义
        int compareLength = Integer.MAX_VALUE;
        int finalResult = -1;
        //for循环寻找下一个节点
        for (int i = 0; i < edges.length; i++) {
            //获取结束节点
            int tempEnd = getEnd(edges[i], tempStart);
            //发现下个节点
            if (tempEnd != 0 && tempEnd != end && pathList.indexOf(tempEnd) == -1) {
                //初始化入参
                HashMap<String, Object> tempMap = new HashMap();
                tempMap.put("result", first ? edges[i][2] : result | edges[i][2]);
                tempMap.put("length", first ? edges[i][2] : length + edges[i][2]);
                ArrayList<Integer> tempList = new ArrayList<>((ArrayList<Integer>) map.get("path"));
                tempList.add(tempEnd);
                tempMap.put("path", tempList);
                //递归
                HashMap<String, Object> tempResult = recursion(tempMap, edges, end, false);
                if ((Integer) tempResult.get("length") != Integer.MAX_VALUE) {
                    finalResult = Integer.compare(compareLength, (Integer) tempResult.get("length")) == -1 ? finalResult : (Integer) tempResult.get("result");
                    compareLength = Integer.min(compareLength, (Integer) tempResult.get("length"));
                }
            }
            if (tempEnd != 0 && tempEnd == end) {
                int tempResult = edges[i][2];
                finalResult = Integer.compare(compareLength, first ? edges[i][2] : length + tempResult) == -1 ? finalResult : result | tempResult;
                compareLength = Integer.min(first ? edges[i][2] : length + tempResult,compareLength);

            }
        }
        //创建返回数据结构
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("result", compareLength ==  Integer.MAX_VALUE ? -1 : finalResult);
        returnMap.put("length", compareLength);
        return returnMap;
    }

    //获取结束节点
    public static int getEnd(int[] arr, int start) {
        int tempEnd = 0;
        if (arr[0] == start) {
            tempEnd = arr[1];
        }
        if (arr[1] == start) {
            tempEnd = arr[0];
        }
        return tempEnd;
    }

    //用于打印第一题的数组
    public static void printArray(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            } else {
                System.out.print(",[");
            }
            for (int j = 0; j < array[i].length - 1; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.print(array[i][array[i].length - 1] + "]");
        }
        System.out.print("]");
        System.out.println();

    }

    public static void main(String[] args) {
         //第一题用例
        int[][] interval1 = {{1, 3}, {4, 5}, {6, 8}};
        int[][] interval2 = {{1, 3}, {3, 5}, {5, 7}};
        int[][] interval3 = {{1, 3}, {2, 5}, {6, 7}};
        printArray(merge(interval3));

//        //第二题用例
//        String word1 = "internationalization";
//        String abbr1 = "i12iz4n";
//        String word2 = "slowgenius";
//        String abbr2 = "sl2g2iu3";
//        System.out.println(valid(word1, abbr1));
//        System.out.println(valid(word2, abbr2));

//        //第三题用例
//        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 2}, {3, 4, 100}, {5, 6, 2}, {4, 5, 1}, {1, 5, 2}, {2,4, 10}};
//        int[][] edges1 = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}, {4, 5, 200}, {3, 4, 5}};
//        System.out.println(minPath(3, edges, 1, 3));
    }
}
