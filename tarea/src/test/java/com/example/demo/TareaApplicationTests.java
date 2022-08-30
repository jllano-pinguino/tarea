package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Controlador.TareaControlador;
import com.example.demo.Modelo.ModeloTarea;
import com.example.demo.Servicio.TareaServicio;

@SpringBootTest
class TareaApplicationTests {

	@Test
	public void testCrear() {
		TareaServicio ts= new TareaServicio();
		ModeloTarea mt= new ModeloTarea();
		mt.setId_t(20);
		mt.setDescripcion("Unitaria");
		mt.setEstado('A');
		ModeloTarea res=ts.crearTarea(mt);
		assertEquals(mt, res);
	}
	
	@Test
	public void testModificar() {
		TareaServicio ts = new TareaServicio();
		ModeloTarea mt = new ModeloTarea(21,"Unitaria 2",'A');
		//agregar tarea
		ts.crearTarea(mt);
		//modificar tarea
		mt.setDescripcion("Unitaria 2 Cambiado");
		ModeloTarea res=ts.actualizarTarea(mt);
		assertEquals(mt, res);
		
	}
	
	@Test
	public void testListar() {
		TareaServicio ts = new TareaServicio();
		ArrayList<ModeloTarea> mt= ts.listarTarea();
		
		
	}
	
	@Test
	public void testEliminar() {
		TareaServicio ts = new TareaServicio();
		ModeloTarea mt = new ModeloTarea(21,"Unitaria 2",'A');
		//respuesta
		boolean val=false;
		//agregar tarea
		ts.crearTarea(mt);
		//eliminar tarea
		ts.eliminar(21);
		//comprobar existencia
		Optional<ModeloTarea> res =ts.validar(21);
		
		assertEquals(val, res.isPresent());
		
	}
	
	
	
}
