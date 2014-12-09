/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GlacioSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Diego
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket client = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        
        System.out.println("Bem vindo ao Glaucio Network - UDP\n");
        String dados = "";
        while(!dados.equals("0")){
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            
            //Purpurina
            System.out.print("-> ");
            dados = userInput.readLine();
            sendData = dados.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9876);
            client.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println(modifiedSentence);
        }
        client.close();
        
    }
    
}
