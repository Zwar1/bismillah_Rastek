package Rastek_fix.demo.Repository;


import Rastek_fix.demo.Entity.DivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DivisionRepository extends JpaRepository<DivisionEntity, Long> {
    Optional<DivisionEntity> findFirstById(Long id);
}
