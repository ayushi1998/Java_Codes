import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
class ACK_Message
{
	int seq_num;
	String ack;
	int flow;
	ACK_Message(int num,int f)
	{
		seq_num=num;
		flow = f;
		ack = "ACK" + String.valueOf(num);
	}
	public String toString() { 
	    return "ACK-" + "SEQ_NUM : " + seq_num +" FLOW : " + flow ;
	} 
}
public class Reciever {
	int port;
	int recv_buff_size;;
	InetAddress Address;
	DatagramSocket socket_recv;
	DatagramSocket socket_send;
	DatagramPacket rcv_packet = null;
	byte message[] = new byte[30];
	int[] recv_buff;
	int[] arr = new int[25];
	
	public void MakeSocketConnection(int n) throws SocketException, UnknownHostException
	{
		port = 8990;
	    Address = InetAddress.getLocalHost();
		socket_recv = new DatagramSocket(port); 
		socket_send = new DatagramSocket(); 
		System.out.print("Conneting");
		recv_buff_size=n; 
		recv_buff = new int[n];
	}

	public void simple_recieve_udp() throws IOException
	{
		
		int cnt=0;
		int[] arr1 = new int[100000];
		
		try
		{
				socket_recv.setSoTimeout(10000);
				while(true)
				{
					rcv_packet = new DatagramPacket(message,message.length);
					socket_recv.receive(rcv_packet);
					rcv_packet.toString();
					String s = new String(message);
					System.out.println("Text Decryted : " + s+" "+cnt);
					cnt=cnt+1;	
					//System.out.println("End : " + end);
					message = new byte[15];	
					arr1[Integer.parseInt(s.trim())-1]=1;
				}
				
		}
		catch(SocketTimeoutException e)
		{
					System.out.println("The reciever recieved :" + cnt +"packets");
					System.out.println("LOST PACKETS ARE AS FOLLOWS : ");
					for(int i=0;i<10000;i++)
					{
						if(arr1[i]==0)
							System.out.println(i+1);
					}
		}
		//System.exit(0);	
				
		
		


		
	}
	
	
	public void rdt(int n) throws IOException
	{
		
		// Receiving first Data Packet
		rcv_packet = new DatagramPacket(message,message.length);
		socket_recv.receive(rcv_packet);
		rcv_packet.toString();
		String s = new String(message);
		s = s.substring(0,1);
		System.out.println("Text Decryted : " + s);
		message = new byte[10];	
		int actual_seq_num=Integer.parseInt(s.trim());
		arr[actual_seq_num]=1;
		recv_buff[actual_seq_num%n]=1;

		// CREATING THE ACK MESSAGE with parameters : flow and seq num.
		//ACK_Message  ak = new ACK_Message(0,n-1);
		//Send_ACK(ak);
		
		int i_start=0;
		int i_end =i_start+ n-1;
		
		while(i_end<arr.length)
		{
			int j = i_start;
			while(j<i_end+1)
			{
				// CREATING THE ACK MESSAGE with parameters : flow and seq num.
				
				
				ACK_Message ak = new ACK_Message(j,n-((j)%n));
				socket_recv.setSoTimeout(10000);
				while(true)
				{
					rcv_packet = new DatagramPacket(message,message.length);
					try
					{
						socket_recv.receive(rcv_packet);
						rcv_packet.toString();
						s = new String(message);
						s = s.substring(0,1);
						System.out.println("Text Decryted : " + s);
						message = new byte[10];	
						actual_seq_num=Integer.parseInt(s.trim());
						
						arr[actual_seq_num]=1;
						
						
						recv_buff[actual_seq_num%n]=1;
					}catch(SocketTimeoutException e)
					{
						// Retransmit
						System.out.println("Retranmistting ACK "+j);
						Send_ACK(ak);
						continue;
					}
					break;
				}
				
				j=j+1;
				System.out.println(j+"This is j");
				ak = new ACK_Message(j,n-((j)%n));
				Send_ACK(ak);
			}
			i_start=j+1;
    		i_end = i_start+n-1;
    		if(i_end>arr.length)
    			break;
    		System.out.println(i_end+"This is i_end");
    		System.out.println(arr.length+"arr");
    		if(i_end>arr.length  && n-1!=1)
    			i_end = arr.length-1;

			
		}
	}
	
	public void Send_ACK(ACK_Message m) throws IOException {
		System.out.println("hi");
		ACK_Message  ak = m;
		int seq_num=ak.seq_num;
		String mess = ak.toString();
		System.out.println("Sending Message :" + mess);
		message = mess.getBytes();
		System.out.println(message+"Message");
		DatagramPacket send_packet = new DatagramPacket(message,message.length,Address ,8991);
		socket_recv.send(send_packet);
	}
	
	
	
	
	
	
	public static void main(String args[]) throws IOException
	{
		Reciever r= new Reciever();
		r.MakeSocketConnection(4);
		r.simple_recieve_udp();
		//r.rdt(4);
		
	}
}
