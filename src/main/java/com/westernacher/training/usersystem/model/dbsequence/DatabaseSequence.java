package com.westernacher.training.usersystem.model.dbsequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * It's a collection that will store the auto-incremented
 * sequence for other collections. During the creation
 * of a new record, it'll be used to fetch the next value.
 *
 * @author Kristiyan SLavov
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long sequence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
