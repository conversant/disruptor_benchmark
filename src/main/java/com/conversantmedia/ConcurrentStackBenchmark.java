package com.conversantmedia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

import com.conversantmedia.util.concurrent.BlockingStack;
import com.conversantmedia.util.concurrent.ConcurrentStack;

/**
 * Created by jcairns on 1/15/16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(Run.FORK)
@Warmup(iterations=Run.WARM_ITER)
@Measurement(iterations = Run.MEAS_ITER)
public class ConcurrentStackBenchmark {

    private ExecutorService executor;
    private BlockingStack<Long> msgStack;

    private final Runnable addTask = () -> {
        for(int i = 0; i<Run.OFFER_COUNT; i++) {
            while(!msgStack.push(Run.LONGVAL)) {
                ;
            }
        }
    };

    private final Runnable addWaitingTask = () -> {
        try {
            for(int i = 0; i<Run.OFFER_COUNT; i++) {
                while(!msgStack.push(Run.LONGVAL, 1L, TimeUnit.MICROSECONDS)) {
                    ;
                }
            }
        } catch(final InterruptedException ex) {
            throw new RuntimeException("Test failed due to interrupt.", ex);
        }
    };

    @Setup
    public void setup() {
        executor = Executors.newFixedThreadPool(Run.NTHREAD);
        msgStack = new ConcurrentStack<>(Run.QUEUE_SIZE);
    }

    // @Benchmark
    public void addOneM() {
        executor.execute(addTask);
        for(int i = 0; i<Run.OFFER_COUNT; i++) {
            while(msgStack.pop() != Run.LONGVAL) {
                ;
            }
        }
    }

    // @Benchmark
    public void addOneMWaiting() {
        executor.execute(addWaitingTask);
        try {
            for(int i = 0; i<Run.OFFER_COUNT; i++) {
                while(msgStack.pop(1L, TimeUnit.MICROSECONDS) != Run.LONGVAL) {
                    ;
                }
            }
        } catch(final InterruptedException ex) {
            throw new RuntimeException("Test failed due to interrupt.", ex);
        }
    }


    @TearDown
    public void tearDown() {
        executor.shutdown();
    }
}
