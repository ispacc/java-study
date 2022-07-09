public class Test {
    public static void main(String[] args) {
        int[] arr = new int[43];

        int cnt = 41;
        int flag = 1;
        while (cnt != 2) {
            for (int i = 1; i < arr.length; i++) {
                flag = flag % 3;
                if (arr[i] == 1) {
                    i++;
                    flag += 1;
                }
                if (flag == 3) {

                }
            }
        }
    }
}
