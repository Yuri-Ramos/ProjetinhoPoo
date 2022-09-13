package src.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    

    public String converterDateParaDataEHora(Date data){

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        //08/08/2021 12:52 hrs
        return formatador.format(data);

    }

}
