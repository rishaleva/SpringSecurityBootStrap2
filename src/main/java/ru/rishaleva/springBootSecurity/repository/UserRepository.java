package ru.rishaleva.springBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rishaleva.springBootSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
