package threadimpl.pool;

/**
 * @author zfx
 * @date 2022-07-25 18:57
 */
public class ThreadPoolStudy {
	public static void main(String[] args) {
//        ExecutorService pool1 = Executors.newCachedThreadPool();
//        ExecutorService pool2 = Executors.newFixedThreadPool(2);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
		long l = 123456789L;
		System.out.println(byte2Long(long2Byte(l)));
	}
	
	/**
	 * @param i 整数
	 * @return byte数组
	 * @brief int整数转换为4字节的byte数组
	 */
	public static byte[] intToByte4(int i) {
		byte[] targets = new byte[4];
		targets[3] = (byte) (i & 0xFF);
		targets[2] = (byte) (i >> 8 & 0xFF);
		targets[1] = (byte) (i >> 16 & 0xFF);
		targets[0] = (byte) (i >> 24 & 0xFF);
		return targets;
	}
	
	public static byte[] long2Byte(long num) {
		byte[] bytes = new byte[8];
		int temp = 0;
		for (int i = bytes.length; i > 0; i--) {
			bytes[i - 1] = (byte) (num >> temp++ * 8 & 0xFF);
		}
		return bytes;
	}
	
	/**
	 * @param bytes byte数组
	 * @param off   开始位置
	 * @return int整数
	 * @brief byte数组转换为int整数
	 */
	public static int byte4ToInt(byte[] bytes, int off) {
		int b0 = bytes[off] & 0xFF;
		int b1 = bytes[off + 1] & 0xFF;
		int b2 = bytes[off + 2] & 0xFF;
		int b3 = bytes[off + 3] & 0xFF;
		int i = (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
		int num = 0;
		for (int j = 4; j > 0; j--) {
			num = (num | (bytes[off++] & 0xFF) << (int) Math.pow(8, j - 1));
		}
		return i;
	}
	
	public static long byte2Long(byte[] bytes) {
		int off = 0;
		long num = 0;
		for (int j = 8; j > 0; j--) {
			int temp = (bytes[off++] & 0xFF) << (long) Math.pow(8, j - 1);
			System.out.println(temp);
			if (j == 8)
				num = temp;
			else
				num = num | temp;
		}
		return num;
		
	}
}
