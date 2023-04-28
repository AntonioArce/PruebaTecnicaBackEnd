package com.backend.rest.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.rest.model.UserM;
import com.backend.rest.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<UserM> obtenerUsuarios(){
        return (ArrayList<UserM>) userRepository.findAll();
    }

    public UserM guardarUsuario(UserM user){
        return userRepository.save(user);
    }
    
    public boolean eliminarUsuario(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
