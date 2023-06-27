import javax.swing.*;

public class OrdenCompra extends JFrame {
    private JPanel panelMain;
    private JLabel Fecha;
    private JButton generarOrdenButton;
    private JButton agregarButton;

    public JButton getGenerarOrdenButton() {
        return generarOrdenButton;
    }

    public static void main(String[] args) {
        OrdenCompra h=new OrdenCompra();
        h.setContentPane(h.panelMain);
        h.setTitle("Hello");
        h.setSize(650,500);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
