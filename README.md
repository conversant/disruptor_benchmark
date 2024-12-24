# disruptor_benchmark
JMH Benchmark for Conversant Disruptor and LMAX Disruptor

## Install Jar under test

```shell
$ mvn install:install-file  \
      -Dfile=./disruptor-1.2.22-SNAPSHOT.jar \
      -DgroupId=com.conversantmedia \
      -DartifactId=disruptor \
      -Dversion=1.2.22-SNAPSHOT \
      -Dpackaging=jar
```

## Build

```shell
$ mvn -U clean package
```

## Run

```shell
$ java -jar target/benchmarks.jar
```


# sample output (Broadwell)
```$ cat /proc/cpuinfo

processor       : 0
vendor_id       : GenuineIntel
cpu family      : 6
model           : 79
model name      : Intel(R) Xeon(R) CPU E5-2680 v4 @ 2.40GHz
stepping        : 1
microcode       : 0xb00001e
cpu MHz         : 3300.000
cache size      : 35840 KB
```

```$ taskset 0x5 java -server -XX:-RestrictContended -jar benchmarks.jar
# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneM

# Run progress: 0.00% complete, ETA 00:06:08
# Fork: 1 of 1
# Warmup Iteration   1: 455.034 ms/op
# Warmup Iteration   2: 444.139 ms/op
# Warmup Iteration   3: 427.296 ms/op
# Warmup Iteration   4: 417.742 ms/op
# Warmup Iteration   5: 345.306 ms/op
# Warmup Iteration   6: 339.912 ms/op
# Warmup Iteration   7: 357.221 ms/op
# Warmup Iteration   8: 342.482 ms/op
Iteration   1: 356.235 ms/op
Iteration   2: 343.283 ms/op
Iteration   3: 353.182 ms/op
Iteration   4: 387.701 ms/op
Iteration   5: 348.048 ms/op
Iteration   6: 383.684 ms/op
Iteration   7: 356.898 ms/op
Iteration   8: 384.847 ms/op
Iteration   9: 451.383 ms/op
Iteration  10: 377.231 ms/op
Iteration  11: 370.818 ms/op
Iteration  12: 408.279 ms/op
Iteration  13: 382.322 ms/op
Iteration  14: 378.637 ms/op
Iteration  15: 371.041 ms/op


Result "com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneM":
  376.906 ±(99.9%) 28.876 ms/op [Average]
  (min, avg, max) = (343.283, 376.906, 451.383), stdev = 27.011
  CI (99.9%): [348.030, 405.782] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneMWaiting

# Run progress: 6.25% complete, ETA 00:06:42
# Fork: 1 of 1
# Warmup Iteration   1: 270.334 ms/op
# Warmup Iteration   2: 270.158 ms/op
# Warmup Iteration   3: 273.083 ms/op
# Warmup Iteration   4: 310.080 ms/op
# Warmup Iteration   5: 310.582 ms/op
# Warmup Iteration   6: 310.168 ms/op
# Warmup Iteration   7: 353.476 ms/op
# Warmup Iteration   8: 391.738 ms/op
Iteration   1: 364.012 ms/op
Iteration   2: 371.624 ms/op
Iteration   3: 368.054 ms/op
Iteration   4: 369.810 ms/op
Iteration   5: 371.915 ms/op
Iteration   6: 358.242 ms/op
Iteration   7: 367.717 ms/op
Iteration   8: 376.737 ms/op
Iteration   9: 407.342 ms/op
Iteration  10: 399.067 ms/op
Iteration  11: 404.018 ms/op
Iteration  12: 406.058 ms/op
Iteration  13: 287.710 ms/op
Iteration  14: 283.110 ms/op
Iteration  15: 282.335 ms/op


Result "com.conversantmedia.ArrayBlockingQueueBenchmark.sendOneMWaiting":
  361.183 ±(99.9%) 45.868 ms/op [Average]
  (min, avg, max) = (282.335, 361.183, 407.342), stdev = 42.905
  CI (99.9%): [315.315, 407.052] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ConcurrentStackBenchmark.addOneM

# Run progress: 12.50% complete, ETA 00:06:16
# Fork: 1 of 1
# Warmup Iteration   1: 189.340 ms/op
# Warmup Iteration   2: 182.687 ms/op
# Warmup Iteration   3: 181.750 ms/op
# Warmup Iteration   4: 179.348 ms/op
# Warmup Iteration   5: 178.483 ms/op
# Warmup Iteration   6: 161.591 ms/op
# Warmup Iteration   7: 165.522 ms/op
# Warmup Iteration   8: 160.904 ms/op
Iteration   1: 160.527 ms/op
Iteration   2: 185.419 ms/op
Iteration   3: 163.050 ms/op
Iteration   4: 160.718 ms/op
Iteration   5: 161.942 ms/op
Iteration   6: 159.787 ms/op
Iteration   7: 179.299 ms/op
Iteration   8: 179.713 ms/op
Iteration   9: 164.172 ms/op
Iteration  10: 165.264 ms/op
Iteration  11: 163.507 ms/op
Iteration  12: 162.853 ms/op
Iteration  13: 163.858 ms/op
Iteration  14: 182.990 ms/op
Iteration  15: 186.658 ms/op


Result "com.conversantmedia.ConcurrentStackBenchmark.addOneM":
  169.317 ±(99.9%) 10.837 ms/op [Average]
  (min, avg, max) = (159.787, 169.317, 186.658), stdev = 10.137
  CI (99.9%): [158.480, 180.154] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.ConcurrentStackBenchmark.addOneMWaiting

# Run progress: 18.75% complete, ETA 00:05:45
# Fork: 1 of 1
# Warmup Iteration   1: 299.820 ms/op
# Warmup Iteration   2: 259.335 ms/op
# Warmup Iteration   3: 274.119 ms/op
# Warmup Iteration   4: 292.301 ms/op
# Warmup Iteration   5: 246.564 ms/op
# Warmup Iteration   6: 247.076 ms/op
# Warmup Iteration   7: 246.598 ms/op
# Warmup Iteration   8: 278.024 ms/op
Iteration   1: 281.445 ms/op
Iteration   2: 261.775 ms/op
Iteration   3: 245.541 ms/op
Iteration   4: 246.569 ms/op
Iteration   5: 246.229 ms/op
Iteration   6: 244.840 ms/op
Iteration   7: 246.533 ms/op
Iteration   8: 246.190 ms/op
Iteration   9: 276.603 ms/op
Iteration  10: 273.883 ms/op
Iteration  11: 278.749 ms/op
Iteration  12: 273.065 ms/op
Iteration  13: 272.591 ms/op
Iteration  14: 274.070 ms/op
Iteration  15: 272.180 ms/op


Result "com.conversantmedia.ConcurrentStackBenchmark.addOneMWaiting":
  262.684 ±(99.9%) 15.731 ms/op [Average]
  (min, avg, max) = (244.840, 262.684, 281.445), stdev = 14.715
  CI (99.9%): [246.953, 278.415] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneM

# Run progress: 25.00% complete, ETA 00:05:19
# Fork: 1 of 1
# Warmup Iteration   1: 35.813 ms/op
# Warmup Iteration   2: 31.866 ms/op
# Warmup Iteration   3: 32.554 ms/op
# Warmup Iteration   4: 31.192 ms/op
# Warmup Iteration   5: 32.634 ms/op
# Warmup Iteration   6: 30.267 ms/op
# Warmup Iteration   7: 29.655 ms/op
# Warmup Iteration   8: 32.590 ms/op
Iteration   1: 33.165 ms/op
Iteration   2: 33.554 ms/op
Iteration   3: 33.024 ms/op
Iteration   4: 37.097 ms/op
Iteration   5: 30.223 ms/op
Iteration   6: 32.125 ms/op
Iteration   7: 29.963 ms/op
Iteration   8: 30.000 ms/op
Iteration   9: 29.208 ms/op
Iteration  10: 29.035 ms/op
Iteration  11: 30.436 ms/op
Iteration  12: 29.458 ms/op
Iteration  13: 29.540 ms/op
Iteration  14: 30.024 ms/op
Iteration  15: 30.365 ms/op


Result "com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneM":
  31.148 ±(99.9%) 2.379 ms/op [Average]
  (min, avg, max) = (29.035, 31.148, 37.097), stdev = 2.226
  CI (99.9%): [28.768, 33.527] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneMNThread

# Run progress: 31.25% complete, ETA 00:04:46
# Fork: 1 of 1
# Warmup Iteration   1: 578.815 ms/op
# Warmup Iteration   2: 1463.647 ms/op
# Warmup Iteration   3: 1440.840 ms/op
# Warmup Iteration   4: 1172.061 ms/op
# Warmup Iteration   5: 1719.889 ms/op
# Warmup Iteration   6: 1530.590 ms/op
# Warmup Iteration   7: 1199.826 ms/op
# Warmup Iteration   8: 1166.003 ms/op
Iteration   1: 1821.219 ms/op
Iteration   2: 1331.282 ms/op
Iteration   3: 1153.869 ms/op
Iteration   4: 1338.984 ms/op
Iteration   5: 1694.697 ms/op
Iteration   6: 1657.809 ms/op
Iteration   7: 1453.638 ms/op
Iteration   8: 1321.298 ms/op
Iteration   9: 1018.574 ms/op
Iteration  10: 1589.678 ms/op
Iteration  11: 1400.665 ms/op
Iteration  12: 1296.671 ms/op
Iteration  13: 1354.680 ms/op
Iteration  14: 1050.474 ms/op
Iteration  15: 1265.617 ms/op


Result "com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneMNThread":
  1383.277 ±(99.9%) 245.628 ms/op [Average]
  (min, avg, max) = (1018.574, 1383.277, 1821.219), stdev = 229.761
  CI (99.9%): [1137.649, 1628.905] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneMWaiting

# Run progress: 37.50% complete, ETA 00:04:33
# Fork: 1 of 1
# Warmup Iteration   1: 29.650 ms/op
# Warmup Iteration   2: 53.389 ms/op
# Warmup Iteration   3: 35.376 ms/op
# Warmup Iteration   4: 44.650 ms/op
# Warmup Iteration   5: 51.150 ms/op
# Warmup Iteration   6: 34.556 ms/op
# Warmup Iteration   7: 32.501 ms/op
# Warmup Iteration   8: 32.490 ms/op
Iteration   1: 39.166 ms/op
Iteration   2: 40.705 ms/op
Iteration   3: 35.097 ms/op
Iteration   4: 35.113 ms/op
Iteration   5: 43.784 ms/op
Iteration   6: 44.137 ms/op
Iteration   7: 45.905 ms/op
Iteration   8: 34.086 ms/op
Iteration   9: 29.969 ms/op
Iteration  10: 35.746 ms/op
Iteration  11: 32.098 ms/op
Iteration  12: 27.489 ms/op
Iteration  13: 34.763 ms/op
Iteration  14: 29.450 ms/op
Iteration  15: 26.976 ms/op


Result "com.conversantmedia.DisruptorBlockingQueueBenchmark.addOneMWaiting":
  35.632 ±(99.9%) 6.454 ms/op [Average]
  (min, avg, max) = (26.976, 35.632, 45.905), stdev = 6.037
  CI (99.9%): [29.178, 42.086] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LMAXDisruptorBenchmark.addOneM

# Run progress: 43.75% complete, ETA 00:04:01
# Fork: 1 of 1
# Warmup Iteration   1: 68.010 ms/op
# Warmup Iteration   2: 61.085 ms/op
# Warmup Iteration   3: 64.392 ms/op
# Warmup Iteration   4: 63.965 ms/op
# Warmup Iteration   5: 60.738 ms/op
# Warmup Iteration   6: 60.626 ms/op
# Warmup Iteration   7: 60.663 ms/op
# Warmup Iteration   8: 60.541 ms/op
Iteration   1: 60.685 ms/op
Iteration   2: 62.533 ms/op
Iteration   3: 64.375 ms/op
Iteration   4: 62.230 ms/op
Iteration   5: 60.600 ms/op
Iteration   6: 60.578 ms/op
Iteration   7: 60.602 ms/op
Iteration   8: 60.745 ms/op
Iteration   9: 60.654 ms/op
Iteration  10: 60.682 ms/op
Iteration  11: 60.624 ms/op
Iteration  12: 60.631 ms/op
Iteration  13: 60.582 ms/op
Iteration  14: 60.669 ms/op
Iteration  15: 60.748 ms/op


Result "com.conversantmedia.LMAXDisruptorBenchmark.addOneM":
  61.129 ±(99.9%) 1.161 ms/op [Average]
  (min, avg, max) = (60.578, 61.129, 64.375), stdev = 1.086
  CI (99.9%): [59.968, 62.290] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LMAXDisruptorPushPullBenchmark.addOneM

# Run progress: 50.00% complete, ETA 00:03:32
# Fork: 1 of 1
# Warmup Iteration   1: 36.210 ms/op
# Warmup Iteration   2: 34.277 ms/op
# Warmup Iteration   3: 33.508 ms/op
# Warmup Iteration   4: 33.969 ms/op
# Warmup Iteration   5: 34.355 ms/op
# Warmup Iteration   6: 34.305 ms/op
# Warmup Iteration   7: 34.154 ms/op
# Warmup Iteration   8: 33.823 ms/op
Iteration   1: 32.221 ms/op
Iteration   2: 34.269 ms/op
Iteration   3: 34.352 ms/op
Iteration   4: 34.001 ms/op
Iteration   5: 34.193 ms/op
Iteration   6: 34.161 ms/op
Iteration   7: 34.119 ms/op
Iteration   8: 34.184 ms/op
Iteration   9: 33.750 ms/op
Iteration  10: 33.987 ms/op
Iteration  11: 34.105 ms/op
Iteration  12: 33.666 ms/op
Iteration  13: 34.114 ms/op
Iteration  14: 34.209 ms/op
Iteration  15: 34.025 ms/op


Result "com.conversantmedia.LMAXDisruptorPushPullBenchmark.addOneM":
  33.957 ±(99.9%) 0.549 ms/op [Average]
  (min, avg, max) = (32.221, 33.957, 34.352), stdev = 0.513
  CI (99.9%): [33.408, 34.506] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LinkedTransferQueueBenchmark.sendOneM

# Run progress: 56.25% complete, ETA 00:03:03
# Fork: 1 of 1
# Warmup Iteration   1: 148.909 ms/op
# Warmup Iteration   2: 123.343 ms/op
# Warmup Iteration   3: 127.123 ms/op
# Warmup Iteration   4: 125.901 ms/op
# Warmup Iteration   5: 135.434 ms/op
# Warmup Iteration   6: 173.252 ms/op
# Warmup Iteration   7: 181.735 ms/op
# Warmup Iteration   8: 137.006 ms/op
Iteration   1: 126.609 ms/op
Iteration   2: 125.785 ms/op
Iteration   3: 132.421 ms/op
Iteration   4: 125.707 ms/op
Iteration   5: 128.216 ms/op
Iteration   6: 120.927 ms/op
Iteration   7: 124.363 ms/op
Iteration   8: 128.100 ms/op
Iteration   9: 123.651 ms/op
Iteration  10: 121.845 ms/op
Iteration  11: 121.568 ms/op
Iteration  12: 125.169 ms/op
Iteration  13: 127.324 ms/op
Iteration  14: 129.615 ms/op
Iteration  15: 121.364 ms/op


Result "com.conversantmedia.LinkedTransferQueueBenchmark.sendOneM":
  125.511 ±(99.9%) 3.561 ms/op [Average]
  (min, avg, max) = (120.927, 125.511, 132.421), stdev = 3.331
  CI (99.9%): [121.950, 129.072] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.LinkedTransferQueueBenchmark.sendOneMWaiting

# Run progress: 62.50% complete, ETA 00:02:36
# Fork: 1 of 1
# Warmup Iteration   1: 106.065 ms/op
# Warmup Iteration   2: 153.057 ms/op
# Warmup Iteration   3: 138.356 ms/op
# Warmup Iteration   4: 139.127 ms/op
# Warmup Iteration   5: 133.255 ms/op
# Warmup Iteration   6: 130.590 ms/op
# Warmup Iteration   7: 124.569 ms/op
# Warmup Iteration   8: 123.731 ms/op
Iteration   1: 166.696 ms/op
Iteration   2: 126.946 ms/op
Iteration   3: 125.239 ms/op
Iteration   4: 132.497 ms/op
Iteration   5: 149.021 ms/op
Iteration   6: 132.312 ms/op
Iteration   7: 133.889 ms/op
Iteration   8: 168.473 ms/op
Iteration   9: 188.927 ms/op
Iteration  10: 189.132 ms/op
Iteration  11: 186.859 ms/op
Iteration  12: 134.594 ms/op
Iteration  13: 128.342 ms/op
Iteration  14: 155.537 ms/op
Iteration  15: 131.376 ms/op


Result "com.conversantmedia.LinkedTransferQueueBenchmark.sendOneMWaiting":
  149.989 ±(99.9%) 25.768 ms/op [Average]
  (min, avg, max) = (125.239, 149.989, 189.132), stdev = 24.103
  CI (99.9%): [124.222, 175.757] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.MPMCBlockingQueueBenchmark.addOneM

# Run progress: 68.75% complete, ETA 00:02:09
# Fork: 1 of 1
# Warmup Iteration   1: 54.432 ms/op
# Warmup Iteration   2: 54.440 ms/op
# Warmup Iteration   3: 51.986 ms/op
# Warmup Iteration   4: 51.710 ms/op
# Warmup Iteration   5: 51.665 ms/op
# Warmup Iteration   6: 51.733 ms/op
# Warmup Iteration   7: 51.653 ms/op
# Warmup Iteration   8: 51.635 ms/op
Iteration   1: 51.617 ms/op
Iteration   2: 51.727 ms/op
Iteration   3: 52.263 ms/op
Iteration   4: 51.653 ms/op
Iteration   5: 52.129 ms/op
Iteration   6: 51.751 ms/op
Iteration   7: 51.658 ms/op
Iteration   8: 51.745 ms/op
Iteration   9: 51.603 ms/op
Iteration  10: 52.069 ms/op
Iteration  11: 52.456 ms/op
Iteration  12: 53.155 ms/op
Iteration  13: 52.232 ms/op
Iteration  14: 57.696 ms/op
Iteration  15: 52.255 ms/op


Result "com.conversantmedia.MPMCBlockingQueueBenchmark.addOneM":
  52.401 ±(99.9%) 1.630 ms/op [Average]
  (min, avg, max) = (51.603, 52.401, 57.696), stdev = 1.524
  CI (99.9%): [50.771, 54.031] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.MPMCBlockingQueueBenchmark.addOneMNThread

# Run progress: 75.00% complete, ETA 00:01:43
# Fork: 1 of 1
# Warmup Iteration   1: 204.238 ms/op
# Warmup Iteration   2: 260.413 ms/op
# Warmup Iteration   3: 246.878 ms/op
# Warmup Iteration   4: 241.960 ms/op
# Warmup Iteration   5: 336.127 ms/op
# Warmup Iteration   6: 222.743 ms/op
# Warmup Iteration   7: 283.140 ms/op
# Warmup Iteration   8: 292.502 ms/op
Iteration   1: 262.615 ms/op
Iteration   2: 325.283 ms/op
Iteration   3: 252.948 ms/op
Iteration   4: 265.691 ms/op
Iteration   5: 383.929 ms/op
Iteration   6: 402.604 ms/op
Iteration   7: 262.340 ms/op
Iteration   8: 290.601 ms/op
Iteration   9: 368.229 ms/op
Iteration  10: 350.241 ms/op
Iteration  11: 287.425 ms/op
Iteration  12: 316.427 ms/op
Iteration  13: 310.631 ms/op
Iteration  14: 341.238 ms/op
Iteration  15: 258.134 ms/op


Result "com.conversantmedia.MPMCBlockingQueueBenchmark.addOneMNThread":
  311.889 ±(99.9%) 52.342 ms/op [Average]
  (min, avg, max) = (252.948, 311.889, 402.604), stdev = 48.960
  CI (99.9%): [259.548, 364.231] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.MPMCBlockingQueueBenchmark.addOneMWaiting

# Run progress: 81.25% complete, ETA 00:01:17
# Fork: 1 of 1
# Warmup Iteration   1: 50.292 ms/op
# Warmup Iteration   2: 44.959 ms/op
# Warmup Iteration   3: 44.947 ms/op
# Warmup Iteration   4: 44.770 ms/op
# Warmup Iteration   5: 44.556 ms/op
# Warmup Iteration   6: 44.703 ms/op
# Warmup Iteration   7: 44.565 ms/op
# Warmup Iteration   8: 44.570 ms/op
Iteration   1: 44.575 ms/op
Iteration   2: 44.618 ms/op
Iteration   3: 44.971 ms/op
Iteration   4: 45.553 ms/op
Iteration   5: 44.456 ms/op
Iteration   6: 44.495 ms/op
Iteration   7: 44.468 ms/op
Iteration   8: 44.884 ms/op
Iteration   9: 44.939 ms/op
Iteration  10: 44.731 ms/op
Iteration  11: 44.305 ms/op
Iteration  12: 44.808 ms/op
Iteration  13: 44.276 ms/op
Iteration  14: 44.833 ms/op
Iteration  15: 44.261 ms/op


Result "com.conversantmedia.MPMCBlockingQueueBenchmark.addOneMWaiting":
  44.678 ±(99.9%) 0.364 ms/op [Average]
  (min, avg, max) = (44.261, 44.678, 45.553), stdev = 0.340
  CI (99.9%): [44.314, 45.042] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneM

# Run progress: 87.50% complete, ETA 00:00:51
# Fork: 1 of 1
# Warmup Iteration   1: 115.431 ms/op
# Warmup Iteration   2: 113.153 ms/op
# Warmup Iteration   3: 112.018 ms/op
# Warmup Iteration   4: 112.492 ms/op
# Warmup Iteration   5: 111.797 ms/op
# Warmup Iteration   6: 111.924 ms/op
# Warmup Iteration   7: 111.756 ms/op
# Warmup Iteration   8: 112.063 ms/op
Iteration   1: 111.767 ms/op
Iteration   2: 111.863 ms/op
Iteration   3: 111.868 ms/op
Iteration   4: 111.858 ms/op
Iteration   5: 111.576 ms/op
Iteration   6: 111.823 ms/op
Iteration   7: 111.833 ms/op
Iteration   8: 111.916 ms/op
Iteration   9: 111.911 ms/op
Iteration  10: 111.631 ms/op
Iteration  11: 111.773 ms/op
Iteration  12: 111.729 ms/op
Iteration  13: 112.250 ms/op
Iteration  14: 112.673 ms/op
Iteration  15: 111.802 ms/op


Result "com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneM":
  111.885 ±(99.9%) 0.283 ms/op [Average]
  (min, avg, max) = (111.576, 111.885, 112.673), stdev = 0.265
  CI (99.9%): [111.602, 112.168] (assumes normal distribution)


# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/java/jdk1.8.0_121/jre/bin/java
# VM options: -XX:-RestrictContended
# Warmup: 8 iterations, 1 s each
# Measurement: 15 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneMWaiting

# Run progress: 93.75% complete, ETA 00:00:25
# Fork: 1 of 1
# Warmup Iteration   1: 129.431 ms/op
# Warmup Iteration   2: 120.089 ms/op
# Warmup Iteration   3: 119.267 ms/op
# Warmup Iteration   4: 121.043 ms/op
# Warmup Iteration   5: 118.906 ms/op
# Warmup Iteration   6: 120.183 ms/op
# Warmup Iteration   7: 122.231 ms/op
# Warmup Iteration   8: 118.832 ms/op
Iteration   1: 118.456 ms/op
Iteration   2: 118.213 ms/op
Iteration   3: 119.135 ms/op
Iteration   4: 118.612 ms/op
Iteration   5: 121.866 ms/op
Iteration   6: 122.043 ms/op
Iteration   7: 123.503 ms/op
Iteration   8: 122.520 ms/op
Iteration   9: 118.520 ms/op
Iteration  10: 118.376 ms/op
Iteration  11: 118.471 ms/op
Iteration  12: 118.397 ms/op
Iteration  13: 121.858 ms/op
Iteration  14: 122.141 ms/op
Iteration  15: 121.950 ms/op


Result "com.conversantmedia.PushPullBlockingQueueBenchmark.sendOneMWaiting":
  120.271 ±(99.9%) 2.119 ms/op [Average]
  (min, avg, max) = (118.213, 120.271, 123.503), stdev = 1.982
  CI (99.9%): [118.152, 122.390] (assumes normal distribution)


# Run complete. Total time: 00:06:49

Benchmark                                       Mode  Cnt     Score     Error  Units
ArrayBlockingQueueBenchmark.sendOneM            avgt   15   376.906 ±  28.876  ms/op
ArrayBlockingQueueBenchmark.sendOneMWaiting     avgt   15   361.183 ±  45.868  ms/op
ConcurrentStackBenchmark.addOneM                avgt   15   169.317 ±  10.837  ms/op
ConcurrentStackBenchmark.addOneMWaiting         avgt   15   262.684 ±  15.731  ms/op
DisruptorBlockingQueueBenchmark.addOneM         avgt   15    31.148 ±   2.379  ms/op
DisruptorBlockingQueueBenchmark.addOneMNThread  avgt   15  1383.277 ± 245.628  ms/op
DisruptorBlockingQueueBenchmark.addOneMWaiting  avgt   15    35.632 ±   6.454  ms/op
LMAXDisruptorBenchmark.addOneM                  avgt   15    61.129 ±   1.161  ms/op
LMAXDisruptorPushPullBenchmark.addOneM          avgt   15    33.957 ±   0.549  ms/op
LinkedTransferQueueBenchmark.sendOneM           avgt   15   125.511 ±   3.561  ms/op
LinkedTransferQueueBenchmark.sendOneMWaiting    avgt   15   149.989 ±  25.768  ms/op
MPMCBlockingQueueBenchmark.addOneM              avgt   15    52.401 ±   1.630  ms/op
MPMCBlockingQueueBenchmark.addOneMNThread       avgt   15   311.889 ±  52.342  ms/op
MPMCBlockingQueueBenchmark.addOneMWaiting       avgt   15    44.678 ±   0.364  ms/op
PushPullBlockingQueueBenchmark.sendOneM         avgt   15   111.885 ±   0.283  ms/op
PushPullBlockingQueueBenchmark.sendOneMWaiting  avgt   15   120.271 ±   2.119  ms/op
```
