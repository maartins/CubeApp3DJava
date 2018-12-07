package MainApp;

public class NEATSolver {
    private Cube cube;

    private int population = 100;

    private float mutateAddNodeChance = 0.5f;
    private float mutateAddConnChance = 0.5f;


    public NEATSolver(Cube scrabledCube) {
        cube = scrabledCube;
    }

    private void mutateNode() {}
    private void mutateConn() {}

    private void calculateFitness() {}
}

class Genome {
    private int in = 0;
    private int out = 0;
    private float weight = 0.0f;
    private boolean enabled = true;
    private int inovation = 0;
}