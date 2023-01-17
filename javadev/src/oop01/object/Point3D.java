package oop01.object;

public class Point3D extends Point2D {
  private int z;

  public Point3D() {
    // super();
    // this.z = 30;

    this(10, 20, 30);
  }

  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
    System.out.println("z 값 추가 설정");
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

  @Override
  public void print() {
    super.print();
    System.out.println(this.getZ());
  }
}
