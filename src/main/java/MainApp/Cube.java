package MainApp;

import Etc.RotationDirection;
import SubCubes.Edge;
import SubCubes.SubCube;
import SubCubes.Center;
import SubCubes.Corner;
import Etc.ColorPosition;

import java.util.ArrayList;
import java.util.Arrays;

import static Etc.Color.*;
import static Etc.Position.*;

public class Cube {
    private ArrayList<SubCube> subCubes = new ArrayList<>();
    private CubeSliceManager csm;

    public Cube(){
        createPresetSubCubes();

        if (verifyColors()) {
            csm = new CubeSliceManager(subCubes);
            csm.rotateSlice(Bottom, RotationDirection.CCW);
        }
    }

    private void createPresetSubCubes() {
        // top
        subCubes.add(new Corner(new ColorPosition(Red, Left), new ColorPosition(White, Front), new ColorPosition(Green, Top)));
        subCubes.add(new Edge(new ColorPosition(Yellow, Front), new ColorPosition(Green, Top)));
        subCubes.add(new Corner(new ColorPosition(Yellow, Front), new ColorPosition(Blue, Top), new ColorPosition(Orange, Right)));
        subCubes.add(new Edge(new ColorPosition(Yellow, Left), new ColorPosition(Red, Top)));
        subCubes.add(new Center(new ColorPosition(Blue, Top)));
        subCubes.add(new Edge(new ColorPosition(Green, Top), new ColorPosition(Red, Right)));
        subCubes.add(new Corner(new ColorPosition(White, Left), new ColorPosition(Blue, Top), new ColorPosition(Orange, Back)));
        subCubes.add(new Edge(new ColorPosition(Blue, Top), new ColorPosition(White, Back)));
        subCubes.add(new Corner(new ColorPosition(Red, Top), new ColorPosition(Green, Right), new ColorPosition(Yellow, Back)));
        // middle
        subCubes.add(new Edge(new ColorPosition(White, Left), new ColorPosition(Red, Front)));
        subCubes.add(new Center(new ColorPosition(Yellow, Front)));
        subCubes.add(new Edge(new ColorPosition(White, Front), new ColorPosition(Orange, Right)));
        subCubes.add(new Center(new ColorPosition(Red, Left)));
        subCubes.add(new Center(new ColorPosition(None, Top))); // empty core sub cube
        subCubes.add(new Center(new ColorPosition(Orange, Right)));
        subCubes.add(new Edge(new ColorPosition(Green, Left), new ColorPosition(Orange, Back)));
        subCubes.add(new Center(new ColorPosition(White, Back)));
        subCubes.add(new Edge(new ColorPosition(Yellow, Back), new ColorPosition(Orange, Right)));
        // bottom
        subCubes.add(new Corner(new ColorPosition(Blue, Left), new ColorPosition(Red, Front), new ColorPosition(White, Bottom)));
        subCubes.add(new Edge(new ColorPosition(Orange, Front), new ColorPosition(Blue, Bottom)));
        subCubes.add(new Corner(new ColorPosition(Red, Front), new ColorPosition(Yellow, Bottom), new ColorPosition(Blue, Right)));
        subCubes.add(new Edge(new ColorPosition(Blue, Left), new ColorPosition(Yellow, Bottom)));
        subCubes.add(new Center(new ColorPosition(Green, Bottom)));
        subCubes.add(new Edge(new ColorPosition(White, Bottom), new ColorPosition(Green, Right)));
        subCubes.add(new Corner(new ColorPosition(Orange, Left), new ColorPosition(Green, Bottom), new ColorPosition(Yellow, Back)));
        subCubes.add(new Edge(new ColorPosition(Red, Bottom), new ColorPosition(Blue, Back)));
        subCubes.add(new Corner(new ColorPosition(White, Bottom), new ColorPosition(Green, Right), new ColorPosition(Orange, Back)));
    }

    public boolean verifyColors(){
        int greenCount = 0, yellowCount = 0, redCount = 0, blueCount = 0, orangeCount = 0, whiteCount = 0;

        for (SubCube sc: subCubes) {
            redCount += Arrays.stream(sc.getAllColors()).filter(c -> c == Red).count();
            greenCount += Arrays.stream(sc.getAllColors()).filter(c -> c == Green).count();
            yellowCount += Arrays.stream(sc.getAllColors()).filter(c -> c == Yellow).count();
            blueCount += Arrays.stream(sc.getAllColors()).filter(c -> c == Blue).count();
            orangeCount += Arrays.stream(sc.getAllColors()).filter(c -> c == Orange).count();
            whiteCount += Arrays.stream(sc.getAllColors()).filter(c -> c == White).count();
        }

        int[] colorCount = new int[]{greenCount, yellowCount, redCount, blueCount, orangeCount, whiteCount};
        return Arrays.stream(colorCount).sum() == 54;
    }
}
