package com.javabackendakademisi.freelancerMatchingPlatform.repository;

import com.javabackendakademisi.freelancerMatchingPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
