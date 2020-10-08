package com.company.tblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.company.*"})
@EntityScan( basePackages = {"com.company.entity"} )
public class TblueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TblueApplication.class, args);
	}

}
