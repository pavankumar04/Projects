package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStreamReader;

//import java.util.Scanner;

public class ReadWriteClass {

    public void readFile() {
//      Scanner sc = new Scanner(System.in);
//      
//      String str = sc.next();
//      int i = sc.nextInt();
//      
//      System.out.println(str + " " + i);
//      sc.close();
        
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      
//      try {
//          String str = br.readLine();
//          System.out.println(str);
//      } catch (IOException e) {
//          System.out.println(e.getMessage());
//      }
        
        String path = "E:\\training\\hexaware\\Java Technology\\8Sep-12Oct(JT)\\workspace\\test.txt";
        
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            String str = br.readLine();
            
            System.out.println(str);
            
            br.close();
            fr.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void writeByte() {
        String path = "E:\\training\\hexaware\\Java Technology\\8Sep-12Oct(JT)\\workspace\\first.txt";
        
        try {
            FileOutputStream fOut = new FileOutputStream(path);
            
            BufferedOutputStream buffer = new BufferedOutputStream(fOut);
            
            String data = "This is the data to write";
            
            byte[] array = data.getBytes();
            
            buffer.write(array);
            
            buffer.close();
            fOut.close();
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void readByte() {
        String path = "E:\\training\\hexaware\\Java Technology\\8Sep-12Oct(JT)\\workspace\\first.txt";
        
        try {
            FileInputStream fIn = new FileInputStream(path);
            BufferedInputStream buffer = new BufferedInputStream(fIn);
            
            int i = buffer.read();
            
            while(i != -1) {
                System.out.print((char) i);
                i = buffer.read();
            }
            buffer.close();
            
            fIn.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void writeFile() {
        String path = "E:\\training\\hexaware\\Java Technology\\8Sep-12Oct(JT)\\workspace\\test.txt";
        
        try {
            FileWriter fw = new FileWriter(path);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            String data = "This is the content to write into a file.";
            bw.write(data);
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}