import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 1, 4, 5,5,5,};
        int[] b = {3, 6, 1, 3, 2, 4};

        Arrays.stream(a).distinct().sorted().forEach(System.out::print);

    }
}
