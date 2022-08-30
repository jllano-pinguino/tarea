package com.example.demo.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.ModeloTarea;




@Repository("RepositorioTarea")
public interface TareaRepositorio extends CrudRepository<ModeloTarea, Integer> {
	
}
