package pantallas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JLabel titulo;
    private JButton prestamoDevolucion, registroLibros, registroUsuarios, visualizarTablas;
    private JPanel contenedorOpcionesOeste, contenedorOpcionesNorte, contenedorOpcionesEste, contenedorOpcionesSur, contenedorOpcionesCentro;

    PantallaPrestamoDevolucionLibros ppdl = new PantallaPrestamoDevolucionLibros("Prestamos Y Devoluciones");
    PantallaRegistroLibros prl = new PantallaRegistroLibros("Resgitro de Libros");
    PantallaRegistroUsuarios pru = new PantallaRegistroUsuarios("Registro de Usuarios");
    PantallVisualizarTablas pvt = new PantallVisualizarTablas("Visualisar Tablas");

    public PantallaPrincipal (String title){
        //Poner el titulo
        super(title);

        //Parametros de la ventana
        setSize(1024,768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Agregando los contenedores
        contenedorNorte();
        contenedorEste();
        contenedorOeste();
        contenedorSur();
        contenedorCentro();
    }



    private void contenedorNorte(){
        contenedorOpcionesNorte = new JPanel();
        contenedorOpcionesNorte.setLayout(new GridBagLayout());
        componentesContenedorNorte();
        add(contenedorOpcionesNorte,BorderLayout.NORTH);
    }
    private void contenedorEste(){
        contenedorOpcionesEste = new JPanel();
        contenedorOpcionesEste.setLayout(new GridBagLayout());
        componentesContenedorEste();
        add(contenedorOpcionesEste,BorderLayout.EAST);
    }
    private void contenedorOeste (){
        contenedorOpcionesOeste = new JPanel();
        contenedorOpcionesOeste.setLayout(new GridBagLayout());
        componentesContenedorOeste();
        add(contenedorOpcionesOeste, BorderLayout.WEST);
    }
    private void contenedorSur(){
        contenedorOpcionesSur = new JPanel();
        contenedorOpcionesSur.setLayout(new GridBagLayout());
        componentesContenedorSur();
        add(contenedorOpcionesSur, BorderLayout.SOUTH);
    }
    private void contenedorCentro(){
        contenedorOpcionesCentro = new JPanel();
        contenedorOpcionesCentro.setLayout(new GridBagLayout());
        componentesContenedorCentro();
        add(contenedorOpcionesCentro, BorderLayout.CENTER);
    }
    
    private void componentesContenedorNorte(){
        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        titulo = new JLabel("Sistema Bibliotecario");
        titulo.setFont(new Font("Arial", Font.PLAIN, 36)); //Establecer tamano y fuente al JLabel
        contenedorOpcionesNorte.add(titulo);

    }
    private void componentesContenedorOeste(){

        
    }
    private void componentesContenedorEste(){

    }
    private void componentesContenedorSur(){
        
    }
    private void componentesContenedorCentro(){
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);


        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
		gbc.gridy = 1;
        prestamoDevolucion = new JButton("Prestamo y Devoluciones");
        prestamoDevolucion.addActionListener(this);
        contenedorOpcionesCentro.add(prestamoDevolucion, gbc);

        gbc.gridx = 0;
		gbc.gridy = 2;
        registroLibros = new JButton("Registro Libros");
        registroLibros.addActionListener(this);
        contenedorOpcionesCentro.add(registroLibros, gbc);

        gbc.gridx = 0;
		gbc.gridy = 3;
        registroUsuarios = new JButton("Registro Usuarios");
        registroUsuarios.addActionListener(this);
        contenedorOpcionesCentro.add(registroUsuarios, gbc);

        gbc.gridx = 0;
		gbc.gridy = 4;
        visualizarTablas = new JButton("Visualizar Tablas");
        visualizarTablas.addActionListener(this);
        contenedorOpcionesCentro.add(visualizarTablas, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prestamoDevolucion){
            ppdl.setVisible(true);
        }
        if (e.getSource() == registroLibros){
            prl.setVisible(true);
        }
        if (e.getSource() == registroUsuarios){
            pru.setVisible(true);
        }
        if (e.getSource() == visualizarTablas){
            pvt.setVisible(true);
        } 
    }
}
