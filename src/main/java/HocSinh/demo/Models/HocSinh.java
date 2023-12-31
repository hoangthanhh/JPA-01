package HocSinh.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "hocsinhs")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hocSinhId;
    @Column(name = "lopid")
    private int lopId;
    @ManyToOne()
    @JoinColumn(name = "lopid",insertable = false,updatable = false)
    @JsonBackReference
    private Lop lop;
    @Column(name = "hoten")
    @Size(min = 2, max = 20, message = "ho ten khong duoc qua 20 ky tu, co it nhat 2 tu")
    private String hoTen;
    @Column(name = "namsinh")
    private LocalDate namSinh;
    @Column(name = "quequan")
    private String queQuan;

    public int getHocSinhId() {
        return hocSinhId;
    }

    public void setHocSinhId(int hocSinhId) {
        this.hocSinhId = hocSinhId;
    }

    public int getLopId() {
        return lopId;
    }

    public void setLopId(int lopId) {
        this.lopId = lopId;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(LocalDate namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
}
