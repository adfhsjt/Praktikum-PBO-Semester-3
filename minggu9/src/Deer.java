/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Deer extends Animal implements Vegetarian{
    @Override
    public void walk(){
        System.out.println("The deer walking aaround the jungle.");
    }
    
    @Override
    public void eat(){
        System.out.println("Kijang hewan vegetarian");
    }
}
