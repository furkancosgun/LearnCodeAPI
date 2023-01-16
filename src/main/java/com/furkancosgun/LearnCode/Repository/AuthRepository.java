package com.furkancosgun.LearnCode.Repository;

import com.furkancosgun.LearnCode.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User,Long> {
}
