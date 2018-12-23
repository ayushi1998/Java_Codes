package lab4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FruitStall extends JFrame
{

	
	static int sum=0;
	static int sumactual=0;

	public static void main(String[] args) 
	{
		window();
	}
	
	
	
	
	public static void window()
	{
		JFrame frame = new JFrame();
        frame.setTitle("Lab");
        frame.setSize(1000,1100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        

        
        JLabel headerLabel = new JLabel("IIITD Fruit Stall", SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerLabel.setFont(new Font("Serif",Font.PLAIN,20));
        headerLabel.setBounds(50, 50, 800, 50);
        frame.add(headerLabel);
        
        JLabel Inventory = new JLabel("Inventory", SwingConstants.CENTER);
        Inventory.setBorder(BorderFactory.createLineBorder(Color.black));
        Inventory.setFont(new Font("Serif",Font.PLAIN,20));
        Inventory.setBounds(50,100,400,50);
        frame.add(Inventory);
        
        JLabel User = new JLabel("User", SwingConstants.CENTER);
        User.setBorder(BorderFactory.createLineBorder(Color.black));
        User.setFont(new Font("Serif",Font.PLAIN,20));
        User.setBounds(450,100,400,50);
        frame.add(User);
        
        String arr[]={"Items","Apple","Mango","Orange","Pineapple","Banana","Total"};
        
        
        for(int i=0; i<7; i++)
        {
        	JLabel newlab=new JLabel(arr[i], SwingConstants.CENTER);
        	JLabel newlab2=new JLabel(arr[i], SwingConstants.CENTER);
        	newlab.setBorder(BorderFactory.createLineBorder(Color.black));
            newlab.setFont(new Font("Serif",Font.PLAIN,20));
            newlab.setBounds(50,150+(50*i),200,50);
            frame.add(newlab);
            newlab2.setBorder(BorderFactory.createLineBorder(Color.black));
            newlab2.setFont(new Font("Serif",Font.PLAIN,20));
            newlab2.setBounds(450,150+(50*i),200,50);
            frame.add(newlab2);
        }
        
        JLabel Quantity1=new JLabel("Quantity",SwingConstants.CENTER);
        JLabel Quantity2=new JLabel("Quantity",SwingConstants.CENTER);
        Quantity1.setBorder(BorderFactory.createLineBorder(Color.black));
        Quantity1.setFont(new Font("Serif",Font.PLAIN,20));
        Quantity1.setBounds(250,150,200,50);
        frame.add(Quantity1);
        
        Quantity2.setBorder(BorderFactory.createLineBorder(Color.black));
        Quantity2.setFont(new Font("Serif",Font.PLAIN,20));
        Quantity2.setBounds(650,150,200,50);
        frame.add(Quantity2);
        
        

       
        
        int[] invvalues={8,3,8,1,2,22};
        JLabel holder[]=new JLabel[6];
        
        for(int i=0; i<6; i++)
        {
        	holder[i]=new JLabel(invvalues[i]+"", SwingConstants.CENTER);
        	holder[i].setBorder(BorderFactory.createLineBorder(Color.black));
            holder[i].setFont(new Font("Serif",Font.PLAIN,20));
            holder[i].setBounds(250,200+(50*i),200,50);
            frame.add(holder[i]);
        }
        
        
        
        
//
//        JLabel jtf6=new JLabel("0");
//        jtf6.setBounds(650,450, 200, 50);
//        jtf6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		jtf6.setFont(new Font("Serif",Font.PLAIN,20));
//		
//		frame.add(jtf6);
        
        
        
        
        
        JButton submit=new JButton("Submit");
        submit.setFont(new Font("Serif",Font.PLAIN,20));
        submit.setBounds(650,500,200,50);
        submit.setVisible(true);
        frame.add(submit);
      
        
        
        JButton clear=new JButton("Clear");
        clear.setFont(new Font("Serif",Font.PLAIN,20));
        clear.setBounds(450,500,200,50);
        clear.setVisible(true);
        frame.add(clear);
        
        
        
        
        
        
        
        JTextField jtf1=new JTextField();
        jtf1.setBorder(BorderFactory.createLineBorder(Color.black));
        jtf1.setFont(new Font("Serif",Font.PLAIN,20));
        jtf1.setBounds(650,200,200,50);
        jtf1.setVisible(true);
        jtf1.setHorizontalAlignment(JTextField.CENTER);
        frame.add(jtf1);
        
        
        jtf1.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        						
        							String in1=jtf1.getText();
        							sumactual+=Integer.parseInt(in1);
        							
        							
        							if(Integer.parseInt(holder[0].getText())<Integer.parseInt(in1))
        								sum+=0;
        							
        							else
        							{
        								if(Integer.parseInt(holder[0].getText())==Integer.parseInt(in1))
            								jtf1.setEditable(false);
            							
            							sum+=Integer.parseInt(in1);
        							}
        							
        							System.out.println(sum);
        						}
        		
        		}			 );
        
        
        JTextField jtf2=new JTextField();
        jtf2.setBorder(BorderFactory.createLineBorder(Color.black));
        jtf2.setFont(new Font("Serif",Font.PLAIN,20));
        jtf2.setBounds(650,250,200,50);
        jtf2.setVisible(true);
        jtf2.setHorizontalAlignment(JTextField.CENTER);
        frame.add(jtf2);
        
        
        jtf2.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        							String in2=jtf2.getText();
        							sumactual+=Integer.parseInt(in2);
        							
        							if(Integer.parseInt(holder[1].getText())<Integer.parseInt(in2))
        								sum+=0;
        								
        							else
        							{
        								if(Integer.parseInt(holder[1].getText())==Integer.parseInt(in2))
            								jtf2.setEditable(false);
            							sum+=Integer.parseInt(in2);
        							}
        							
        							System.out.println(sum);
        							
        						}
        		
        		}			 );
        
        
        JTextField jtf3=new JTextField();
        jtf3.setBorder(BorderFactory.createLineBorder(Color.black));
        jtf3.setFont(new Font("Serif",Font.PLAIN,20));
        jtf3.setBounds(650,300,200,50);
        jtf3.setVisible(true);
        jtf3.setHorizontalAlignment(JTextField.CENTER);
        frame.add(jtf3);
        
        
        jtf3.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        							String in3=jtf3.getText();
        							sumactual+=Integer.parseInt(in3);
        							
        							if(Integer.parseInt(holder[2].getText())<Integer.parseInt(in3))
        								sum+=0;
        							
        							else
        							{
        								if(Integer.parseInt(holder[2].getText())==Integer.parseInt(in3))
            								jtf3.setEditable(false);
            							
            						
            							sum+=Integer.parseInt(in3);
        							}
        							
        							System.out.println(sum);
        						}
        		
        		}			 );
        
        
        JTextField jtf4=new JTextField();
        jtf4.setBorder(BorderFactory.createLineBorder(Color.black));
        jtf4.setFont(new Font("Serif",Font.PLAIN,20));
        jtf4.setBounds(650,350,200,50);
        jtf4.setVisible(true);
        jtf4.setHorizontalAlignment(JTextField.CENTER);
        frame.add(jtf4);
        
        
        jtf4.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        							
        							
        							String in4=jtf4.getText();
        							sumactual+=Integer.parseInt(in4);
        							
        							if(Integer.parseInt(holder[3].getText())<Integer.parseInt(in4))
        								sum+=0;
        							
        							else
        							{
        								if(Integer.parseInt(holder[3].getText())==Integer.parseInt(in4))
            								jtf4.setEditable(false);
            							sum+=Integer.parseInt(in4);
        							}
        							
        							System.out.println(sum);
        						}
        		
        		}			 );
        
        
        JTextField jtf5=new JTextField();
        jtf5.setBorder(BorderFactory.createLineBorder(Color.black));
        jtf5.setFont(new Font("Serif",Font.PLAIN,20));
        jtf5.setBounds(650,400,200,50);
        jtf5.setVisible(true);
        jtf5.setHorizontalAlignment(JTextField.CENTER);
        frame.add(jtf5);
        
        
        jtf5.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        							String in5=jtf5.getText();
        							sumactual+=Integer.parseInt(in5);
        							
        							if(Integer.parseInt(holder[4].getText())<Integer.parseInt(in5))
        								sum+=0;
        							else
        							{
        								if(Integer.parseInt(holder[4].getText())==Integer.parseInt(in5))
            								jtf5.setEditable(false);
            							sum+=Integer.parseInt(in5);
        							}
        							
        							System.out.println(sum);
        							
        							
        						}
        		
        		}			 );
        
        
        
        
        //System.out.println(sum);
        
        
        JLabel jtf6=new JLabel("", SwingConstants.CENTER);
        
        
        
      
       
        
        submit.addActionListener(new ActionListener()
        		{
        						public void actionPerformed(ActionEvent e)
        						{
        							jtf6.setBounds(650,450,200,50);
        					        jtf6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        					        jtf6.setFont(new Font("Serif",Font.PLAIN,20));
        					        jtf6.setVisible(true);
        					        frame.add(jtf6);
        							
        							jtf6.setText(sumactual+"");
        							
        							
        							
        					        if(Integer.parseInt(holder[0].getText())>=Integer.parseInt(jtf1.getText()))
        					        	holder[0].setText(String.valueOf(Integer.parseInt(holder[0].getText())-Integer.parseInt(jtf1.getText())));
        							if(Integer.parseInt(holder[1].getText())>=Integer.parseInt(jtf2.getText()))
        								holder[1].setText(String.valueOf(Integer.parseInt(holder[1].getText())-Integer.parseInt(jtf2.getText())));
        							if(Integer.parseInt(holder[2].getText())>=Integer.parseInt(jtf3.getText()))
        								holder[2].setText(String.valueOf(Integer.parseInt(holder[2].getText())-Integer.parseInt(jtf3.getText())));
        							if(Integer.parseInt(holder[3].getText())>=Integer.parseInt(jtf4.getText()))
        								holder[3].setText(String.valueOf(Integer.parseInt(holder[3].getText())-Integer.parseInt(jtf4.getText())));
        							if(Integer.parseInt(holder[4].getText())>=Integer.parseInt(jtf5.getText()))
        								holder[4].setText(String.valueOf(Integer.parseInt(holder[4].getText())-Integer.parseInt(jtf5.getText())));
        							holder[5].setText(String.valueOf(Integer.parseInt(holder[5].getText())-sum));
        							
        							
        						}
        		}
        		
        						);
        
        
        clear.addActionListener(new ActionListener()
        		{
        				public void actionPerformed(ActionEvent e)
        				{
        					sum=0;
        					sumactual=0;
							jtf1.setText("0");
							jtf2.setText("0");
							jtf3.setText("0");
							jtf4.setText("0");
							jtf5.setText("0");
							jtf6.setText("0");
        				}
        	
        		}
        		
        		
        		
        		
        		);
	
	}
}
