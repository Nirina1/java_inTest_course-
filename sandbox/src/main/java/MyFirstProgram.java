public class MyFirstProgram {

    public static void main(String[] args) {

      // Point p1 = new Point(5.0,6.0);
      //  Point p2 = new Point(8.0,9.0);
        /* double dx;
        double dy;
        double distance;
        dx = p1.p1 - p2.p1;
        dy = p2.p1 - p2.p2;
        distance = Math.sqrt((dx * dx) + (dy * dy));
        System.out.println("" + distance); */

       Point  p1 = new Point(1.0, 1.0);
       Point  p2 = new Point(3.0, 1.0);
       double distance = p1.calculateDistance(p2);

       System.out.println("the distance is " + distance);



    }
}
