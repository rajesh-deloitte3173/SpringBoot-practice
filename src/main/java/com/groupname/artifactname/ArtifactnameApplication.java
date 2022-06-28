package com.groupname.artifactname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ArtifactnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtifactnameApplication.class, args);

		for (EnumsT mobile : EnumsT.values()){
			System.out.println("Enums: "+ mobile + " Index: "+mobile.ordinal() + " Price: " + mobile.getPrice());
		}
	}

}
