package zendesk.intern.data;

import zendesk.intern.interfaces.Via;

/**
 * @author Kevin Niland
 * @category @version 1.0
 * 
 *           Via.java -
 */
public class ViaImpl implements Via {
	private String channel;
	private SourceImpl source;

	public ViaImpl() {
		
	}

	@Override
	public String getChannel() {
		return channel;
	}

	@Override
	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public SourceImpl getSource() {
		return source;
	}

	@Override
	public void setSource(SourceImpl source) {
		this.source = source;
	}
}
