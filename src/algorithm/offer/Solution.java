//package algorithm.offer;
//
///**
// * @author ltw
// * on 2020-02-07.
// */
//public class Solution
//{
//
//    public static float calculate(float[] x, float[] y, float input)
//    {
//        float a = getA(x, y);
//        float b = getB(x, y);
//        System.out.println("线性回归系数a值：\t" + a + "\n" + "线性回归系数b值：\t" + b);
//        return (a * input + b);
//    }
//
//    public static float getA(float[] x, float[] y)
//    {
//        int n = x.length;
//        return (float) ((n * pSum(x, y) - sum(x) * sum(y)) / (n * sqSum(x) - Math
//                .pow(sum(x), 2)));
//    }
//
//    public static float getB(float[] x, float[] y)
//    {
//        int n = x.length;
//        float a = getA(x, y);
//        return sum(y) / n - a * sum(x) / n;
//    }
//
//    private static float sum(float[] ds)
//    {
//        float s = 0;
//        for (float d : ds)
//        {
//            s = s + d;
//        }
//        return s;
//    }
//
//    private static float sqSum(float[] ds)
//    {
//        float s = 0;
//        for (float d : ds)
//        {
//            s = (float) (s + Math.pow(d, 2));
//        }
//        return s;
//    }
//
//    private static float pSum(float[] x, float[] y)
//    {
//        float s = 0;
//        for (int i = 0; i < x.length; i++)
//        {
//            s = s + x[i] * y[i];
//        }
//        return s;
//    }
//
//    public static void main(String[] args)
//    {
//        float[] x =
////		{ 540, 360, 240, 480, 420 };
//                { 205, 325, 445, 505, 625 };
//        float[] y =
////		{  520, 475, 430, 386, 500 };
//                { 100, 123, 148, 407, 319, 301 };
//        System.out.println("经线性回归后的y值：\t" + estimate(x, y,240));
//    }
//}
