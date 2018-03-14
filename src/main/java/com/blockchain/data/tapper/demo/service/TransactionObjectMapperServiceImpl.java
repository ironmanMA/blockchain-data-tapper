package com.blockchain.data.tapper.demo.service;

import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponseBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TransactionObjectMapperServiceImpl implements TransactionObjectMapperService {
    private ObjectMapper objectMapper;
    private static final String SUCCESS = "SUCCESS";
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionObjectMapperServiceImpl.class);

    public TransactionObjectMapperServiceImpl() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public UnspentTransactionResponse constructUnspentTransactionResponse(HttpStatus statusCode,
                                                                          String responseBodyAsString) {
        try {
            switch (statusCode) {
                case OK:
                    UnspentTransactionResponse unspentTransactionResponse
                            = objectMapper.readValue(responseBodyAsString, UnspentTransactionResponse.class);
                    unspentTransactionResponse.setStatus(statusCode);
                    unspentTransactionResponse.setMessage(SUCCESS);
                    return unspentTransactionResponse;
                default:
                    return UnspentTransactionResponseBuilder.anUnspentTransactionResponse()
                            .withStatus(statusCode)
                            .withMessage(responseBodyAsString)
                            .build();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return UnspentTransactionResponseBuilder.anUnspentTransactionResponse()
                    .withStatus(HttpStatus.SERVICE_UNAVAILABLE)
                    .withMessage(e.getMessage())
                    .build();
        }
    }
}
