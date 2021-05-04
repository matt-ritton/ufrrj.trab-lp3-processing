
public class Player extends Tela{
	
	private int tamanho;
	private int vida = 1;
	private float pos_x;
	private float pos_y;
	private double passos = 64;
	
	Player(float x, float y, int tamanho) {
		
		this.pos_x = x;
		this.pos_y = y;
		this.tamanho = tamanho;
	}
	
	public float getPosx() {
		return pos_x;
	}
	
	public float getPosy() {
		return pos_y;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void moveDireita() {
		pos_x = (float) (pos_x + passos);
	}
	
	public void moveEsquerda() {
		pos_x = (float) (pos_x - passos);
	}
	
	public void moveCima() {
		pos_y = (float) (pos_y - passos);
	}
	
	public void moveBaixo() {
		pos_y = (float) (pos_y + passos);
	}
	
	
	
	
	public void colisao(Inimigo in) {
		
		if (pos_x + tamanho > in.getPosx() && pos_x < in.getPosx() + in.getTamanho() && pos_y + tamanho > in.getPosy() && pos_y < in.getPosy() + in.getTamanho()) {
			pos_x = getLargura()/2 - 16;
			pos_y = getAltura() - 32;
			vida = 0;
		}
	
	}
	
}
