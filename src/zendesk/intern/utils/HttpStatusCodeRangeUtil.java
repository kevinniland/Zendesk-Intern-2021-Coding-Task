package zendesk.intern.utils;

import zendesk.intern.enums.HttpStatusCodeRange;

/**
 * @author Kevin Niland
 * @category Utilities
 * @version 1.0
 * 
 *          HttpStatusCodeRangeUtil.java - Utility class for defining the ranges
 *          of a successful HTTP status code, client-side HTTP status code,
 *          server-side HTTP status code, or an unknown HTTP status code
 */
public class HttpStatusCodeRangeUtil {
	public static HttpStatusCodeRange getRange(int code) {
		if (code >= 200 && code < 300) {
			return HttpStatusCodeRange.SUCCESS_RANGE;
		}

		if (code >= 400 && code < 500) {
			return HttpStatusCodeRange.CLIENT_ERROR_RANGE;
		}

		if (code >= 500 && code < 600) {
			return HttpStatusCodeRange.SERVER_ERROR_RANGE;
		}

		return HttpStatusCodeRange.UNKNOWN;
	}
}
