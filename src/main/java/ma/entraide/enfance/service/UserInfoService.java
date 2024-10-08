package ma.entraide.enfance.service;



import ma.entraide.enfance.repository.UserInfoRepository;
import ma.entraide.enfance.entity.Province;
import ma.entraide.enfance.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProvinceService provinceService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByEmail(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
    }
    public String addUser(UserInfo userInfo){
        String password = userInfo.getPassword();
        String email = userInfo.getEmail();
        if(password == null )
        {
            throw new IllegalArgumentException("Password cannot be null");
        }
        else if(password.trim().matches("")){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        else if(password.length()<6){
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        else if (!email.trim().matches("^[a-zA-Z0-9_!#$%&'*+/=?^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        else{
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
        }
    }
    public List<UserInfo> getAllUser(){
         return userInfoRepository.findAll();
    }

    public UserInfo findUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserInfo> userInfoOp = userInfoRepository.findByEmail(email);
        UserInfo userInfo = null;
        if(userInfoOp.isPresent()){
            userInfo = userInfoOp.get();
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
        return userInfo;
    }

    public UserInfo getUserById(Integer id) {
        Optional<UserInfo> userOp = userInfoRepository.findById(id);
        UserInfo user = null;
        if(userOp.isPresent()){
            user = userOp.get();
        }
        else{
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    public String deleteUser(Integer id){
        Optional<UserInfo> userOp = userInfoRepository.findById(id);
        UserInfo user = null;
        if(userOp.isPresent()){
            user = userOp.get();
        }
        else{
            throw new ResourceNotFoundException("User not found");
        }
        userInfoRepository.deleteById(user.getId());
        return "User deleted successfully";
    }

    public String updateUser(Integer id,UserInfo updatedUserInfo){
            Province province = provinceService.getProvinceById(updatedUserInfo.getProvince().getId());
            Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(id);
            if (!optionalUserInfo.isPresent()) {
                throw new ResourceNotFoundException("User not found");
            }
                String pwd = updatedUserInfo.getPassword();
                if(pwd == null || pwd.trim().equals("") || pwd.length()<6){
                    throw new IllegalArgumentException("password is too short or empty");
                } else if (!updatedUserInfo.getEmail().trim().matches("^[a-zA-Z0-9_!#$%&'*+/=?^.-]+@[a-zA-Z0-9.-]+$")) {
                    throw new IllegalArgumentException("email format invalid");
                }
                UserInfo existingUser = optionalUserInfo.get();
                existingUser.setName(updatedUserInfo.getName());
                existingUser.setEmail(updatedUserInfo.getEmail());
                existingUser.setRoles(updatedUserInfo.getRoles());
                existingUser.setProvince(province);
                existingUser.setPassword(passwordEncoder.encode(updatedUserInfo.getPassword())); // Update password

                // Save the updated user
                userInfoRepository.save(existingUser);
                return "User updated successfully";
            }
    public int getUsersCountByRegion(Long regionId) {
        return userInfoRepository.countUsersByRegionId(regionId);
    }

    public int getUsersCountByProvince(Long provinceId) {
        return userInfoRepository.countUsersByProvinceId(provinceId);
    }

    public Object dashboard() {
        Object data = new Object() {
            // Par région
            public int nbrUsersRegion1 = getUsersCountByRegion(1L); // Exemple pour la région avec id 1
            public int nbrUsersRegion2 = getUsersCountByRegion(2L); // Exemple pour la région avec id 2

            // Par province
            public int nbrUsersProvince1 = getUsersCountByProvince(1L); // Exemple pour la province avec id 1
            public int nbrUsersProvince2 = getUsersCountByProvince(2L); // Exemple pour la province avec id 2

            public int totalUsers = nbrUsersRegion1 + nbrUsersRegion2 + nbrUsersProvince1 + nbrUsersProvince2; // Total (peut être calculé de manière dynamique)
        };
        return data;
    }


}
