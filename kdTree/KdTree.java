public class Kdtree {


  private double x;
  private double y;
  private Point2D value;

  private KdTree left;
  private KdTree right;

  private int axis; // -1 for X  // 0 for start // 1 for Y 
  private int size;

  public KdTree() {
    this.size = 0;
    this.axis = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  } 
  private int size() {
    return this.size;
  }

  public void insert(Point2D p) {
    if (p == null) throw new IllegalArgumentException();
    if (isEmpty()) {
      this.value = p;
      this.size++;
      return; 
    }
    if (this.value == p) {
      return;
    }
    // Insert on X axis
    if (this.axis <= 0) {
      if (this.value.x() >= p.x()) {
        this.left.insert(p);
        return;
      } else {
        this.right.insert(p);
        return;
      }
    }
    // Insert on Y axis
    if (this.axis >= 0) {
      if (this.value.y() >= p.y()) {
        this.left.insert(p);
        return;
      } else {
        this.right.insert(p);
        return;
      }
    }
  }

  public static void main(String[] args) {

  }
}