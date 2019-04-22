//Dhruv Hooda//


package project;

import java.io.*;
import java.util.Scanner;



class Login implements Serializable {
    
     String email, number,  username,  password;
        
        void createAccount() throws IOException{
            
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter your email : ");       
        email = scan.nextLine();
        
       /* Login mail = new Login();
        Login usern = new Login();
        Login pass = new Login();
        Login num = new Login();
        */
        
        System.out.println("Please enter your username : ");       
        username = scan.nextLine();
        
        System.out.println("Please enter your number");       
        number = scan.nextLine();
        
        System.out.println("Please enter your password (at least 5 characters) : ");       
        password = scan.nextLine();
        
        
        
        FileOutputStream outStream = new FileOutputStream("Userinfo.dat");
        ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
        objectOuputFile.writeObject(username);
        objectOutputFile.writeObject(password);
        objectOutputFile.writeObject(email);
        objectOutputFile.writeObject(number);
        
        objectOutputStream.close();
        
        
        
        
       /* BufferedWriter in = new BufferedWriter(new FileWriter("Userinfo.txt", true));
        in.write(username + " "  + password + " " + email + " " + number);
        in.newLine();
        in.close();
        */
        
        
        }    

        
        void logIn() throws FileNotFoundException {
            
            String user, pass ; 
            
        Scanner scan = new Scanner(System.in); 
        System.out.println("Please enter your username : ");
        user = scan.nextLine();
        
        System.out.println("Please enter your password : ");
        pass = scan.nextLine();
        
        File text = new File("Userinfo.txt");
        
        Scanner s = new Scanner (text);

        while(s.hasNextLine()){
            String line = s.nextLine();
            int contents1[][] = new int[1][3];
            
            String content[] = line.split(" ");
            //String username[]= content[0];
            System.out.println(content[1]);
            //System.out.println(content[1]);
            
            if(content[0] == user && content[1] == pass){
                System.out.println("Found");
                break;
            }
        }
        
        
            
        }
        
        
    
    
}




public class Project {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Login l = new Login();
       // l.createAccount();
        l.logIn();
        
    }
    
}
