using System;
using WSDL.mensajes;
using System.Collections;

namespace WSDL.operaciones {
	public class Operaciones : Mensajes {
		ArrayList Lista = new ArrayList();
		public string Saludar (string nombre){
			string msj = "hola " + nombre;
			return msj;
		}

		public string Mostrar(int id)
{
    // Verificar si el índice está dentro del rango
    if (id >= 0 && id < Lista.Count)
    {
        // Devolver el elemento correspondiente al id
        return Lista[id].ToString();
    }
    else
    {
        // Si el índice está fuera del rango, devolver un mensaje de error
        return "ID fuera de rango";
    }
}

	}
}
