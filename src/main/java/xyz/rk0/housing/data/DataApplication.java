package xyz.rk0.housing.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings({"checkstyle:FinalClass", "checkstyle:HideUtilityClassConstructor"})
@SpringBootApplication
public class DataApplication {

    DataApplication() { }

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

}
