package ru.javamentor.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javamentor.springboot.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
