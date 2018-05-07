package br.ufs.dcomp.AmatuerRadio;

/**
 * @author Micael Santos Nascimento
 *
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Device_2{
    public static void main(String[] args){
        try {
            System.out.print("[ Conecting TCP Server  ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream input = sock.getInputStream(); //Canal de entrada de dados
            OutputStream output = sock.getOutputStream(); //Canal de saída de dados
            Scanner sc = new Scanner(System.in);
            String msg="oi";
            
            System.out.print("  *******CHAT*******\n");
            while(msg.length() > 0){
                //canal de saida
                msg = sc.nextLine();
                byte[] bufSend = msg.getBytes();
                System.out.print("[ Enviando mensagem    ..............................  ");
                output.write(bufSend); //primitiva send
                System.out.println("[OK] ]");
                
                //canal de entrada
                byte[] bufRead = new byte[30];
                input.read(bufRead); //primitiva receive, operação bloqueante (aguardando chegada de dados)
                String msgToDevice1 = new String(bufRead);
                System.out.println("  Divice_1 say: "+ msgToDevice1);
            }
        } catch(Exception e){
            System.out.println(e);
        }    
        System.out.println("[ FIM ]");
    }
}