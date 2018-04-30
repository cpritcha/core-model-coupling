package net.comses.bmi.examples;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Point extends Structure {
    public int x;
    public int y;

    public static class ByValue extends Point implements Structure.ByValue {}

    public Point() {}

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("x", "y");
    }
}
