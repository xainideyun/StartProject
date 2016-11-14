package pack17;
import java.io.*;
import java.net.*;
class NetDemo23{
    public static void main(String[] args) throws Exception {
        // URL∂‘œÛΩÈ…‹
        URL url = new URL("http://localhost:8080/User/List?username=sunxsh&age=28");
        System.out.println("getProtocol£∫" + url.getProtocol());
        System.out.println("getHost£∫" + url.getHost());
        System.out.println("getPort£∫" + url.getPort());
        System.out.println("getPath£∫" + url.getPath());
        System.out.println("getFile£∫" + url.getFile());
        System.out.println("getQuery£∫" + url.getQuery());
    }
}
