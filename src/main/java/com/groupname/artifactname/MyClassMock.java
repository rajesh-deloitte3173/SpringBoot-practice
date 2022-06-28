package com.groupname.artifactname;

import java.util.Arrays;

public class MyClassMock {
    private final DataServiceMock dataServiceMock;

    public MyClassMock(DataServiceMock dataServiceMock) {
        super();
        this.dataServiceMock = dataServiceMock;
    }

    int findGreatest(){
        int[] data = dataServiceMock.retrieveAllData();
        System.out.println("data: " + Arrays.toString(data));
        int greatest = Integer.MIN_VALUE;

        for (int value: data){
            if (value>greatest)
                greatest = value;
        }
        System.out.println("result: "+greatest);
        return greatest;
    }
}
