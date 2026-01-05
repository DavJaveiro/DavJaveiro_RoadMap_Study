public class example2_1 {
    public static int search(int[] x, int target) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static boolean areDifferent(int[] x, int[] y) {
    for (int i = 0; i < x.length; i++) {
        if (search(y, x[i]) != -1)
            return false;
    }
    return true;
}

    public static boolean areUnique(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (i != j && x[i] == x[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean areUnique2(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for(int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int[] x =  {1, 2, 3, 4, 5};
        // int[] y =  {6, 7, 8, 13, 10};

        // boolean result = areDifferent(x, y);
        // System.out.println("Are the two arrays different? " + result);

        int[] x  = {1, 2, 3, 4, 5, 1};
        int[] y  = {6, 7, 8, 9, 10};
        boolean resultX= areUnique(x);
        System.out.println("Are all elements in the array unique? " + resultX);

        boolean resultY= areUnique(y);
        System.out.println("Are all elements in the array unique? " + resultY);

    }   
}
