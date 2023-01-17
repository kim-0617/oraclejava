package oop05.abstract01;

public class ShapeTest {
  public static void main(String[] args) {
    printArea(new Circle());
    printArea(new Triangle());
    printArea(new Rectangle());
  }

  private static void printArea(Shape s) {
    s.area();

    if (s instanceof Circle) {
      Circle c = (Circle) s;
      System.out.println(c.res);
    } else if (s instanceof Triangle) {
      Triangle t = (Triangle) s;
      System.out.println(t.res);
    } else if (s instanceof Rectangle) {
      Rectangle r = (Rectangle) s;
      System.out.println(r.res);
    }
  }

  // private static void printArea(Rectangle r) {
  // r.area();
  // System.out.println(r.res);
  // }
  //
  // private static void printArea(Triangle t) {
  // t.area();
  // System.out.println(t.res);
  // }
  //
  // private static void printArea(Circle c) {
  // c.area();
  // System.out.println(c.res);
  // }
}
