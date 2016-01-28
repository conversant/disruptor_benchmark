package com.conversantmedia;

import com.lmax.disruptor.ClaimStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.MultiThreadedClaimStrategy;
import com.lmax.disruptor.RingBuffer;
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
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by jcairns on 1/15/16.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(Run.FORK)
@Warmup(iterations=Run.WARM_ITER)
@Measurement(iterations = Run.MEAS_ITER)
public class LMAXDisruptorBenchmark {

    private ExecutorService executor;

    private EventHandler<LongEvent> handler;
    private Disruptor<LongEvent> disruptor;

    private RingBuffer<LongEvent> ringBuffer;

    private AtomicInteger eventCount;

    @Setup
    public void setup() {
        executor = Executors.newFixedThreadPool(Run.NTHREAD);
        disruptor = new Disruptor<LongEvent>(LongEvent.EVENT_FACTORY, executor, new MultiThreadedClaimStrategy(Run.QUEUE_SIZE), new BusySpinWaitStrategy());

        eventCount = new AtomicInteger();

        handler = (event, sequence, endOfBatch) -> {
            if(Run.LONGVAL == event.getValue()) {
                eventCount.incrementAndGet();
            } else {
                throw new RuntimeException("Failed.");
            }
        };

        disruptor.handleEventsWith(handler);

        ringBuffer = disruptor.start();
    };


    @Benchmark
    public void addOneM() {
        for(int i=0; i<Run.OFFER_COUNT; i++) {

            long seq = ringBuffer.next();
            LongEvent longEvent = ringBuffer.get(seq);
            longEvent.setValue(Run.LONGVAL);
            ringBuffer.publish(seq);
        }

        while(eventCount.get() < Run.OFFER_COUNT) {
            Thread.yield();
        }
    }

    @TearDown
    public void tearDown() {
        disruptor.shutdown();
        executor.shutdown();
    }

    private static final class LongEvent
    {
        private Long value;

        public Long getValue()
        {
            return value;
        }

        public void setValue(final Long value)
        {
            this.value = value;
        }

        public final static EventFactory<LongEvent> EVENT_FACTORY = new EventFactory<LongEvent>()
        {
            @Override
            public LongEvent newInstance()
            {
                return new LongEvent();
            }
        };
    }
}
