package zendesk.intern.data;

import zendesk.intern.interfaces.Source;

/**
 * @author Kevin Niland
 * @category Data
 * @version 1.0
 * 
 *           Source.java -
 */
public class SourceImpl implements Source {
	private String rel;
	
	/**
	 * 
	 * @return rel
	 */
	@Override
	public String getRel() {
		return rel;
	}

	/**
	 * 
	 * @param rel
	 */
	@Override
	public void setRel(String rel) {
		this.rel = rel;
	}
}
