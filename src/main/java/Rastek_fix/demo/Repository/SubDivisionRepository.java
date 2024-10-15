package Rastek_fix.demo.Repository;


import Rastek_fix.demo.Entity.SubDivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubDivisionRepository extends JpaRepository<SubDivisionEntity, Long> {
    Optional<SubDivisionEntity> findFirstById(Long id);
}
