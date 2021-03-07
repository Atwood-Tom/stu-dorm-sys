package util;

public class ThreadLocalHolder {
    private static final ThreadLocal<Integer> COUNT=new ThreadLocal<>();

    public static ThreadLocal<Integer> getThreadLocal(){
        return COUNT;
    }
}
