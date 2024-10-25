/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class IntershipEmployee extends Employee{
    private int length;

    public IntershipEmployee(String name, int length) {
        this.length = length;
        this.name = name;
    }
    
    public int getLength(){
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    @Override
    public String getEmployeeInfo(){
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as intership employee for " + length + " month/s\n";
        return info;
    }

    
    
}
