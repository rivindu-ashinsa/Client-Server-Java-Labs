/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_based_practical_mock_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost"; 
        Integer port = 7000; 
        BufferedReader in = null; 
        PrintWriter out = null; 
        
        
        try(Socket clientSocket = new Socket(serverAddress, port)){
            System.out.println("client connected to the server: " + port);
            
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            Scanner scanner = new Scanner(System.in); 
            
            while(true) {
                System.out.print("You: ");
                String message = scanner.nextLine(); 
                
                out.println(message);
                
                String response = in.readLine();
                System.out.println(response);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            if (in != null){
                in.close();
            }
            if (out != null){
                out.close(); 
            }
        }
    }
    
}
