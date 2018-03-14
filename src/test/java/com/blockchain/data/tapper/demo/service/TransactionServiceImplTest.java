package com.blockchain.data.tapper.demo.service;

import com.blockchain.data.tapper.demo.entity.UnspentTransactionBatchResponse;
import com.blockchain.data.tapper.demo.entity.UnspentTransactionResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;

    @Test
    public void getUnSpentTransactions() {
        UnspentTransactionResponse unspentTransactionResponse1 = transactionService.getUnSpentTransactions("1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr");
        Assert.assertEquals(unspentTransactionResponse1.getStatus().toString(), "200");
        UnspentTransactionResponse unspentTransactionResponse2 = transactionService.getUnSpentTransactions("1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2");
        Assert.assertEquals(unspentTransactionResponse2.getStatus().toString(), "500");
        Assert.assertEquals(unspentTransactionResponse2.getMessage(), "Invalid Bitcoin Address");
    }

    @Test
    public void getUnSpentTransactionBatch() {
        UnspentTransactionBatchResponse unspentTransactionBatchResponse =
                transactionService.getUnSpentTransactionBatch(
                        "1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr",
                        "1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2",
                        "1A8JiWcwvpY7tAopUkSnGuEYHmzGYfZPiq");
        
        Assert.assertEquals(unspentTransactionBatchResponse.getResults().get("1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr").getStatus().toString(), "200");
        Assert.assertEquals(unspentTransactionBatchResponse.getResults().get("1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2").getStatus().toString(), "500");
        Assert.assertEquals(unspentTransactionBatchResponse.getResults().get("1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2").getMessage(), "Invalid Bitcoin Address");
        Assert.assertEquals(unspentTransactionBatchResponse.getResults().get("1A8JiWcwvpY7tAopUkSnGuEYHmzGYfZPiq").getStatus().toString(), "200");
    }
}