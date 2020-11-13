package zendesk.intern.data;

/**
 * @author Kevin Niland
 * @category @version 1.0
 * 
 *           Via.java -
 */
public class Via {
	private String channel;
	private Source source;

	public Via() {
		
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
}
