package netty;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ByteBufferDemo {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            var x = 19;
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            while (true){
                int len = channel.read(byteBuffer);
                if (len == -1) {
                    break;
                }
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    System.out.println((char) b);
                }
                byteBuffer.clear();
            }
        } catch (IOException e) {
        }
    }
}
