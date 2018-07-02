

public class Point {
  public double p1;
  public double p2;

  public Point(double p1, double p2){
      this.p1 = p1;
      this.p2 = p2;
  }

  public double calculateDistance(Point p) {
      double dx = this.p1 - p.p1;
      double dy =  this.p2 - p.p2;
      return Math.sqrt((dx * dx) + (dy * dy));

  }
  }


