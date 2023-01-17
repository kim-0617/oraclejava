package oop01.object;

public class Point2D {
  protected int x;
  protected int y;

  public Point2D() {
    this(10, 20);
    System.out.println("Point2D()");
  }

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
    System.out.println("Point2D(x, y)");
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void print() {
    System.out.println(this.getX());
    System.out.println(this.getY());
  }
}
