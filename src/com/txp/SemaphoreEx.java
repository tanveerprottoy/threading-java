package com.txp;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    // max 4
    static Semaphore semaphore = new Semaphore(4);

    static class SemaphoreThread extends Thread {

        String name = "";

        SemaphoreThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available com.txp.Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available com.txp.Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available com.txp.Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}