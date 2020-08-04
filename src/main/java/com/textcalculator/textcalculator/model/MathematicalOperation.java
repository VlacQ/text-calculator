package com.textcalculator.textcalculator.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MathematicalOperation {

    @Getter
    private EMathematicalOperation operation;

    @Getter
    private BigDecimal value;

    public MathematicalOperation(String line)  {
        String[] mathOp = line.split(" ");
        this.operation = validateMathematicalOperation(mathOp[0]);
        this.value = new BigDecimal(mathOp[1]);
    }

    private EMathematicalOperation validateMathematicalOperation(String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return EMathematicalOperation.ADD;
            case "subtract":
                return EMathematicalOperation.SUBTRACT;
            case "multiply":
                return EMathematicalOperation.MULTIPLY;
            case "divide":
                return EMathematicalOperation.DIVIDE;
            case "power":
                return EMathematicalOperation.POWER;
            case "apply":
                return EMathematicalOperation.APPLY;
            default:
                return null;
        }
    }
}
