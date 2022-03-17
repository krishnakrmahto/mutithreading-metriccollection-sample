package metrics.average;

import metrics.Metric;

/**
 * One object of this Metric object exists in the application, which is a single process which we
 * would like to collect metrics of. Therefore, same object will be shared by different threads.
 * Operations on long and double are not atomic.
 * computeCurrentAverageWithSample method has multiple lines of code, and hence it is easy to see
 * it is not an atomic operation without the synchronized keyword, moreover, the method does operations
 * on sampleCount and average, operations on which are non-atomic by default without the volatile
 * keyword.
 * We have made only average as atomic because operations (both read and write) are non-atomic
 * on double are non-atomic by default, and we have a getter defined for it.
 * Since all operations on sampleCount happen inside the synchronized computeCurrentAverageWithSample
 * method, we need not make it volatile at this point.
 */
public class ExampleAverageMetric implements Metric<Long, Double> {

  private long sampleCount;
  private volatile double average;

  @Override
  public Double get() {
    return average;
  }

  @Override
  public synchronized void computeWithSample(Long sample) {
    double currentSum = sampleCount * average;
    sampleCount++;
    average = (currentSum + sample) / sampleCount;
  }
}
