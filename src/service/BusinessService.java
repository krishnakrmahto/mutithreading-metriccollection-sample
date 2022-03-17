package service;

import java.util.Random;
import metrics.average.ExampleAverageMetric;

public class BusinessService extends Thread {

  private final ExampleAverageMetric metric;
  private final Random random = new Random();

  public BusinessService(ExampleAverageMetric metric) {
    this.metric = metric;
  }

  @Override
  public void run() {
    long start = System.currentTimeMillis();

    while (true) {
      try {
        Thread.sleep(random.nextInt(10));
      } catch (InterruptedException e) {
        System.out.println("InterruptedException caught");
      }
      long end = System.currentTimeMillis();

      metric.computeWithSample(end - start);
    }
  }
}
