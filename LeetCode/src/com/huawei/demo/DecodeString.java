package com.huawei.demo;


public class DecodeString {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        String[] split = s.replace("[", " ").replace("]", " ").split(" ");
        for (int i = 0; i < split.length; i++) {
            if (Character.isDigit(split[i].charAt(0))) {
                //当是数字,则加上 数字 个下一个字符串
                int num = Integer.parseInt(split[i]);
                for (int j = 0; j < num; j++) {
                    result.append(split[i + 1]);
                }
                i++;
            } else {//不是数字,则加一次字符串
                result.append(split[i]);
            }
        }
        return result.toString();
    }
}
