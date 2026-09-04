# Java Raytracer
A raytracer written in Java

## Project structure

- `Main` - Entry point of the program. Creates the scene, shapes and renderer.
- `Renderer` - Renders the scene by creating rays for the image pixels and writes the result to a PPM image file.
- `Scene` - Stores the shapes in the scene and checks whether a ray intersects any of them.
- `Shape` - Interface implemented by the different shapes. Defines the `hit(Ray ray)` method and the `Hit` result.
- `Sphere` - Represents a sphere and implements the ray-sphere intersection logic.
- `Triangle` - Represents a triangle and implements the ray-triangle intersection logic.
- `Ray` - Record representing a ray using an origin and a direction.
- `Vector3D` - Record representing a three-dimensional vector and providing the vector operations used by the raytracer.
- `Color` - Record representing an RGB color.

## Add a new shape

To add a new shape to the raytracer, use the following steps:

1. Create a new class that implements the Shape interface
2. Implement the "hit(Ray ray)" method. This should return a Hit object indicating if the ray intersects the shape in question.
3. Create an instance of your new shape in Main and add it to the Scene with "addShape".

Example of implementation:
```java
public class YourShape implements Shape(){

    @Override
    public Hit hit(Ray ray){
    //Add your intersection logic here
    return new Hit(false);
    }
}

When an instance has been created, add it to the scene:


scene.addShape(yourShape);

