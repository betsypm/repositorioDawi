package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

import lombok.extern.apachecommons.CommonsLog;


@RestController
@CommonsLog
@RequestMapping("/rest/alumno")
public class AlumnoControler {

	@Autowired
	private AlumnoService service;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> lista(){
		log.info(">>>>>>> Lista");
		List<Alumno> lstAlumno= service.listaAlumno();
		return ResponseEntity.ok(lstAlumno);
	}
	
	@PostMapping
	public ResponseEntity<Alumno> registra(@RequestBody Alumno obj){
		log.info(">>>>>> Registra " + obj.getIdAlumno());
		Alumno objSalida=service.insertaActualizaAlumno(obj);
		if (objSalida != null) {
			return ResponseEntity.ok(objSalida);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
