package elei;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Apuração {
    
    public void Apuracao() {
        
        String voto;
        int ci = 0,lu = 0,bo = 0, ma = 0, fi = 0, al = 0, da = 0, bn = 0;
        try {
            File file = new File("Resultadovotação.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader ler = new FileReader("Resultadovotação.txt");
            BufferedReader reader = new BufferedReader(ler);
            Scanner input = new Scanner(reader);
            String linha;
            String dados[];
            
            //Percorre as linhas enquanto houver texto 
            while( (linha = reader.readLine()) != null ){
                dados = linha.split(" ");
                voto = dados[1];
            
                if (voto.equals("12")) {
                    ci++;
                }else if (voto.equals("13")) {
                    lu++;
                }else if (voto.equals("17")) {
                    bo++;
                }else if (voto.equals("18")) {
                    ma++;                
                }else if (voto.equals("28")) {
                    fi++;                
                }else if (voto.equals("45")) {
                    al++;                
                }else if (voto.equals("70")) {
                    da++;
                }else if (voto.equals("x")) {
                    bn++;
                }
            }
            if (da > ci && da > lu && da > bo && da > ma && da > fi && da > al && da > bn){
                Presidente("Daciolo ", "7 0 ", "Avante");
                
            }else
                if (lu > ci && lu > da && lu > bo && lu > ma && lu > fi && lu > al && lu > bn) {
                    Presidente("Haddad ", "1 3 ", "PT" );
                    
            }else
                if (bo > ci && bo > da && bo > bo && lu > ma && bo > fi && bo > al && bo > bn) {
                    Presidente("Bolsonaro ", "1 7 ", "PSL");
                    
            }else
                if (ma > ci && ma > da && ma > bo && ma > ma && lu > fi && ma > al && ma > bn) {
                    Presidente("Marina ", "1 8 ", "REDE");
                    
            }else
                if (al > ci && al > da && al > bo && al > ma && al > fi && al > lu && al > bn) {
                    Presidente("Alckmin ","4 5 ","PSDB");
                    
            }else
                if (ci > lu && ci > da && ci > bo && ci > ma && ci > fi && ci > al && ci > bn) {
                    Presidente("Ciro ","1 2 ","PDT");
                    
            }else
                if (fi > ci && fi > da && fi > bo && fi > ma && fi > lu && fi > al && fi > bn) {
                    Presidente("Fidelix ", "2 8 ","PRTB");
            }else{
                    if(bn > ci && bn > da && bn > bo && bn > ma && bn > lu && bn > al && bn > fi){
                        Presidente("Nulo / Branco ", "X X ", "POVO");
            }else
                        Presidente("Segundo Turno ", "X X ", "POVÃO");
                }
                    
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void Presidente(String candidato, String num, String partido){
        try {
            File file = new File("NovoPresidente.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write((candidato) + (num) + (partido));
            bw.close();
            urna.Vencedor presidente = new urna.Vencedor();
            presidente.anunciaVencedor();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
