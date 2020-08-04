package com.textcalculator.textcalculator.service;

import com.textcalculator.textcalculator.model.MathematicalOperation;
import com.textcalculator.textcalculator.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

@Slf4j
@Service
public class MathematicalOperationService {

    public String run(String path) {
        LinkedList<MathematicalOperation> list = FileUtils.readFile(path);
        String result = null;

        if (list.size() == 0)
            log.error("Empty file");
        else{
            result = calculateOperations(list).toString();
            log.info(result);
        }

        return result;
    }

    private BigDecimal calculateOperations(LinkedList<MathematicalOperation> operations) {
        BigDecimal result = operations.getLast().getValue();

        for (MathematicalOperation mo : operations) {
            result = chooseOperation(result, mo);
        }

        return divideOperation(result, BigDecimal.ONE);
    }

    private BigDecimal chooseOperation(BigDecimal result, MathematicalOperation operation) {
        switch (operation.getOperation()) {
            case ADD:
                return addOperation(result, operation.getValue());
            case SUBTRACT:
                return subtractOperation(result, operation.getValue());
            case MULTIPLY:
                return multiplyOperation(result, operation.getValue());
            case DIVIDE:
                return divideOperation(result, operation.getValue());
            case POWER:
                return powerOperation(result, operation.getValue());
            case APPLY:
            default:
                return result;
        }
    }

    private BigDecimal addOperation(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    private BigDecimal subtractOperation(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    private BigDecimal multiplyOperation(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    private BigDecimal divideOperation(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0){
            log.error("Cannot divide by zero. Operation omitted.");
            return a;
        }
        return a.divide(b, 5, RoundingMode.HALF_EVEN);
    }

    private BigDecimal powerOperation(BigDecimal a, BigDecimal b) {
        return a.pow(Integer.parseInt(String.valueOf(b)));
    }
}
