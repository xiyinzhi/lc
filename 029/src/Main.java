public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.divide(-2147483648, -1));
    }


    // overflow 爆炸！！！！！！！！！！
    // binary search
    // Time:O(log|dividend|) Space:0(1)
    // 总结：若有overflow问题，不如全转换成long，但依旧需要注意绝对值，正负等问题
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        // when using ^(XOR), remember to add ()
        if ((dividend < 0) ^ (divisor < 0)) {
            isNegative = true;
        }
        // when converting int to long, be careful about Math.abs or so.
        long dend = dividend >= 0 ? dividend : -(long) dividend;
        long dsor = divisor >= 0 ? divisor : -(long) divisor;
        if (dend == dsor) {
            if (isNegative) {
                return -1;
            } else {
                return 1;
            }
        } else if (dend < dsor) {
            return 0;
        } else {
            long low = 1;
            long high = dend;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                if (mid * dsor == dend || mid * dsor < dend && (mid + 1) * dsor > dend) {
                    if (isNegative) {
                        mid *= -1;
                    }
                    if (mid > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    return (int) mid;
                } else if (mid * dsor < dend) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
