package br.com.voisinonline.login.repository;

import br.com.voisinonline.login.model.User;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByMail(String mail);
}