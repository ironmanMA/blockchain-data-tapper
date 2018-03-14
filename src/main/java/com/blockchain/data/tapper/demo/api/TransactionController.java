package com.blockchain.data.tapper.demo.api;

import com.blockchain.data.tapper.demo.entity.UnspentTransactionBatchResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;
import com.blockchain.data.tapper.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/address/{bitcoinAddress}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UnspentTransactionResponse> unspentTransactionInfo(@PathVariable("bitcoinAddress") String bitcoinAddress) {
        UnspentTransactionResponse unspentTransactionResponse = transactionService.getUnSpentTransactions(bitcoinAddress);
        return new ResponseEntity<>(unspentTransactionResponse, unspentTransactionResponse.getStatus());
    }

    @RequestMapping(value = "/batch/address/{bitcoinAddressBatch}", method = RequestMethod.GET, produces = "application/json")
    public UnspentTransactionBatchResponse unspentTransactionBatchInfo(@PathVariable("bitcoinAddressBatch") String bitcoinAddressBatch) {
        return transactionService.getUnSpentTransactionBatch(bitcoinAddressBatch.split(","));
    }
}
