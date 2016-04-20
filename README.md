# disruptor_benchmark
JMH Benchmark for Conversant Disruptor and LMAX Disruptor

Build:

```$ mvn -U clean package```


Run:

```$ java -jar target/benchmarks.jar```


# sample output
```$ cat /proc/cpuinfo

processor	: 0
vendor_id	: GenuineIntel
cpu family	: 6
model		: 69
model name	: Intel(R) Core(TM) i7-4600U CPU @ 2.10GHz
stepping	: 1
microcode	: 0x17
cpu MHz		: 3285.140
cache size	: 4096 KB 
```

```$ perf stat taskset 0x5 java -jar target/benchmarks.jar
# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneM

# Run progress: 0.00% complete, ETA 00:04:24
# Fork: 1 of 2
# Warmup Iteration   1: 120.392 ms/op
# Warmup Iteration   2: 97.314 ms/op
# Warmup Iteration   3: 95.834 ms/op
Iteration   1: 96.064 ms/op
Iteration   2: 95.927 ms/op
Iteration   3: 96.324 ms/op
Iteration   4: 96.964 ms/op
Iteration   5: 96.176 ms/op
Iteration   6: 96.376 ms/op
Iteration   7: 95.872 ms/op
Iteration   8: 95.715 ms/op

# Run progress: 4.17% complete, ETA 00:04:36
# Fork: 2 of 2
# Warmup Iteration   1: 127.389 ms/op
# Warmup Iteration   2: 105.396 ms/op
# Warmup Iteration   3: 101.620 ms/op
Iteration   1: 102.166 ms/op
Iteration   2: 101.271 ms/op
Iteration   3: 100.889 ms/op
Iteration   4: 100.896 ms/op
Iteration   5: 100.975 ms/op
Iteration   6: 102.001 ms/op
Iteration   7: 102.084 ms/op
Iteration   8: 101.495 ms/op


Result "sendOneM":
  98.825 ±(99.9%) 2.823 ms/op [Average]
  (min, avg, max) = (95.715, 98.825, 102.166), stdev = 2.773
  CI (99.9%): [96.002, 101.648] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneMWaiting

# Run progress: 8.33% complete, ETA 00:04:20
# Fork: 1 of 2
# Warmup Iteration   1: 216.535 ms/op
# Warmup Iteration   2: 101.950 ms/op
# Warmup Iteration   3: 100.255 ms/op
Iteration   1: 96.101 ms/op
Iteration   2: 95.523 ms/op
Iteration   3: 96.451 ms/op
Iteration   4: 96.833 ms/op
Iteration   5: 97.311 ms/op
Iteration   6: 95.333 ms/op
Iteration   7: 97.382 ms/op
Iteration   8: 95.812 ms/op

# Run progress: 12.50% complete, ETA 00:04:09
# Fork: 2 of 2
# Warmup Iteration   1: 171.589 ms/op
# Warmup Iteration   2: 128.097 ms/op
# Warmup Iteration   3: 120.151 ms/op
Iteration   1: 115.163 ms/op
Iteration   2: 115.196 ms/op
Iteration   3: 119.922 ms/op
Iteration   4: 116.878 ms/op
Iteration   5: 116.071 ms/op
Iteration   6: 116.655 ms/op
Iteration   7: 117.013 ms/op
Iteration   8: 116.765 ms/op


Result "sendOneMWaiting":
  106.526 ±(99.9%) 10.771 ms/op [Average]
  (min, avg, max) = (95.333, 106.526, 119.922), stdev = 10.579
  CI (99.9%): [95.754, 117.297] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ConcurrentStackBenchmark.addOneM

# Run progress: 16.67% complete, ETA 00:03:57
# Fork: 1 of 2
# Warmup Iteration   1: 106.466 ms/op
# Warmup Iteration   2: 99.423 ms/op
# Warmup Iteration   3: 98.643 ms/op
Iteration   1: 98.983 ms/op
Iteration   2: 99.873 ms/op
Iteration   3: 98.072 ms/op
Iteration   4: 97.323 ms/op
Iteration   5: 97.222 ms/op
Iteration   6: 97.530 ms/op
Iteration   7: 97.713 ms/op
Iteration   8: 97.499 ms/op

# Run progress: 20.83% complete, ETA 00:03:46
# Fork: 2 of 2
# Warmup Iteration   1: 168.165 ms/op
# Warmup Iteration   2: 113.479 ms/op
# Warmup Iteration   3: 112.349 ms/op
Iteration   1: 114.180 ms/op
Iteration   2: 113.643 ms/op
Iteration   3: 119.454 ms/op
Iteration   4: 113.163 ms/op
Iteration   5: 114.355 ms/op
Iteration   6: 115.655 ms/op
Iteration   7: 114.981 ms/op
Iteration   8: 113.454 ms/op


Result "addOneM":
  106.444 ±(99.9%) 8.986 ms/op [Average]
  (min, avg, max) = (97.222, 106.444, 119.454), stdev = 8.826
  CI (99.9%): [97.457, 115.430] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ConcurrentStackBenchmark.addOneMWaiting

# Run progress: 25.00% complete, ETA 00:03:33
# Fork: 1 of 2
# Warmup Iteration   1: 91.425 ms/op
# Warmup Iteration   2: 61.615 ms/op
# Warmup Iteration   3: 60.066 ms/op
Iteration   1: 61.688 ms/op
Iteration   2: 59.687 ms/op
Iteration   3: 59.820 ms/op
Iteration   4: 59.903 ms/op
Iteration   5: 60.965 ms/op
Iteration   6: 60.194 ms/op
Iteration   7: 59.324 ms/op
Iteration   8: 59.651 ms/op

# Run progress: 29.17% complete, ETA 00:03:21
# Fork: 2 of 2
# Warmup Iteration   1: 112.028 ms/op
# Warmup Iteration   2: 59.842 ms/op
# Warmup Iteration   3: 56.691 ms/op
Iteration   1: 57.344 ms/op
Iteration   2: 56.839 ms/op
Iteration   3: 56.883 ms/op
Iteration   4: 56.985 ms/op
Iteration   5: 56.909 ms/op
Iteration   6: 56.802 ms/op
Iteration   7: 57.070 ms/op
Iteration   8: 57.224 ms/op


Result "addOneMWaiting":
  58.581 ±(99.9%) 1.748 ms/op [Average]
  (min, avg, max) = (56.802, 58.581, 61.688), stdev = 1.717
  CI (99.9%): [56.832, 60.329] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneM

# Run progress: 33.33% complete, ETA 00:03:08
# Fork: 1 of 2
# Warmup Iteration   1: 18.406 ms/op
# Warmup Iteration   2: 15.428 ms/op
# Warmup Iteration   3: 15.055 ms/op
Iteration   1: 15.668 ms/op
Iteration   2: 16.773 ms/op
Iteration   3: 16.180 ms/op
Iteration   4: 16.296 ms/op
Iteration   5: 16.292 ms/op
Iteration   6: 16.285 ms/op
Iteration   7: 16.574 ms/op
Iteration   8: 16.256 ms/op

# Run progress: 37.50% complete, ETA 00:02:56
# Fork: 2 of 2
# Warmup Iteration   1: 17.686 ms/op
# Warmup Iteration   2: 15.663 ms/op
# Warmup Iteration   3: 14.984 ms/op
Iteration   1: 15.673 ms/op
Iteration   2: 15.602 ms/op
Iteration   3: 15.406 ms/op
Iteration   4: 17.361 ms/op
Iteration   5: 16.568 ms/op
Iteration   6: 15.322 ms/op
Iteration   7: 15.368 ms/op
Iteration   8: 15.561 ms/op


Result "addOneM":
  16.074 ±(99.9%) 0.596 ms/op [Average]
  (min, avg, max) = (15.322, 16.074, 17.361), stdev = 0.586
  CI (99.9%): [15.478, 16.670] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneMWaiting

# Run progress: 41.67% complete, ETA 00:02:44
# Fork: 1 of 2
# Warmup Iteration   1: 23.468 ms/op
# Warmup Iteration   2: 17.222 ms/op
# Warmup Iteration   3: 17.361 ms/op
Iteration   1: 17.353 ms/op
Iteration   2: 17.853 ms/op
Iteration   3: 17.321 ms/op
Iteration   4: 17.557 ms/op
Iteration   5: 30.718 ms/op
Iteration   6: 30.713 ms/op
Iteration   7: 31.054 ms/op
Iteration   8: 28.506 ms/op

# Run progress: 45.83% complete, ETA 00:02:32
# Fork: 2 of 2
# Warmup Iteration   1: 23.265 ms/op
# Warmup Iteration   2: 17.668 ms/op
# Warmup Iteration   3: 17.688 ms/op
Iteration   1: 18.059 ms/op
Iteration   2: 18.056 ms/op
Iteration   3: 17.355 ms/op
Iteration   4: 17.389 ms/op
Iteration   5: 17.349 ms/op
Iteration   6: 17.372 ms/op
Iteration   7: 17.413 ms/op
Iteration   8: 17.387 ms/op


Result "addOneMWaiting":
  20.716 ±(99.9%) 5.817 ms/op [Average]
  (min, avg, max) = (17.321, 20.716, 31.054), stdev = 5.713
  CI (99.9%): [14.899, 26.533] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LMAXDisruptorBenchmark.addOneM

# Run progress: 50.00% complete, ETA 00:02:20
# Fork: 1 of 2
# Warmup Iteration   1: 23.740 ms/op
# Warmup Iteration   2: 21.726 ms/op
# Warmup Iteration   3: 21.644 ms/op
Iteration   1: 21.780 ms/op
Iteration   2: 21.854 ms/op
Iteration   3: 21.844 ms/op
Iteration   4: 21.755 ms/op
Iteration   5: 21.835 ms/op
Iteration   6: 21.751 ms/op
Iteration   7: 21.893 ms/op
Iteration   8: 21.647 ms/op

# Run progress: 54.17% complete, ETA 00:02:08
# Fork: 2 of 2
# Warmup Iteration   1: 23.784 ms/op
# Warmup Iteration   2: 21.757 ms/op
# Warmup Iteration   3: 21.669 ms/op
Iteration   1: 21.775 ms/op
Iteration   2: 21.744 ms/op
Iteration   3: 21.634 ms/op
Iteration   4: 21.779 ms/op
Iteration   5: 22.889 ms/op
Iteration   6: 39.058 ms/op
Iteration   7: 39.127 ms/op
Iteration   8: 39.038 ms/op


Result "addOneM":
  25.088 ±(99.9%) 7.071 ms/op [Average]
  (min, avg, max) = (21.634, 25.088, 39.127), stdev = 6.945
  CI (99.9%): [18.016, 32.159] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LMAXDisruptorPushPullBenchmark.addOneM

# Run progress: 58.33% complete, ETA 00:01:56
# Fork: 1 of 2
# Warmup Iteration   1: 17.235 ms/op
# Warmup Iteration   2: 13.993 ms/op
# Warmup Iteration   3: 13.943 ms/op
Iteration   1: 13.945 ms/op
Iteration   2: 14.004 ms/op
Iteration   3: 13.992 ms/op
Iteration   4: 13.572 ms/op
Iteration   5: 11.182 ms/op
Iteration   6: 11.203 ms/op
Iteration   7: 11.231 ms/op
Iteration   8: 11.215 ms/op

# Run progress: 62.50% complete, ETA 00:01:44
# Fork: 2 of 2
# Warmup Iteration   1: 12.297 ms/op
# Warmup Iteration   2: 11.241 ms/op
# Warmup Iteration   3: 11.184 ms/op
Iteration   1: 11.171 ms/op
Iteration   2: 11.179 ms/op
Iteration   3: 11.170 ms/op
Iteration   4: 11.192 ms/op
Iteration   5: 11.204 ms/op
Iteration   6: 11.208 ms/op
Iteration   7: 11.239 ms/op
Iteration   8: 11.249 ms/op


Result "addOneM":
  11.872 ±(99.9%) 1.222 ms/op [Average]
  (min, avg, max) = (11.170, 11.872, 14.004), stdev = 1.200
  CI (99.9%): [10.650, 13.094] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LinkedTransferQueueBenchmark.sendOneM

# Run progress: 66.67% complete, ETA 00:01:33
# Fork: 1 of 2
# Warmup Iteration   1: 114.146 ms/op
# Warmup Iteration   2: 45.536 ms/op
# Warmup Iteration   3: 59.483 ms/op
Iteration   1: 37.120 ms/op
Iteration   2: 75.358 ms/op
Iteration   3: 40.641 ms/op
Iteration   4: 39.725 ms/op
Iteration   5: 47.337 ms/op
Iteration   6: 46.116 ms/op
Iteration   7: 37.441 ms/op
Iteration   8: 36.844 ms/op

# Run progress: 70.83% complete, ETA 00:01:21
# Fork: 2 of 2
# Warmup Iteration   1: 50.178 ms/op
# Warmup Iteration   2: 55.107 ms/op
# Warmup Iteration   3: 42.919 ms/op
Iteration   1: 46.114 ms/op
Iteration   2: 127.638 ms/op
Iteration   3: 68.935 ms/op
Iteration   4: 70.206 ms/op
Iteration   5: 69.887 ms/op
Iteration   6: 43.552 ms/op
Iteration   7: 38.288 ms/op
Iteration   8: 38.638 ms/op


Result "sendOneM":
  53.990 ±(99.9%) 24.399 ms/op [Average]
  (min, avg, max) = (36.844, 53.990, 127.638), stdev = 23.963
  CI (99.9%): [29.591, 78.389] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LinkedTransferQueueBenchmark.sendOneMWaiting

# Run progress: 75.00% complete, ETA 00:01:09
# Fork: 1 of 2
# Warmup Iteration   1: 60.278 ms/op
# Warmup Iteration   2: 43.796 ms/op
# Warmup Iteration   3: 42.708 ms/op
Iteration   1: 53.482 ms/op
Iteration   2: 43.225 ms/op
Iteration   3: 43.778 ms/op
Iteration   4: 43.305 ms/op
Iteration   5: 43.265 ms/op
Iteration   6: 43.095 ms/op
Iteration   7: 43.274 ms/op
Iteration   8: 43.561 ms/op

# Run progress: 79.17% complete, ETA 00:00:58
# Fork: 2 of 2
# Warmup Iteration   1: 61.389 ms/op
# Warmup Iteration   2: 46.371 ms/op
# Warmup Iteration   3: 46.439 ms/op
Iteration   1: 46.153 ms/op
Iteration   2: 72.548 ms/op
Iteration   3: 82.339 ms/op
Iteration   4: 82.637 ms/op
Iteration   5: 80.071 ms/op
Iteration   6: 45.905 ms/op
Iteration   7: 45.119 ms/op
Iteration   8: 44.297 ms/op


Result "sendOneMWaiting":
  53.503 ±(99.9%) 16.070 ms/op [Average]
  (min, avg, max) = (43.095, 53.503, 82.637), stdev = 15.783
  CI (99.9%): [37.433, 69.573] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneM

# Run progress: 83.33% complete, ETA 00:00:46
# Fork: 1 of 2
# Warmup Iteration   1: 9.820 ms/op
# Warmup Iteration   2: 8.729 ms/op
# Warmup Iteration   3: 8.777 ms/op
Iteration   1: 8.811 ms/op
Iteration   2: 9.606 ms/op
Iteration   3: 15.645 ms/op
Iteration   4: 15.609 ms/op
Iteration   5: 15.578 ms/op
Iteration   6: 13.016 ms/op
Iteration   7: 8.670 ms/op
Iteration   8: 8.673 ms/op

# Run progress: 87.50% complete, ETA 00:00:34
# Fork: 2 of 2
# Warmup Iteration   1: 9.401 ms/op
# Warmup Iteration   2: 8.751 ms/op
# Warmup Iteration   3: 8.688 ms/op
Iteration   1: 8.711 ms/op
Iteration   2: 8.690 ms/op
Iteration   3: 8.696 ms/op
Iteration   4: 8.718 ms/op
Iteration   5: 8.714 ms/op
Iteration   6: 8.760 ms/op
Iteration   7: 8.768 ms/op
Iteration   8: 8.733 ms/op


Result "sendOneM":
  10.337 ±(99.9%) 2.878 ms/op [Average]
  (min, avg, max) = (8.670, 10.337, 15.645), stdev = 2.827
  CI (99.9%): [7.459, 13.215] (assumes normal distribution)


# JMH 1.11.2 (released 132 days ago, please consider updating!)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 8 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneMWaiting

# Run progress: 91.67% complete, ETA 00:00:23
# Fork: 1 of 2
# Warmup Iteration   1: 16.833 ms/op
# Warmup Iteration   2: 23.041 ms/op
# Warmup Iteration   3: 23.360 ms/op
Iteration   1: 23.459 ms/op
Iteration   2: 23.415 ms/op
Iteration   3: 13.183 ms/op
Iteration   4: 13.004 ms/op
Iteration   5: 13.014 ms/op
Iteration   6: 12.948 ms/op
Iteration   7: 13.031 ms/op
Iteration   8: 13.016 ms/op

# Run progress: 95.83% complete, ETA 00:00:11
# Fork: 2 of 2
# Warmup Iteration   1: 17.634 ms/op
# Warmup Iteration   2: 13.266 ms/op
# Warmup Iteration   3: 23.414 ms/op
Iteration   1: 23.494 ms/op
Iteration   2: 23.629 ms/op
Iteration   3: 22.444 ms/op
Iteration   4: 14.565 ms/op
Iteration   5: 12.917 ms/op
Iteration   6: 12.993 ms/op
Iteration   7: 12.969 ms/op
Iteration   8: 12.939 ms/op


Result "sendOneMWaiting":
  16.314 ±(99.9%) 4.967 ms/op [Average]
  (min, avg, max) = (12.917, 16.314, 23.629), stdev = 4.878
  CI (99.9%): [11.347, 21.281] (assumes normal distribution)


# Run complete. Total time: 00:04:38

Benchmark                                       Mode  Cnt    Score    Error  Units
ArrayBlockingQueueBenchmark.sendOneM            avgt   16   98.825 ±  2.823  ms/op
ArrayBlockingQueueBenchmark.sendOneMWaiting     avgt   16  106.526 ± 10.771  ms/op
ConcurrentStackBenchmark.addOneM                avgt   16  106.444 ±  8.986  ms/op
ConcurrentStackBenchmark.addOneMWaiting         avgt   16   58.581 ±  1.748  ms/op
DisruptorBlockingQueueBenchmark.addOneM         avgt   16   16.074 ±  0.596  ms/op
DisruptorBlockingQueueBenchmark.addOneMWaiting  avgt   16   20.716 ±  5.817  ms/op
LMAXDisruptorBenchmark.addOneM                  avgt   16   25.088 ±  7.071  ms/op
LMAXDisruptorPushPullBenchmark.addOneM          avgt   16   11.872 ±  1.222  ms/op
LinkedTransferQueueBenchmark.sendOneM           avgt   16   53.990 ± 24.399  ms/op
LinkedTransferQueueBenchmark.sendOneMWaiting    avgt   16   53.503 ± 16.070  ms/op
PushPullBlockingQueueBenchmark.sendOneM         avgt   16   10.337 ±  2.878  ms/op
PushPullBlockingQueueBenchmark.sendOneMWaiting  avgt   16   16.314 ±  4.967  ms/op
failed to read counter stalled-cycles-frontend
failed to read counter stalled-cycles-backend

 Performance counter stats for 'taskset 0x5 java -jar target/benchmarks.jar':

     550164.750732      task-clock (msec)         #    1.973 CPUs utilized          
           388,812      context-switches          #    0.707 K/sec                  
             5,135      cpu-migrations            #    0.009 K/sec                  
           799,691      page-faults               #    0.001 M/sec                  
 1,684,446,528,660      cycles                    #    3.062 GHz                    
   <not supported>      stalled-cycles-frontend  
   <not supported>      stalled-cycles-backend   
 1,914,886,508,465      instructions              #    1.14  insns per cycle        
   352,381,336,915      branches                  #  640.501 M/sec                  
     3,718,527,750      branch-misses             #    1.06% of all branches        

     278.796275179 seconds time elapsed
```
