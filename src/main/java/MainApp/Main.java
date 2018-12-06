package MainApp;

import Etc.CubeType;

import static Etc.Position.*;
import static Etc.RotationDirection.*;
import static Etc.Color.*;

public class Main {
    public static void main(String[] args) {
        //testingHardcoded();
        testingScrable();
    }

    private static void testingScrable() {
        Cube scrabledCube = ScrableReader.generateFromString("U1U1F1U1U1R3L1F1F1U1F3B3R1L1U1U1R1U1D3R1L3D1R3L3D3");
    }

    private static void testingHardcoded() {
        Cube cube = new Cube(CubeType.Hardcoded);

        /*cube.rotateSlice(Bottom, CCW);
        cube.rotateSlice(Left, CCW);
        cube.rotateSlice(Top, CCW);
        cube.rotateSlice(Right, CCW);
        cube.rotateSlice(Back, CCW);
        cube.rotateSlice(Front, CCW);*/

        cube.rotateSlice(Bottom, ACW);
        cube.rotateSlice(Left, ACW);
        cube.rotateSlice(Top, ACW);
        cube.rotateSlice(Right, ACW);
        cube.rotateSlice(Back, ACW);
        cube.rotateSlice(Front, ACW);

        ComparableSlice newSlice = new ComparableSlice(Green, Green, Green, Green, Green, Green, Green, Green, Green);

        ComparableSliceResult frontCheck = cube.compareSlice(Front, newSlice);
        frontCheck.displayResult();
    }
}
