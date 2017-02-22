/**
 * PRACTICA 3: LA CLASE FECHA
 * 
 * Creamos una clase capaz de trabajar con fechas.
 * 
 * @author alu0100888102
 * @version 1.0
 */

public class Fecha {
	int dia;
	int mes;
	int anio;
	
	
	public Fecha(){
		dia=1;
		mes=1;
		anio=1;
	}
	public Fecha(int year, int month, int day){
		this.setFecha(year, month, day);
	}
	
	public int getDia(){
		return dia;
	}
	public int getMes(){
		return mes;
	}
	public int getAnio(){
		return anio;
	}
	
	/**
	 * Devuelve true si el año que se pasa como parametro es bisiesto.
	 * Un año es bisiesto si es divisible por 4 pero no por 100 o es divisible por 400.
	 * @param year
	 * @return
	 */
	public static boolean esBisiesto(int year){
		if(((year % 4) == 0) && ((year % 100) != 0))
			return true;
		if((year % 400) == 0)
			return true;
		return false;
	}
	
	/**
	 * Devuelve true si los parámetros constituyen una fecha válida
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static boolean esFechaValida(int year, int month, int day){
		if(day < 1)
			return false;
		if(year < 1)
			return false;
		switch (month){
			case 1:
				if(day <= 31)
					return true;
				else
					return false;
			case 2:
				if(day<=28)
					return true;
				if((day == 29) && esBisiesto(year))
					return true;
				else
					return false;
			case 3: 
				if(day <= 31)
					return true;
				else
					return false;
			case 4:
				if(day <= 30)
					return true;
				else
					return false;
			case 5: 
				if(day <= 31)
					return true;
				else
					return false;
			case 6: 
				if(day <= 30)
					return true;
				else
					return false;
			case 7: 
				if(day <= 31)
					return true;
				else
					return false;
			case 8: 
				if(day <= 31)
					return true;
				else
					return false;
			case 9: 
				if(day <= 30)
					return true;
				else
					return false;
			case 10: 
				if(day <= 31)
					return true;
				else
					return false;
			case 11: 
				if(day <= 30)
					return true;
				else
					return false;
			case 12: 
				if(day <= 31)
					return true;
				else
					return false;
			default: return false;
		}
	}
	
	/**
	 * Para calcular el dia de la semana utilizaremos una variante del algoritmo de gauss.
	 * https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
	 * @return
	 */
	public int getDiaDeSemana(){
		int Y, y, c, d, m;
		if(mes <=2)
			Y = anio-1;
		else
			Y = anio;
		y = Y%100;
		c = Y / 100;
		d = dia;
		m = (mes+9)%12 +1;
		
		int w=(d + (int)(Math.floor(2.6*m - 0.2)) + y + (int)(Math.floor(y/4)) + (int)(Math.floor(c /4)) - 2*c)%7;
		//w => 0= domingo,1= lunes... hay que sumarle 6, hacer el modulo y sumar 1 para 0=lunes, 1= martes
		return (w+6)%7 +1;
	}
	
	/**
	 * Antes de hacer el set comprueba que es una fecha valida
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setFecha(int year, int month, int day){
		if(day > year){
			int temp = day;
			day = year;
			year = temp;
		}
		if(!esFechaValida(year, month, day))
			throw new IllegalArgumentException("dia, mes o año invalido");
		else{
			dia = day;
			mes = month;
			anio = year;
		}
		if(anio > 9999)
			throw new IllegalStateException("Año fuera de rango");
	}
	
	/**
	 * Estos métodos cambian sólo uno de los parámetros, asegurandose de que
	 * la fecha resultante sea válida
	 */
	
	public void setAnio(int year){
		try{
			this.setFecha(year, mes, dia);
		}
		catch(IllegalArgumentException e){
			System.out.println("Año invalido\n" +e);
		}
	}
	public void setMes(int month){
		try{
			this.setFecha(anio, month, dia);
		}
		catch(IllegalArgumentException e){
			System.out.println("Mes invalido\n" +e);
		}
	}
	public void setDia(int day){
		try{
			this.setFecha(anio, mes, day);
		}
		catch(IllegalArgumentException e){
			System.out.println("Dia invalido\n" +e);
		}
	}
	
	/**
	 * La salida del toString es DiaDeLaSemana DiaDelMes Mes Año.
	 */
	public String toString(){
		String salida = new String();
		switch(this.getDiaDeSemana()){
			case 1:
				salida = salida + "Lunes ";
				break;
			case 2: 
				salida = salida + "Martes ";
				break;
			case 3: 
				salida = salida + "Miércoles ";
				break;
			case 4: 
				salida = salida + "Jueves ";
				break;
			case 5: 
				salida = salida + "Viernes ";
				break;
			case 6: 
				salida = salida + "Sábado ";
				break;
			case 7: 
				salida = salida + "Domingo ";
				break;
		}
		salida = salida + dia + " ";
		switch(mes){
			case 1:
				salida = salida + "Enero ";
				break;
			case 2: 
				salida = salida + "Febrero ";
				break;
			case 3: 
				salida = salida + "Marzo ";
				break;
			case 4: 
				salida = salida + "Abril ";
				break;
			case 5: 
				salida = salida + "Mayo ";
				break;
			case 6: 
				salida = salida + "Junio ";
				break;
			case 7: 
				salida = salida + "Julio ";
				break;
			case 8: 
				salida = salida + "Agosto ";
				break;
			case 9: 
				salida = salida + "Septiembre ";
				break;
			case 10: 
				salida = salida + "Octubre ";
				break;
			case 11: 
				salida = salida + "Noviembre ";
				break;
			case 12: 
				salida = salida + "Diciembre ";
				break;
		}
		salida = salida + anio;
		return salida;
	}
	
	/**
	 * Avanza hasta el siguiente dia del calendario
	 */
	public void siguienteDia(){
		//si la fecha es valida simplemente cambiando el dia
		if(esFechaValida(anio, mes, dia+1)){
			this.setFecha(anio, mes, dia+1);
			return;
		}
		//si no es valida con solo el dia entonces es que nos salimos del mes
		if(esFechaValida(anio, mes+1, 1)){
			this.setFecha(anio, mes+1, 1);
			return;
		}
		//ahora nos salimos del año
		if(esFechaValida(anio+1,1, 1)){
			this.setFecha(anio+1, 1, 1);
		}
	}
	/**
	 * Retrocede hasta el dia anterior
	 */
	public void anteriorDia(){
		//si la fecha es valida retrocediendo un dia
		if(esFechaValida(anio, mes, dia-1)){
			this.setFecha(anio, mes, dia-1);
			return;
		}
		//si no retrocedemos al ultimo dia del mes anterior, que puede ser 31,30,29 o 28
		if(esFechaValida(anio, mes-1, 31)){
			this.setFecha(anio, mes-1, 31);
			return;
		}
		if(esFechaValida(anio, mes-1, 30)){
			this.setFecha(anio, mes-1, 30);
			return;
		}
		if(esFechaValida(anio, mes-1, 29)){
			this.setFecha(anio, mes-1, 29);
			return;
		}
		//si no retrocedemos al año anterior
		if(esFechaValida(anio-1,12, 31)){
			this.setFecha(anio-1, 12, 31);
		}
	}
	/**
	 * Avanza hasta el siguiente mes del calendario
	 */
	public void siguienteMes(){
		//si la fecha es valida avanzando un mes
		if(esFechaValida(anio, mes+1, dia)){
			this.setFecha(anio, mes+1, dia);
			return;
		}
		//si no, retocedemos el dia hasta que lleguemos al maximo del mes
		if(esFechaValida(anio, mes+1, dia-1)){
			this.setFecha(anio, mes+1, dia-1);
			return;
		}
		if(esFechaValida(anio, mes+1, dia-2)){
			this.setFecha(anio, mes+1, dia-2);
			return;
		}
		//lo maximo que hay que retroceder son 3 dias, del 31 al 28
		if(esFechaValida(anio, mes+1, dia-3)){
			this.setFecha(anio, mes+1, dia-3);
			return;
		}
		//si nos pasamos del año, no hace falta retroceder ningun dia porque enero tiene 31 dias
		if(esFechaValida(anio+1,1, dia)){
			this.setFecha(anio+1, 1, dia);
		}
	}
	/**
	 * Retrocede hasta el mes anterior
	 */
	public void anteriorMes(){
		//si la fecha es valida retrocedo un mes
		if(esFechaValida(anio, mes-1, dia)){			
			this.setFecha(anio, mes-1, dia);
			return;
		}
		//si no, retocedemos el dia hasta que lleguemos al maximo del mes
		if(esFechaValida(anio, mes-1, dia-1)){
			this.setFecha(anio, mes-1, dia-1);
			return;
		}
		if(esFechaValida(anio, mes-1, dia-2)){
			this.setFecha(anio, mes-1, dia-2);
			return;
		}
		//lo maximo que hay que retroceder son 3 dias, del 31 al 28
		if(esFechaValida(anio, mes-1, dia-3)){
			this.setFecha(anio, mes-1, dia-3);
		return;
		}
		//si nos pasamos del año, no hace falta retroceder ningun dia porque diciembre tiene 31 dias
		if(esFechaValida(anio-1, 12, dia)){
			this.setFecha(anio-1, 12, dia);
		}
	}
	/**
	 * Avanza hasta el siguiente año del calendario
	 */
	public void siguienteAnio(){
		//si la fecha es valida avanzando un mes
		if(esFechaValida(anio+1, mes, dia)){
			this.setFecha(anio+1, mes, dia);
			return;
		}
		//si no, es 29 de febreroasi que retrocedemos un dia
		if(esFechaValida(anio+1, mes, dia-1)){
			this.setFecha(anio+1, mes, dia-1);
		}
	}
	/**
	 * Retrocede hasta el mes anterior
	 */
	public void anteriorAnio(){
		//si la fecha es valida retrocedo un mes
		if(esFechaValida(anio-1, mes, dia)){
			this.setFecha(anio-1, mes, dia);
			return;
		}
		//si no, es 29 de febreroasi que retrocedemos un dia
		if(esFechaValida(anio-1, mes, dia-1)){
			this.setFecha(anio-1, mes, dia-1);
		}
	}
	
	
	public static void main(String args[]){
		Fecha fecha1 = new Fecha ( 28 , 2 , 2012) ;
		System.out.println(fecha1) ; // martes 28 Feb 2012
		fecha1.siguienteDia();
		System.out.println(fecha1); // mi´ercoles 29 Feb 2012
		fecha1.siguienteDia();
		System.out.println(fecha1); // jueves 1 Mar 2012
		fecha1.siguienteMes();
		System.out.println(fecha1); // domingo 1 Apr 2012
		fecha1.siguienteAnio();
		System.out.println(fecha1); // lunes 1 Apr 2013
		
		Fecha fecha2= new Fecha ( 2 , 1 , 2012) ;
		System.out.println(fecha2); // lunes 2 Ene 2012
		fecha2.anteriorDia();
		System.out.println(fecha2); // domingo 1 Ene 2012
		fecha2.anteriorDia();
		System.out.println(fecha2) ; // s´abado 31 Dic 2011
		fecha2.anteriorMes();
		System.out.println(fecha2) ; // mi´ercoles 30 Nov 2011
		fecha2.anteriorAnio();
		System.out.println(fecha2) ; // martes 30 Nov 2010
		
		Fecha d3 = new Fecha (2012 , 2 , 29 ) ;
		d3.anteriorAnio();
		System.out.println (d3) ; // lunes 28 Feb 2011
	}
}
