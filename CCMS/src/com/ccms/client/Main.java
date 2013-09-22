/**
 * 
 */
package com.ccms.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ccms.UI.Login;

/**
 * @author magic282
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(new File("clientConf.ini"));
			String serverAdd;
			String string = in.nextLine();
			String[] tmp = string.split(" = ");
			serverAdd = tmp[1];
			in.next();
			in.next();
			int port = in.nextInt();
			if(Client.init(serverAdd, port)){
				
				if(!Client.isConnectedToServer()){
					System.out.println("Cannot connect the server!");
					
					System.exit(-1);
				}
				System.out.println("system initialized successfully!");
				
				Login.main(null);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot read the configure file !");
		}
	}

}
