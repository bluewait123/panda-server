package com.panda.common.utils;

public class Hex {
	 private Hex() {
	    } // static methods only

	    private static final char[] hexDigits = {
	            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	    };

	    /**
	     * toString(控制长度的将byte[]的转换为相应的十六进制String表示)
	     *
	     * @param ba     需要转换的byte[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toString
	     * @Description: 控制长度的将byte[]的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:03:46 PM
	     * @modifyDate May 2, 2012 3:03:46 PM
	     */
	    public static String toString(byte[] ba, int offset, int length) {
	        char[] buf = new char[length * 2];
	        int j = 0;
	        int k;

	        for (int i = offset; i < offset + length; i++) {
	            k = ba[i];
	            buf[j++] = hexDigits[(k >>> 4) & 0x0F];
	            buf[j++] = hexDigits[k & 0x0F];
	        }
	        return new String(buf);
	    }

	    /**
	     * toString(将byte[]的转换为相应的十六进制String表示)
	     *
	     * @param ba 需要转换的byte[]
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toString
	     * @Description: 将byte[]的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:05:35 PM
	     * @modifyDate May 2, 2012 3:05:35 PM
	     */
	    public static String toString(byte[] ba) {
	        return toString(ba, 0, ba.length);
	    }

	    /**
	     * toString(控制长度的将int[]的转换为相应的十六进制String表示)
	     *
	     * @param ia     需要转换的int[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toString
	     * @Description: 控制长度的将int[]的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:06:02 PM
	     * @modifyDate May 2, 2012 3:06:02 PM
	     */
	    public static String toString(int[] ia, int offset, int length) {
	        char[] buf = new char[length * 8];
	        int j = 0;
	        int k;

	        for (int i = offset; i < offset + length; i++) {
	            k = ia[i];
	            buf[j++] = hexDigits[(k >>> 28) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 24) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 20) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 16) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 12) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 8) & 0x0F];
	            buf[j++] = hexDigits[(k >>> 4) & 0x0F];
	            buf[j++] = hexDigits[k & 0x0F];
	        }
	        return new String(buf);
	    }

	    /**
	     * toString(将int[]的转换为相应的十六进制String表示)
	     *
	     * @param ia 需要转换的int[]
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toString
	     * @Description: 将int[]的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:06:02 PM
	     * @modifyDate May 2, 2012 3:06:02 PM
	     */
	    public static String toString(int[] ia) {
	        return toString(ia, 0, ia.length);
	    }

	    /**
	     * toReversedString(控制长度的将byte[]反转的转换为相应的十六进制String表示)
	     *
	     * @param b      需要转换的byte[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toReversedString
	     * @Description: 控制长度的将byte[]反转的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:03:46 PM
	     * @modifyDate May 2, 2012 3:03:46 PM
	     */
	    public static String toReversedString(byte[] b, int offset, int length) {
	        char[] buf = new char[length * 2];
	        int j = 0;

	        for (int i = offset + length - 1; i >= offset; i--) {
	            buf[j++] = hexDigits[(b[i] >>> 4) & 0x0F];
	            buf[j++] = hexDigits[b[i] & 0x0F];
	        }
	        return new String(buf);
	    }

	    /**
	     * toReversedString(将byte[]反转的转换为相应的十六进制String表示)
	     *
	     * @param b 需要转换的byte[]
	     * @return String 得到转换后的内容 java.lang.String
	     * @Title: toReversedString
	     * @Description: 将byte[]反转的转换为相应的十六进制String表示
	     * @Date May 2, 2012 3:03:46 PM
	     * @modifyDate May 2, 2012 3:03:46 PM
	     */
	    public static String toReversedString(byte[] b) {
	        return toReversedString(b, 0, b.length);
	    }

	    /**
	     * fromString(将十六进制形式的字符串转换为byte[])
	     *
	     * @param hex 十六进制形式的字符串
	     * @return byte[] 得到转换后的结果 byte[]
	     * @Title: fromString
	     * @Description: 将十六进制形式的字符串转换为byte[]
	     * @Date May 2, 2012 3:10:34 PM
	     * @modifyDate May 2, 2012 3:10:34 PM
	     */
	    public static byte[] fromString(String hex) {
	        int len = hex.length();
	        byte[] buf = new byte[((len + 1) / 2)];

	        int i = 0, j = 0;
	        if ((len % 2) == 1){
				buf[j++] = (byte) fromDigit(hex.charAt(i++));
			}

	        while (i < len) {
	            buf[j++] = (byte) ((fromDigit(hex.charAt(i++)) << 4) |
	                    fromDigit(hex.charAt(i++)));
	        }
	        return buf;
	    }

	    /**
	     * fromReversedString(将十六进制形式的字符串反转转换为byte[])
	     *
	     * @param hex 十六进制形式的字符串
	     * @return byte[] 得到转换后的结果 byte[]
	     * @Title: fromReversedString
	     * @Description: 将十六进制形式的字符串反转转换为byte[]
	     * @Date May 2, 2012 3:10:34 PM
	     * @modifyDate May 2, 2012 3:10:34 PM
	     */
	    public static byte[] fromReversedString(String hex) {
	        int len = hex.length();
	        byte[] buf = new byte[((len + 1) / 2)];

	        int j = 0;
	        if ((len % 2) == 1) {
				throw new IllegalArgumentException("string must have an even number of digits");
			}

	        while (len > 0) {
	            buf[j++] = (byte) (fromDigit(hex.charAt(--len)) |
	                    (fromDigit(hex.charAt(--len)) << 4));
	        }
	        return buf;
	    }

	    /**
	     * toDigit(将十进制的int值转换为十六进制的char)
	     *
	     * @param n 十进制的int值
	     * @return char 十六进制的char
	     * @Title: toDigit
	     * @Description: 将十进制的int值转换为十六进制的char
	     * @Date May 2, 2012 3:16:46 PM
	     * @modifyDate May 2, 2012 3:16:46 PM
	     */
	    public static char toDigit(int n) {
	        try {
	            return hexDigits[n];
	        } catch (ArrayIndexOutOfBoundsException e) {
	            throw new IllegalArgumentException(n +
	                    " is out of range for a hex digit");
	        }
	    }

	    /**
	     * fromDigit(将十六进制的char转换为十进制的int值)
	     *
	     * @param ch 十六进制的char
	     * @return int 十进制的int值
	     * @throws IllegalArgumentException 抛出不是十六禁止的值
	     * @Title: fromDigit
	     * @Description: 将十六进制的char转换为十进制的int值
	     * @Date May 2, 2012 3:17:58 PM
	     * @modifyDate May 2, 2012 3:17:58 PM
	     */
	    public static int fromDigit(char ch) {
	        if (ch >= '0' && ch <= '9'){
				return ch - '0';
			}

	        if (ch >= 'A' && ch <= 'F'){
				return ch - 'A' + 10;
			}

	        if (ch >= 'a' && ch <= 'f'){
				return ch - 'a' + 10;
			}

	        throw new IllegalArgumentException("invalid hex digit '" + ch + "'");
	    }

	    /**
	     * byteToString(将int的值转换为两位byte的十六进制字符串形式)
	     *  (如：08,02只有两位的表示)
	     *
	     * @param n int的值
	     * @return String 十六进制字符串形式 java.lang.String
	     * @Title: byteToString
	     * @Description: 将int的值转换为两位byte的十六进制字符串形式
	     * @Date May 2, 2012 3:21:27 PM
	     * @modifyDate May 2, 2012 3:21:27 PM
	     */
	    public static String byteToString(int n) {
	        char[] buf = {hexDigits[(n >>> 4) & 0x0F], hexDigits[n & 0x0F]};
	        return new String(buf);
	    }

	    /**
	     * shortToString(将int的值转换为四位short的十六进制字符串形式)
	     *  (如：03E8,0001只有四位的表示)
	     *
	     * @param n int的值
	     * @return String 十六进制字符串形式 java.lang.String
	     * @Title: shortToString
	     * @Description: 将int的值转换为四位short的十六进制字符串形式
	     * @Date May 2, 2012 3:21:27 PM
	     * @modifyDate May 2, 2012 3:21:27 PM
	     */
	    public static String shortToString(int n) {
	        char[] buf = {hexDigits[(n >>> 12) & 0x0F], hexDigits[(n >>> 8) & 0x0F],
	                hexDigits[(n >>> 4) & 0x0F], hexDigits[n & 0x0F]};
	        return new String(buf);
	    }

	    /**
	     * intToString(将int的值转换为八位int的十六进制字符串形式)
	     *  (如：000003E8,00000001只有八位的表示)
	     *
	     * @param n int的值
	     * @return String 十六进制字符串形式 java.lang.String
	     * @Title: intToString
	     * @Description: 将int的值转换为八位int的十六进制字符串形式
	     * @Date May 2, 2012 3:34:55 PM
	     * @modifyDate May 2, 2012 3:34:55 PM
	     */
	    public static String intToString(int n) {
	        char[] buf = new char[8];

	        for (int i = 7; i >= 0; i--) {
	            buf[i] = hexDigits[n & 0x0F];
	            n >>>= 4;
	        }
	        return new String(buf);
	    }

	    /**
	     * longToString(将int的值转换为十六位long的十六进制字符串形式)
	     *  (如：0000000003E8,000000000001只有十六位的表示)
	     *
	     * @param n int的值
	     * @return String 十六进制字符串形式 java.lang.String
	     * @Title: longToString
	     * @Description: 将int的值转换为十六位long的十六进制字符串形式
	     * @Date May 2, 2012 3:36:44 PM
	     * @modifyDate May 2, 2012 3:36:44 PM
	     */
	    public static String longToString(long n) {
	        char[] buf = new char[16];

	        for (int i = 15; i >= 0; i--) {
	            buf[i] = hexDigits[(int) n & 0x0F];
	            n >>>= 4;
	        }
	        return new String(buf);
	    }

	    /**
	     * dumpString(控制长度的将byte[]数据进行32位的十六进制进行换行转换，并加入提示头)
	     *  (byte[] 形式的数据)
	     *
	     * @param data   数据内容 byte[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @param m      提示头 java.lang.String
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 控制长度的将byte[]数据进行32位的十六进制进行换行转换，并加入提示头
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(byte[] data, int offset, int length, String m) {
	        if (data == null) {
				return m + "null\n";
			}

	        StringBuffer sb = new StringBuffer(length * 3);
	        if (length > 32){
				sb.append(m).append("Hexadecimal dump of ").append(length).append(" bytes...\n");
			}

	        // each line will list 32 bytes in 4 groups of 8 each
	        int end = offset + length;
	        String s;
	        int l = Integer.toString(length).length();
	        if (l < 4){
				l = 4;
			}
	        for (; offset < end; offset += 32) {
	            if (length > 32) {
	                s = "         " + offset;
	                sb.append(m).append(s.substring(s.length() - l)).append(": ");
	            }
	            int i = 0;
	            for (; i < 32 && offset + i + 7 < end; i += 8){
					sb.append(toString(data, offset + i, 8)).append(' ');
				}

	            if (i < 32) {
	                for (; i < 32 && offset + i < end; i++){
						sb.append(byteToString(data[offset + i]));
					}
	            }
	            sb.append('\n');
	        }
	        return sb.toString();
	    }

	    /**
	     * dumpString(将byte[]数据进行32位的十六进制进行换行转换)
	     *  (byte[] 形式的数据)
	     *
	     * @param data 数据内容 byte[]
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 将byte[]数据进行32位的十六进制进行换行转换
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(byte[] data) {
	        return (data == null) ? "null\n"
	                : dumpString(data, 0, data.length, "");
	    }

	    /**
	     * dumpString(将byte[]数据进行32位的十六进制进行换行转换并加入提示头)
	     *  (byte[] 形式的数据)
	     *
	     * @param data 数据内容 byte[]
	     * @param m    提示头 java.lang.String
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 将byte[]数据进行32位的十六进制进行换行转换并加入提示头
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(byte[] data, String m) {
	        return (data == null) ? "null\n"
	                : dumpString(data, 0, data.length, m);
	    }

	    /**
	     * dumpString(控制长度的将byte[]数据进行32位的十六进制进行换行转换)
	     *  (byte[] 形式的数据)
	     *
	     * @param data   数据内容 byte[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 控制长度的控制将byte[]数据进行32位的十六进制进行换行转换
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(byte[] data, int offset, int length) {
	        return dumpString(data, offset, length, "");
	    }

	    /**
	     * dumpString(控制长度的将int[]数据进行32位的十六进制进行换行转换，并加入提示头)
	     *  (int[] 形式的数据)
	     *
	     * @param data   数据内容 int[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @param m      提示头 java.lang.String
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 控制长度的将int[]数据进行32位的十六进制进行换行转换，并加入提示头
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(int[] data, int offset, int length, String m) {
	        if (data == null) {
				return m + "null\n";
			}

	        StringBuffer sb = new StringBuffer(length * 3);
	        if (length > 8){
				sb.append(m).append("Hexadecimal dump of ").append(length).append(" integers...\n");
			}

	        // each line will list 32 bytes in 8 groups of 4 each (1 int)
	        int end = offset + length;
	        String s;
	        int x = Integer.toString(length).length();
	        if (x < 8) {
				x = 8;
			}
	        for (; offset < end; ) {
	            if (length > 8) {
	                s = "         " + offset;
	                sb.append(m).append(s.substring(s.length() - x)).append(": ");
	            }
	            for (int i = 0; i < 8 && offset < end; i++){
					sb.append(intToString(data[offset++])).append(' ');
				}
	            sb.append('\n');
	        }
	        return sb.toString();
	    }

	    /**
	     * dumpString(将int[]数据进行32位的十六进制进行换行转换)
	     *  (int[] 形式的数据)
	     *
	     * @param data 数据内容 int[]
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 将int[]数据进行32位的十六进制进行换行转换
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(int[] data) {
	        return dumpString(data, 0, data.length, "");
	    }

	    /**
	     * dumpString(将int[]数据进行32位的十六进制进行换行转换，并加入提示头)
	     *  (int[] 形式的数据)
	     *
	     * @param data 数据内容 int[]
	     * @param m    提示头 java.lang.String
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 将int[]数据进行32位的十六进制进行换行转换，并加入提示头
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(int[] data, String m) {
	        return dumpString(data, 0, data.length, m);
	    }

	    /**
	     * dumpString(控制长度的将int[]数据进行32位的十六进制进行换行转换)
	     *  (int[] 形式的数据)
	     *
	     * @param data   数据内容 int[]
	     * @param offset 起始位置
	     * @param length 长度
	     * @return String 格式化好的内容 java.lang.String
	     * @Title: dumpString
	     * @Description: 控制长度的将int[]数据进行32位的十六进制进行换行转换
	     * @Date May 2, 2012 3:41:20 PM
	     * @modifyDate May 2, 2012 3:41:20 PM
	     */
	    public static String dumpString(int[] data, int offset, int length) {
	        return dumpString(data, offset, length, "");
	    }

}
