package org;

public record Vector3D(double x, double y, double z) {

    //calculate the difference between the ray origin and sphere center
    public Vector3D subtract(Vector3D other) {
        return new Vector3D(
                this.x() - other.x(),
                this.y() - other.y(),
                this.z() - other.z()
        );
    }

    public double dot(Vector3D other) {
        double x = this.x() * other.x();
        double y = this.y() * other.y();
        double z = this.z() * other.z();

        return x + y + z;
    }

    //Möller trumbore algorithm to see if ray crosses triangle
    public Vector3D cross(Vector3D other){
        double x = this.y() * other.z() - this.z() * other.y();
        double y = this.z() * other.x() - this.x() * other.z();
        double z = this.x() * other.y() - this.y() * other.x();

        return new Vector3D(x,y,z);
    }
}
