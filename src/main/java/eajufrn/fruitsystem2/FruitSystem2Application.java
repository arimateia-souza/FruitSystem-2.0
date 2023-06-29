package eajufrn.fruitsystem2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FruitSystem2Application {

    public static void main(String[] args) {
        SpringApplication.run(FruitSystem2Application.class, args);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
