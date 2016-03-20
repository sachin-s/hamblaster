package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
public class Menu extends BasicGameState
{	
	Image playnow;
	Image exitgame;
	public Menu(int State)
	{
		
	}
	public void init(GameContainer gc,StateBasedGame sbg)throws SlickException
	{
		playnow=new Image("rse/playNow.png");
		exitgame=new Image("rse/exitGame.png");
		
	}
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g)throws SlickException
	{	
		g.drawString("Welcome to Bucky land", 100, 50);
		playnow.draw(100,100);
		exitgame.draw(100,200);
	}
	public void update(GameContainer gc,StateBasedGame sbg,int delta)throws SlickException
	{
		int posx=Mouse.getX();
		int posy=Mouse.getY();
		//playnow button
		if((posx>100&&posx<311) && (posy>209 && posy<260))
		{
			if(Mouse.isButtonDown(0))
			{
				sbg.enterState(1);
			}
		}
		//exit now button
		if((posx>100&&posx<311) && (posy>109 && posy<160))
		{
			if(Mouse.isButtonDown(0))
			{
				System.exit(0);
			}
		}
			
			
	}	
	public int getID()
	{
		return 0;
	}
	
}
