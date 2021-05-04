import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Main extends PApplet {
	
	Tela t = new Tela();
	ArrayList<Inimigo> inimigos;
	Inimigo in;
	Player p;
	PImage player, inimigo, score, controles, fundo, txtbox;
	PFont fonte;
	
	int spawn;
	int spawn2;
	int spawn3;
	int spawn4;
	int spawn5;
	int timer;
	
	int contador;
	int contador2;
	int contador3;
	int contador4;
	int contador5;
	
	int pontos;
	
	public void settings() {
		
		contador = 0;
		contador2 = 0;
		contador3 = 0;
		contador4 = 0;
		contador5 = 0;
		pontos = 0;
		
		size(t.getLargura(), t.getAltura());
		  
		inimigos = new ArrayList<Inimigo>();
		p = new Player(t.getLargura()/2 - 16, t.getAltura() - 32, 32);
		
		timer = millis();
		
		//HUD		
		player = loadImage("player.png");
		inimigo = loadImage("enemy.png");
		score = loadImage("score.png");
		controles = loadImage("controls.png");
		fundo = loadImage("BG.png");
		txtbox = loadImage("text-box.png");
		
		inimigos.add(new Inimigo(t.getLargura()/2 - 16, t.getAltura(), 32));
		
	}
	
	/*O que falta fazer?
	Otimizar a dificuldade do jogo
	Adicionar colisao com borda do mapa
	 */

	public void draw(){
		background(fundo);
		fonte = createFont("Pixel.ttf", 24);
		textFont(fonte);
		
		//Jogador
		noFill();
		noStroke();
		rect(p.getPosx(),p.getPosy(),p.getTamanho(),p.getTamanho());
		image(player, p.getPosx(),p.getPosy());
		
		if(millis() - timer > 2000) {
			pontos++;
			timer = millis();
		}
		
		//HUD
		textAlign(CENTER);
		textSize(32);
		fill(255,216,0);
		image(score, 10, 10);
		text(pontos, 68, 35);
		fill(0,225,255);
		textSize(18);
		text("Matheus Ritton", t.getLargura() - 80, t.getAltura() - 10);
		fill(255);
		textSize(24);
		text("Controles", t.getAltura()/6 + 10, t.getLargura()/6 + 10);
		image(controles, t.getAltura()/20, t.getLargura()/5);

		//Inimigos
		for (int i = 0; i < inimigos.size(); i++) {	
			Inimigo in = inimigos.get(i);
			noFill();
			noStroke();
			rect(in.getPosx(),in.getPosy(),in.getTamanho(),in.getTamanho());
			image(inimigo, in.getPosx(),in.getPosy());
			in.move();
			
			p.colisao(in);
						
			//Spawn de Inimigos - Level 1
			if(millis() - spawn > 2000 && contador < 1) {
				criaInimigoLinha1();

			}
			
			if(millis() - spawn2 > 3000 && contador2 < 2) {
				criaInimigoLinha2();

			}
			
			if(millis() - spawn3 > 4000 && contador3 < 2) {
				criaInimigoLinha3();

			}
			
			if(millis() - spawn4 > 4000 && contador4 < 2) {
				criaInimigoLinha4();

			}
			
			if(millis() - spawn5 > 3000 && contador5 < 2) {
				criaInimigoLinha5();

			}
			
			//Checagem de vidas do Jogador
			
			if(p.getVida() == 0) {
				fill(0,225,255);
				textFont(fonte);
				image(txtbox, t.getLargura()/2 - 200, t.getAltura()/2 - 48);
				text("Fim de Jogo!\nPressione 'R' para recomeçar\nPressione 'ESC' para Sair", t.getLargura()/2, t.getAltura()/2);
				noLoop();
			
			}

			
		}
			
	}
	
	public void criaInimigoLinha1() {
		inimigos.add(new Inimigo(t.getLargura()/2 - 16, t.getAltura(), 32));
		spawn = millis();
		contador++;

	}
	
	public void criaInimigoLinha2() {
		inimigos.add(new Inimigo(t.getLargura()/2 - 80, t.getAltura(), 32, 1.75));
		spawn2 = millis();
		contador2++;
	}
	
	public void criaInimigoLinha3() {
		inimigos.add(new Inimigo(t.getLargura()/2 + 48, t.getAltura(), 32, 2.5));
		spawn3 = millis();
		contador3++;
	}
	
	public void criaInimigoLinha4() {
		inimigos.add(new Inimigo(t.getLargura()/2 - 144, t.getAltura(), 32, 3.0));
		spawn4 = millis();
		contador4++;
	}
	
	public void criaInimigoLinha5() {
		inimigos.add(new Inimigo(t.getLargura()/2 + 112, t.getAltura(), 32));
		spawn5 = millis();
		contador5++;
	}
	
	//Funcoes relacionadas a pressionamento de teclas
	
	public void keyReleased() {
		
		if (key == 'd' || key == 'D') {
			p.moveDireita();
		
		}
		
		if (key == 'a' || key == 'A') {
			p.moveEsquerda();
		}
		
		if (key == 'w' || key == 'W') {
			p.moveCima();
			
		}
		
		if (key == 's' || key == 'S') {
			p.moveBaixo();
			
		}
		
		if (key == 'r' || key == 'R') {
			loop();
			settings();
		}
		
		if (key == 27) {
			exit();
		}
	
	}
	

	public static void main(String[] args) {
		
		String[] processingArgs = {"MySketch"};
		Main mySketch = new Main();
		PApplet.runSketch(processingArgs, mySketch);

	}

}
