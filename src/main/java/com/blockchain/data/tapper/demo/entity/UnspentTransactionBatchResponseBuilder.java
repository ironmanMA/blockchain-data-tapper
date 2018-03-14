package com.blockchain.data.tapper.demo.entity;

import java.util.HashMap;
import java.util.Map;

public final class UnspentTransactionBatchResponseBuilder {
    Map<String, UnspentTransactionResponse> results;

    private UnspentTransactionBatchResponseBuilder() {
        results = new HashMap<>();
    }

    public static UnspentTransactionBatchResponseBuilder anUnspentTransactionBatchResponse() {
        return new UnspentTransactionBatchResponseBuilder();
    }

    public UnspentTransactionBatchResponseBuilder withResults(Map<String, UnspentTransactionResponse> results) {
        this.results = results;
        return this;
    }

    public UnspentTransactionBatchResponseBuilder withResult(String address, UnspentTransactionResponse output) {
        this.results.put(address, output);
        return this;
    }

    public UnspentTransactionBatchResponse build() {
        UnspentTransactionBatchResponse unspentTransactionBatchResponse = new UnspentTransactionBatchResponse();
        unspentTransactionBatchResponse.setResults(results);
        return unspentTransactionBatchResponse;
    }
}
