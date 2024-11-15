/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soal.pkg1;

/**
 *
 * @author ahmad
 */
abstract class AlatMusik {
    protected String nama;
    protected String jenis;
    
    public abstract void mainkan();
    
    public void berhenti(){
        System.out.println("Berhenti memainkan alat musik " + nama);
    }
}
