/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.bo.PersonaBO;
import ec.edu.ups.bo.UsuarioBO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Personas;
import ec.edu.ups.entidad.Usuarios;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Test {
    PersonaDAO pa = new PersonaDAO ();
    UsuarioDAO uD = new UsuarioDAO();        
    PersonaBO pBO = new PersonaBO(pa);
    UsuarioBO uBO = new UsuarioBO(uD);
    Personas p = new Personas();

    String mensaje = "";
    Map<Character, Character> map = new HashMap<>();


    private void cargarLetras() {
        map.put('a', '*');
        map.put('b', '$');
        map.put('c', '?');
        map.put('d', '%');
        map.put('e', '#');
        map.put('f', '!');
        map.put('g', '¡');
        map.put('h', '¿');
        map.put('i', '}');
        map.put('j', '{');
        map.put('k', '[');
        map.put('l', ']');
        map.put('m', '|');
        map.put('n', '°');
        map.put('ñ', '=');
        map.put('o', '+');
        map.put('p', '-');
        map.put('q', ';');
        map.put('r', ',');
        map.put('s', '>');
        map.put('t', '<');
        map.put('u', 'A');
        map.put('v', 'B');
        map.put('w', 'C');
        map.put('x', 'f');
        map.put('y', 'x');
        map.put('z', 'p');
        map.put(' ', 'd');
        map.put('A', '&');
        map.put('B', '0');
        map.put('C', '1');
        map.put('D', '2');
        map.put('E', '3');
        map.put('F', '4');
        map.put('G', '5');
        map.put('H', '6');
        map.put('I', '7');
        map.put('J', '8');
        map.put('K', '9');
        map.put('L', 'ñ');
        map.put('M', 'y');
        map.put('N', 'Y');
        map.put('Ñ', '♠');
        map.put('O', 'z');
        map.put('P', 'Z');
        map.put('Q', 'X');
        map.put('R', 'W');
        map.put('S', 'w');
        map.put('T', 'J');
        map.put('U', 'j');
        map.put('V', 'Ñ');
        map.put('W', 'g');
        map.put('X', 'G');
        map.put('Y', 'P');
        map.put('Z', 'F');

    }

   private void cargarNumeros() {
        map.put('1', 'v');
        map.put('2', '♦');
        map.put('3', 's');
        map.put('4', 'E');
        map.put('5', 'k');
        map.put('6', '@');
        map.put('7', '☻');
        map.put('8', '↑');
        map.put('9', '↨');
        map.put('0', 'a');
    }

    private String encript(String cadena) {
        String encript = "";
        cargarLetras();
        cargarNumeros();
        for (int i = 0; i < cadena.length(); i++) {
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                char c = cadena.charAt(i);
        
                if (c==entry.getValue()) {

                    encript += entry.getKey();

                }

            }
        }
        return encript;

    }
    public void insertar() {
//        Usuarios u = new Usuarios();
//        u.setUsu_rol('G');
//        p.setPer_nombre("MARLON");
//        p.setPer_apellidos("CABRERA");
//        p.setPer_cedula("0123456789");
//        p.setPer_correo("marlonC@gmail.com");
//        p.setPer_direccion("DON BOSCO");
//        p.setPer_telefono("+5939616705787");
//        p.setPer_rol('C');
//        p.setPer_estado(' ');
//        // mensaje = pBO.agregarPersona(p,u);
//        mensaje = pBO.agregarPersona(p, u);
//        System.out.println(p);
//        System.out.println(mensaje);

     Usuarios u = new Usuarios();
     u.setUsu_nombre("pGuapu");
     u.setUsu_contra(encript("paul123"));
     u.setUsu_rol('A');

    mensaje = uBO.agregarUsuario("0104050607", u);

        System.out.println(p);
        System.out.println(mensaje);
     
     
    
    }

    public void actualizar() {
//        Usuarios u = new Usuarios();
//        u.setUsu_rol('A');
//        p.setPer_codigo(9);
//        p.setPer_nombre("KALM");
//        p.setPer_apellidos("REE");
//        p.setPer_cedula("0123456783");
//        p.setPer_correo("maria@hotmail.com");
//        p.setPer_direccion("NY");
//        p.setPer_telefono("+19616705787");
//        p.setPer_rol('O');
//        p.setPer_estado('A');
//        mensaje = pBO.actualizarPersona(p, u);
//        System.out.println(p);
        System.out.println(mensaje);
    }

    public void eliminar() {
       Usuarios u = new Usuarios();
       u.setUsu_rol('A');
        mensaje = pBO.eliminarPersona(28, u);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {

        Test t = new Test();
        t.insertar();
    }
}
