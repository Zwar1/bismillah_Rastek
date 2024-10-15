package Rastek_fix.demo.Repository;

import Rastek_fix.demo.Entity.RiwayatJabatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiwayatJabatanRepository extends JpaRepository<RiwayatJabatanEntity, Long> {

}
