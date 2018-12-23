import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;





public class Sender {
	int port;
	InetAddress Address;
	DatagramSocket socket_send;
	DatagramSocket socket_recv;
	byte message[] = null;
	int[] arr = new int[25];
	int[] ack_arr = new int[100];
	
	DatagramPacket rcv_packet = null;
	byte message_ack[] = new byte[300];

	
	
	
	//Send_Packet sp;
	public void MakeSocketConnection() throws SocketException, UnknownHostException
	{
		port = 8990;
	    Address = InetAddress.getLocalHost();
		socket_send = new DatagramSocket(); 
		socket_recv = new DatagramSocket(8991); 
		System.out.print("Prepared UDP Socket");
	}

	public void simple_udp() throws IOException
	{
		byte message[] = null;
		int message_i=1;
		while(message_i<100)
		{
			String mess = String.valueOf(message_i);
			message = mess.getBytes();
			DatagramPacket send_packet = new DatagramPacket(message,message.length,Address ,8990);
			socket_send.send(send_packet);
			message_i=message_i+1;
	
		}
		
		
	}
	public void rdt(int n) throws IOException
	{

		int seq_num=0;
		for(int i=0;i<25;i++)
		{
			arr[i]=i;
		}
	
	    int total_packets_len = 25;
	    int i=0;
	    int turns=0;
	    
	    // First set of messages
	    	Send_Data(turns+seq_num);
	    	seq_num=seq_num+1;
	    	String ack_string = Rcv_Ack_Packet(seq_num);
			ack_arr[Integer.parseInt(ack_string.trim())]=1;
			int i_start=1;
	    	
	    	int width_window =  n-1;
	    	int i_end = i_start+width_window;
			// START : Sliding Window
	    	while(i_end<total_packets_len)
	    	{
	    		
	    		int j=i_start;
	    		System.out.println(j+"This is start");
	    		
	    		while(j<i_end+1)
	    		{
	    			Send_Data(j);
	    			socket_recv.setSoTimeout(1000);
	    			while(true)
	    			{
	    				try
	    				{
	    					ack_string = Rcv_Ack_Packet(j);
	    					int seq_num_recv =  j;
		    				ack_arr[seq_num_recv]=1;
		    				width_window = n-1;
	    				} catch (SocketTimeoutException e)
	    					{
	    						// Retransmit
	    						System.out.println("Retranmistting DATA "+j);
	    						Send_Data(j);
	    						continue;
	    					}	
	    				//We have sent the data and ack is recieved for j
		    			break;
	    			}
	    			
	    			j=j+1;
	    			System.out.println(j+"This is j");
	    			
	    		}
	    		
	    		i_start=j;
	    		i_end = i_start+n-1;
	    		System.out.println(i_end+"This is end");
	    		if(i_end>total_packets_len && n-1!=1)
	    			i_end = total_packets_len-1;
	    
	    		
	    		
	    	}
			
			
			
			

	    
	   
	    
	    
		
	}
	
	public void Send_Data(int seq) {
		System.out.println("hi");
		Thread readThread = new Thread() {
			public void run() {
					try {
						int seq_num=seq;
			    		String mess = String.valueOf(arr[seq_num]);
			    		System.out.println("Sending Message :" + seq_num);
						message = mess.getBytes();
						DatagramPacket send_packet = new DatagramPacket(message,message.length,Address ,8990);
						socket_send.send(send_packet);
						seq_num=seq_num+1;
			} catch (SocketException se) {
							System.exit(0);
							}
					catch (IOException i) 
					{
						i.printStackTrace();
					}			}
		};
		readThread.start();
	}

	
	
	public String Rcv_Ack_Packet(int seq) throws IOException {
		System.out.println("TO RECIEVE PACKET");
		rcv_packet = new DatagramPacket(message_ack,message_ack.length);
		socket_recv.receive(rcv_packet);
		System.out.println("ACK RECIEVED IN CLIENT : " + rcv_packet);
		rcv_packet.toString();
		String s = new String(message);
		System.out.println("ACK RECIEVED IN CLIENT : " + s.trim());
		message_ack = new byte[300];
		return s;

	}
	
	
	
	public static void main(String args[]) throws IOException
	{
		Sender s= new Sender();
		s.MakeSocketConnection();
		s.simple_udp();
		//s.rdt(4);
		System.out.println("Number of active threads from the given thread: " + Thread.activeCount());
	}
	
	
}
