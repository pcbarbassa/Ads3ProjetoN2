/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Autor;
import java.util.ArrayList;

/**
 *
 * @author repez
 */
public interface IAutor {
    public void incluir(Autor autor) throws Exception;
    public ArrayList<Autor> listar() throws Exception;   
    public void alterar(Autor autor) throws Exception;
    public void excluir(int parametro)throws Exception;
}
