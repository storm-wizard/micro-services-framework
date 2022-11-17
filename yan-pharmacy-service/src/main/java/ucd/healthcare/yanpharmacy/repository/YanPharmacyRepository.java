package ucd.healthcare.yanpharmacy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ucd.healthcare.yanpharmacy.model.Medicine;

@Repository
public interface YanPharmacyRepository extends JpaRepository<Medicine, Integer> {
    Optional<Medicine> findByName(String name);

    @Query("select * from medicine where name in (:names)")
    List<Medicine> findByNames(@Param("names") List<String> names);
}
