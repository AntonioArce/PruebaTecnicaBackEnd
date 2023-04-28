package com.backend.rest.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.rest.model.UserM;
import com.backend.rest.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
    UserService userService;
	
	@GetMapping()
    public ArrayList<UserM> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }
	
	@PostMapping()
    public UserM guardarUsuario(@RequestBody UserM user){
        return this.userService.guardarUsuario(user);
    }
	
	/*
	@DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.userService.eliminarUsuario(id);
        if (ok){
        	return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
        .body("{\"success\": \"true\"}");
    }*/
	
	@DeleteMapping( path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.userService.eliminarUsuario(id);
        if (ok){
        	return ResponseEntity.status(HttpStatus.OK).body("{\"success\": \"true \"}");
        }else{
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("False");
        }
    }
	
}
