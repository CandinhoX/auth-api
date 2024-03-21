package io.github.CandinhoX.authapi.repositories;

import io.github.CandinhoX.authapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
