/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CITAS;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private String Nombre;
    private static final int DIAS_EN_MAYO = 31; // Número de días en mayo
    private boolean[][] horarios; // Matriz de horarios disponibles

    // Constructor
    public Agenda() {
        // Inicializar la matriz de horarios disponibles
        this.horarios = new boolean[DIAS_EN_MAYO][6]; // 6 horas entre las 9 y las 14
        // Inicializar todos los horarios como disponibles (true)
        for (boolean[] dia : horarios) {
            java.util.Arrays.fill(dia, true);
        }
    }

    // Método para marcar un horario como no disponible
    public void marcarHorarioNoDisponible(int dia, String horaCompleta) {
        String horaParte = horaCompleta.substring(0, 2);
        int hora = Integer.parseInt(horaParte);
        if (dia >= 1 && dia <= DIAS_EN_MAYO && hora >= 9 && hora <= 16) {
            horarios[dia - 1][hora - 9] = false; // Restamos 9 porque los horarios comienzan desde las 9
        } else {
            System.out.println("Día u hora inválidos.");
        }
    }

    public void marcarHorarioDisponible(int dia, String horaCompleta) {
        String horaParte = horaCompleta.substring(0, 2);
        int hora = Integer.parseInt(horaParte);
        if (dia >= 1 && dia <= DIAS_EN_MAYO && hora >= 9 && hora <= 14) {
            horarios[dia - 1][hora - 9] = true; // Restamos 9 porque los horarios comienzan desde las 9
        } else {
            System.out.println("Día u hora inválidos.");
        }
    }
    

    // Método para obtener una lista de horarios disponibles de un día
    public List<String> obtenerHorariosDisponiblesLista(int dia) {
        List<String> horariosDisponibles = new ArrayList<>();
        if (dia >= 1 && dia <= DIAS_EN_MAYO) {
            for (int hora = 9; hora <= 14; hora++) {
                if (horarios[dia - 1][hora - 9]) {
                    horariosDisponibles.add(String.format("%02d:%02d", hora, 0));
                }
            }
        }
        return horariosDisponibles;
    }

    // Método para obtener una lista de horarios no disponibles de un día
    public List<String> obtenerHorariosNoDisponiblesLista(int dia) {
        List<String> horariosNoDisponibles = new ArrayList<>();
        if (dia >= 1 && dia <= DIAS_EN_MAYO) {
            for (int hora = 9; hora <= 14; hora++) {
                if (!horarios[dia - 1][hora - 9]) {
                    horariosNoDisponibles.add(String.format("%02d:%02d", hora, 0));
                }
            }
        }
        return horariosNoDisponibles;
    }
    
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public String getNombre(){
        return Nombre;
    }
    
    public void setHorarios(boolean[][] horarios){
        this.horarios = horarios;
    }
    
    public boolean[][] getHorarios(){
        return horarios;
    }
}
