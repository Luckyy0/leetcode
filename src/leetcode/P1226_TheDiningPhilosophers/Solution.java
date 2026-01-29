package leetcode.P1226_TheDiningPhilosophers;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Resource Hierarchy: Pick smaller index first
        int first = Math.min(leftFork, rightFork);
        int second = Math.max(leftFork, rightFork);

        forks[first].acquire();
        forks[second].acquire();

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forks[second].release();
            forks[first].release();
        }
    }
}
