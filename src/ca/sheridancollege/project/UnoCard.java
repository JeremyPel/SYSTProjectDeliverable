/**
 * 
 */
package ca.sheridancollege.project;

/**
 * 
 */
public class UnoCard extends Card {
	public enum Color {
		BLUE, GREEN, RED, YELLOW, NONE
	}
	
	public enum Value {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, DRAW_TWO, WILD
	}
	
	private Color color = null;
	private Value value = null;
	
	public UnoCard(Color color, Value value) {
		this.color = color;
		this.value = value;
	}
	
	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}
        
        public void setColor(Color color) {
                this.color = color;
        }

	@Override
	public String toString() {
		return "UnoCard [color=" + color + ", value=" + value + "]";
	}
}
