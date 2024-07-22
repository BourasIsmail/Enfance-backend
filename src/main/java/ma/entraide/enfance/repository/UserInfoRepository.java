package ma.entraide.enfance.repository;


import ma.entraide.enfance.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> ,
        PagingAndSortingRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String name);

    Optional<UserInfo> findByEmail(String email);



}
