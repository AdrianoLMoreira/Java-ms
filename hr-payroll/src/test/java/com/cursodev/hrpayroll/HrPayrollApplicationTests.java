package com.cursodev.hrpayroll;

import com.cursodev.hrpayroll.entities.Worker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static  org.mockito.Mockito.*;

@SpringBootTest
class HrPayrollApplicationTests {


    @Test
    void testeWork(){
        Worker mockedWorker = mock(Worker.class);
        mockedWorker.setName("Bruce Wayne");
        mockedWorker.getName();

        verify(mockedWorker).setName("Bruce Wayne");
        verify(mockedWorker).getName();
    }

}
