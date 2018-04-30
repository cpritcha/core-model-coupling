package net.comses.bmi.examples;

import edu.colorado.csdms.bmi.BMI;
import org.nlogo.app.App;

import java.lang.reflect.InvocationTargetException;


// wolf, sheep - energy Double[], location Double[][] 2 x N
// patches - count down Double[]


public class WolfSheep implements BMI {
    private static final String MODEL_NAME = "Wolf Sheep";
    private static final String[] INPUT_VAR_NAMES =
        {"wolf__energy", "sheep__energy", "patches__countdown", "wolf__location", "sheep__location"};
    private static final String[] OUTPUT_VAR_NAMES =
        {"wolf__energy", "sheep__energy", "patches__countdown", "wolf__location", "sheep__location"};
    
    private int tick = 0;
//    HashMap<String, AnyRef> values;

    public WolfSheep() {
    }

    @Override
    public String getComponentName() {
        return MODEL_NAME;
    }

    @Override
    public int getInputVarNameCount() {
        return INPUT_VAR_NAMES.length;
    }

    @Override
    public String[] getOutputVarNames() {
        return new String[0];
    }

    @Override
    public String[] getInputVarNames() {
        return INPUT_VAR_NAMES;
    }

    @Override
    public int getOutputVarNameCount() {
        return OUTPUT_VAR_NAMES.length;
    }

    public String[] getOutputNames() {
        return OUTPUT_VAR_NAMES;
    }

    @Override
    public double getStartTime() {
        return 0;
    }

    @Override
    public double getCurrentTime() {
        return 0;
    }

    @Override
    public double getEndTime() {
        return 0;
    }

    @Override
    public double getTimeStep() {
        return 0;
    }

    @Override
    public String getTimeUnits() {
        return null;
    }

    @Override
    public void initialize(String s) {
        initialize();
    }

    @Override
    public void initialize() {
        try {
            App.main(new String[0]);
            java.awt.EventQueue.invokeAndWait(
                    new Runnable() {
                        public void run() {
                            try {
                                App.app().open(
                                        "src/main/netlogo/WolfSheep.nlogo");
                            }
                            catch(java.io.IOException ex) {
                                ex.printStackTrace();
                            }}});
            App.app().command("setup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize() {}

    @Override
    public void update() {
        App.app().command("go");
    }

    @Override
    public void updateUntil(double v) {

    }

    @Override
    public void updateFrac(double v) {

    }

    @Override
    public <T> T getValue(String s) {
        return null;
    }

    @Override
    public <T> T getValueRef(String s) {
        return null;
    }

    @Override
    public <T> T getValueAtIndices(String s, int[] ints) {
        return null;
    }

    @Override
    public int[] getGridShape(int i) {
        return new int[0];
    }

    @Override
    public double[] getGridSpacing(int i) {
        return new double[0];
    }

    @Override
    public double[] getGridOrigin(int i) {
        return new double[0];
    }

    @Override
    public double[] getGridX(int i) {
        return new double[0];
    }

    @Override
    public double[] getGridY(int i) {
        return new double[0];
    }

    @Override
    public double[] getGridZ(int i) {
        return new double[0];
    }

    @Override
    public int[] getGridConnectivity(int i) {
        return new int[0];
    }

    @Override
    public int[] getGridOffset(int i) {
        return new int[0];
    }

    @Override
    public int getGridRank(int i) {
        return 0;
    }

    @Override
    public int getGridSize(int i) {
        return 0;
    }

    @Override
    public String getGridType(int i) {
        return null;
    }

    @Override
    public void setValue(String s, double[] doubles) {

    }

    @Override
    public void setValue(String s, int[] ints) {

    }

    @Override
    public void setValue(String s, String[] strings) {

    }

    @Override
    public void setValueAtIndices(String s, int[] ints, double[] doubles) {

    }

    @Override
    public void setValueAtIndices(String s, int[] ints, int[] ints1) {

    }

    @Override
    public void setValueAtIndices(String s, int[] ints, String[] strings) {

    }

    @Override
    public String getVarType(String s) {
        return null;
    }

    @Override
    public String getVarUnits(String s) {
        return null;
    }

    @Override
    public int getVarItemsize(String s) {
        return 0;
    }

    @Override
    public int getVarNbytes(String s) {
        return 0;
    }

    @Override
    public int getVarGrid(String s) {
        return 0;
    }

    public static void main(String[] argv) {
        WolfSheep ws = new WolfSheep();
        ws.initialize();
        ws.update();
    }

//    public AnyRef getValue(String var_name) {
//        App.app().report();
//    }
//    public AnyRef getPatchCountdowns() {
//        return App.app().command("map [p -> [countdown] of p] (sort patches)");
//    }
//
//    public AnyRef getWolfEnergy() {
//        return App.app().command("map [w -> [energy] of w] (sort wolves)");
//    }
//
//    public getSheepEnery() {
//        return App.app().command("map [s -> [energy] of s] (sort sheep)");
//    }
//
//    public setValue(string var_name, Object src) {
//        App.app().command();
//    }
}