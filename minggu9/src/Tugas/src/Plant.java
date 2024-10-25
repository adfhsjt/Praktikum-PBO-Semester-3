/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Plant {
    public void doDestroy(Destroyable d){
        if(d instanceof WalkingZombie){
            ((WalkingZombie) d).health -= (((WalkingZombie) d).health * 0.02); 
        } else if(d instanceof JumpingZombie){
            ((JumpingZombie) d).health -= (((JumpingZombie) d).health * 0.01);
        } else if(d instanceof Barrier){
            int temp = ((Barrier) d).getStrength();
            temp -= (temp * 0.1);
            ((Barrier) d).setStrength(temp);
        }else{
            System.out.println("Musuh tidak diketahui");
        }
    }
}
