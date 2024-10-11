/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Mahasiswa extends AnggotaKampus {
    public String nim;
    public String programStudi; 

    public Mahasiswa(String nim, String programStudi, String nama, String id) {
        super(nama, id);
        this.nim = nim;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return nim;
    }

    public String getProgramStudi() {
        return programStudi;
    }
    
    
}
