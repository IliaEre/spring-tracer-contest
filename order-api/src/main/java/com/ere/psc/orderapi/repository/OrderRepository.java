package com.ere.psc.orderapi.repository;

import com.ere.psc.orderapi.model.dto.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDocument, String> {}
