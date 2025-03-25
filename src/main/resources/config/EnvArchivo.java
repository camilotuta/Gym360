package main.resources.config;

import io.github.cdimascio.dotenv.Dotenv;

/*
 cSpell:ignore dotenv 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tutaa
 */
public class EnvArchivo {

    public static Dotenv dotenv = Dotenv.configure()
            .directory("main/resources/config")
            .load();

}
