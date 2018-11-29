package MainApp;

import Etc.RotationDirection;
import SubCubes.SubCube;

public class FrontCubeSlice extends CubeSlice implements ICubeSlice {

    public FrontCubeSlice(SubCube top_l, SubCube top_m, SubCube top_r, SubCube mid_l, SubCube mid_m, SubCube mid_r, SubCube bot_l, SubCube bot_m, SubCube bot_r) {
        super(top_l, top_m, top_r, mid_l, mid_m, mid_r, bot_l, bot_m, bot_r);
    }

    @Override
    public void setRelations(CubeSlice top, CubeSlice bottom, CubeSlice left, CubeSlice right) {
        super.setRelations(top, bottom, left, right);
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

        top.setBottomSide(top_r, top_m, top_l);
        bottom.setTopSide(bot_r, bot_m, bot_l);
        left.setRightSide(top_l, mid_l, bot_l);
        right.setLeftSide(top_r, mid_r, bot_r);
    }

    @Override
    public void display() {
        System.out.println("-- Front");
        System.out.println(top_l.getFront().name() + " \t" + top_m.getFront().name() + " \t" + top_r.getFront().name());
        System.out.println(mid_l.getFront().name() + " \t" + mid_m.getFront().name() + " \t" + mid_r.getFront().name());
        System.out.println(bot_l.getFront().name() + " \t" + bot_m.getFront().name() + " \t" + bot_r.getFront().name());
        System.out.println("######################################################");
    }
}
