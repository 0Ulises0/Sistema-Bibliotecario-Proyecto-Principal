package pantallas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creando la Pantalla Principal del Sistema Bibliotecario
public class PantallaPrincipal extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JLabel ulises,ilse,darlin,integrantes;
    private JLabel separador1,titulo,separador2;
    private JButton prestamoDevolucion, registroLibros, registroUsuarios, visualizarTablas;
    private JPanel contenedorOpcionesOeste, contenedorOpcionesNorte, contenedorOpcionesEste, contenedorOpcionesSur, contenedorOpcionesCentro;


    JMenuBar JMBmenuBar;
    JMenu JMopciones;
    JMenuItem JMIacerdaDe,JMIsalir;
    JMenuItem JMIprestamoDevolucion, JMIregistroLibros, JMIregistroUsuarios, JMIvisualizarTablas;

    //Creando las otras pantallas de las opciones disponibles
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
        menuBar();

        contenedorNorte();
        contenedorEste();
        contenedorOeste();
        contenedorSur();
        contenedorCentro();
    }


    //Metodos para crear los contenedores
    
    //-Contenedor norte con BorderLayout.NORTH
    private void contenedorNorte(){
        contenedorOpcionesNorte = new JPanel();
        contenedorOpcionesNorte.setBackground(Color.decode("#D4D4D4"));
        contenedorOpcionesNorte.setLayout(new GridBagLayout());
        componentesContenedorNorte();
        add(contenedorOpcionesNorte,BorderLayout.NORTH);
    }
    //-Contenedor este con BorderLayout.EAST
    private void contenedorEste(){
        contenedorOpcionesEste = new JPanel();
        contenedorOpcionesEste.setBackground(Color.decode("#FAFAF9"));
        contenedorOpcionesEste.setLayout(new GridBagLayout());
        componentesContenedorEste();
        add(contenedorOpcionesEste,BorderLayout.EAST);
    }
    //-Contenedor oeste con BorderLayout.WEST
    private void contenedorOeste (){
        contenedorOpcionesOeste = new JPanel();
        contenedorOpcionesOeste.setBackground(Color.decode("#FAFAF9"));
        contenedorOpcionesOeste.setLayout(new GridBagLayout());
        componentesContenedorOeste();
        add(contenedorOpcionesOeste, BorderLayout.WEST);
    }
    //-Contenedor sur con BorderLayout.SOUTH
    private void contenedorSur(){
        contenedorOpcionesSur = new JPanel();
        contenedorOpcionesSur.setBackground(Color.decode("#FAFAF9"));
        contenedorOpcionesSur.setLayout(new GridBagLayout());
        componentesContenedorSur();
        add(contenedorOpcionesSur, BorderLayout.SOUTH);
    }
    //-Contenedor centro con BorderLayout.CENTER
    private void contenedorCentro(){
        contenedorOpcionesCentro = new JPanel();
        contenedorOpcionesCentro.setBackground(Color.decode("#FAFAF9"));
        contenedorOpcionesCentro.setLayout(new GridBagLayout());
        componentesContenedorCentro();
        add(contenedorOpcionesCentro, BorderLayout.CENTER);
    }
    
    
    
    //Metodos para agregar componentes a los contenedores

    //-Componentes del contenedor norte se rige con GridBagLayout
    private void componentesContenedorNorte(){
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Configurar el JLabel del titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        titulo = new JLabel("Sistema Bibliotecario");
        titulo.setFont(new Font("Arial", Font.PLAIN, 36)); //Establecer tamano y fuente al JLabel
        contenedorOpcionesNorte.add(titulo, gbc);

    }
    //-Componentes del contenedor oeste se rige con GridBagLayout
    private void componentesContenedorOeste(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        // Configurar los botones de las opciones
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
		gbc.gridy = 0;
        prestamoDevolucion = new JButton("Prestamo y Devoluciones");
        prestamoDevolucion.addActionListener(this);
        contenedorOpcionesOeste.add(prestamoDevolucion, gbc);

        gbc.gridx = 0;
		gbc.gridy = 1;
        registroLibros = new JButton("Registro Libros");
        registroLibros.addActionListener(this);
        contenedorOpcionesOeste.add(registroLibros, gbc);

        gbc.gridx = 0;
		gbc.gridy = 2;
        registroUsuarios = new JButton("Registro Usuarios");
        registroUsuarios.addActionListener(this);
        contenedorOpcionesOeste.add(registroUsuarios, gbc);

        gbc.gridx = 0;
		gbc.gridy = 3;
        visualizarTablas = new JButton("Visualizar Tablas");
        visualizarTablas.addActionListener(this);
        contenedorOpcionesOeste.add(visualizarTablas, gbc);
    }
    //-Componentes del contenedor este se rige con GridBagLayout
    private void componentesContenedorEste(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        integrantes = new JLabel("Integrantes:");
        integrantes.setFont(new Font("Arial", Font.PLAIN, 24)); //Establecer
        contenedorOpcionesEste.add(integrantes, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        ulises = new JLabel("Castillo Pimienta Ilse Marianne");
        contenedorOpcionesEste.add(ulises, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        ilse = new JLabel("Molina Beltran Berenice Darlin");
        contenedorOpcionesEste.add(ilse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        darlin = new JLabel("Papachoris Camacho Ulises");
        contenedorOpcionesEste.add(darlin, gbc);
    }
    //-Componentes del contenedor sur se rige con GridBagLayout
    private void componentesContenedorSur(){
        
    }
    //-Componentes del contenedor centro se rige con GridBagLayout
    private void componentesContenedorCentro(){
        
    }

    private void menuBar(){
        //Creando la barra de menu
        JMBmenuBar = new JMenuBar();
        JMBmenuBar.setLayout(new FlowLayout());
        JMBmenuBar.setBackground(Color.decode("#D4D4D4"));

        //Creando menu de opciones
        JMopciones = new JMenu("Opciones");

        //Agregar opciones del Menu Opciones
        JMIprestamoDevolucion = new JMenuItem("Prestamo y Devoluciones");
        JMIprestamoDevolucion.addActionListener(this);
        JMopciones.add(JMIprestamoDevolucion);
        JMIregistroLibros = new JMenuItem("Registro Libros");
        JMIregistroLibros.addActionListener(this);
        JMopciones.add(JMIregistroLibros);
        JMIregistroUsuarios = new JMenuItem("Registro Usuarios");
        JMIregistroUsuarios.addActionListener(this);
        JMopciones.add(JMIregistroUsuarios);
        JMIvisualizarTablas = new JMenuItem("Visualizar Tablas");
        JMIvisualizarTablas.addActionListener(this);
        JMopciones.add(JMIvisualizarTablas);
        //Agregar opciones al menui principal
        JMopciones.addSeparator();
        JMopciones.setBackground(Color.decode("#FAFAF9"));
        JMBmenuBar.add(JMopciones);

        //Agregando acerca
        JMIacerdaDe = new JMenuItem("Acerca De");
        JMIacerdaDe.addActionListener(this);
        JMopciones.addSeparator();
        JMBmenuBar.add(JMIacerdaDe);

        //Agregando salir
        JMIsalir = new JMenuItem("Salir");
        JMIsalir.addActionListener(this);
        JMBmenuBar.add(JMIsalir);

        setJMenuBar(JMBmenuBar);

        
        
        
    }

    //Hacer visibles las pantallas de las opciones
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
        
        //MenuBar
        if(e.getSource() == JMIacerdaDe){
            JOptionPane.showMessageDialog(this, "Proyecto Principal de Topicos Avanzados de Programacion\nacerca de un Sistema Bibliotecario\nMaestro: Edmundo");
        }
        if(e.getSource() == JMIsalir){
            int respuesta = JOptionPane.showConfirmDialog(this, "Deseas salir de la aplicacion?", "MODIFICAR", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            if(respuesta == JOptionPane.NO_OPTION){
                return;
            }
        }

        if (e.getSource() == JMIprestamoDevolucion){
            ppdl.setVisible(true);
        }
        if (e.getSource() == JMIregistroLibros){
            prl.setVisible(true);
        }
        if (e.getSource() == JMIregistroUsuarios){
            pru.setVisible(true);
        }
        if (e.getSource() == JMIvisualizarTablas){
            pvt.setVisible(true);
        }
    }
}
