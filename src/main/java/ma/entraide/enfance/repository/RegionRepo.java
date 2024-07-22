package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> ,
        PagingAndSortingRepository<Region, Long> {

}
