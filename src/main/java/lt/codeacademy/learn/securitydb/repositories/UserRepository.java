package lt.codeacademy.learn.securitydb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.learn.securitydb.entities.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {

	MyUser findByUsername(String username);
}
