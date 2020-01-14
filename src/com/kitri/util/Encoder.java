package com.kitri.util;

import java.io.*;
import java.net.*;

public class Encoder {

	public static String utfEncode(String tmp) {
		String enc = "";
			try {
				if(tmp != null && !tmp.isEmpty()) {
					enc = URLEncoder.encode(tmp, BoardConstance.ENCODING);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return enc;
		}
}
