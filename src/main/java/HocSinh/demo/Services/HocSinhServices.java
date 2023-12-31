package HocSinh.demo.Services;

import HocSinh.demo.Models.HocSinh;
import HocSinh.demo.Models.Lop;
import HocSinh.demo.repository.HocSinhRepo;
import HocSinh.demo.repository.LopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HocSinhServices implements IHocSinhServices{
    @Autowired
    private HocSinhRepo hocSinhRepo;
    @Autowired
    private LopRepo lopRepo;

    @Override
    public HocSinh them1HocSinhVao1Lop(HocSinh hs) {
        Optional<Lop> lop = lopRepo.findById(hs.getLop().getLopId());
        if (lop.isEmpty()) {
            return null;
        }
        Lop lop1 = new Lop();
        lop1 = lop.get();
        if (lop1.getSiSo() < 20) {
            hocSinhRepo.save(hs);
            lop1.setSiSo(lop1.getSiSo()+1);
            lopRepo.save(lop1);
            return hs;
        }
        return null;
    }

    @Override
    public HocSinh suaHocSinh(HocSinh hocSinhSua) {
        Optional<HocSinh> hocSinh = hocSinhRepo.findById(hocSinhSua.getHocSinhId());
        if (hocSinh.isEmpty()){
            return null;
        }
        HocSinh hs = hocSinh.get();
        hs.setHoTen(hocSinhSua.getHoTen());
        hs.setNamSinh(hocSinhSua.getNamSinh());
        hs.setQueQuan(hocSinhSua.getQueQuan());
        hocSinhRepo.save(hs);
        return hs;
    }

    @Override
    public HocSinh xoaHocSinh(int hocSinhId) {
        Optional<HocSinh> hocSinhOptional = hocSinhRepo.findById(hocSinhId);
        HocSinh hocSinh =hocSinhOptional.orElseThrow(()-> new RuntimeException("Khong tim thay hoc sinh"));
        if(hocSinh != null){
            Lop lop = hocSinh.getLop();
            if (lop != null) {
                lop.setSiSo(lop.getSiSo()-1);
                lopRepo.save(lop);
            }
            hocSinhRepo.delete(hocSinh);
        }
        return hocSinh;
    }


    @Override
    public HocSinh chuyenLop(HocSinh hocSinh, Lop lopMoi) {
        // Kiểm tra xem học sinh đang thuộc lớp nào
        Lop lopCu = hocSinh.getLop();

        // Kiểm tra nếu học sinh đã có lớp và lớp mới không phải là lớp cũ
        if (lopCu != null && !lopCu.equals(lopMoi)) {
            // Kiểm tra sĩ số của lớp mới
            if (lopMoi.getSiSo() < 20) {
                // Cập nhật sĩ số của lớp cũ và lớp mới
                lopCu.setSiSo(lopCu.getSiSo() - 1);
                lopMoi.setSiSo(lopMoi.getSiSo() + 1);

                // Chuyển học sinh sang lớp mới
                hocSinh.setLop(lopMoi);

                // Lưu các thay đổi vào cơ sở dữ liệu
                hocSinhRepo.save(hocSinh);

                return hocSinh;
            }
        }
        return null; // Học sinh không thuộc lớp nào hoặc lớp mới giống lớp cũ
    }
}
