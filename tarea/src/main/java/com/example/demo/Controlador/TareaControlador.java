package com.example.demo.Controlador;


import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.SafeConstructor.ConstructUndefined;

import com.example.demo.Modelo.ModeloTarea;
import com.example.demo.Repositorio.TareaRepositorio;
import com.example.demo.Servicio.TareaServicio;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import antlr.Parser;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;
import oracle.sql.CHAR;
@Controller
@RestController
@RequestMapping("tarea")
@CrossOrigin(origins = "*")
@ComponentScan
public class TareaControlador  {
	@Autowired
	private TareaServicio tareaServicio;
	
	
	@GetMapping(path = "listar", produces = "application/json")
	public ArrayList<ModeloTarea> listarTarea(){
		return tareaServicio.listarTarea();
	}
	
	
	@PostMapping(path = "crear", produces = "application/json")
	public ResponseEntity<String> crearTarea(@RequestBody ModeloTarea t) {
		
		if(t!=null) {
			Optional<ModeloTarea> model= tareaServicio.validar(t.getId_t());
			if(!model.isPresent()) {
				try {
					tareaServicio.crearTarea(t);
					return ResponseEntity.status(HttpStatus.OK).body("Tarea Creada");
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, "+e.toString());
				}
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, Tarea ya existente");
			}
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, formato no valido");
		}
	}
	
	@PostMapping(path = "actualizar", produces = "application/json" )
	public ResponseEntity<String> actualizarTarea(@RequestBody ModeloTarea t){
		if(t !=null) {
			Optional<ModeloTarea> model = tareaServicio.validar(t.getId_t());
			if(model.isPresent()) {
				try {
					tareaServicio.actualizarTarea(t);
					return ResponseEntity.status(HttpStatus.OK).body("Tarea actualizada " );
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, "+e);
				}
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, tarea no encontrada");
			}
						
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error, tarea no valida");
		}	
	}
	
	@GetMapping(path = "buscar/{id}", produces = "application/json")
	public Optional<ModeloTarea> buscar(@PathVariable int id){
		return tareaServicio.validar(id);
	}
	
	
	@GetMapping(path="validar/{id}", produces = "application/json")
	public boolean validar(@PathVariable int id){
		Optional<ModeloTarea> model= tareaServicio.validar(id);
		return (model.isPresent());
	}
	
	@PostMapping(path="eliminar/{id}" ,produces = "application/json")
	public ResponseEntity<String> eliminarTarea(@PathVariable int id){
		Optional<ModeloTarea> op = tareaServicio.validar(id);
		if(op.isPresent()) {
			try {
				tareaServicio.eliminar(id);
				return ResponseEntity.status(HttpStatus.OK).body("tarea eliminada");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, "+e.toString());
			}
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, tarea no existente");
		}
	}
}
