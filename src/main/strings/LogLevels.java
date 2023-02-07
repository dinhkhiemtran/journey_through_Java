package main.strings;

import static java.lang.String.format;

public class LogLevels {
    private final static String INFO_PREFIX = "[INFO]:";
    private final static String WARNING_PREFIX = "[WARNING]:";
    private final static String ERROR_PREFIX = "[ERROR]:";

    private final static String test1 = "[ERROR]: Invalid operation";
    private final static String test2 = "[WARNING]:  Disk almost full\r\n";


    public static String messageSolution1(String logLine) {
        String handleLogLine = "";
        if (logLine.contains(INFO_PREFIX)) {
            handleLogLine = logLine.replace(INFO_PREFIX, "").trim();
        } else if (logLine.contains(WARNING_PREFIX)) {
            handleLogLine = logLine.replace(WARNING_PREFIX, "").trim();
        } else if (logLine.contains(ERROR_PREFIX)) {
            handleLogLine = logLine.replace(ERROR_PREFIX, "").trim();
        }
        return handleLogLine;
    }

    public static String messageSolution2(String logLine) {
        int indexOfColon = logLine.indexOf(":");
        return logLine.substring(indexOfColon + 1).trim();
    }

    public static String logLevelSolution1(String logLine) {
        if (logLine.contains(INFO_PREFIX)) {
            return "info";
        } else if (logLine.contains(WARNING_PREFIX)) {
            return "warning";
        } else if (logLine.contains(ERROR_PREFIX)) {
            return "error";
        }
        return "";
    }

    public static String logLevelSolution2(String logLine) {
        int indexOfStart = 1;
        int indexOfColon = logLine.indexOf(":");
        return logLine.substring(indexOfStart, indexOfColon - 1).toLowerCase().trim();
    }

    public static String reformatSolution1(String logLine) {
        if (logLine.contains(INFO_PREFIX)) {
            return logLine.replace(INFO_PREFIX, "").trim() + " (info)";
        } else if (logLine.contains(WARNING_PREFIX)) {
            return logLine.replace(WARNING_PREFIX, "").trim() + " (warn)";
        } else if (logLine.contains(ERROR_PREFIX)) {
            return logLine.replace(ERROR_PREFIX, "").trim() + " (error)";
        }
        return "";
    }

    public static String reformatSolution2(String logLine) {
        return messageSolution2(logLine) + " " + "(" + logLevelSolution2(logLine) + ")";
    }

    public static String messageSolution3(String logLine) {
        return logLine.split("]: ")[1].trim();
    }

    public static String logLevelSolution3(String logLine) {
        return logLine.split(("]: "))[0].substring(1).toLowerCase().trim();
    }

    public static String reformatSolution3(String logLine) {
        return format("%s (%s)", messageSolution3(logLine), logLevelSolution3(logLine));
    }

    public void solution1() {
        System.out.println(messageSolution1(test1));
        System.out.println(messageSolution1(test2));
        System.out.println(logLevelSolution1(test1));
        System.out.println(logLevelSolution1(test2));
        System.out.println(reformatSolution1("[INFO]: Operation completed"));
    }


    public void solution2() {
        System.out.println(messageSolution2(test1));
        System.out.println(messageSolution2(test2));
        System.out.println(logLevelSolution2(test1));
        System.out.println(logLevelSolution2(test2));
        System.out.println(reformatSolution2("[INFO]: Operation completed"));
    }

    public void solution3() {
        System.out.println(messageSolution3(test1));
        System.out.println(messageSolution3(test2));
        System.out.println(logLevelSolution3(test1));
        System.out.println(logLevelSolution3(test2));
        System.out.println(reformatSolution3("[INFO]: Operation completed"));
    }

    public static void main(String[] args) {
        LogLevels logLevels = new LogLevels();
        System.out.println("Solution 1->");
        logLevels.solution1();
        System.out.println("Solution 2->");
        logLevels.solution2();
        System.out.println("Solution 3->");
        logLevels.solution3();
    }
}
