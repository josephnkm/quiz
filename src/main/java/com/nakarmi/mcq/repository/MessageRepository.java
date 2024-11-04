package com.nakarmi.mcq.repository;

import com.nakarmi.mcq.entity.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<MessageDocument, String> {

}

