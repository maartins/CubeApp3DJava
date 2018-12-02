package Slices;

import Etc.RotationDirection;
import MainApp.ComparableSliceResult;
import MainApp.ComparebleSlice;
import SubCubes.SubCube;

public class BackCubeSlice extends CubeSlice {

    public BackCubeSlice(SubCube top_l, SubCube top_m, SubCube top_r, SubCube mid_l, SubCube mid_m, SubCube mid_r, SubCube bot_l, SubCube bot_m, SubCube bot_r) {
        super(top_l, top_m, top_r, mid_l, mid_m, mid_r, bot_l, bot_m, bot_r);
    }

    @Override
    public void rotate(RotationDirection direction) {
        subCubes.forEach(sc -> sc.rotateBack(direction));

        SubCube ttop_l = top_l, ttop_m = top_m, ttop_r = top_r;
        SubCube tmid_l = mid_l, tmid_m = mid_m, tmid_r = mid_r;
        SubCube tbot_l = bot_l, tbot_m = bot_m, tbot_r = bot_r;

        if(direction == RotationDirection.CCW) {
            top_l = tbot_l; top_m = tmid_l; top_r = ttop_l;
            mid_l = tbot_m; mid_m = tmid_m; mid_r = ttop_m;
            bot_l = tbot_r; bot_m = tmid_r; bot_r = ttop_r;
        } else {
            top_l = ttop_r; top_m = tmid_r; top_r = tbot_r;
            mid_l = ttop_m; mid_m = tmid_m; mid_r = tbot_m;
            bot_l = ttop_l; bot_m = tmid_l; bot_r = tbot_l;
        }

        top.setTopSide(top_r, top_m, top_l);
        bottom.setBottomSide(bot_r, bot_m, bot_l);
        left.setRightSide(bot_l, mid_l, top_l);
        right.setLeftSide(top_r, mid_r, bot_r);
    }

    @Override
    public ComparableSliceResult compareSlice(ComparebleSlice slice) {
        boolean testTop_l = top_l.getBack() == slice.getTop_l();
        boolean testTop_m = top_m.getBack() == slice.getTop_m();
        boolean testTop_r = top_r.getBack() == slice.getTop_r();

        boolean testMid_l = mid_l.getBack() == slice.getMid_l();
        boolean testMid_m = mid_m.getBack() == slice.getMid_m();
        boolean testMid_r = mid_r.getBack() == slice.getMid_r();

        boolean testBot_l = bot_l.getBack() == slice.getBot_l();
        boolean testBot_m = bot_m.getBack() == slice.getBot_m();
        boolean testBot_r = bot_r.getBack() == slice.getBot_r();

        return new ComparableSliceResult(testTop_l, testTop_m, testTop_r,
                                         testMid_l, testMid_m, testMid_r,
                                         testBot_l, testBot_m, testBot_r);
    }

    @Override
    public void display() {
        System.out.println("-- Back");
        System.out.println(top_l.getBack().name() + " \t" + top_m.getBack().name() + " \t" + top_r.getBack().name());
        System.out.println(mid_l.getBack().name() + " \t" + mid_m.getBack().name() + " \t" + mid_r.getBack().name());
        System.out.println(bot_l.getBack().name() + " \t" + bot_m.getBack().name() + " \t" + bot_r.getBack().name());
        System.out.println("######################################################");
    }
}
