package HocSinh.demo.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "lops")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lopId;
    @Column(name = "tenlop")
    @Size(max = 10, message = "ten lop khong duoc qua 10 ky tu")
    private String tenLop;
    @Column(name = "siso")
    private int siSo;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lop")
    @JsonManagedReference
    private Set<HocSinh> hocSinhs;

    public int getLopId() {
        return lopId;
    }

    public void setLopId(int lopId) {
        this.lopId = lopId;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public Set<HocSinh> getHocSinhs() {
        return hocSinhs;
    }

    public void setHocSinhs(Set<HocSinh> hocSinhs) {
        this.hocSinhs = hocSinhs;
    }
}
