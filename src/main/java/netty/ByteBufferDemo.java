package netty;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferDemo {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            channel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                System.out.println((char) b);
            }
        } catch (IOException e) {
        }
    }
}
