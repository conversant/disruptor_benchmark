package com.conversantmedia;

/**
 * Created by jcairns on 1/15/16.
 */
public final class Run {
    static final int MULTITHREAD = 4*Runtime.getRuntime().availableProcessors();
    static final int NTHREAD = Math.min(Runtime.getRuntime().availableProcessors(), 4);
    static final int FORK = 1;
    static final int WARM_ITER = 10;
    static final int MEAS_ITER = 20;
    static final int QUEUE_SIZE = 2048;
    static final int OFFER_COUNT = 1_000_000;
    static final Long LONGVAL = 0xba53ba1L;

}
