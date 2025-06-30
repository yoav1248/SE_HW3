public class Utils {
    public static final String STAR = " * ";
    public static final String SPACE = "   ";

    public static double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public static int max(int x, int y) {
        return y > x ? y : x;
    }
}
