package com.blockchain.data.tapper.demo.service;

import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;
import org.springframework.http.HttpStatus;

public interface TransactionObjectMapperService {
    UnspentTransactionResponse constructUnspentTransactionResponse(HttpStatus statusCode,
                                                 String responseBodyAsString);
}
