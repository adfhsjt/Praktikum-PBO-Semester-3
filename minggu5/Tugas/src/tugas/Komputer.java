/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Komputer {

    private boolean on = false;
    private Motherboard m;
    private Processor p;
    private Memory mr;
    private Storage s;
    private PowerSupply ps;
    private GraphicCard g;

    public Komputer() {
    }

    public void setM(Motherboard m) {
        System.out.println("Memasang Motherboard ...");
        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }
        this.m = m;
        System.out.println("Berhasil dipasang " + m.getSeri());
        System.out.println("----------------------------------------------------");

    }

    public void setP(Processor p) {
        System.out.println("Memasang Prosesor ...");

        if (this.m == null) {
            System.out.println("Siapkan motherboard terlebih dahulu");
            System.out.println("----------------------------------------------------");
            return;
        }
        
        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }

        if (this.m.getSoket().equals(p.getsocket())) {
            this.p = p;
            System.out.println("Berhasil dipasang " + p.getSeri());
            System.out.println("----------------------------------------------------");

        } else {
            System.out.println("Socket tidak mendukung");
            System.out.println("----------------------------------------------------");

        }
    }

    public void setMr(Memory mr) {
        System.out.println("Memasang Memory ...");

        if (this.m == null) {
            System.out.println("Siapkan motherboard terlebih dahulu");
            System.out.println("----------------------------------------------------");
            return;
        }
        
        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }
        
        this.mr = mr;
        System.out.println("Berhasil dipasang " + mr.getNama());
        System.out.println("----------------------------------------------------");

    }

    public void setS(Storage s) {
        System.out.println("Memasang Storage ...");

        if (this.m == null) {
            System.out.println("Siapkan motherboard terlebih dahulu");
            System.out.println("----------------------------------------------------");

            return;
        }
        
        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }
        this.s = s;
        System.out.println("Berhasil dipasang " + s.getNama());
        System.out.println("----------------------------------------------------");

    }

    public void setPs(PowerSupply ps) {
        System.out.println("Memasang Power Supply ...");

        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }
        
        if (this.m == null) {
            System.out.println("Siapkan motherboard terlebih dahulu");
            System.out.println("----------------------------------------------------");

            return;
        }
        this.ps = ps;
        System.out.println("Berhasil dipasang " + ps.getSeri());
        System.out.println("----------------------------------------------------");

    }

    public void setG(GraphicCard g) {
        System.out.println("Memasang Graphic Card ...");

        if (this.m == null) {
            System.out.println("Siapkan motherboard terlebih dahulu");
            System.out.println("----------------------------------------------------");

            return;
        }
        
        if(on==true){
            System.out.println("Matikan komputer sebelum memasang komponen");
            System.out.println("----------------------------------------------------");
            return;
        }
        
        this.g = g;
        System.out.println("Berhasil dipasang " + g.getSeri());
        System.out.println("----------------------------------------------------");

    }

    public String on() {
        if (on != false) {
            return "Menyala";
        } else {
            return "Mati";
        }
    }

    public Processor getP() {

        return p;
    }

    public Motherboard getM() {

        return m;
    }

    public Memory getMr() {

        return mr;
    }

    public Storage getS() {

        return s;
    }

    public PowerSupply getPs() {

        return ps;
    }

    public GraphicCard getG() {

        return g;
    }

    public double hitungSkorBenchmark() {
        double totalSkor = (p != null ? p.hitungSkorBenchmark() : 0)
                + (m != null ? m.getPoinBenchmark() : 0)
                + (mr != null ? mr.hitungSkorBenchmark() : 0)
                + (s != null ? s.hitungSkorBenchmark() : 0)
                + (ps != null ? ps.hitungSkorBenchmark() : 0);

        if (g != null) {
            totalSkor += g.hitungSkorBenchmark();
        }

        return totalSkor;
    }

    public boolean cekKomponen() {
        return (p != null)
                && (m != null)
                && (mr != null)
                && (s != null)
                && (ps != null);
    }

    public void nyalakan() {
        System.out.println("Menyalakan Komputer ...");
        if (cekKomponen()) {
            on = true;
            System.out.println("Berhasil dinyalakan");
            System.out.println("----------------------------------------------------");

        } else {
            System.out.println("Komponen ada yang tidak terpasang");
            System.out.println("----------------------------------------------------");

        }
    }

    public void matikan() {
        System.out.println("Mematikan Komputer ...`");
        
        on = false;
        System.out.println("Berhasil dimatikan");
            System.out.println("----------------------------------------------------");

    }

    public void mainMinecraft() {
        if (on != true) {
            System.out.println("Komputer masih mati");
            System.out.println("----------------------------------------------------");

            return;
        }
        if (hitungSkorBenchmark() >= 1200) {
            System.out.println("Perangkat bisa menjalankan game minecraft");
            System.out.println("----------------------------------------------------");

        } else {
            System.out.println("Game mungkin akan lag / crash");
            System.out.println("----------------------------------------------------");

        }
    }

    public void mainGTA() {
        if (on != true) {
            System.out.println("Komputer masih mati");
            System.out.println("----------------------------------------------------");

            return;
        }
        if (hitungSkorBenchmark() >= 2400) {
            System.out.println("Perangkat bisa menjalankan game GTA");
            System.out.println("----------------------------------------------------");

        } else {
            System.out.println("Game mungkin akan lag / crash");
            System.out.println("----------------------------------------------------");

        }
    }

    public void info() {
        System.out.println("Status\t\t:\t" + (on() != null ? on() : "Tidak terpasang"));
        System.out.println("Prosesor\t\t:\t" + (getP() != null ? getP().getSeri() : "Tidak terpasang"));
        System.out.println("Motherboard\t:\t" + (getM() != null ? getM().getSeri() : "Tidak terpasang"));
        System.out.println("Graphic Card\t:\t" + (getG() != null ? getG().getSeri() : "Tidak terpasang"));
        System.out.println("Memory\t\t:\t" + (getMr() != null ? getMr().getNama() : "Tidak terpasang"));
        System.out.println("Storage\t\t:\t" + (getS() != null ? getS().getNama() : "Tidak terpasang"));
        System.out.println("Power Supply\t:\t" + (getPs() != null ? getPs().getSeri() : "Tidak terpasang"));
        System.out.println("Skor Benchmark\t:\t" + hitungSkorBenchmark());
        System.out.println("----------------------------------------------------");
    }

    public void spesifikasi() {
        System.out.println("----------------------------------------------------");
        System.out.println("------LIST SPESIFIKASI------");
        System.out.println("------PROSESOR------");
        if (p != null) {
            p.info();
        }else {
            System.out.println("Komponen tidak terpasang");
        }
        System.out.println("------MOTHERBOARD------");
        if (m != null) {
            m.info();
        }else {
            System.out.println("Komponen tidak terpasang");
        }
        System.out.println("------GRAPHIC CARD------");
        if (g != null) {
            g.info();
        } else {
            System.out.println("Komponen tidak terpasang");
        }
        
        System.out.println("------MEMORY------");
        if (mr != null) {
            mr.info();
        }else {
            System.out.println("Komponen tidak terpasang");
        }
        System.out.println("------STORAGE------");
        if (s != null) {
            s.info();
        }else {
            System.out.println("Komponen tidak terpasang");
        }
        System.out.println("------POWER SUPPLY------");
        if (ps != null) {
            ps.info();
        }else {
            System.out.println("Komponen tidak terpasang");
        }
        System.out.println("------SKOR BENCHMARK TOTAL------");
        System.out.println(hitungSkorBenchmark());
        System.out.println("----------------------------------------------------");

    }

}
