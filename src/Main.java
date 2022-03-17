import metrics.MetricsPrinter;
import metrics.average.ExampleAverageMetric;
import service.BusinessService;

public class Main {

  public static void main(String[] args) {

    ExampleAverageMetric metric = new ExampleAverageMetric();

    BusinessService businessServiceThread1 = new BusinessService(metric);
    BusinessService businessServiceThread2 = new BusinessService(metric);

    MetricsPrinter metricsPrinter = new MetricsPrinter(metric);

    businessServiceThread1.start();
    businessServiceThread2.start();
    metricsPrinter.start();
  }

}
