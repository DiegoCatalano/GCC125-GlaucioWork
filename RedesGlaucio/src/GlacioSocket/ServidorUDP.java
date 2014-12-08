/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GlacioSocket;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Diego
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
         DatagramSocket serverSocket = new DatagramSocket(9876);
         byte[] receiveData = new byte[1024];
         byte[] sendData = new byte[1024];
         
         System.out.println("Servidor do Glaucio Network - UDP\n");
         while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            String[] dados = sentence.split("\\+");
            double result = 0;
            for (int i = 0; i < dados.length; i++) {
                result += Double.parseDouble(dados[i]);
            }
            
            sendData = String.valueOf(result).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
         }
    }
    
}
