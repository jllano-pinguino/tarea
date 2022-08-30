package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

import com.example.demo.Modelo.ModeloTarea;
import com.example.demo.Servicio.TareaServicio;



@SpringBootApplication
public class TareaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaApplication.class, args);
		
	}

}
