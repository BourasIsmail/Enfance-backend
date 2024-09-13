package ma.entraide.enfance.repository;


import ma.entraide.enfance.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> ,
        PagingAndSortingRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String name);

    Optional<UserInfo> findByEmail(String email);

    @Query("SELECT COUNT(u) FROM UserInfo u WHERE u.province.id = :provinceId")
    int countUsersByProvinceId(@Param("provinceId") Long provinceId);

    @Query("SELECT COUNT(u) FROM UserInfo u WHERE u.province.region.id = :regionId")
    int countUsersByRegionId(@Param("regionId") Long regionId);

    @Query("SELECT COUNT(u) FROM UserInfo u")
    int countAllUsers();




}
