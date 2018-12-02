package Slices;

import Etc.Position;
import Etc.RotationDirection;
import MainApp.ComparableSliceResult;
import MainApp.ComparebleSlice;
import SubCubes.SubCube;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.ArrayList;
import java.util.HashMap;

import static Etc.Position.*;

public class CubeSliceManager {
    private HashMap<Position, CubeSlice> slices = new HashMap<>();

    public CubeSliceManager(ArrayList<SubCube> subCubes){
        slices.put(Top, new TopCubeSlice(subCubes.get(6), subCubes.get(7), subCubes.get(8),
                                         subCubes.get(3), subCubes.get(4), subCubes.get(5),
                                         subCubes.get(0), subCubes.get(1), subCubes.get(2)));
        slices.put(Bottom, new BottomCubeSlice(subCubes.get(18), subCubes.get(19), subCubes.get(20),
                                               subCubes.get(21), subCubes.get(22), subCubes.get(23),
                                               subCubes.get(24), subCubes.get(25), subCubes.get(26)));
        slices.put(Left, new LeftCubeSlice(subCubes.get(6), subCubes.get(3), subCubes.get(0),
                                           subCubes.get(15), subCubes.get(12), subCubes.get(9),
                                           subCubes.get(24), subCubes.get(21), subCubes.get(18)));

        slices.put(Right, new RightCubeSlice(subCubes.get(2), subCubes.get(5), subCubes.get(8),
                                             subCubes.get(11), subCubes.get(14), subCubes.get(17),
                                             subCubes.get(20), subCubes.get(23), subCubes.get(26)));

        slices.put(Front, new FrontCubeSlice(subCubes.get(0), subCubes.get(1), subCubes.get(2),
                                             subCubes.get(9), subCubes.get(10), subCubes.get(11),
                                             subCubes.get(18), subCubes.get(19), subCubes.get(20)));

        slices.put(Back, new BackCubeSlice(subCubes.get(8), subCubes.get(7), subCubes.get(6),
                                           subCubes.get(17), subCubes.get(16), subCubes.get(15),
                                           subCubes.get(26), subCubes.get(25), subCubes.get(24)));

        slices.get(Top).setRelations(slices.get(Back), slices.get(Front), slices.get(Left), slices.get(Right));
        slices.get(Bottom).setRelations(slices.get(Front), slices.get(Back), slices.get(Left), slices.get(Right));
        slices.get(Front).setRelations(slices.get(Top), slices.get(Bottom), slices.get(Left), slices.get(Right));
        slices.get(Back).setRelations(slices.get(Top), slices.get(Bottom), slices.get(Right), slices.get(Left));
        slices.get(Left).setRelations(slices.get(Top), slices.get(Bottom), slices.get(Back), slices.get(Front));
        slices.get(Right).setRelations(slices.get(Top), slices.get(Bottom), slices.get(Front), slices.get(Back));

        displayAllSlices();
    }

    public void rotateSlice(Position position, RotationDirection direction){
        System.out.println("----- Rotating " + position.name() + ": " + direction.name() + " -----");
        slices.get(position).rotate(direction);
        displayAllSlices();
    }

    public ComparableSliceResult compareSlice(Position position, ComparebleSlice slice) {
        System.out.println("----- Comparing " + position.name() + " slices");
        return slices.get(position).compareSlice(slice);
    }

    public void displayAllSlices() {
        System.out.println("----- Displaying all slices -----");
        slices.forEach((p, s) -> s.display());
    }
}
