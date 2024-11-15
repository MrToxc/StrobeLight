package com.example;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.*;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import java.time.Instant;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Initialize Pi4J context
        Context pi4j = Pi4J.newAutoContext();

        // Configure the digital output pin
        DigitalOutputConfig config = DigitalOutput.newConfigBuilder(pi4j)
                .id("led")
                .name("LED Blinker")
                .address(17) // Use GPIO17; adjust if using a different GPIO pin
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .build();

        // Create the digital output instance
        DigitalOutput output = pi4j.create(config);

        System.out.println("LED will blink every second. Press Ctrl+C to exit.");

        // Blink the LED indefinitely
        int counter = 0;

        while (true) {
            counter++;
            System.out.println(counter + " " + Instant.now());
            output.toggle(); // Toggle LED state
            Thread.sleep(500); // Wait for 1 second
        }

    }
}
