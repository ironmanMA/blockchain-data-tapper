package com.blockchain.data.tapper.demo.service;

import com.blockchain.data.tapper.demo.entity.UnspentTransactionBatchResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;

public interface TransactionService {
    /*
     * Given a bitcoin address, return all getUnSpentTransactions
     * */
    UnspentTransactionResponse getUnSpentTransactions(String address);

    /*
     * Given a batch of bitcoin addresses, return all getUnSpentTransactions w.r.t each address
     * */
    UnspentTransactionBatchResponse getUnSpentTransactionBatch(String... address);
}
