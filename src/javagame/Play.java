package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState
{	
	Animation bucky,movingUp,movingDown,movingLeft,movingRight;
	Image worldMap;
	boolean quit=false;
	int[] duration={200,200};
	float buckyPositionX=0;
	float buckyPositionY=0;
	float shiftX=buckyPositionX +320;
	float shiftY=buckyPositionY +160;
	
	public Play(int State)
	{
		
	}
	public void init(GameContainer gc,StateBasedGame sbg)throws SlickException
	{
		worldMap=new Image("rse/world.png");
		Image[] walkUp={new Image("rse/buckysBack.png"),new Image("rse/buckysBack.png")};
		Image[] walkDown={new Image("rse/buckysFront.png"),new Image("rse/buckysFront.png")};
		Image[] walkLeft={new Image("rse/buckysLeft.png"),new Image("rse/buckysLeft.png")};
		Image[] walkRight={new Image("rse/buckysRight.png"),new Image("rse/buckysRight.png")};
		movingUp=new Animation(walkUp,duration,false);
		movingDown=new Animation(walkDown,duration,false);
		movingLeft=new Animation(walkLeft,duration,false);
		movingRight=new Animation(walkRight,duration,false);
		bucky=movingDown;
	}
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g)throws SlickException
	{
		worldMap.draw(buckyPositionX,buckyPositionY);
		bucky.draw(shiftX,shiftY);
		g.drawString("Bucky's x:"+buckyPositionX+"\nBucky's y:"+buckyPositionY, 400,20);
		if(quit==true)
		{
			g.drawString("Resume(R)", 250, 100);
			g.drawString("Main Menu(M)",250,150);
			g.drawString("Quit Game(Q)",250,200);
		
		if(quit==false)
		{
			g.clear();
		}}
		
	}
	public void update(GameContainer gc,StateBasedGame sbg,int delta)throws SlickException
	{
		Input input=gc.getInput();
		if(input.isKeyDown(Input.KEY_UP))
		{	
			bucky=movingUp;
			buckyPositionY+=delta*.1f;
			if(buckyPositionY>162)
			{
				buckyPositionY-=delta*.1f;
				
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			bucky=movingDown;
			buckyPositionY-=delta*.1f;
			if(buckyPositionY<-600)
			{
				buckyPositionY+=delta*.1f;
				
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			bucky=movingLeft;
			buckyPositionX+=delta*.1f;
			if(buckyPositionX>324)
			{
				buckyPositionX-=delta*.1f;
				
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			bucky=movingRight;
			buckyPositionX-=delta*.1f;
			if(buckyPositionX<-840)
			{
				buckyPositionX+=delta*.1f;
				
			}
		}
		//escape
		if(input.isKeyDown(Input.KEY_ESCAPE))
		{
			quit=true;
		}
		if(quit==true)
		{
			if(input.isKeyDown(Input.KEY_R)){quit=false;}
			if(input.isKeyDown(Input.KEY_M)){sbg.enterState(0);quit=false;}
			if(input.isKeyDown(Input.KEY_Q)){System.exit(0);}
		}
		
	}
	public int getID()
	{
		return 1;
	}
	
}
