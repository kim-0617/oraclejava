package oop04.poly;

public class PointTest {
  public static void main(String[] args) {
    // up casting
    Point2D pt = new Point3D();
    pt.x = 1100;
    pt.y = 2100;

    // down casting
    Point3D dn = (Point3D) pt;
    dn.z = 3100;

    dn.print();
  }
}
