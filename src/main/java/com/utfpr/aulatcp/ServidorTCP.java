/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulatcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aluno
 */
public class ServidorTCP {
    public static void main(String[] args) throws IOException {
       //Para iniciar um servidor, esse servidor precisa ter uma porta
       //para que ele possa ficar ouvindo as solicitações do cliente
       ServerSocket servidor = new ServerSocket(8081); 
       System.out.println("Servidor rodando na porta 8081");
       
       //Fica no aguardo de alguma solicitação do lado do cliente
       Socket socket = servidor.accept(); 
       
       //Imprime o IP e a Porta do cliente
       System.out.println("O cliente IP: " + socket.getInetAddress().getHostAddress() + " se conectou!");
        
       //Definir um stream de entrada de dados no servidor
       DataInputStream entrada = new DataInputStream(socket.getInputStream()); 
       
       //Por padrão o próprio Stream(socket) Java serializa as informações
       String mensagem = entrada.readUTF();
       
       //O servidor tem a função de converter a mensagem para maiúscula.
       String novaMensagem = mensagem.toUpperCase();
       
       //Definir um stream de saida para os dados enviados para o cliente. 
       DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
       
       saida.writeUTF(novaMensagem);
       
       //Fecha a comunicação com o cliente
       entrada.close(); 
       saida.close(); 
       
       //Fecha a conexão
       socket.close(); 
       servidor.close();
    }
}
