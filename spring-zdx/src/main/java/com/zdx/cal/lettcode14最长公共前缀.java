package com.zdx.cal;

/**
 * @author : wangzhicheng
 * @version : 1.0
 * @since : 2022/8/3 15:43
 */
public class lettcode14最长公共前缀 {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"a"}));

	}

	public static String longestCommonPrefix(String[] strs) {

//		int length = 0;
//		while (strs[0] != null && !strs[0].equals("") && strs[0].length() >1 && strs[0].substring(length, length + 1) != null){
//			for (String str : strs) {
//				String substring = strs[0].substring(0, length);
//				if (!str.startsWith(substring)) {
//					return  str.equals("")? "" : strs[0].substring(0, length-1);
//				}
//			}
//			length ++;
//		}
//		return "";
		String maxPrefix = "";
		if (strs[0] == null || strs[0].equals("")) {
			return maxPrefix;
		}
		for (int i = 0; i < strs[0].length(); i++) {
			String substring = strs[0].substring(0, i + 1);
			for (String str : strs) {
				if (!str.startsWith(substring)) {
					return substring.substring(0, i);
				} else {
					maxPrefix = substring;
				}
			}
		}
		return maxPrefix;
	}
}
