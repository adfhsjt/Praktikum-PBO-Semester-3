/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Zombie implements Destroyable{
    protected int health;
    protected int level;
    
    public void heal(){
        switch (level) {
            case 1:
                health += health * 0;
                break;
            case 2: 
                health += health * 0;
                break;
            case 3: 
                health += health * 0;
                break;
        }
    }
    
    public void destroyed(){
        health = 0;
    }
    
    public String getZombieInfo(){
        String info = "Health = " + health + "\n"+
                "Level = " + level;
        return info;
    }
}
