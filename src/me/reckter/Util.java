package me.reckter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Class containing useful and general functions
 */
public abstract class Util {

    /**
     * a clear way of printing something on the console
     * @param module The module which wants to print something
     * @param title The title of the print ( reason ) [example: "DEBUG"]
     * @param text The text that contains the message of the print
     */
    public static void c_log(String module, String title, String text) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println("[" + time + "][" + module + "][" + title + "]: " + text);

    }

    /**
     * Print a message to the console and to a log. Guess the module and the title from a stack trace
     * @param text The message
     * @see #c_log(String, String, String)
     */
    public static void c_log(String text) {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        String classname = "";
        String methodname = "";
        for(int i = 1; i < trace.length; i++) {
            if(!trace[i].getMethodName().toLowerCase().equals("c_log")) {
                classname = trace[i].getClassName();
                methodname = trace[i].getMethodName();
                break;
            }
        }

        c_log(classname, methodname, text);
    }

    public static double peakRandom(Random rnd) {
        return rnd.nextGaussian() + 1;
    }
}