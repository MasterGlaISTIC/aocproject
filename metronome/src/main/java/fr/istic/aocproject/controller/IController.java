package fr.istic.aocproject.controller;


public interface IController {

	public void inStart();
	public void inStop();
	public String initBPM();
	public void incBPM();
	public void decBPM();
	public String getBPM();
}
