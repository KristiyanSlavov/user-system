package com.westernacher.training.usersystem.service.listener;

import com.westernacher.training.usersystem.model.entity.UserAccount;
import com.westernacher.training.usersystem.service.idgenerator.DatabaseSequenceGenerator;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for setting the user account'
 * id field every time a new instance of our entity class is created.
 * For this purpose, it uses the onBeforeConvert method from
 * the {@link AbstractMongoEventListener} class and a {@link DatabaseSequenceGenerator}
 * instance which will generate the id and set it to the new record.
 *
 * @author Kristiyan SLavov
 */
@Service
public class UserAccountModelListener extends AbstractMongoEventListener<UserAccount> {

    private DatabaseSequenceGenerator databaseSequenceGenerator;

    public UserAccountModelListener(DatabaseSequenceGenerator databaseSequenceGenerator) {
        this.databaseSequenceGenerator = databaseSequenceGenerator;
    }

    /**
     * This method uses {@link DatabaseSequenceGenerator#generateSequence}
     * to generate an id for every new record (user account).
     *
     * @param event - the event that contains the record (user account)
     *              for which will generate an id.
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<UserAccount> event) {
        if(event.getSource().getId() == null) {
            event.getSource().setId(databaseSequenceGenerator.generateSequence(UserAccount.SEQUENCE_NAME));
        }
    }
}
