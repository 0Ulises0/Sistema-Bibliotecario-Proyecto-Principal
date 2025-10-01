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
    private static final int ANCHO_VENTANA = 1366;
    private static final int ALTO_VENTANA = 768;

    private static final Color COLOR_PANELES = Color.decode("#F6CFFF");
    private static final Color COLOR_TITULO = Color.decode("#DAB2FF");
    private static final Color COLOR_MENU = Color.decode("#C4B4FF");

    private JLabel ulises,ilse,darlin,integrantes;
    private JLabel titulo;
    private JButton prestamoDevolucion, registroLibros, registroUsuarios;
    private JPanel contenedorOpcionesOeste, contenedorOpcionesNorte, contenedorOpcionesEste, contenedorOpcionesSur, contenedorOpcionesCentro;


    JMenuBar JMBmenuBar;
    JMenu JMopciones;
    JMenuItem JMIacerdaDe,JMIsalir;
    JMenuItem JMIprestamoDevolucion, JMIregistroLibros, JMIregistroUsuarios, JMIvisualizarTablas;

    //Creando las otras pantallas de las opciones disponibles
    PantallaPrestamoDevolucionLibros ppdl;
    PantallaRegistroLibros prl;
    PantallaRegistroUsuarios pru ;

    public PantallaPrincipal (String title){
        //Poner el titulo
        super(title);

        //Parametros de la ventana
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
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
        contenedorOpcionesNorte.setBackground(COLOR_TITULO);
        contenedorOpcionesNorte.setLayout(new GridBagLayout());
        componentesContenedorNorte();
        add(contenedorOpcionesNorte,BorderLayout.NORTH);
    }
    //-Contenedor este con BorderLayout.EAST
    private void contenedorEste(){
        contenedorOpcionesEste = new JPanel();
        contenedorOpcionesEste.setBackground(COLOR_PANELES);
        contenedorOpcionesEste.setLayout(new GridBagLayout());
        componentesContenedorEste();
        add(contenedorOpcionesEste,BorderLayout.EAST);
    }
    //-Contenedor oeste con BorderLayout.WEST
    private void contenedorOeste (){
        contenedorOpcionesOeste = new JPanel();
        contenedorOpcionesOeste.setBackground(COLOR_PANELES);
        contenedorOpcionesOeste.setLayout(new GridBagLayout());
        componentesContenedorOeste();
        add(contenedorOpcionesOeste, BorderLayout.WEST);
    }
    //-Contenedor sur con BorderLayout.SOUTH
    private void contenedorSur(){
        contenedorOpcionesSur = new JPanel();
        contenedorOpcionesSur.setBackground(COLOR_PANELES);
        contenedorOpcionesSur.setLayout(new GridBagLayout());
        componentesContenedorSur();
        add(contenedorOpcionesSur, BorderLayout.SOUTH);
    }
    //-Contenedor centro con BorderLayout.CENTER
    private void contenedorCentro(){
        contenedorOpcionesCentro = new JPanel();
        contenedorOpcionesCentro.setBackground(COLOR_PANELES);
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
        JMBmenuBar.setBackground(COLOR_MENU);

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
        JMopciones.setBackground(COLOR_MENU);
        JMBmenuBar.add(JMopciones);

        JMopciones.addSeparator();

        //Agregando acerca
        JMIacerdaDe = new JMenuItem("Acerca De");
        JMIacerdaDe.addActionListener(this);
        JMopciones.addSeparator();
        JMBmenuBar.add(JMIacerdaDe);

        JMopciones.addSeparator();

        //Agregando salir
        JMIsalir = new JMenuItem("Salir");
        JMIsalir.addActionListener(this);
        JMBmenuBar.add(JMIsalir);

        setJMenuBar(JMBmenuBar); 
    }

    //Metodos para la creacion y muestra de pantallas
    public void mostrarPrestamosYDevoluciones(){
        if(ppdl == null){
            ppdl = new PantallaPrestamoDevolucionLibros("Prestamos Y Devoluciones");
        }
        ppdl.setVisible(true);
    }
    public void mostrarRegistroLibros(){
        if(prl == null){
            prl = new PantallaRegistroLibros("Registro De Libros");
        }
        prl.setVisible(true);
    }
    public void mostrarRegistroUsuarios(){
        if(pru == null){
            pru = new PantallaRegistroUsuarios("Registro De Usuarios");
        }
        pru.setVisible(true);
    }

    //Hacer visibles las pantallas de las opciones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prestamoDevolucion){
            mostrarPrestamosYDevoluciones();
        }
        else if (e.getSource() == registroLibros){
            mostrarRegistroLibros();
        }
        else if (e.getSource() == registroUsuarios){
            mostrarRegistroUsuarios();
        }
        
        //MenuBar
        else if (e.getSource() == JMIacerdaDe){
            JOptionPane.showMessageDialog(this, "Proyecto Principal de Topicos Avanzados de Programacion\nacerca de un Sistema Bibliotecario\nMaestro: Edmundo");
        }
        else if (e.getSource() == JMIsalir){
            int respuesta = JOptionPane.showConfirmDialog(this, "Deseas salir de la aplicacion?", "MODIFICAR", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            else if (respuesta == JOptionPane.NO_OPTION){
                return;
            }
        }

        //Menu de opciones
        else if (e.getSource() == JMIprestamoDevolucion){
            mostrarPrestamosYDevoluciones();
        }
        else if (e.getSource() == JMIregistroLibros){
            mostrarRegistroLibros();
        }
        else if (e.getSource() == JMIregistroUsuarios){
            mostrarRegistroUsuarios();
        }
    }
}
