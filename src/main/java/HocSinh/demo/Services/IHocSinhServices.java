package HocSinh.demo.Services;

import HocSinh.demo.Models.HocSinh;
import HocSinh.demo.Models.Lop;

public interface IHocSinhServices {
    public HocSinh them1HocSinhVao1Lop(HocSinh hs);
    public HocSinh suaHocSinh(HocSinh hocSinhSua);
    public HocSinh xoaHocSinh(int hocSinhId);
    public HocSinh chuyenLop(HocSinh hocSinh, Lop lopMoi);
}
