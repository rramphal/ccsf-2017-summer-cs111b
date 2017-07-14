/*	Author	: Novia Chandra
	Date		: 7/16/07
	Homework	: #5
	This program is an Applet Animation of the night in the City with moving cars.
*/					
	
import java.awt.*;
import java.applet.*;
import java.util.*;

/*
<applet code="City" align=right width=600 height=600>
</applet>
*/

public class City extends Applet
{
	int n = 0,i;	
	public void init()
	{
 		setBackground(Color.gray);
 	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.drawString("Author: Novia Chandra",450,590);
	 	//Moon	
		g.setColor(Color.white);
		g.fillOval(500,60,35,35);
			
		//Building
		g.setColor(Color.black);
		g.fillRect(0,130,65,320);
		g.fillRect(65,230,20,220);
		g.fillRect(85,100,75,350);
		g.fillRect(160,200,30,250);
		g.fillRect(190,160,45,290);
		g.fillRect(235,200,55,250);
		g.fillRect(290,230,20,220);
		g.fillRect(310,100,60,350);
		g.fillRect(370,190,20,260);
		g.fillRect(390,140,55,310);
		g.fillRect(445,170,75,280);
		g.fillRect(520,150,80,300);
		//Building lights
		//1st
		g.setColor(Color.orange);
		g.fillRect(5,135,10,10);
		g.fillRect(20,150,10,10);
		g.fillRect(35,150,10,10);
		g.fillRect(50,180,10,10);
		//3rd
		g.fillRect(90,105,10,10);
		g.fillRect(90,120,10,10);
		g.fillRect(90,135,10,10);
		g.fillRect(105,120,10,10);
		g.fillRect(130,180,10,10);
		g.fillRect(145,165,10,10);		
		//5th
		g.fillRect(220,165,10,10);
		g.fillRect(220,180,10,10);
		//6th
		g.fillRect(260,205,10,10);
		g.fillRect(275,205,10,10);
		g.fillRect(260,220,10,10);
		g.fillRect(275,235,10,10);
		g.fillRect(245,250,10,10);
		//8th
		g.fillRect(315,105,10,10);
		g.fillRect(315,120,10,10);
		g.fillRect(315,135,10,10);
		g.fillRect(330,120,10,10);
		//10th
		g.fillRect(395,145,10,10);
		g.fillRect(395,160,10,10);
		//11th
		g.fillRect(450,175,10,10);
		g.fillRect(465,175,10,10);
		g.fillRect(465,190,10,10);
		g.fillRect(480,175,10,10);
		g.fillRect(195,190,10,10);	
		//12th
		for(i=0 ; i<4 ; i++)
		{
			g.fillRect(525,155+(15*i),10,10);
		}
		g.fillRect(540,155,10,10);
		g.fillRect(555,155,10,10);
		g.fillRect(540,170,10,10);
			
		//Building doors/Sushi House
		g.setColor(Color.yellow);
		g.fillRect(50,410,50,40);
		g.fillRect(540,410,25,40);
		g.setColor(Color.white);
		g.fillOval(55,340,70,40);
		g.fillOval(70,382,15,10);
		g.fillOval(70,395,8,5);
		g.fillRect(234,390,34,70);
		g.fillRect(270,390,34,70);
		g.fillRect(306,390,34,70);
		g.fillRect(342,390,34,70);
		g.setColor(Color.black);
		g.drawString("g'nite",75,355);
		g.drawString("everyone!!",63,367);
		g.setColor(Color.green);
		g.fillRect(75,410,25,40);
		g.setColor(Color.red);
		g.fillRect(280,400,51,50);
		g.fillRect(234,440,142,10);
		int x[] = {258,352,391,219};
		int y[] = {350,350,390,390};
		g.fillPolygon(x,y,4);
		g.fillRect(219,392,10,15);
		g.fillRect(381,392,10,15);
		g.fillRect(264,392,10,15);
		g.fillRect(336,392,10,15);
		g.fillOval(217,394,14,10);
		g.fillOval(379,394,14,10);
		g.fillOval(262,394,14,10);
		g.fillOval(334,394,14,10);
		g.setColor(Color.black);
		for(i=0 ; i<4 ; i++)
		{
			g.drawRect(282+(12*i),402,10,10);
			g.drawRect(282+(12*i),414,10,10);
			g.drawRect(282+(12*i),426,10,10);
			g.drawRect(282+(12*i),438,10,10);
			g.drawRect(77,412+(9*i),21,7);
			
		}
		g.drawArc(294,414,22,22,100,160);
		g.drawArc(294,414,22,22,-80,160);	
		//ligtht polls
		g.setColor(Color.blue);
		for(i=0 ; i<3 ; i++)
		{
			g.drawLine(200*i,360,200*i,450);
			g.drawArc(200*i,335,50,50,90,90);
			g.drawArc(150+(200*i),335,50,50,0,95);
		}
		//people		
		g.setColor(Color.black);
		g.fillOval(51,411,18,18);
		g.fillOval(541,411,18,18);
		g.drawLine(58,440,56,450);
		g.drawLine(62,440,62,450);
		g.drawLine(548,440,548,450);
		g.drawLine(552,440,554,450);
		g.setColor(Color.pink);
		g.fillOval(55,415,10,10);
		g.fillOval(545,415,10,10);
		g.setColor(Color.red);
		g.fillRect(55,425,10,15);
		g.setColor(Color.magenta);
		g.fillRect(545,425,10,15);

		//street
		g.setColor(Color.blue);
		g.fillRect(0,450,600,10);
		g.setColor(Color.white);
		for(i=0 ; i<12; i++)
		{
			g.fillRect(50*i,520,25,5);
		}
		//ligths
		g.setColor(Color.pink);
		for(i=0 ; i<3 ; i++)
		{
			g.fillOval(25+(200*i),335,10,10);
			g.fillOval(165+(200*i),335,10,10);
		}
		if(n<600)
		{
			//FIRST CAR
			g.setColor(Color.pink);
			g.fillRect(35+n,460,80,25);
			g.fillArc(10+n,460,50,50,90,90);
			g.fillArc(65+n,460,100,50,0,90);
			g.drawArc(45+n,435,70,50,0,180);
			g.fillRect(80+n,435,5,35);
			//wheels
			g.setColor(Color.black);
			g.fillOval(30+n,470,25,25);
			g.fillOval(110+n,470,25,25);
			g.setColor(Color.yellow);
			g.fillOval(145+n,470,10,10);
			g.drawLine(150+n,470,350+n,500);
			g.drawLine(150+n,480,250+n,500);
			g.fillOval(250+n,497,100,6);
			//driver & passenger
			g.setColor(Color.pink);
			g.fillOval(60+n,445,10,10);
			g.fillOval(90+n,445,10,10);
			g.setColor(Color.black);
			g.fillArc(56+n,441,18,18,45,180);
			g.fillArc(86+n,441,18,18,45,180);
			g.setColor(Color.green);
			g.fillRect(60+n,455,10,5);
			g.setColor(Color.orange);
			g.fillRect(90+n,455,10,5);
			n = n+5;
			//SECOND CAR
			g.setColor(Color.cyan);
			g.fillRect(465-n,540,75,25);
			g.fillArc(440-n,540,50,50,90,90);
			g.fillArc(515-n,540,50,50,0,90);
			g.drawArc(465-n,515,70,50,0,180);
			g.fillRect(500-n,515,5,35);
			//wheels
			g.setColor(Color.black);
			g.fillOval(450-n,550,25,25);
			g.fillOval(530-n,550,25,25);
			g.setColor(Color.yellow);
			g.fillOval(440-n,550,8,8);
			g.drawLine(444-n,550,252-n,582);
			g.drawLine(444-n,558,350-n,582);
			g.fillOval(250-n,580,100,6);
			//driver & passenger
			g.setColor(Color.pink);
			g.fillOval(480-n,525,10,10);
			g.fillOval(510-n,525,10,10);
			g.setColor(Color.black);
			g.fillArc(476-n,521,18,18,-45,180);
			g.fillArc(506-n,521,18,18,-45,180);

			g.setColor(Color.red);
			g.fillRect(480-n,535,10,5);
			g.setColor(Color.blue);
			g.fillRect(510-n,535,10,5);
			n = n+5;
			sleep(100);
			repaint(0+n,435,350,85);
			repaint(250-n,515,340,85);
			}
	}
	public static void sleep(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException e){}
	}
}