/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author bernard
 */
public class Carona {
    
    private String localOrigem;
    private String localDestino;
    private int hora,minuto;
	private Calendar dataDaCarona,dataATual;
	private String dataDaCarona_String;
	private int vagasDisponiveis;
	private int dia,mes,ano;
    
    public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Carona(String origem,String destino,int dia,int mes,int ano, int hora,int minuto,int vagas)throws Exception{
		this.dataDaCarona = new GregorianCalendar();
		this.dataATual = new GregorianCalendar();
		this.dataDaCarona.set(ano, mes, dia);
		if (dataDaCarona.before(dataATual)){
			throw new Exception("Data invalida");
		}
		
        if( origem==null || origem.equals("")){
            throw new Exception("origem/destino entrada invalida");
        }
        if(hora>23 || hora<0 || minuto>59 || minuto<0){
            throw new Exception("hora/minuto entrada invalida");
        }
        this.dataDaCarona = new GregorianCalendar();
        this.dataDaCarona.set(ano, mes, dia);
        this.dataDaCarona_String = dia + "/" + mes + "/" + ano;
        this.hora = hora;
        this.localDestino = destino;
        this.localOrigem = origem;
        this.minuto = minuto;
        this.vagasDisponiveis = vagas;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
	
	public Carona(){
		
	}
    
    public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
    
    protected Calendar getDataDaCarona() {
		return dataDaCarona;
	}
    
     public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

	protected String getData() {
		return dataDaCarona_String;
	}

	public String getTrajeto(){
		return this.getLocalOrigem()+" - "+this.getLocalDestino();
	}
    
    
}
