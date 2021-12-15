package test;

import measurements.Dimensions;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Dimensions(15, 3, 5).calculateVector()

        -(new Dimensions(7,1,1).calculateVector()
                + new Dimensions(3,1,2).calculateVector()
                /*+ new Dimensions(8,3,4).calculateVector()*/
                ));
    }
}
