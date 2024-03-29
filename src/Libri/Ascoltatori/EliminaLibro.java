/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.DeleteQuery;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import Utils.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class EliminaLibro implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Conferma", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            try {
                DeleteQuery.eliminaLibro();
                
                
                if(ControlloQuery.controlloLibriPreferiti()==false){
                    DeleteQuery.eliminaLibriPreferiti();
                }
                
                JOptionPane.showMessageDialog(null, "Libro eliminato correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);

                Applicazione.svuotaLibri();
                
                ListeQuery.caricaLibri();
                
                Applicazione.back.remove(Applicazione.back.size()-1);
                
                Ordina.Libri();
                
                ListaLibriPanel libri = new ListaLibriPanel();
                Grafica.container.add(libri, "libri");
                Grafica.card.show(Grafica.container, "libri");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del libro", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
