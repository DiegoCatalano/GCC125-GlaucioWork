/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GlacioSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Diego
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("127.0.0.1",12345);
        System.out.println("Bem vindo ao Glaucio Network - TCP\n");
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String dados = "";
        while(!dados.equals("0")){
            
            //Purpurina
            System.out.print("-> ");
            
            //Escreve para o servidor
            dados = userInput.readLine();
            out.writeUTF(dados);
            
            //Obtem resposta do servidor
            double resposta = in.readDouble();
            System.out.println(resposta);
            
        }
        socket.close();
        
    }
    
}
