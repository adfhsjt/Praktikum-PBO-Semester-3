/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Programmer extends Pegawai{
    private int bonus;

    public Programmer(int bonus, String nama, int gaji) {
        super(nama, gaji);
        this.bonus = bonus;
    }

    @Override
    public int getGaji() {
        return super.getGaji(); 
    }

    public int getBonus() {
        return bonus;
    }
    
    
}
