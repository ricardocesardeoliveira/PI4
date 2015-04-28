package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.crypto.Data;

public class BuscaCEP {

    static String datinha;
    static Date data;

    public static void main(String[] args) throws ParseException {

        Date data = new Date();//Instanciando data da classe Date()
      
//        data.getDate();
//        data.getTime();//Informando a data atual do computador
//        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");//formatando a data atual do computador
//        String dataFormatada = formatarDate.format(data);//data já formatada utilizando o metodo format()
//        System.out.println(dataFormatada);
//        System.out.println(data.getTime());
//----------------------------------------------------------------------------------------------------------------------------
// TESTE da conversão de Data        
        datinha = "02/04/1992";

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        data = (Date) (java.util.Date) formatter.parse(datinha);
        System.out.print("Data porra: " + datinha + "\n \n");
          
//----------------------------------------------------------------------------------------------------------------------------
// TESTE do buscador de CEP        
//        CepWebService web = new CepWebService("04865-060");
//
//        System.out.println(web.getCidade());
//        System.out.println(web.getEstado());
//        System.out.println(web.getBairro());
//        System.out.println(web.getLogradouro());
//----------------------------------------------------------------------------------------------------------------------------
    }

}
