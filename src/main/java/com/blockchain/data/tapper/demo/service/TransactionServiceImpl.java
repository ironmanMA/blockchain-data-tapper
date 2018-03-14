package com.blockchain.data.tapper.demo.service;

import com.blockchain.data.tapper.demo.common.TransactionErrorHandler;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionBatchResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionBatchResponseBuilder;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final String serviceEndPoint = "https://blockchain.info/unspent?active=%s";
    private RestTemplate restTemplate;
    private TransactionObjectMapperService transactionObjectMapperService;

    @Autowired
    public TransactionServiceImpl(TransactionObjectMapperService transactionObjectMapperService) {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new TransactionErrorHandler());
        this.transactionObjectMapperService = transactionObjectMapperService;

    }

    @Override
    public UnspentTransactionResponse getUnSpentTransactions(String address) {
        if (address.isEmpty()) {
            return UnspentTransactionResponseBuilder.anUnspentTransactionResponse()
                    .withStatus(HttpStatus.SERVICE_UNAVAILABLE)
                    .withMessage("INVALID ADDRESS").build();
        }
        String urlFormatted = String.format(serviceEndPoint, address);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(urlFormatted, HttpMethod.GET, request, String.class);
        return transactionObjectMapperService.constructUnspentTransactionResponse(response.getStatusCode(), response.getBody());
    }

    @Override
    public UnspentTransactionBatchResponse getUnSpentTransactionBatch(String... address) {
        UnspentTransactionBatchResponseBuilder unspentTransactionBatchResponseBuilder =
                UnspentTransactionBatchResponseBuilder.anUnspentTransactionBatchResponse();

        /*
         * can use thread pool service for faster proc.
         * */
        for (String bitcoinAddress : address) {
            unspentTransactionBatchResponseBuilder.withResult(bitcoinAddress, getUnSpentTransactions(bitcoinAddress));
        }

        return unspentTransactionBatchResponseBuilder.build();
    }
}
