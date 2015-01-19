package fr.istic.aocproject.v2.adapter;

import fr.istic.aocproject.controller.IController;
import fr.istic.aocproject.ihm.IiHMController;

	public interface Adapter extends IiHMController, IController{
		/**
		* Lit l'état du matériel
		*/
		public void lireMateriel();
		}

