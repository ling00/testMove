package wifi;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
/*
 * @author: lingyun
 * @date:23/9/2015
 */
public class runClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		WifiClient wifi=new WifiClient(1234);
		Scanner in = new Scanner(System.in);
		//String command;
		String startCommand="BA<";
		String msg=wifi.getMessageFromRpi();
		
		while (msg==null||!msg.contains(":")){
			msg=wifi.getMessageFromRpi();
		}
		wifi.sendMessageToRpi("BA<S");	
		//String[] words=msg.split(":");		
		while(true){
			System.out.println("Enter command to send: ");
			String command = in.nextLine();	
			wifi.sendMessageToRpi(startCommand+command);
			wifi.getMessageFromRpi();	
		}
		
		
	}
}
