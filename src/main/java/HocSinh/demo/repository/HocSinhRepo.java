package HocSinh.demo.repository;

import HocSinh.demo.Models.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepo extends JpaRepository<HocSinh,Integer> {
}
