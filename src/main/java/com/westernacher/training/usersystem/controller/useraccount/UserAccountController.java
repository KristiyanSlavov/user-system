package com.westernacher.training.usersystem.controller.useraccount;

import com.westernacher.training.usersystem.model.dto.UserAccountDto;
import com.westernacher.training.usersystem.model.exception.UserAccountDuplicateKeyException;
import com.westernacher.training.usersystem.model.exception.UserAccountNotFoundException;
import com.westernacher.training.usersystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Kristiyan SLavov
 */
@RestController
@RequestMapping("/accounts")
public class UserAccountController {

    private UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccountDto> getById(@PathVariable Long id) throws UserAccountNotFoundException {
        return ResponseEntity.ok(userAccountService.getById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserAccountDto>> getAll() throws UserAccountNotFoundException {
        return ResponseEntity.ok(userAccountService.getAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccountDto> insert(@RequestBody UserAccountDto userAccountDto) throws UserAccountDuplicateKeyException {
        return new ResponseEntity<>(userAccountService.insert(userAccountDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccountDto> update(@RequestBody UserAccountDto userAccountDto,
                                                 @PathVariable Long id) {
        return ResponseEntity.ok(userAccountService.update(userAccountDto, id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable Long id) throws UserAccountNotFoundException{
        userAccountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
