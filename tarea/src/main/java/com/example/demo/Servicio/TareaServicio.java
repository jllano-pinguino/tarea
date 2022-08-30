package com.example.demo.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.ModeloTarea;
import com.example.demo.Repositorio.TareaRepositorio;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@Service("ServicioTarea")
@Transactional
public class TareaServicio  {

	@Autowired
	@Qualifier("RepositorioTarea")
	TareaRepositorio tarearepositorio;
	
	//listo
	public ArrayList<ModeloTarea> listarTarea(){
		return (ArrayList<ModeloTarea>)tarearepositorio.findAll();
	}
	
	//listo
	public ModeloTarea crearTarea(ModeloTarea t) {
		return tarearepositorio.save(t);
	}
	
	//listo
	public ModeloTarea actualizarTarea(ModeloTarea t) {
		return tarearepositorio.save(t);
	}
	
	//listo
	public void eliminar(int id) {
		tarearepositorio.deleteById(id);
	}
	
	
	
	//complementario
	public Optional<ModeloTarea> validar(int id) {
		
		return tarearepositorio.findById(id);
		
	}
	
	
	
	
	
}
