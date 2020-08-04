package com.textcalculator.textcalculator;

import com.textcalculator.textcalculator.service.MathematicalOperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class TextCalculatorApplication implements CommandLineRunner {

    @Autowired
    private final MathematicalOperationService mos;

    public static void main(String[] args) {
        SpringApplication.run(TextCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Text Calculator started...");
        if (args.length != 0)
            mos.run(args[0]);
        else
            log.info("Missing argument");
    }
}
