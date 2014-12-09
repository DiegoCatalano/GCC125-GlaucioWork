/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GlacioSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Diego
 */
public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor do Glaucio Network - TCP\n");
        
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket server = serverSocket.accept();
        
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        
        String dados = "";
        while(!dados.equals("0")){
            
            dados = in.readUTF();
            System.out.println("Recebido do IP: " + server.getInetAddress().getHostAddress() + "  -> " + dados);
            
            double result = MathExpression.Evaluation(dados);
            
            //String r = String.valueOf(result);
            out.writeDouble(result);
            
            
        }
        server.close();
        
        
    }
    
}
