package uk.ac.cam.kjh67.q50;


public final class Point3D implements Comparable<Point3D> {
    private final double x;
    private final double y;
    private final double z;

    Point3D (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Point3D p) {
        if (
                this.z < p.z
                || (this.z == p.z && this.y < p.y)
                || (this.z == p.z && this.y == p.y && this.x < p.x)
        ) {
                return -1;
            }
        else if (this.z == p.z && this.y == p.y && this.x == p.x) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%s]", x, y, z);
    }
}