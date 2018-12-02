package MainApp;

import static Etc.Position.*;
import static Etc.RotationDirection.*;
import static Etc.Color.*;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube();

        cube.rotateSlice(Bottom, CCW);
        cube.rotateSlice(Left, CCW);
        cube.rotateSlice(Top, CCW);
        cube.rotateSlice(Right, CCW);
        cube.rotateSlice(Back, CCW);
        cube.rotateSlice(Front, CCW);

        ComparebleSlice newSlice = new ComparebleSlice(Green, Green, Green, Green, Green, Green, Green, Green, Green);

        ComparableSliceResult frontCheck = cube.compareSlice(Front, newSlice);
        frontCheck.displayResult();
    }
}
