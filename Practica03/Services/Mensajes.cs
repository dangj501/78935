using System;
using imensajes;

namespace mensajes{
    public class Mensajes: iMensajes{
        public string saludar(string nombre){
            return "Hola "+ nombre;
        }
        public string mostrar(string nombre){
            return "Toma Perro";
        }
    }
}