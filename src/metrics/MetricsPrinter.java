package metrics;

import metrics.average.ExampleAverageMetric;

public class MetricsPrinter extends Thread {

  private final ExampleAverageMetric metric;

  public MetricsPrinter(ExampleAverageMetric metric) {
    this.metric = metric;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("MetricsPrinter thread InterruptedException");
      }

      double currentAverage = metric.get();
      System.out.println(currentAverage);
    }
  }
}
