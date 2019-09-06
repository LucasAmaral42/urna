package elei;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.*;

public class urna extends JFrame {

    static String nome, numero1, numero2, partido;

    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JPanel top = new JPanel();
    JPanel bottom = new JPanel();

    // Labels:
    JLabel lblTitulo = new JLabel("Justiça Eleitoral");
    JLabel lblNumero = new JLabel("Numero: ");
    JLabel lblPartido = new JLabel("Partido: ");
    JLabel lblFoto = new JLabel();
    JLabel lblNome = new JLabel("Nome: ");
    JLabel lblInfo1 = new JLabel("Confirmar voto - clique em 'Confirma'");
    JLabel lblInfo2 = new JLabel("Apagar voto - clique em 'Corrige'");
    
    // TextFields:
    private final JTextField txtNumero1 = new JTextField();
    private final JTextField txtNumero2 = new JTextField();
        
            
    // Botões:
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn0 = new JButton("0");
    JButton btnBranco = new JButton("Branco");
    JButton btnCorrige = new JButton("Corrige");
    JButton btnConfirma = new JButton("Confirma");

    // Cria Txt



    private void criaTxt(String candidato, String voto){

        try {
            File file = new File("Resultadovotação.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(writer);
            if(candidato.equals("apagar")){
                try {
                    // Get the file
                    File f = new File("C:\\Users\\luvin\\OneDrive\\Documentos\\Projetos\\Java\\urna\\src\\elei\\Resultadovotação.txt");

                    // delete file
                    if (f.delete())
                        System.out.println("File deleted");
                    else
                        System.out.println("File was not deleted");
                }
                catch (Exception e) {
                    System.err.println(e);
                }
            }
            else{
                bw.write((candidato) + voto);
                bw.newLine();
                bw.close();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Numeros
    public void botaoNumero(String valor){
        String voto;
        int numero = 0;
        
        if (txtNumero1.getText().length() < 1) {
            txtNumero1.setText(valor);
        }
        else{
            if (txtNumero2.getText().length() < 1) {
                txtNumero2.setText(valor);
                
                voto = txtNumero1.getText() + txtNumero2.getText();
        
                if (voto.equals("13")) {
                    lblNome.setText(lblNome.getText() + "Handrade");
                    lblPartido.setText(lblPartido.getText() + "PT");
                    lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\haddad1.jpg"));
                }
                else{
                    if (voto.equals("17")) {
                        lblNome.setText(lblNome.getText() + "Bolsonaro");
                        lblPartido.setText(lblPartido.getText() + "PSL");
                        lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\bolsonaro1.jpg"));
                    }
                    else{
                        if (voto.equals("12")) {
                            lblNome.setText(lblNome.getText() + "Ciro");
                            lblPartido.setText(lblPartido.getText() + "PDT");
                            lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\ciro1.jpg"));
                        }
                        else{
                            if(voto.equals("18")){
                                lblNome.setText(lblNome.getText() + "Marina");
                                lblPartido.setText(lblPartido.getText() + "Rede");
                                lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\marina.jpg"));
                            }
                            else{
                                if(voto.equals("70")){
                                    lblNome.setText(lblNome.getText() + "Daciolo");
                                    lblPartido.setText(lblPartido.getText() + "Avante");
                                    lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\daciolo.jpg"));
                                }
                                else{
                                    if(voto.equals("28")){
                                        lblNome.setText(lblNome.getText() + "Fidel");
                                        lblPartido.setText(lblPartido.getText() + "PRTB");
                                        lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\fidel.jpg"));
                                    }
                                    else{
                                        if(voto.equals("45")){
                                            lblNome.setText(lblNome.getText() + "Alckmin");
                                            lblPartido.setText(lblPartido.getText() + "PSDB");
                                            lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\geraldo.png"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
     
    // Confirma
    public void botaoConfirma(){
        String aux1,aux2, voto;
        
        aux1 = txtNumero1.getText();
        aux2 = txtNumero2.getText();
        
        if ("Nome: Voto Branco".equals(lblNome.getText())) {
            criaTxt("Branco ", "x");
            criaTxt("Branco ", "x");
        }
        else{
            
            if (aux1.equals("") || aux2.equals("")) {
                criaTxt("Nulo ", "x");
            }
            else{
                voto = aux1 + aux2;
                
                if (voto.equals("13")) {
                    criaTxt("Haddad ", "13");
                }
                else{
                    if (voto.equals("17")) {
                      criaTxt("Bolsonaro ", "17");
                    }
                    else{
                        if(voto.equals("12")){
                           criaTxt("Ciro ", "12");
                        }
                        else{
                            if(voto.equals("18")){
                                criaTxt("Marina ", "18");
                            }
                            else{
                                if(voto.equals("70")){
                                 criaTxt("Daciolo ", "70");
                                }
                                else{
                                    if(voto.equals("28")){
                                        criaTxt("Fidelix ", "28");
                                    }
                                    else{
                                        if(voto.equals("45")){
                                            criaTxt("Alckmin ", "45");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    

    public void botaoCorrige(){
        txtNumero1.setText(null);
        txtNumero2.setText(null);
        
        lblNome.setText("Nome: ");
        lblPartido.setText("Partido: ");
        lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\vazio1.jpg"));
    }
    
    
    public urna(){
        String num = lblTitulo.getText();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // Declaração:
        setTitle("Ele");
        setVisible(true);
        setSize(850,550);

        // Layout:
        GridBagLayout layout = new GridBagLayout();
        left.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipady = 30;
        gbc.ipadx = 30;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Chamadas: 
       
        // ============================= LEFT ==================================
        
        
        // Labels        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,5);
        left.add(lblNumero, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        left.add(lblPartido, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        left.add(lblNome, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        bottom.add(lblInfo1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        bottom.add(lblInfo2, gbc);
        
        // TextFields
        txtNumero1.setEditable(false);
        txtNumero2.setEditable(false);
        gbc.ipady = 10;
        gbc.ipadx = 20;        
        gbc.gridx = 2;
        gbc.gridy = 2;
        left.add(txtNumero1, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        left.add(txtNumero2, gbc);
        
        // Foto 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        top.add(lblFoto, gbc);
        
        // ============================= RIGHT =================================
        right.setLayout(layout);

        gbc.ipady = 20;
        gbc.ipadx = 10;
        
        // Botões
       
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        right.add(lblTitulo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        right.add(btn1, gbc);
        btn1.setBackground(new Color(0,0,0));
        btn1.setForeground(Color.white);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        right.add(btn2, gbc);
        btn2.setBackground(new Color(0,0,0));
        btn2.setForeground(Color.white);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        right.add(btn3, gbc);
        btn3.setBackground(new Color(0,0,0));
        btn3.setForeground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        right.add(btn4, gbc);
        btn4.setBackground(new Color(0,0,0));
        btn4.setForeground(Color.white);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        right.add(btn5, gbc);
        btn5.setBackground(new Color(0,0,0));
        btn5.setForeground(Color.white);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        right.add(btn6, gbc);
        btn6.setBackground(new Color(0,0,0));
        btn6.setForeground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        right.add(btn7, gbc);
        btn7.setBackground(new Color(0,0,0));
        btn7.setForeground(Color.white);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        right.add(btn8, gbc);
        btn8.setBackground(new Color(0,0,0));
        btn8.setForeground(Color.white);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        right.add(btn9, gbc);
        btn9.setBackground(new Color(0,0,0));
        btn9.setForeground(Color.white);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        right.add(btn0, gbc);
        btn0.setBackground(new Color(0,0,0));
        btn0.setForeground(Color.white);
         
        // B,C,C:
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        right.add(btnBranco, gbc);
        btnBranco.setBackground(new Color(255,255,255));
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        right.add(btnCorrige, gbc);
         btnCorrige.setBackground(new Color(255,127,0));
        
        gbc.gridx = 2;
        gbc.gridy = 5;
        right.add(btnConfirma, gbc);
        btnConfirma.setBackground(new Color(35,142,35));
        
        
        // LAYOUT:
        
        setLayout(new BorderLayout());
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        validate();
        
    }

    static class Vencedor extends JFrame{

        JPanel vencedor = new JPanel();

        // Labels:
        JLabel lblNumero = new JLabel("Numero: ");
        JLabel lblPartido = new JLabel("Partido: ");
        JLabel lblFoto = new JLabel();
        JLabel lblNome = new JLabel("Nome: ");

        // TextFields:
        private final JTextField txtNumero1 = new JTextField();
        private final JTextField txtNumero2 = new JTextField();

        public Vencedor() {

            // Ler o vencedor
            try {
                File file = new File("NovoPresidente.txt");

                FileReader ler = new FileReader("NovoPresidente.txt");
                BufferedReader reader = new BufferedReader(ler);
                String linha;
                String dados[];

                while ((linha = reader.readLine()) != null) {
                    dados = linha.split(" ");
                    nome = dados[0];
                    numero1 = dados[1];
                    numero2 = dados[2];
                    partido = dados[3];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Declaração:
            setSize(400, 400);

            // Layout:
            GridBagLayout layout = new GridBagLayout();
            vencedor.setLayout(layout);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipady = 30;
            gbc.ipadx = 30;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Chamadas:

            // ============================= LEFT ==================================

            // Labels
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(5, 5, 5, 5);
            vencedor.add(lblNumero, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            vencedor.add(lblPartido, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            vencedor.add(lblNome, gbc);

            // TextFields
            txtNumero1.setEditable(false);
            gbc.ipady = 10;
            gbc.ipadx = 20;
            gbc.gridx = 2;
            gbc.gridy = 2;
            vencedor.add(txtNumero1, gbc);

            txtNumero2.setEditable(false);
            gbc.gridx = 3;
            gbc.gridy = 2;
            vencedor.add(txtNumero2, gbc);

            // Foto

            gbc.gridx = 0;
            gbc.gridy = 0;
            vencedor.add(lblFoto, gbc);

            // LAYOUT:
            add(vencedor, BorderLayout.CENTER);
            validate();

        }

        public void anunciaVencedor(){

            String aux = numero1 + numero2;
            System.out.println(aux);

            if (aux.equals("13")){
                lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\haddad1.jpg"));
            }
            else{
                if(aux.equals("17")){
                    lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\bolsonaro1.jpg"));
                }
                else{
                    if (aux.equals("12")){
                        lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\ciro1.jpg"));
                    }
                    else{
                        if(aux.equals("70")){
                            lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\daciolo.jpg"));
                        }
                        else{
                            if(aux.equals("28")){
                                lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\fidel.jpg"));
                            }
                            else{
                                if (aux.equals("45")){
                                    lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\\\geraldo.jpg"));
                                }
                                else{
                                    // 18
                                    if (aux.equals("18")) {
                                        lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\marina.jpg"));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Foto
            this.txtNumero1.setText(numero1);
            this.txtNumero2.setText(numero2);

            this.lblPartido.setText(this.lblPartido.getText() + " " + partido);
            this.lblNome.setText(this.lblNome.getText() + " " + nome);
        }

    }


    public static void main(String[] args) {        
        urna urna = new urna();
        Vencedor presidente = new Vencedor();
        Apuração apu = new Apuração();

        // Anuncia Vencedor
        urna.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    apu.Apuracao();
                    presidente.anunciaVencedor();
                    presidente.setVisible(true);
            }
        });

        presidente.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Foto:
        urna.lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\vazio1.jpg"));
        
        // NUMEROS:
        
        urna.btn1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("1");
            }
        });
        
        urna.btn2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("2");
            }
        });
        
        urna.btn3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("3");
            }
        });
        
        urna.btn4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("4");
            }
        });
        
        urna.btn5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("5");
            }
        });
        
        urna.btn6.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("6");
            }
        });
        
        urna.btn7.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("7");
            }
        });
        
        urna.btn8.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("8");
            }
        });
        
        urna.btn9.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("9");
            }
        });
        
        urna.btn0.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoNumero("0");
            }
        });
        
        // CONFIRMA:
        
        urna.btnConfirma.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoConfirma();
                urna.txtNumero1.setText(null);
                urna.txtNumero2.setText(null);
                urna.lblNome.setText("Nome: ");
                urna.lblPartido.setText("Partido: ");
                urna.lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\vazio1.jpg"));
            }
        });
        
        // CORRIGE:
        
        urna.btnCorrige.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                urna.botaoCorrige();
            }
        });
        
        // BRANCO:
        
        urna.btnBranco.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(urna.lblNome.getText().equals("Nome: ")){
                    urna.lblNome.setText(urna.lblNome.getText() + "Voto Branco");
                    urna.txtNumero1.setText("X");
                    urna.txtNumero2.setText("X");
                    urna.lblFoto.setIcon(new ImageIcon("C:\\Users\\ricar\\OneDrive\\Documentos\\NetBeansProjects\\Ele\\src\\Elei\\vazio1.jpg"));
                }
                
            }
        });
    }
}

