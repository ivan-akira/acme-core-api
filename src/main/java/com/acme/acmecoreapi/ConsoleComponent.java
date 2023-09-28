package com.acme.acmecoreapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleComponent implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    // ref: https://stackoverflow.com/a/24271946/5948846
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
