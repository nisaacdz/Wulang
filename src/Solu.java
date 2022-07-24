import java.util.Arrays;
import java.util.Comparator;

class Solu {
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				boolean isA = isLetterLog(a);
				boolean isB = isLetterLog(b);
				if (isA && isB) {
					int sA = a.indexOf('\s');
					int sB = b.indexOf('\s');

					String aA = a.substring(0, sA);
					String aZ = a.substring(sA);

					String bA = b.substring(0, sB);
					String bZ = b.substring(sB);

					if (aZ.equals(bZ))
						return aA.compareTo(bA);

					return aZ.compareTo(bZ);

				}
				if (isA && !isB)
					return -1;
				if (isB && !isA)
					return 1;
				return 0;
			}

		});

		return logs;
	}

	private boolean isLetterLog(String a) {
		char lasChar = a.charAt(a.length() - 1);
		if (lasChar > 96 && lasChar < 123)
			return true;
		return false;
	}
}