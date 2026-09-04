# Java Raytracer
A raytracer written in Java

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

