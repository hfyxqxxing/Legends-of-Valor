/*
 * Wrapper of color output
 */

package legendsofvalor.utils;

public class ColorPrint {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BRIGHT_GREEN_BACKGROUND = "\033[0;102m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String Nexuspanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_BLUE_BACKGROUND+ANSI_BLACK+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_BLUE_BACKGROUND+ANSI_BLACK+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_BLUE_BACKGROUND+ANSI_BLACK+" H "+ANSI_RESET;
        } else {
            return ANSI_BLUE_BACKGROUND+"   "+ANSI_RESET;
        }
    }

    public static String Bushpanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_GREEN_BACKGROUND+ANSI_BLACK+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_GREEN_BACKGROUND+ANSI_BLACK+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_GREEN_BACKGROUND+ANSI_BLACK+" H "+ANSI_RESET;
        } else {
            return ANSI_GREEN_BACKGROUND+"   "+ANSI_RESET;
        }
    }

    public static String Plainpanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_BRIGHT_GREEN_BACKGROUND+ANSI_BLACK+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_BRIGHT_GREEN_BACKGROUND+ANSI_BLACK+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_BRIGHT_GREEN_BACKGROUND+ANSI_BLACK+" H "+ANSI_RESET;
        } else {
            return ANSI_BRIGHT_GREEN_BACKGROUND+"   "+ANSI_RESET;
        }
    }

    public static String Cavepanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_YELLOW_BACKGROUND+ANSI_BLACK+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_YELLOW_BACKGROUND+ANSI_BLACK+" H "+ANSI_RESET;
        } else {
            return ANSI_YELLOW_BACKGROUND+"   "+ANSI_RESET;
        }
    }

    public static String Kouloupanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_RED_BACKGROUND+ANSI_BLACK+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_RED_BACKGROUND+ANSI_BLACK+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_RED_BACKGROUND+ANSI_BLACK+" H "+ANSI_RESET;
        } else {
            return ANSI_RED_BACKGROUND+"   "+ANSI_RESET;
        }
    }

    public static String Wallpanel(boolean hashero,boolean hasmonster){
        if (hashero && hasmonster){
            return ANSI_BLACK_BACKGROUND+ANSI_WHITE+"H M"+ANSI_RESET;
        } else if (hasmonster) {
            return ANSI_BLACK_BACKGROUND+ANSI_WHITE+" M "+ANSI_RESET;
        } else if (hashero) {
            return ANSI_BLACK_BACKGROUND+ANSI_WHITE+" H "+ANSI_RESET;
        } else {
            return ANSI_BLACK_BACKGROUND+"   "+ANSI_RESET;
        }
    }


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

