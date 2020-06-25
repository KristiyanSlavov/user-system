package com.westernacher.training.usersystem.service.idgenerator;

import com.westernacher.training.usersystem.model.dbsequence.DatabaseSequence;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * This class is responsible for generating
 * the auto-incremented value that will be used
 * as id for our entities.
 *
 * @author Kristiyan SLavov
 */
@Service
public class DatabaseSequenceGenerator {

    private static final String SEQUENCE_KEY = "sequence";

    private MongoOperations mongoOperations;

    public DatabaseSequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    /**
     * This method is used fo generating an id for every
     * new record (user account) that will be inserted into the database.
     *
     * @param sequenceName
     * @return - the new auto-generated id
     */
    public long generateSequence(String sequenceName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(sequenceName)),
                new Update().inc(SEQUENCE_KEY, 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);

        return !Objects.isNull(counter) ? counter.getSequence() : 1;
    }
}
