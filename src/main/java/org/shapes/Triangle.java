package org.shapes;

import org.Ray;
import org.Vector3D;

public class Triangle implements Shape {
    private final Vector3D p1;
    private final Vector3D p2;
    private final Vector3D p3;

    public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public Hit hit(Ray ray) {
        Vector3D edge1 = p2.subtract(p1);
        Vector3D edge2 = p3.subtract(p1);

        Vector3D h = ray.direction().cross(edge2);
        double a = edge1.dot(h);
        double epsilon = 0.0000001;

        if (a > -epsilon && a < epsilon) {
            return new Hit(false);
        }

        double f = 1.0 / a;
        Vector3D s = ray.origin().subtract(p1);
        double u = f * (s.dot(h));

        if (u < 0 || u > 1) {
            return new Hit(false);
        }

        Vector3D q = s.cross(edge1);
        double v = f * (ray.direction().dot(q));

        if (v < 0 || u + v > 1) {
            return new Hit(false);
        }

        double t = f * edge2.dot(q);

        if (t > epsilon) {
            return new Hit(true);
        }

        return new Hit(false);

    }
}
