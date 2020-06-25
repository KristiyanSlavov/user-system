package com.westernacher.training.usersystem.repository;

import com.westernacher.training.usersystem.model.entity.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used for communication with MongoDB.
 * It uses the {@link MongoRepository} methods for this purpose.
 *
 * @author Kristiyan SLavov
 */

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, Long> {
}
