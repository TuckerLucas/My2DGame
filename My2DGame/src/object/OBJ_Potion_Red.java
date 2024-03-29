package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity
{
	GamePanel gp;
			
	public OBJ_Potion_Red(GamePanel gp) 
	{
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "Red Potion";
		value = 5;
		down1 = setup("/objects/potion_red", gp.tileSize, gp.tileSize);
		description = "[" + name + "]\n Heals your life by " + value + ".";
		price = 15;
		stackable = true;
		
		setDialogue();
	}
	
	public void setDialogue()
	{
		dialogues[0][0] = "You drink the " + name + "!\n" + "Your life has been recovered by " + value + ".";
	}
	
	public boolean use(Entity entity)
	{
		startDialogue(this, 0);
		entity.life += value;
		gp.playSE(2);
		
		return true;
	}
}
