package com.leetcode.middle;

import java.util.Stack;

/**
 * @author yanhanf
 * @Description TODO
 * @ClassName SimplifyPath
 * @Date 2021/11/30
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String sep = "/";
        if(path == null || path.length() == 0) {
            return sep;
        }
        String[] paths = path.split(sep);
        Stack<String> s1 = new Stack<>();
        for (String p : paths) {
            if(p.length() > 0 && !".".equals(p)) {
                if("..".equals(p)) {
                    if(!s1.isEmpty()) {
                        s1.pop();
                    }
                } else {
                    s1.push(p);
                }
            }
        }

        Stack<String> s2 = new Stack<>();
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        StringBuilder realPath = new StringBuilder();
        while(!s2.isEmpty()) {
            realPath.append(sep).append(s2.pop());
        }
        if(realPath.length() == 0) {
            realPath.append(sep);
        }
        return realPath.toString();
    }

    public static void main(String[] args) {
        System.out.println("target is /home, test is " + simplifyPath("/home/"));
        System.out.println("target is /, test is " + simplifyPath("/../"));
        System.out.println("target is /home/foo, test is " + simplifyPath("/home//foo/"));
    }
}
