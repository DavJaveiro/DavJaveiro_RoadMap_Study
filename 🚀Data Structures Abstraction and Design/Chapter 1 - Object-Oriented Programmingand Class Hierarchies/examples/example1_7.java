public class example1_7 {
    public static void main(String[] args) {
        Object[] stuff = new Object[10];

        double sum = 0;
        for (int i = 0; i < stuff.length; i++) {
            if (stuff[i] instanceof Number) {
                Number num = (Number) stuff[i];
                sum += num.doubleValue();
            }
        }

        double sum2 = 0;
        for (int x = 0; x < stuff.length; x++) {
            if (stuff[x] instanceof Number n) {
                sum2 += n.doubleValue();
            }
        }

    }
}
