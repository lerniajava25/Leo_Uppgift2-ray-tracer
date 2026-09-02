package org;

import org.shapes.Shape;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Renderer {
    private int width;
    private int height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Scene scene, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.write("P3\n");
        writer.write(width + " " + height + "\n");
        writer.write("255\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double viewportX = (x - width / 2.0) / width;
                double viewportY = (height / 2.0 - y) / height;

                Vector3D direction = new Vector3D(viewportX, viewportY, -1);
                Ray ray = new Ray(new Vector3D(0, 0, 0), direction);
                Shape.Hit hit = scene.hit(ray);

                Color color;

                if (hit.hit()) {
                    color = new Color(255, 120, 30);
                } else {
                    color = new Color(20, 20, 30);
                }

                writer.write(color.red() + " " + color.green() + " " + color.blue() + "\n");
            }
        }

        writer.close();
    }
}
