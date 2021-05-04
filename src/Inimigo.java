
public class Inimigo extends Tela{
	
	private int tamanho;
	private float pos_x;
	private float pos_y;
	private double velocidade = 2.0;
	
	Inimigo(float x, float y, int tamanho) {
		
		this.pos_x = x;
		this.pos_y = y;
		this.tamanho = tamanho;
	}
	
	Inimigo(float x, float y, int tamanho, double vel) {
		
		this.pos_x = x;
		this.pos_y = y;
		this.tamanho = tamanho;
		this.velocidade = vel;
	}
	
	public float getPosx() {
		return pos_x;
	}
	
	public float getPosy() {
		return pos_y;
	}
	
	public float getTamanho() {
		return tamanho;
	}
	
	public void move() {
		pos_y = (float) (pos_y + velocidade);
		
		if (pos_y > getAltura()) {
			pos_y = pos_y - getAltura();
		}

	}

}
