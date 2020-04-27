package algorithm.offer;

/**
 * @author ltw
 * on 2020-02-07.
 */
public class LeastSquares {

//    y = a x + b b = sum( y ) / n - a * sum( x ) / n a = ( n * sum( xy ) - sum( x
// * ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )

    //y 房屋价格

    public static float estimate(float[] x, float[] y, float input) {
        float a = getA(x, y);
        float b = getB(x, y);
        System.out.println("线性回归系数a值：\t" + a + "\n" + "线性回归系数b值：\t" + b);
        return (a * input + b);
    }

    public static float getA(float[] x, float[] y) {
        int n = x.length;
        return (float) ((n * pSum(x, y) - sum(x) * sum(y)) / (n * sqSum(x) - Math
                .pow(sum(x), 2)));
    }

    /*
     * 杜航 功能：返回常量系数系数b 公式：b = sum( y ) / n - a sum( x ) / n
     */
    public static float getB(float[] x, float[] y) {
        int n = x.length;
        float a = getA(x, y);
        return sum(y) / n - a * sum(x) / n;
    }

    /*
     * 杜航 功能：求和
     */
    private static float sum(float[] ds) {
        float s = 0;
        for (float d : ds) {
            s = s + d;
        }
        return s;
    }

    /*
     * 杜航 功能：求平方和
     */
    private static float sqSum(float[] ds) {
        float s = 0;
        for (float d : ds) {
            s = (float) (s + Math.pow(d, 2));
        }
        return s;
    }

    /*
     * 杜航 功能：返回对应项相乘后的和
     */
    private static float pSum(float[] x, float[] y) {
        float s = 0;
        for (int i = 0; i < x.length; i++) {
            s = s + x[i] * y[i];
        }
        return s;
    }

    /*
     * 杜航 功能：main()测试线性回归的最小二乘法java实现函数
     */
    public static void main(String[] args) {
        float[] x =
                {205, 325, 445, 505, 625};
        float[] y =
                {41000, 62000, 53000, 29500, 55600, 65000, 60400};
        System.out.println("经线性回归后的y值：\t" + estimate(x, y, 240));
    }
}
