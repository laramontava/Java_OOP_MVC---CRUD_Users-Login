package app.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class fecha {

    private String fecha;

    public fecha(String fecha) {//constructor
        this.fecha = fecha;
    }

    public fecha() {

    }

    public String getFecha() {//get
        return fecha;
    }

    public void setFecha(String fecha) {//set
        this.fecha = fecha;
    }

    public String toString() {//to string
        return this.fecha;
    }

    /**
     * Convierte un String en Calendar
     *
     * @param s
     * @return fecha
     */
    public Calendar stringtocalendar(String s) {
        Calendar fecha = new GregorianCalendar();
        String sdia = "", smes = "", sanyo = "";
        int dia = 0, mes = 0, anyo = 0;
        if (s.charAt(2) == '/' || s.charAt(2) == '-') {
            for (int i = 0; i <= 1; i++) {
                sdia += s.charAt(i);
                dia = Integer.parseInt(sdia);
            }
            for (int i = 3; i <= 4; i++) {
                smes += s.charAt(i);
                mes = Integer.parseInt(smes) - 1;
            }
            for (int i = 6; i <= 9; i++) {
                sanyo += s.charAt(i);
                anyo = Integer.parseInt(sanyo);
            }
        } else {
            for (int i = 8; i <= 9; i++) {
                sdia += s.charAt(i);
                dia = Integer.parseInt(sdia);
            }
            for (int i = 5; i <= 6; i++) {
                smes += s.charAt(i);
                mes = Integer.parseInt(smes) - 1;
            }
            for (int i = 0; i <= 3; i++) {
                sanyo += s.charAt(i);
                anyo = Integer.parseInt(sanyo);
            }
        }
        fecha.set(anyo, mes, dia);
        return fecha;
    }

    /**
     * Convierte un Calendar a String
     *
     * @param c
     * @return fechastring
     */
    public String calendartostring(Calendar c, int format) {
        String fe = "";
        switch (format) {
            case 0:
                if (c.get(Calendar.DATE) > 9) {
                    fe += Integer.toString(c.get(Calendar.DATE));
                } else {
                    fe += "0";
                    fe += Integer.toString(c.get(Calendar.DATE));
                }
                if (c.get(Calendar.MONTH) + 1 > 9) {
                    fe += "/" + Integer.toString(c.get(Calendar.MONTH) + 1) + "/";
                } else {
                    fe += "/" + "0";
                    fe += Integer.toString(c.get(Calendar.MONTH) + 1) + "/";
                }
                fe += Integer.toString(c.get(Calendar.YEAR));
                break;
            case 1:
                if (c.get(Calendar.DATE) > 9) {
                    fe += Integer.toString(c.get(Calendar.DATE));
                } else {
                    fe += "0";
                    fe += Integer.toString(c.get(Calendar.DATE));
                }
                if (c.get(Calendar.MONTH) + 1 > 9) {
                    fe += "-" + Integer.toString(c.get(Calendar.MONTH) + 1) + "-";
                } else {
                    fe += "-" + "0";
                    fe += Integer.toString(c.get(Calendar.MONTH) + 1) + "-";
                }
                fe += Integer.toString(c.get(Calendar.YEAR));
                break;
            case 2:
                fe += Integer.toString(c.get(Calendar.YEAR));
                if (c.get(Calendar.MONTH) + 1 > 9) {
                    fe += "/" + Integer.toString(c.get(Calendar.MONTH) + 1) + "/";
                } else {
                    fe += "/" + "0";
                    fe += Integer.toString(c.get(Calendar.MONTH) + 1) + "/";
                }
                if (c.get(Calendar.DATE) > 9) {
                    fe += Integer.toString(c.get(Calendar.DATE));
                } else {
                    fe += "0";
                    fe += Integer.toString(c.get(Calendar.DATE));
                }
                break;
            case 3:
                fe += Integer.toString(c.get(Calendar.YEAR));
                if (c.get(Calendar.MONTH) + 1 > 9) {
                    fe += "-" + Integer.toString(c.get(Calendar.MONTH) + 1) + "-";
                } else {
                    fe += "-" + "0";
                    fe += Integer.toString(c.get(Calendar.MONTH) + 1) + "-";
                }
                if (c.get(Calendar.DATE) > 9) {
                    fe += Integer.toString(c.get(Calendar.DATE));
                } else {
                    fe += "0";
                    fe += Integer.toString(c.get(Calendar.DATE));
                }
                break;
        }
        return fe;
    }

    /**
     * Recoge la fecha del sistema
     *
     * @return system
     */
    public Calendar fechasystem() {//fecha actual
        //int anyo, mes, dia;
        Calendar system = Calendar.getInstance();
        return system;
    }

    /**
     * Compara dos fechas y comprueba si la primera es posterior, anterior o la
     * misma que la segunda
     *
     * @param f
     * @return estado
     */
    public int comparafechas(Calendar f) {
        Calendar fecha1 = this.stringtocalendar(fecha);
        Calendar fecha2 = Calendar.getInstance();
        int estado = 0;
        if (fecha1.before(fecha2)) {
            estado = -1;
        } else if (fecha1.compareTo(fecha2) == 0) {
            estado = 0;
        } else if (fecha1.after(fecha2)) {
            estado = 1;
        }
        return estado;
    }

    /**
     * Resta dos fechas dando el resultado en a�os o en d�as seg�n el valor de
     * String election
     *
     * @param fecha1
     * @param fecha2
     * @param election
     * @return resta
     */
    public int restafechas(Calendar fecha1, Calendar fecha2, String election) {
        long resta = 0, anyo1, anyo2;
        anyo1 = fecha1.getTimeInMillis();
        anyo2 = fecha2.getTimeInMillis();
        switch (election) {
            case "years":
                if (anyo1 > anyo2) {
                    resta = ((anyo1 - anyo2) / (60 * 60 * 24 * 1000) / 365);
                } else {
                    resta = ((anyo2 - anyo1) / (60 * 60 * 24 * 1000) / 365);
                }

                break;
            case "day":
                if (anyo1 > anyo2) {
                    resta = ((anyo1 - anyo2) / (60 * 60 * 24 * 1000));
                } else {
                    resta = ((anyo2 - anyo1) / (60 * 60 * 24 * 1000));
                }
                break;

        }
        return (int) resta;
    }
}
