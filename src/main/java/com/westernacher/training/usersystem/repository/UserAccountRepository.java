package com.westernacher.training.usersystem.repository;

import com.westernacher.training.usersystem.model.entity.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This interface is used for communication with MongoDB.
 * It uses the {@link MongoRepository} methods for this purpose.
 *
 * @author Kristiyan SLavov
 */

@CrossOrigin
@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, Long> {
}
