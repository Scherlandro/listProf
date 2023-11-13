package com.api.listProf;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListProfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListProfApplication.class, args);
	}
	
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
