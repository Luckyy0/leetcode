package leetcode.P1117_BuildingH2O;

import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

class H2O {
    private Semaphore hSem;
    private Semaphore oSem;
    private CyclicBarrier barrier;

    public H2O() {
        hSem = new Semaphore(2);
        oSem = new Semaphore(1);
        barrier = new CyclicBarrier(3, () -> {
            // Barrier action (optimization: could reset things if needed)
            // But Semaphores handle flow.
            // Wait, if barrier completes, all 3 threads continue.
            // They need to release semaphores in the next cycle?
            // Actually, releasing semaphores inside barrier action is unsafe?
            // Better: Each thread releases its own semaphore slot after crossing barrier?
            // No, semaphore allows new threads to enter.
            // We want to release AFTER work is done.
            hSem.release(2);
            oSem.release(1);
        });
        // Initial permits are 2 and 1. So 3 threads enter.
        // They wait at barrier. Once 3 arrive, barrier trips.
        // Action releases permits. So next 3 can enter.
        // Wait, initial permits are ALREADY available.
        // If barrier releases MORE, we have 4 permits?
        // Correction: Initialize barrier action to NOT release.
        // Threads acquire, do work, wait barrier.
        // But how do NEXT threads enter?
        // Someone must release.
        // If we release in barrier action, we restore the 2H, 1O capacity.
        // But initial state is 2H, 1O.
        // So first group consumes permits. Barrier refills them. Correct.
        // BUT: barrier action runs in ONE of the threads.
        // hSem.release(2) adds 2 permits. oSem.release(1) adds 1.
        // Initial state: permits available.
        // Group 1: 2H acquire, 1O acquire. Permits 0, 0.
        // Barrier trips. Permits become 2, 1.
        // Group 2 enters.
        // Looks correct.

        // One issue: initial permits is correct. But barrier action releases permits
        // BEFORE threads exit barrier?
        // Yes, barrier action runs before await returns.
        // Is it possible for a new H to acquire permit before old H returns from await?
        // Yes.
        // Is that a problem? "release h2o". Order of printing doesn't matter as long as
        // grouped.
        // But output must be HHO HHO.
        // If H1 prints, waits. H2 prints, waits. O prints, waits.
        // Barrier trips. Permits available.
        // H3 acquires. Prints.
        // Output: H H O H...
        // Valid.
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        // To ensure grouping in output might need finer locking, but usually HHO is
        // flexible (e.g. HOH).
        // LeetCode accepts: "HHO", "HOH", "OHH", etc.
        // Just need consistency of counts.
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }

    // Correction:
    // If I put print AFTER barrier, they print essentially simultaneously.
    // If I put print BEFORE barrier, they print as they arrive.
    // The requirement: "The code ... must guarantee that for every 2 H threads ...
    // 1 O thread".
    // Printing before or after: if after, they are grouped in time.
    // Let's print BEFORE barrier to simulate "doing work" then syncing?
    // Actually, standard solution prints inside the method.
    // Let's try printing before barrier.

    // BUT: Using barrier action to release permits works.
    // However, I constructed H2O above.
    // Let's fix constructor initialization:
    // We cannot define barrier logic inside constructor referencing instance fields
    // easily if fields not init.
    // Move barrier init to end or use local vars.
}
