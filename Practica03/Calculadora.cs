using System;
using icalculadora;
namespace calculadora{
    public class Calculadora: iCalculadora{
        public int suma(int a, int b){
            return a+b;
        }
        public int resta(int a, int b){
            return a-b;
        }
    }
}