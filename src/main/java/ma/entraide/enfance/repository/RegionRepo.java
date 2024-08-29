package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long>, PagingAndSortingRepository<Region, Long> {

    @Query("SELECT COUNT(u) FROM UserInfo u WHERE u.province.region.id = :regionId")
    int countUsersByRegionId(@Param("regionId") Long regionId);

    @Query("SELECT r FROM Region r WHERE r.name = :name")
    Region findByName(@Param("name") String name);

    @Override
    List<Region> findAll();

    @Query("SELECT r FROM Region r")
    List<Region> findAllRegions();

    @Query("SELECT COUNT(r) FROM Region r")
    int countRegions();
}

