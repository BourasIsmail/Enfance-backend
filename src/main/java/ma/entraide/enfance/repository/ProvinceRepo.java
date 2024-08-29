package ma.entraide.enfance.repository;


import ma.entraide.enfance.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Long> ,
        PagingAndSortingRepository<Province, Long> {
    // Compter le nombre d'utilisateurs par province
    @Query("SELECT COUNT(u) FROM UserInfo u WHERE u.province.id = :provinceId")
    int countUsersByProvinceId(@Param("provinceId") Long provinceId);

    // Récupérer toutes les provinces
    @Query("SELECT p FROM Province p WHERE p.region.id = :regionId")
    List<Province> findByRegionId(@Param("regionId") Long regionId);

    @Query("SELECT p FROM Province p WHERE p.name = :name")
    Province findByName(@Param("name") String name);

}
