package com.java.interview.designPatterns.creationalPattern.builderPattern.breaking;

import com.java.interview.designPatterns.creationalPattern.builderPattern.implementation.Burger;
import com.java.interview.designPatterns.creationalPattern.builderPattern.implementation.BurgerBuilder;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

/**
 * Demonstrates how Builder can be misused / broken:
 * 1) Build incomplete burger (no validation)
 * 2) Reuse the same builder across threads -> race condition
 * 3) Use reflection to bypass builder or create object in unexpected way
 */
public class BuilderBreaking {

    public static void main(String[] args) throws Exception {
        System.out.println("=== 1) Incomplete build (no validation) ===");
        incompleteBuild();

        System.out.println("\n=== 2) Reusing builder across threads (race) ===");
        builderRaceCondition();

        System.out.println("\n=== 3) Reflection bypass of builder ===");
        reflectionBypass();
    }

    // 1) Build without setting mandatory fields
    private static void incompleteBuild() {
        Burger emptyBurger = new BurgerBuilder().build(); // bun & patty likely null
        System.out.println("Incomplete Burger: " + emptyBurger);
    }

    // 2) Reuse same builder in two threads and build -> unpredictable final burger
    private static void builderRaceCondition() throws InterruptedException {
        final BurgerBuilder shared = new BurgerBuilder();
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            shared.setBun("sesame").setPatty("chicken").addCheese(true);
            // simulate work
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            Burger b = shared.build();
            System.out.println("Thread-1 built: " + b);
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            shared.setBun("brioche").setPatty("double beef").addMayo(true);
            // simulate work
            try { Thread.sleep(10); } catch (InterruptedException ignored) {}
            Burger b = shared.build();
            System.out.println("Thread-2 built: " + b);
            latch.countDown();
        });

        t1.start();
        t2.start();
        latch.await();
        // You will likely see two different burgers produced from same builder due to race
    }

    // 3) Reflection: invoke Burger's private constructor directly (bypasses builder guarantees)
    private static void reflectionBypass() throws Exception {
        // Create a "minimal" Burger.Builder instance via the public nested builder
        Burger.Builder workerBuilder = new Burger.Builder()
                .setBun("plain-reflect")
                .setPatty("reflect-patty");

        // Now obtain Burger's (private) constructor that accepts Builder
        Constructor<Burger> ctor = Burger.class.getDeclaredConstructor(Burger.Builder.class);
        ctor.setAccessible(true); // bypass private
        // Directly create a Burger instance using reflection (bypasses any validation that might exist in SafeBuilder)
        Burger hacked = ctor.newInstance(workerBuilder);

        System.out.println("Reflection-created Burger: " + hacked);
    }
}
