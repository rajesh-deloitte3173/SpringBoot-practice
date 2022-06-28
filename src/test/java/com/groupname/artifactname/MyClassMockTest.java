package com.groupname.artifactname;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class MyClassMockTest {

    @Mock
    DataServiceMock dataServiceMock;

    @InjectMocks
    MyClassMock myClassMock;

    @Test
    public void findGreatestTest(){
//        DataServiceMock dataServiceMock = mock(DataServiceMock.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,15,4});
//        MyClassMock myClassMock = new MyClassMock(dataServiceMock);
        int result = myClassMock.findGreatest();
        assertEquals(24,result);
    }

    @Test
    public void testSizeMultipleReturns(){
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(10).thenReturn(20);
        when(listMock.get(0)).thenReturn("some string");

        assertEquals(10,listMock.size());
        assertEquals(20,listMock.size());
        assertEquals(20,listMock.size());

        assertEquals("some string", listMock.get(0));
    }
}
