/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author PC
 */
public class UsuarioDAO {
    private static final List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

    public UsuarioDAO() {
        
    }
    
    public void datosPruebas(){
        UsuarioDTO usu = new UsuarioDTO(1, "Juan Guarnizo", "juan@correo.com", "guarnizo", UsuarioDTO.ADMINISTRADOR);
        UsuarioDTO usu2 = new UsuarioDTO(2, "Nimu", "nimu@correo.com", "vtuber", UsuarioDTO.VENDEDOR);
        UsuarioDTO usu3 = new UsuarioDTO(2, "Rubiu", "rubi@correo.com", "wilson", UsuarioDTO.CLIENTE);
        lista.add(usu);
        lista.add(usu2);
        lista.add(usu3);
    }
    
    public boolean crear(UsuarioDTO c){
        if(c!=null){
            lista.add(c);
            return true;
        }else{
            return false;
        }
    }
    
    public List<UsuarioDTO> readAll(){
        List<UsuarioDTO> obj = null;
        obj = UsuarioDAO.lista;
        return obj;
    }
}
