package com.conversantmedia;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by jcairns on 1/15/16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(Run.FORK)
@Warmup(iterations=Run.WARM_ITER)
@Measurement(iterations = Run.MEAS_ITER)
public class LinkedTransferQueueBenchmark {

    private ExecutorService executor;
    private BlockingQueue<Long> msgQueue;

    private final Runnable addTask = () -> {
        try {
            for(int i = 0; i<Run.OFFER_COUNT; i++) {
                while(!msgQueue.offer(Run.LONGVAL, 1, TimeUnit.MICROSECONDS)) {
                    Thread.yield();
                }
            }
        } catch(InterruptedException ex) {
            throw new RuntimeException("Fail!");
        }
    };

    @Setup
    public void setup() {
        executor = Executors.newFixedThreadPool(Run.NTHREAD);
        msgQueue = new LinkedTransferQueue<>();
    }

    @Benchmark
    public void sendOneM() {
        executor.execute(addTask);

        try {
            for(int i=0; i<Run.OFFER_COUNT; i++) {
                while(msgQueue.poll(1, TimeUnit.MICROSECONDS) != Run.LONGVAL) {
                    Thread.yield();
                }
            }
        } catch(InterruptedException ex) {
            throw new RuntimeException("Fail!");
        }
    }

    @TearDown
    public void tearDown() {
        executor.shutdown();
    }
}
