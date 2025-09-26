package componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;

import javax.swing.JLabel;

public class JLabelReloj extends JLabel {
    public static final int FECHA = 1;
    public static final int HORA = 2;
    public static final int FECHA_HORA = 3;

    private static final long serialVersionUID = 1L;

    private String formato;

    public JLabelReloj (int Formato){
        super();
        switch(Formato){
            case 1: formato = "dd/MM/yy";
                break;
            case 2: formato = "HH:mm:ss";
                break;
            case 3: formato = "dd/MM/yy HH:mm:ss";
        }   
        Timer t = new Timer (1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setText(ActualizaHora());
            }
        });
        t.start();
    }
    public void setFormato (int Formato){
        switch(Formato){
            case 1: formato = "dd/MM/aa";
                break;
            case 2: formato = "HH:mm:ss";
                break;
            case 3: formato = "dd/MM/yy HH:mm:ss";
        }
    }
    public String ActualizaHora(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(cal.getTime());
    }
}
