package HocSinh.demo.repository;

import HocSinh.demo.Models.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepo extends JpaRepository<Lop,Integer> {
}
