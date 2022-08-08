import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Calendar;
import java.time.*;
import java.time.DayOfWeek;

public class Main {


    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);
        String dataUsuario = inputUsuario.next();
        String[] vetorData = dataUsuario.split("/");
        verificaData(dataUsuario);
        retornarDiaSemana(Integer.parseInt(vetorData[2]),Integer.parseInt(vetorData[1]),Integer.parseInt(vetorData[0]));
    }

    public static String retornarDiaSemana(int ano, int mes, int dia) {

        Calendar calendario = new GregorianCalendar(ano, mes - 1, dia);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        return pesquisarDiaSemana(diaSemana);
    }

    public static String pesquisarDiaSemana(int diaSem) {
        String diaSemana = null;

        switch (diaSem) {

            case 1: {
                diaSemana = "Domingo";
                break;
            }
            case 2: {
                diaSemana = "Segunda";
                break;
            }
            case 3: {
                diaSemana = "Terça";
                break;
            }
            case 4: {
                diaSemana = "Quarta";
                break;
            }
            case 5: {
                diaSemana = "Quinta";
                break;
            }
            case 6: {
                diaSemana = "Sexta";
                break;
            }
            case 7: {
                diaSemana = "Sábado";
                break;
            }
        }
        return diaSemana;
    }

    static Boolean verificaData(String dataUsuario) {

        String[] vetorData;
        vetorData = dataUsuario.split("/");
        return verificaDia(vetorData) && verificaMes(vetorData);
    }


    private static Boolean verificaMes(String[] vetorData) {
        int dataInteiro;
        dataInteiro = Integer.parseInt(vetorData[1]);

        if (dataInteiro >= 1 && dataInteiro <= 12) {
            return true;
        } else {
            System.out.println("Mes Inválido");
            return false;
        }

    }


    private static Boolean verificaDia(String[] vetorData) {
        int[] vetorMeses = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diaInteiro;
        diaInteiro = Integer.parseInt(vetorData[0]);

        if (verificaMes(vetorData)) {
            int mesInteiro = Integer.parseInt(vetorData[1]);
            if (diaInteiro >= 1 && diaInteiro <= vetorMeses[mesInteiro - 1]) {
                return true;
            } else {
                System.out.println("Dia Invalido");
                return false;
            }
        } else
            return false;
    }
}
