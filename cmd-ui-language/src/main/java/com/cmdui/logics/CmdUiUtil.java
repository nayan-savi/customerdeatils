package com.cmdui.logics;

import org.springframework.stereotype.Component;

@Component
public class CmdUiUtil {
	public static final String HEADER = "<!DOCTYPE html><html><body>";
	public static final String FOOTER = "</body></html>";
	public static final String h = "h";
	public static final String H = "H";
	public static final String EMPTY_SPACE = " ";
	public static final char COTE = (char) 34;

	public String getCode(String inputValue) {
		String array[] = inputValue.split(";");
		StringBuffer output = new StringBuffer(HEADER);
		boolean styleFlag = false;
		for (int i = 0; i < array.length; i++) {
			styleFlag = false;
			String element = array[i];
			String tags[] = element.trim().split("::");
			if (tags[0].equalsIgnoreCase("br")) {
				output.append("</br>");
			}

			// header generator
			if (tags[0].contains(H) || tags[0].contains(h)) {
				output.append("<" + tags[0]);
				if (tags[1].contains("$")) {
					styleFlag = true;
					getStyle(output, tags);
				}
				output.append(">");
				if (styleFlag) {
					output.append(tags[1].substring(0, (getIndex(tags) - 1)).trim());
				} else {
					output.append(tags[1]);
				}
				output.append("</" + tags[0] + ">");
			}
			// label generator
			if (tags[0].equalsIgnoreCase("label")) {
				output.append("<label");
				if (tags[1].contains("$")) {
					styleFlag = true;
					getStyle(output, tags);
				}
				output.append(">");
				if (styleFlag) {
					output.append(tags[1].substring(0, (getIndex(tags) - 1)).trim());
				} else {
					output.append(tags[1]);
				}
				output.append("</label>");
			}

			// input tag generator
			if (tags[0].equalsIgnoreCase("input")) {
				output.append("<input" + EMPTY_SPACE);
				if (tags.length > 1) {
					String attrib[] = tags[1].split(",");
					output.append("type=" + COTE + attrib[0] + COTE + EMPTY_SPACE);
					for (int j = 1; j < attrib.length; j++) {
						String attValue[] = attrib[j].split("=");
						if (!attValue[0].contains("$")) {
							output.append(attValue[0] + "=" + COTE + attValue[1] + COTE + EMPTY_SPACE);
						}
					}
					if (tags[1].contains("$")) {
						styleFlag = true;
						getStyle(output, tags);
					}

				}
				output.append("/>");
			}
		}
		output.append(FOOTER);
		return output.toString();
	}

	private static String getSubstring(String text) {
		int fIndex = 0;
		int lIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {
				fIndex = i;
			}
			if (text.charAt(i) == ')') {
				lIndex = i;
			}
		}
		return text.substring(fIndex + 1, lIndex);
	}

	private static void getStyle(StringBuffer output, String tags[]) {
		output.append(EMPTY_SPACE);
		String styles = getSubstring(tags[1]);
		String style[] = styles.split(",");
		output.append("style=" + COTE);
		for (int j = 0; j < style.length; j++) {
			String styleValue[] = style[j].split("=");
			output.append(styleValue[0] + ":" + styleValue[1] + ";" + EMPTY_SPACE);
		}
		output.append(COTE);
	}

	public static int getIndex(String tags[]) {
		int fIndex = 0;
		for (int l = 0; l < tags[1].length(); l++) {
			if (tags[1].charAt(l) == '(') {
				fIndex = l;
			}
		}
		return fIndex;
	}
}
