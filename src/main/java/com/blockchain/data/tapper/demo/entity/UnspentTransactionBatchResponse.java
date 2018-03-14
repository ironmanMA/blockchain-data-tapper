package com.blockchain.data.tapper.demo.entity;

import java.util.Map;

public class UnspentTransactionBatchResponse {
    Map<String, UnspentTransactionResponse> results;

    public Map<String, UnspentTransactionResponse> getResults() {
        return results;
    }

    public void setResults(Map<String, UnspentTransactionResponse> results) {
        this.results = results;
    }

}
