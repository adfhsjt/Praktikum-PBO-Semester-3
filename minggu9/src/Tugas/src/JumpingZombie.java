/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class JumpingZombie extends Zombie implements Destroyable {
    public JumpingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }
    
    @Override
    public void heal(){
        switch (level) {
            case 1:
                health += health * 0.3;
                break;
            case 2: 
                health += health * 0.4;
                break;
            case 3: 
                health += health * 0.5;
                break;
        }
    }
    
    @Override
    public void destroyed(){
        health = 0;
    }
    
    @Override
    public String getZombieInfo(){
        String info = "Jumping Zombie Data = \n" + 
                super.getZombieInfo();
        return info;
    }
}
