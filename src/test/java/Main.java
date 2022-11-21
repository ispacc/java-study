import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);

        var files = new File(".").listFiles(File::isHidden);
        
    }
}
