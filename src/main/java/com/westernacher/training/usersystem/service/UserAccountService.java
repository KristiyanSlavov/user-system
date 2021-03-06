package com.westernacher.training.usersystem.service;

import com.westernacher.training.usersystem.model.dto.UserAccountDto;
import com.westernacher.training.usersystem.model.entity.UserAccount;
import com.westernacher.training.usersystem.model.exception.UserAccountDuplicateKeyException;
import com.westernacher.training.usersystem.model.exception.UserAccountNotFoundException;
import com.westernacher.training.usersystem.repository.UserAccountRepository;
import com.westernacher.training.usersystem.service.mapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Kristiyan SLavov
 */
@Service
public class UserAccountService {

    private UserAccountRepository userAccountRepository;

    private ObjectMapper objectMapper;

    private static final String USER_ACCOUNT_NOT_FOUND_MSG = "User account is not found";
    private static final String DUPLICATE_RECORDS_MSG = "Duplicate records";

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository, ObjectMapper objectMapper) {
        this.userAccountRepository = userAccountRepository;
        this.objectMapper = objectMapper;
    }

    public UserAccountDto getById(Long id) throws UserAccountNotFoundException {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new UserAccountNotFoundException(USER_ACCOUNT_NOT_FOUND_MSG));

        return objectMapper.map(userAccount, UserAccountDto.class);
    }

    public List<UserAccountDto> getAll() throws UserAccountNotFoundException {
        List<UserAccount> userAccountList = userAccountRepository.findAll();
        if (userAccountList.isEmpty()) {
            throw new UserAccountNotFoundException(USER_ACCOUNT_NOT_FOUND_MSG);
        }
        return objectMapper.mapAll(userAccountList, UserAccountDto.class);
    }

    public UserAccountDto insert(UserAccountDto userAccountDto) throws UserAccountDuplicateKeyException {
        UserAccount userAccount = objectMapper.map(userAccountDto, UserAccount.class);
        if(userAccountRepository.findByEmail(userAccount.getEmail()) != null) {
            throw new UserAccountDuplicateKeyException(DUPLICATE_RECORDS_MSG);
        }

        return objectMapper.map(userAccountRepository.insert(userAccount), UserAccountDto.class);
    }


    public UserAccountDto update(UserAccountDto userAccountDto, Long id) {
        UserAccount userAccount = objectMapper.map(userAccountDto, UserAccount.class);
        UserAccount updatedUserAccount = userAccountRepository.findById(id)
                .map(account -> {
                    account.setFirstName(userAccount.getFirstName());
                    account.setLastName(userAccount.getLastName());
                    account.setEmail(userAccount.getEmail());
                    account.setDateOfBirth(userAccount.getDateOfBirth());
                    return userAccountRepository.save(account);
                })
                .orElseGet(() -> {
                    return userAccountRepository.insert(userAccount);
                });

        return objectMapper.map(updatedUserAccount, UserAccountDto.class);
    }

    public void delete(Long id) throws UserAccountNotFoundException {
        if (userAccountRepository.findById(id).isPresent()) {
            userAccountRepository.deleteById(id);
        } else {
            throw new UserAccountNotFoundException(USER_ACCOUNT_NOT_FOUND_MSG);
        }
    }
}
