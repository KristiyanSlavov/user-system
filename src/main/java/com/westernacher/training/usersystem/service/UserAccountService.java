package com.westernacher.training.usersystem.service;

import com.westernacher.training.usersystem.model.entity.UserAccount;
import com.westernacher.training.usersystem.model.exception.UserAccountNotFoundException;
import com.westernacher.training.usersystem.repository.UserAccountRepository;
import org.springframework.stereotype.Service;


/**
 * @author Kristiyan SLavov
 */
@Service
public class UserAccountService {

    private UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount getById(Long id) throws UserAccountNotFoundException {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new UserAccountNotFoundException("This user account is not found"));
    }
}
