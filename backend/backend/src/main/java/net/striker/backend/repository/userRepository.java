package net.striker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.striker.backend.model.user;


@Repository
public interface userRepository extends JpaRepository<user,Long>{

}
