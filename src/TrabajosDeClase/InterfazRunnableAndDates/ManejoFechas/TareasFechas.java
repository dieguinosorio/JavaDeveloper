package TrabajosDeClase.InterfazRunnableAndDates.ManejoFechas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TareasFechas {
    public static void main(String[] args) {
        diferenciaFechas(new Date(2024, 05, 1), new Date(2024, 06, 1));
        fechaISO(new Date());
        fechaValida();
        horasPaises();
    }
    public static void diferenciaFechas(Date fecha1, Date fecha2){

        long millisInicio = fecha1.getTime();
        long millisFin = fecha2.getTime();

        long diferenciaMillis = millisFin - millisInicio;

        long diasDiferencia = TimeUnit.MILLISECONDS.toDays(diferenciaMillis);

        System.out.println("La diferencia en días entre " + fecha1 + " y " + fecha2 + " es: " + diasDiferencia + " días.");
    }

    public static void fechaISO( Date fecha) {
        Instant instant = fecha.toInstant();

        LocalDate fechaLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        String fechaISO = fechaLocalDate.toString();
        System.out.println("Fecha en formato ISO: " + fechaISO);
    }

    public static void fechaValida() {
        String fechaString = "2024-06-06";
        String formato = "yyyy-MM-dd";

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
            LocalDate fecha = LocalDate.parse(fechaString, formatter);
            System.out.println("La fecha " + fechaString + " es válida en el formato " + formato);
        } catch (DateTimeParseException e) {
            System.out.println("La fecha " + fechaString + " no es válida en el formato " + formato);
        }
    }

    public static void horasPaises() {
        ZonedDateTime horaLondres = ZonedDateTime.now(ZoneId.of("Europe/London"));
        ZonedDateTime horaNuevaYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime horaTokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        System.out.println("Hora en Londres: " + horaLondres);
        System.out.println("Hora en Nueva York: " + horaNuevaYork);
        System.out.println("Hora en Tokio: " + horaTokio);

        long diferenciaHorariaLondresNuevaYork = horaLondres.getOffset().getTotalSeconds()
                - horaNuevaYork.getOffset().getTotalSeconds();
        System.out.println("Diferencia horaria entre Londres y Nueva York: " + diferenciaHorariaLondresNuevaYork / 3600 + " horas");
    }
}
