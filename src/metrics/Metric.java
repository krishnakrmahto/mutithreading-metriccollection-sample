package metrics;

public interface Metric<T, R> {

  void computeWithSample(T sample);

  R get();
}
