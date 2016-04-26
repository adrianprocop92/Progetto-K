/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Database.MySql.DeleteQuery;
import Database.MySql.ListeQuery;
import Libri.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author adrian
 */
public class EliminaDomanda implements ActionListener{

    private CardLayout card;
    private JPanel container;

    public EliminaDomanda(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.eliminaDomanda();
        
        JOptionPane.showMessageDialog(null, "Domanda eliminata correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaDomande();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaDomande();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaDomandePanel domande = new ListaDomandePanel(card, container);
        container.add(domande, "domande");
        card.show(container, "domande");
        
    }
    
}
