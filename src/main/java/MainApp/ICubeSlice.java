package MainApp;

import Etc.RotationDirection;

public interface ICubeSlice {
    void display();
    void rotate(RotationDirection direction);
    void setRelations(CubeSlice top, CubeSlice bottom, CubeSlice left, CubeSlice right);
}
