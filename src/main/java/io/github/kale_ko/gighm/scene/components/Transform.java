package io.github.kale_ko.gighm.scene.components;

import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3f;

/**
 * An object transform
 * 
 * @version 1.3.0
 * @since 1.0.0
 */
public class Transform extends Component {
    /**
     * The position of the object
     * 
     * @since 1.0.0
     */
    private Vector3d position;

    /**
     * The rotation of the object
     * 
     * @since 1.0.0
     */
    private Quaterniond rotation;

    /**
     * The scale of the object
     * 
     * @since 1.0.0
     */
    private Vector3d scale;

    /**
     * Create an object transform
     * 
     * @param position The position of the object
     * @param rotation The rotation of the object
     * @param scale The scale of the object
     * 
     * @since 1.0.0
     */
    public Transform(Vector3d position, Quaterniond rotation, Vector3d scale) {
        this.position = position;

        this.rotation = rotation;

        this.scale = scale;
    }

    /**
     * Get the position of the object
     * 
     * @return The position of the object
     * 
     * @since 1.0.0
     */
    public Vector3d getPosition() {
        return this.position;
    }

    /**
     * Set the position of the object
     * 
     * @param position The position of the object
     * 
     * @since 1.0.0
     */
    public void setPosition(Vector3d position) {
        this.position = position;
    }

    /**
     * Set the position of the object
     * 
     * @param position The position of the object
     * 
     * @since 1.0.0
     */
    public void setPosition(Vector2d position) {
        this.position = new Vector3d(position, 0);
    }

    /**
     * Get the rotation of the object
     * 
     * @return The rotation of the object
     * 
     * @since 1.0.0
     */
    public Quaterniond getRotation() {
        return this.rotation;
    }

    /**
     * Set the rotation of the object
     * 
     * @param rotation The rotation of the object
     * 
     * @since 1.0.0
     */
    public void setRotation(Quaterniond rotation) {
        this.rotation = rotation;
    }

    /**
     * Set the rotation of the object
     * 
     * @param rotation The rotation of the object
     * 
     * @since 1.3.0
     */
    public void setRotation(Vector3d rotation) {
        this.rotation = new Quaterniond().rotateXYZ(rotation.x, rotation.y, rotation.z);
    }

    /**
     * Set the rotation of the object
     * 
     * @param rotation The rotation of the object
     * 
     * @since 1.3.0
     */
    public void setRotation(double rotation) {
        this.rotation = new Quaterniond().rotateXYZ(rotation, 0, 0);
    }

    /**
     * Get the scale of the object
     * 
     * @return The scale of the object
     * 
     * @since 1.0.0
     */
    public Vector3d getScale() {
        return this.scale;
    }

    /**
     * Set the scale of the object
     * 
     * @param scale The scale of the object
     * 
     * @since 1.0.0
     */
    public void setScale(Vector3d scale) {
        this.scale = scale;
    }

    /**
     * Set the scale of the object
     * 
     * @param scale The scale of the object
     * 
     * @since 1.0.0
     */
    public void setScale(Vector2d scale) {
        this.scale = new Vector3d(scale, 1);
    }

    /**
     * Get the complete matrix of the transform
     * 
     * @return The complete matrix of the transform
     */
    public Matrix4f getMatrix() {
        return new Matrix4f().translate(this.position.get(new Vector3f())).rotate(this.rotation.get(new Quaternionf())).scale(this.scale.get(new Vector3f()));
    }

    /**
     * Get the name of the component
     * 
     * @return The name of the component
     * 
     * @since 1.0.0
     */
    public static String getName() {
        return "Transform";
    }
}