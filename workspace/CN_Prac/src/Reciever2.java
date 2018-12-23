import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

class ack_message
{
	int seq_num;
	String ack;
	int flow;
	ack_message(int num,int f)
	{
		seq_num=num;
		flow = f;
		ack = "ACK" + String.valueOf(num);
	}
}


public class Reciever2 {

	int port;
	int recv_buff_size;;
	InetAddress Address;
	DatagramSocket socket_recv;
	DatagramPacket rcv_packet = null;
	byte message[] = new byte[30];
	byte message1[] = new byte[30];
	int[] recv_buff;
	int ack_cnt=0;
	int[] arr = new int[100];
	int[] ack_arr = new int[100];
	public void MakeSocketConnection(int n) throws SocketException, UnknownHostException
	{
		port = 8992;
	    Address = InetAddress.getLocalHost();
		socket_recv = new DatagramSocket(port); 
		System.out.println("Conneting");
		recv_buff_size=n; 
		recv_buff = new int[n];
	}
	
	public void rdt(int n) throws IOException
	{
		
		// CREATING THE ACK MESSAGE with parameters : flow and seq num.
		//ACK_Message  ak = new ACK_Message(0,n-1);
		//Send_ACK(ak);
		
		int i_start=0;
		int i_end =i_start+ n;
		
		int flow = n;
		while(ack_cnt<arr.length)
		{
			System.out.println("Value of start"+i_start);
			int j =0;
			// Receive till buffer size
			int cnt=0;
    		int index=i_start;
			while(index<ack_arr.length && ack_arr[index]==1)
    		{
    			
    			index=index+1;
    			ack_cnt=ack_cnt+1;
    		}
			
			i_start=index;
			socket_recv.setSoTimeout(1000);
			try
	    	{
				int max=0;
				ack_message am = null;
				while(j<flow)
				{
	    		
				rcv_packet = new DatagramPacket(message1,message1.length);
				socket_recv.receive(rcv_packet);
				rcv_packet.toString();
				String s = new String(message1);
				//s = s.substring(0,1);
				System.out.println("Text Decryted : " + s);
				message1 = new byte[10];	
				int actual_seq_num=Integer.parseInt(s.trim());
			
				arr[actual_seq_num]=1;
				ack_arr[actual_seq_num]=1;
				recv_buff[actual_seq_num%n]=1;
				int i=0;
				
				if(max<actual_seq_num)
				{
					max=actual_seq_num;
				}
				am = new ack_message(max,(n-(actual_seq_num-1)%n));
					
				j=j+1;
				
				}
	    		
				Send_ACK(am);
	    	}
		
    		catch(SocketTimeoutException e)
    		{
    			System.out.println("LOST PACKETS  ");
   		
    		}
			
			System.out.print("Ack-cnt"+ack_cnt);
	}
		}

	public void Send_ACK(ack_message m) throws IOException {
		
		ack_message ak = m;
		int seq_num=ak.seq_num;
		System.out.println("seq number culprit" + seq_num);
		String mess = String.valueOf(seq_num);
		System.out.println("Sending ACKMessage :" + mess);
		message = mess.getBytes();
		System.out.println(message+"Message");
		DatagramPacket send_packet = new DatagramPacket(message,message.length,Address ,8992);
		socket_recv.send(send_packet);
	}
	

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

Reciever2 r= new Reciever2();
		r.MakeSocketConnection(4);
		//r.simple_recieve_udp();
		r.rdt(4);
		

		
	}

}
