package karmo.exercise.controller;

import karmo.exercise.Transfer;
import karmo.exercise.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @CrossOrigin
    @PutMapping("restricted/transfer")
    public String transferMoney (@RequestBody Transfer transfer){

        return transactionsService.transferMoney(transfer);
    }
}
