package test;

import vehicle.power.CombustionEngine;

public class Testing {
    public static void main(String[] args) {

        CombustionEngine combustionEngine =
                new CombustionEngine(CombustionEngine.FuelType.GASOLINE,
                        1,
                        38);
        System.out.println(combustionEngine.getFuelType().getFuel());
    }
}
