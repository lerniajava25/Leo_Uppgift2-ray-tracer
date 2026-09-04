package org.shapes;

import org.Ray;
import org.Vector3D;

public class Sphere implements Shape {
    private final Vector3D center;
    private final double radius;

    public Sphere(Vector3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Hit hit(Ray ray) {
        Vector3D centerToOrigin = ray.origin().subtract(center);
        double a = ray.direction().dot(ray.direction());
        double b = 2.0 * centerToOrigin.dot(ray.direction());
        double c = centerToOrigin.dot(centerToOrigin) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        return new Hit(discriminant >= 0);
    }
}
