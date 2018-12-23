import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Sender1 {

	int port;
	InetAddress Address;
	DatagramSocket socket_send;
	
	byte message[] = null;
	int[] arr = new int[100];
	int[] ack_arr = new int[100];
	
	DatagramPacket rcv_packet = null;
	byte message_ack[] = new byte[300];

	public void MakeSocketConnection() throws SocketException, UnknownHostException
	{
		port = 8992;
	    Address = InetAddress.getLocalHost();
		socket_send = new DatagramSocket(); 
		System.out.print("Prepared UDP Socket");
	}

	public void rdt(int n) throws IOException
	{

		int seq_num=0;
		for(int i=0;i<100;i++)
		{
			arr[i]=i;
		}
	
	    int total_packets_len =100 ;
	    int i=0;
	    int turns=0;
	    
	    // First set of messages
	    	/*Send_Data(turns+seq_num);
	    	seq_num=seq_num+1;
	    	String ack_string = Rcv_Ack_Packet();
	    	ack_arr[Integer.parseInt(ack_string.trim())]=1;
	    	*/
	    
			int i_start=0;
	    	
	    	int width_window =  n;
	    	int i_end = 0;
	    	String ack_string = null;
	    	int ack_cnt =0;
	    	int index=0;
			// START : Sliding Window
	    	while(i_start<total_packets_len-1)
	    	{
	    		
	    		i_end=i_start+width_window;
	    		int cnt=0;
	    		index=i_start;
	    		while(index<arr.length && cnt<n)
	    		{
	    			if(ack_arr[index]==0)
	    			{
	    				//System.out.println("");
	    				Send_Data(index);
	  
	    				cnt=cnt+1;
	    			}
	    			index=index+1;
	    		}
	    		System.out.println("HELLO");
	    		try
	    		{
	    					socket_send.setSoTimeout(1000);
	    					ack_string = Rcv_Ack_Packet();		
	    					System.out.println("ack_string"+Integer.parseInt(ack_string.trim()));
	    					int num=Integer.parseInt(ack_string.trim());
		    				ack_arr[Integer.parseInt(ack_string.trim())]=1;
		    				ack_cnt=ack_cnt+1;
	    		}
	    		catch(SocketTimeoutException e)
	    		{
	    					System.out.println("TIMEOUT ");
	    		}
	    		finally{
	    	i_start=Integer.parseInt(ack_string.trim());
			System.out.println("i_start uodated to " + i_start);	
	
	    	}
	    		System.out.println(i_start<total_packets_len);
	    	}
	}
	
	public void Send_Data(int seq) {
		System.out.println("hi");
		Thread readThread = new Thread() {
			public void run() {
					try {
						int seq_num=seq;
			    		String mess = String.valueOf(seq);
			    		System.out.println("Sending Message :" + seq_num);
						message = mess.getBytes();
						DatagramPacket send_packet = new DatagramPacket(message,message.length,Address ,8992);
						socket_send.send(send_packet);
						seq_num=seq_num+1;
			} catch (SocketException se) {
							System.exit(0);
							}
					catch (IOException i) 
					{
						i.printStackTrace();
					}			
				}
		};
		readThread.start();
	}

	
	
	public String Rcv_Ack_Packet() throws IOException {
		System.out.println("TO RECIEVE PACKET");
		rcv_packet = new DatagramPacket(message_ack,message_ack.length);
		
		System.out.println("ACK RECIEVED IN CLIENT : " + rcv_packet);
		rcv_packet.toString();
		String s = new String(message);
		System.out.println("ACK RECIEVED IN CLIENT : " + s.trim());
		message_ack = new byte[300];
		return s;

	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Sender1 s1= new Sender1();
		s1.MakeSocketConnection();
		
		s1.rdt(4);
		for(int i=0;i<s1.ack_arr.length;i++)
		{
			System.out.print(s1.ack_arr[i]);
		}

	}

}
