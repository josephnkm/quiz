package com.nakarmi.mcq.repository;

import com.nakarmi.mcq.entity.MCQDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCQRepository extends MongoRepository<MCQDocument, String> {

}

