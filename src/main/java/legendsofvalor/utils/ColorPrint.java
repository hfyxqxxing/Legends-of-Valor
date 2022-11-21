/*
 * Wrapper of color output
 */

package legendsofvalor.utils;

public class ColorPrint {
    public static String redString(String str) {
        return "\033[31m" + str + "\033[0m";
    }

    public static String greenString(String str) {
        return "\033[32m" + str + "\033[0m";
    }

    public static String yellowString(String str) {
        return "\033[33m" + str + "\033[0m";
    }


    public static void red(String str) {
        System.out.println(redString(str));
    }

    public static void green(String str) {
        System.out.println(greenString(str));
    }

    public static void yellow(String str) {
        System.out.println(yellowString(str));
    }

    public static void query(String str) {
        yellow("[?] " + str);
    }

    public static void error(String str) {
        red("[!] " + str);
    }

    public static void info(String str) {
        green("[*] " + str);
    }

    public static void debug(String str) {
        System.out.println("[DEBUG] " + str);
    }

    public static void plain(String str) {
        System.out.println(str);
    }
}

