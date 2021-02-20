/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import util.FileUtility;

/**
 *
 * @author M
 */
public class TSPClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("ip address", 6789);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        
        byte[] bytes = FileUtility.readBytes("Downloads\imagegg.jpg");
        dataOutputSream.writeInt(bytes.length);
         dataOutputSream.writeInt(bytes);
        outputStream.write(bytes);
        socket.close();
    }
}
