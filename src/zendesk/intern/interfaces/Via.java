package zendesk.intern.interfaces;

import zendesk.intern.data.SourceImpl;

/**
 * @author Kevin Niland
 * @category Interface
 * @version 1.0
 * 
 *          Via.java - Interface for ViaImpl
 *
 */
public interface Via {
	String getChannel();

	void setChannel(String channel);

	SourceImpl getSource();

	void setSource(SourceImpl source);
}
