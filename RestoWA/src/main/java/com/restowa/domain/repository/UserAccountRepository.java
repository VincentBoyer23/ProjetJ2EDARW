
package com.restowa.domain.repository;

import com.restowa.domain.model.UserAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    
    @Query("SELECT u FROM UserAccount u WHERE email=:email AND password=:password")
    public List<UserAccount> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
    
    @Query("SELECT count(*) FROM UserAccount u WHERE email=:email AND password=:password")
    public List<Long> checkByEmailAndPassword(@Param("email") String email,@Param("password") String password);
    
    @Query("SELECT u FROM UserAccount u WHERE authkey=:authkey")
    public List<UserAccount> findByAuthKey(@Param("authkey") String authKey);
    
}
