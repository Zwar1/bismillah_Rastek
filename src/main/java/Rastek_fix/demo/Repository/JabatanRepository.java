package Rastek_fix.demo.Repository;


import Rastek_fix.demo.Entity.JabatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JabatanRepository extends JpaRepository<JabatanEntity, Long> {
    Optional<JabatanEntity> findFirstById(Long id);
}
