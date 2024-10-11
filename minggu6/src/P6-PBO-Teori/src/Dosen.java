/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Dosen extends AnggotaKampus{
    public String nip;
    public String departemen;

    public Dosen(String nip, String departemen, String nama, String id) {
        super(nama, id);
        this.nip = nip;
        this.departemen = departemen;
    }

    public String getNip() {
        return nip;
    }

    public String getDepartemen() {
        return departemen;
    }
    
    
}
