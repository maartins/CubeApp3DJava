package Slices;

import Etc.RotationDirection;
import MainApp.ComparableSliceResult;
import MainApp.ComparableSlice;
import SubCubes.SubCube;

public class FrontCubeSlice extends CubeSlice {

    public FrontCubeSlice(SubCube top_l, SubCube top_m, SubCube top_r, SubCube mid_l, SubCube mid_m, SubCube mid_r, SubCube bot_l, SubCube bot_m, SubCube bot_r) {
        super(top_l, top_m, top_r, mid_l, mid_m, mid_r, bot_l, bot_m, bot_r);
    }

    @Override
    public void rotate(RotationDirection direction) {
        subCubes.forEach(sc -> sc.rotateFront(direction));

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

        top.setBottomSide(top_l, top_m, top_r);
        bottom.setTopSide(bot_l, bot_m, bot_r);
        left.setRightSide(top_l, mid_l, bot_l);
        right.setLeftSide(top_r, mid_r, bot_r);
    }

    @Override
    public ComparableSliceResult compareSlice(ComparableSlice slice) {
        boolean testTop_l = top_l.getFront() == slice.getTop_l();
        boolean testTop_m = top_m.getFront() == slice.getTop_m();
        boolean testTop_r = top_r.getFront() == slice.getTop_r();

        boolean testMid_l = mid_l.getFront() == slice.getMid_l();
        boolean testMid_m = mid_m.getFront() == slice.getMid_m();
        boolean testMid_r = mid_r.getFront() == slice.getMid_r();

        boolean testBot_l = bot_l.getFront() == slice.getBot_l();
        boolean testBot_m = bot_m.getFront() == slice.getBot_m();
        boolean testBot_r = bot_r.getFront() == slice.getBot_r();

        return new ComparableSliceResult(testTop_l, testTop_m, testTop_r,
                                         testMid_l, testMid_m, testMid_r,
                                         testBot_l, testBot_m, testBot_r);
    }

    @Override
    public void display() {
        System.out.println("-- Front");
        System.out.println(top_l.getFront().name() + " \t" + top_m.getFront().name() + " \t" + top_r.getFront().name());
        System.out.println(mid_l.getFront().name() + " \t" + mid_m.getFront().name() + " \t" + mid_r.getFront().name());
        System.out.println(bot_l.getFront().name() + " \t" + bot_m.getFront().name() + " \t" + bot_r.getFront().name());
        System.out.println("••••••••••••••••••••••••••");
    }
}
