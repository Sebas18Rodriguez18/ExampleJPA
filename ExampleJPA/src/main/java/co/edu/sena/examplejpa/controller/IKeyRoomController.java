/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 *Fecha: 25/03/2025
 * @author Sebastian Rodriguez
 * Objetivo: Interface para el modelo Key.
 */
public interface IKeyRoomController {
    public void insertKey (KeyRoom key) throws Exception;
    public void updateKey(KeyRoom key) throws Exception;
    public void deleteKey (Integer id) throws Exception;
    public List<KeyRoom> getAllKeys() throws Exception;
    public KeyRoom getKeyById(Integer id) throws Exception;
}
