package com.example.demo.controllers;

import com.example.demo.dto.Total;
import com.example.demo.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class TransactionController {
    public HashMap<Long, Transaction> listTransactions            = new HashMap<Long, Transaction>();


    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public HashMap<Long,Transaction> getAll() {

        return  this.listTransactions;
    }
    @GetMapping(value = "/sum/{parent_id}")
    public Total getSumByParent(@PathVariable Long parent_id) {
        List<Long>  listByType = new ArrayList<>();
        Double sum=0.0;

        Total totalAmount = new Total();
       for (Map.Entry<Long, Transaction> tr : listTransactions.entrySet())
                if(tr.getValue().getParent_id().equals(parent_id))
                    sum = sum+ tr.getValue().getAmount();

        totalAmount.setSum(sum);

        return  totalAmount;
    }
    @GetMapping(value = "/types/{type}")
    public List<Long> getTransactionsByType(@PathVariable String type) {
        List<Long>  listByType = new ArrayList<>();

        for (Map.Entry<Long, Transaction> tr : listTransactions.entrySet())
            if(tr.getValue().getType().equals(type))
                listByType.add(tr.getValue().getTransaction_id());

        return  listByType;
    }
    @PutMapping(value = "/{transaction_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> putTransaction(@PathVariable Long transaction_id, @RequestBody  Transaction transaction) {
         transaction.setTransaction_id(transaction_id);

         listTransactions.put(transaction_id,transaction);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
