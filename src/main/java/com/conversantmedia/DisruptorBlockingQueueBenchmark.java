package com.conversantmedia;

import com.conversantmedia.util.concurrent.DisruptorBlockingQueue;
import com.conversantmedia.util.concurrent.SpinPolicy;
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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jcairns on 1/15/16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(Run.FORK)
@Warmup(iterations=Run.WARM_ITER)
@Measurement(iterations = Run.MEAS_ITER)
public class DisruptorBlockingQueueBenchmark {

    private ExecutorService executor;
    private BlockingQueue<Long> msgQueue;

    private final Runnable addTask = () -> {
        for(int i = 0; i<Run.OFFER_COUNT; i++) {
            while(!msgQueue.offer(Run.LONGVAL)) {
                ;
            }
        }
    };

    private final Runnable multiAddTask = () -> {
        for(int i = 0; i<Run.OFFER_COUNT/Run.MULTITHREAD; i++) {
            while(!msgQueue.offer(Run.LONGVAL)) {
                ;
            }
        }
    };


    private final Runnable addWaitingTask = () -> {
        try {
            for(int i = 0; i<Run.OFFER_COUNT; i++) {
                while(!msgQueue.offer(Run.LONGVAL, 1L, TimeUnit.MICROSECONDS)) {
                    ;
                }
            }
        } catch(final InterruptedException ex) {
            throw new RuntimeException("Test failed due to interrupt.", ex);
        }
    };


    @Setup
    public void setup() {
        executor = Executors.newFixedThreadPool(2*Run.MULTITHREAD);
        msgQueue = new DisruptorBlockingQueue<Long>(Run.QUEUE_SIZE);
    }

    @Benchmark
    public void addOneM() {
        executor.execute(addTask);
        for(int i = 0; i<Run.OFFER_COUNT; i++) {
            while(msgQueue.poll() != Run.LONGVAL) {
                ;
            }
        }
    }

    @Benchmark
    public void addOneMNThread() {
        final AtomicInteger nFinished = new AtomicInteger();
        for(int j=0; j<Run.MULTITHREAD; j++) {
            executor.execute(multiAddTask);
            executor.execute(() -> {
                for(int i = 0; i<Run.OFFER_COUNT/Run.MULTITHREAD; i++) {
                    while (msgQueue.poll() != Run.LONGVAL) {
                        ;
                    }
                    nFinished.incrementAndGet();
                }
            });
        }
        while(nFinished.get() < Run.MULTITHREAD)
            Thread.yield();
    }

    @Benchmark
    public void addOneMWaiting() {
        executor.execute(addWaitingTask);
        try {
            for(int i = 0; i<Run.OFFER_COUNT; i++) {
                while(msgQueue.poll(1L, TimeUnit.MICROSECONDS) != Run.LONGVAL) {
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
