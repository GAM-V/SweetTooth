/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pagos;

import java.awt.print.*;
import java.awt.*;

public class Impresora {

    // Método público para imprimir un texto
    public void imprimir(String texto) {
        // Crear un trabajo de impresión
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        // Establecer el objeto Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                // Establecer el área de impresión
                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Establecer la fuente
                g.setFont(new Font("Serif", Font.PLAIN, 12));

                // Obtener el ancho imprimible de la página
                double pageWidth = pageFormat.getImageableWidth();

                // Dibujar el texto centrado
                int y = 0;
                for (String line : texto.split("\n")) {
                    y += g.getFontMetrics().getHeight();
                    int stringWidth = g.getFontMetrics().stringWidth(line);
                    int x = (int) ((pageWidth - stringWidth) / 2);
                    g.drawString(line, x, y);
                }

                return PAGE_EXISTS;
            }
        });

        // Mostrar el cuadro de diálogo de impresión
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
                System.out.println("Impresión realizada con éxito.");
            } catch (PrinterException e) {
                System.out.println("Error durante la impresión: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("La impresión fue cancelada.");
        }
    }

}
