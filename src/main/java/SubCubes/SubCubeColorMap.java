package SubCubes;

import Etc.Color;
import Etc.ColorPosition;
import Etc.Position;

import java.util.EnumMap;
import java.util.Map;
import static Etc.Position.*;

public class SubCubeColorMap {
    private Map<Position, Color> colors = new EnumMap<>(Position.class);

    public SubCubeColorMap(){
        colors.put(Top, Color.None);
        colors.put(Bottom, Color.None);
        colors.put(Front, Color.None);
        colors.put(Back, Color.None);
        colors.put(Left, Color.None);
        colors.put(Right, Color.None);
    }

    public void setColorWithPosition(ColorPosition cp) {
        colors.replace(cp.getPosition(), cp.getColor());
    }

    public Color getColor(Position pos) {
        return colors.get(pos);
    }

    public Color[] getAllColors() {
        return new Color[]{colors.get(Top), colors.get(Bottom), colors.get(Front), colors.get(Back), colors.get(Left), colors.get(Right)};
    }
}
