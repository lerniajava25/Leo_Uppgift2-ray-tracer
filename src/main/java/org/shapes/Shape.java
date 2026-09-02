package org.shapes;

import org.Ray;

public interface Shape {

    Hit hit(Ray ray);

    record Hit(boolean hit){}
}
