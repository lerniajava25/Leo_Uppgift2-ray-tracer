package org;

import org.shapes.Sphere;
import org.shapes.Triangle;

import java.io.IOException;

public class Main {

    static void main() throws IOException {
        Scene scene = new Scene();

        Sphere sphere = new Sphere(
                new Vector3D(0.8, 0, -5),
                0.8
        );

        scene.addShape(sphere);

        Triangle triangle = new Triangle(
                new Vector3D(-1.5, -0.8, -4),
                new Vector3D(-0.2, -0.8, -4),
                new Vector3D(-0.85, 0.8, -4)
        );

        scene.addShape(triangle);

        Renderer renderer = new Renderer(400, 300);
        renderer.render(scene, "render.ppm");
    }
}
