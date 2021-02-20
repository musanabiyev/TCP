package tcpserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import util.FileUtility;

/**
 *
 * @author M
 */
public class TCPServer {

    public static void main(String[] args){
        readAsByte();
    }
@SneakyThrows
    public static void readAsString(){
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("yeni socket ucun ve ya basqa sozle desek (yeni musteri) ucun gozleyirem....");

            Socket connection = ourFirstServerSocket.accept();
            System.out.println("urra yeni musteri geldi....");
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);

            BufferedReader bReader = new BufferedReader(reader);
            String messageFromClient = bReader.readLine();
            System.out.println("musteri deyir ki:" + messageFromClient);

        }
    }

    public static void readAsByte() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("yeni socket ucun ve ya basqa sozle desek (yeni musteri) ucun gozleyirem....");

            Socket connection = ourFirstServerSocket.accept();
            System.out.println("urra yeni musteri geldi....");

            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(dataStream);
            System.out.println("message length2=" + arr.length);
            FileUtility.writeBytes("Downloads\imagg.jpg", arr);

        }
    }

    public static byte[] readMeassage(DataInputStream din) throws IOException {
        int msgLen = din.readInt();
        System.out.println("message length=" + msgLen);
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }
}
