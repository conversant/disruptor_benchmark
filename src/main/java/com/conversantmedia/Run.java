package com.conversantmedia;

/**
 * Created by jcairns on 1/15/16.
 */
public interface Run {
    int MULTITHREAD = 4*Runtime.getRuntime().availableProcessors();
    int NTHREAD = Math.min(Runtime.getRuntime().availableProcessors(), 4);
    int FORK = 2;
    int WARM_ITER = 3;
    int MEAS_ITER = 4;
    int QUEUE_SIZE = 2048;
    int OFFER_COUNT = 1000000;
    Long LONGVAL = 0xdeadbeefL;

}
