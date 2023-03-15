/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulatcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Aluno
 */
public class ClienteTCP {
 public static void main(String[] args) throws IOException {
     //Abrir uma conexão via socket 
     Socket socket = new Socket("127.0.0.1", 8081);
     
     //Definir uma Stream de saída de dados
     DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
     
     //Serialização de dados
     saida.writeUTF("Olá servidor");
     
     //Definir um Stream de entrada de dados do servidor
     DataInputStream entrada = new DataInputStream(socket.getInputStream());
     
     //Deserialização de dados
     String novaMensagem = entrada.readUTF(); 
     System.out.println(novaMensagem);
     
     //Fechar Streams de saida e entrada 
     entrada.close();
     saida.close();
     
     //Fechar socket
     socket.close();
 }   
}
