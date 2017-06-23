/**
 * This class allows the user to create a box defined by height, width, and
 * depth. Constructors exist to accept specific dimensions, one dimension
 * (effectively creating a cube), a Box object (to create a clone), or no
 * dimensions (creating a default box with dimensions of zero).
 *
 * @author  Ravi S. Ramphal
 * @class   CCSF CS111B
 * @date    2017.06.22
 * @version 1.0
 */

public class Box
{
    /**
     * Holds the height of a box.
     */
    int height;

    /**
     * Holds the width of a box.
     */
    int width;

    /**
     * Holds the depth of a box.
     */
    int depth;

    /**
     * This is the parameterized constructor to create a box from a height,
     * width, and depth.
     *
     * param height The height of the box
     * param width  The width  of the box
     * param depth  The depth  of the box
     */
    public Box(int height, int width, int depth)
    {
        this.height = height;
        this.width  = width;
        this.depth  = depth;
    }

    /**
     * This is the parameterized constructor to create a cube.
     *
     * param dimension The value for the box's height, width, and depth
     */
    public Box(int dimension)
    {
        // this.height = dimension;
        // this.width  = dimension;
        // this.depth  = dimension;

        this(dimension, dimension, dimension);
    }

    /**
     * This is the parameterized constructor to clone a given Box.
     *
     * param box An instance of `Box` that you would like to clone
     */
    public Box(Box box)
    {
        // this.height = box.height;
        // this.width  = box.width;
        // this.depth  = box.depth;

        this(box.height, box.width, box.depth);
    }

    /**
     * This overrides the default constructor to create a box with
     * zero dimensions if nothing is passed in.
     */
    public Box()
    {
        // this.height = 0;
        // this.width  = 0;
        // this.depth  = 0;

        this(0, 0, 0);
    }

    /**
     * This method returns the volume of the box.
     *
     * @return int This returns the volume of the box.
     */
    public int volume()
    {
        return this.height * this.width * this.depth;
    }

    /**
     * This method allows a quick way for a user to output the dimensions of
     * a box.
     */
    public void show()
    {
        System.out.println("height : " + this.height);
        System.out.println("width  : " + this.width);
        System.out.println("depth  : " + this.height);
    }

    /**
     * This method allows a quick way for a user to output the dimensions of
     * a box.
     *
     * @param  box     A given box to test against
     * @return boolean Returns whether or not all the dimensions of a box match
     */
    public boolean equals(Box box)
    {
        return (
            this.height == box.height &&
            this.width  == box.width  &&
            this.depth  == box.depth
        );
    }

    /**
     * This method specifies what is returned when an instance of Box is cast
     * to a String.
     */
    public String toString()
    {
        return (
            String.format(
                "(instance of Box: @height = %d; @width = %d; @depth = %d)",
                                  this.height,   this.width,   this.depth
            )
        );
    }
}
