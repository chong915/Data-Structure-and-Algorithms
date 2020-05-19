/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab10;

/**
 *
 * @author Windows 10
 */
public class Vertex<V> {
    private V label;
    
    public Vertex(V label){
        this.label = label;
    }
    public V getVertex(){
        return label;
    }
    public boolean equals(Object o) {
        // null check
        if (o == null) {
                return false;
        }

        // this instance check
        if (this == o) {
                return true;
        }

        // instanceof Check and actual value check
        if ((o instanceof Vertex) && (((Vertex) o).getVertex() == this.label)) {
                return true;
        } else {
                return false;
        }
    }
 
	@Override
	public int hashCode() {
		int result = 0;
		result = (int)(Character)label/11;
		return result;
	}
}
