package MainApp;

import Etc.Position;
import Etc.RotationDirection;
import SubCubes.SubCube;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.ArrayList;

public class CubeSliceManager {
    private ICubeSlice topSlice;
    private ICubeSlice bottomSlice;
    private ICubeSlice leftSlice;
    private ICubeSlice rightSlice;
    private ICubeSlice frontSlice;
    private ICubeSlice backSlice;

    public CubeSliceManager(ArrayList<SubCube> subCubes){
        topSlice = new TopCubeSlice(subCubes.get(6), subCubes.get(7), subCubes.get(8),
                                      subCubes.get(3), subCubes.get(4), subCubes.get(5),
                                      subCubes.get(0), subCubes.get(1), subCubes.get(2));
        topSlice.display();

        bottomSlice = new BottomCubeSlice(subCubes.get(18), subCubes.get(19), subCubes.get(20),
                                            subCubes.get(21), subCubes.get(22), subCubes.get(23),
                                            subCubes.get(24), subCubes.get(25), subCubes.get(26));
        bottomSlice.display();

        leftSlice = new LeftCubeSlice(subCubes.get(6), subCubes.get(3), subCubes.get(0),
                                        subCubes.get(15), subCubes.get(12), subCubes.get(9),
                                        subCubes.get(24), subCubes.get(21), subCubes.get(18));
        leftSlice.display();

        rightSlice = new RightCubeSlice(subCubes.get(2), subCubes.get(5), subCubes.get(8),
                                          subCubes.get(11), subCubes.get(14), subCubes.get(17),
                                          subCubes.get(20), subCubes.get(23), subCubes.get(26));
        rightSlice.display();

        frontSlice = new FrontCubeSlice(subCubes.get(0), subCubes.get(1), subCubes.get(2),
                                          subCubes.get(9), subCubes.get(10), subCubes.get(11),
                                          subCubes.get(18), subCubes.get(19), subCubes.get(20));
        frontSlice.display();

        backSlice = new BackCubeSlice(subCubes.get(8), subCubes.get(7), subCubes.get(6),
                                        subCubes.get(17), subCubes.get(16), subCubes.get(15),
                                        subCubes.get(26), subCubes.get(25), subCubes.get(24));
        backSlice.display();

        topSlice.setRelations((CubeSlice)backSlice, (CubeSlice)frontSlice, (CubeSlice)leftSlice, (CubeSlice)rightSlice);
        bottomSlice.setRelations((CubeSlice)frontSlice, (CubeSlice)backSlice, (CubeSlice)leftSlice, (CubeSlice)rightSlice);
        frontSlice.setRelations((CubeSlice)topSlice, (CubeSlice)bottomSlice, (CubeSlice)leftSlice, (CubeSlice)rightSlice);
        backSlice.setRelations((CubeSlice)topSlice, (CubeSlice)bottomSlice, (CubeSlice)rightSlice, (CubeSlice)leftSlice);
        leftSlice.setRelations((CubeSlice)topSlice, (CubeSlice)bottomSlice, (CubeSlice)backSlice, (CubeSlice)frontSlice);
        rightSlice.setRelations((CubeSlice)topSlice, (CubeSlice)bottomSlice, (CubeSlice)frontSlice, (CubeSlice)backSlice);
    }

    public void rotateSlice(Position position, RotationDirection direction){
        System.out.println("----- Rotating " + position.name() + ": " + direction.name() + " -----");
        switch (position) {
            case Top:
                topSlice.rotate(direction);
                break;
            case Bottom:
                bottomSlice.rotate(direction);
                break;
            case Front:
                frontSlice.rotate(direction);
                break;
            case Back:
                backSlice.rotate(direction);
                break;
            case Left:
                leftSlice.rotate(direction);
                break;
            case Right:
                rightSlice.rotate(direction);
                break;
            default:
                throw new InternalException("No such position :)");
        }

        displayAllSlices();
    }

    public void displayAllSlices() {
        System.out.println("----- Displaying all slices -----");
        topSlice.display();
        bottomSlice.display();
        frontSlice.display();
        backSlice.display();
        leftSlice.display();
        rightSlice.display();
    }
}
