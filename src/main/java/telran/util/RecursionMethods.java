package telran.util;

public class RecursionMethods {
    public static void f(int a) {
        if (a > 3) {
            f(a - 1);
        }
    }

    public static long factorial(int n) {
        if (n < 0) {
            n = -n;
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    /**
     * 
     * @param num - any integer number
     * @param degree - any positive number
     * @return num ^ degree
     * limitations:
     * 1. no cycles allowed
     * 2. arithmetic operators + ; - are allowed only
     * 3. bitwise operators like >>, <<, &&, etc disallowe
     */
    public static long pow(int num, int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        }

        int count = num < 0 ? -num : num;
        long sum = 0;

        if (degree == 0) {
            sum = 1;
        } else if (degree == 1) {
            sum = num;
        } else {
            sum = powDegree(num, count, degree - 1);
        }

        if (num < 0) {
            sum = getSign(-sum, degree);
        }

        return sum;
    }

    private static long getSign(long number, int degree) {
        return degree == 1 ? -number : getSign(-number, degree - 1);
    }

    private static long powDegree(int num, int count, int degree) {
        int sum = 0;
        long res = 0;

        sum = powSum(num, count);

        if (degree == 1) {
            res = sum;
        } else {
            res = powDegree(sum, count, degree - 1);
        }

        return res;
    }

    private static int powSum(int num, int count) {
        return count == 0 ? 0 : num + powSum(num, count - 1);
    }

    public static int sum(int[] array) {      
        return sum(array, array.length);
    }

    private static int sum(int[] array, int length) {
        return length == 0 ? 0 : array[length - 1] + sum(array, length - 1);
    }

    /**
     * 
     * @param x
     * @return x ^ 2
     * limitations:
     * 1. no cycles
     * 2. arithmetic operators only +, - 
     * 3. no bitwise operators
     * 4. no standart and additional methods are allowed
     * 5. no additional fielsd ot the class RecursionMethods are allowed
     */
    public static int square(int x) {
        x = x < 0 ? -x : x;
        return powSum(x, x);
    }

    /**
     * 
     * @param string
     * @param subString
     * @return true if subString is actually substring of the given string
     * limitations:
     * 1. no cycles
     * 2. the allowed methods of class String are
     *      2.1. charAt(int index)
     *      2.2. length()
     *      2.3. subString(int beginIndex)
     */
    public static boolean isSubstring(String string, String subString) {
        if (string.length() == 0 || subString.length() == 0) {
            return false;
        }

        int index = 0;
        int subIndex = 0;
        return stringIncludeSubString(string, subString, index, subIndex);
    }

    private static boolean stringIncludeSubString(String string, String subString, int index, int subIndex) {
        boolean res = false;
        if (subIndex == subString.length() - 1) {
            res = true;
        } else if (index == string.length() - 1) {
            res = false;
        } else if (string.charAt(index) == subString.charAt(subIndex)) {
            res = stringIncludeSubString(string, subString, index + 1, subIndex + 1);
        } else {
            res = stringIncludeSubString(string, subString, index + 1, 0);
        }
        return res;
    }
}
