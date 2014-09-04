package stringAlgorithm;
/**
 * 阿里笔试题，最长连续子串
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m*n),此方法空间复杂度太大
 * Author: Kingpin
 * */

public class LCS {
	public static void main(String[] args) throws Exception{
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("first String : ");
//		String queryStr = in.readLine();
//		System.out.println("second String : ");
//		String textStr = in.readLine();
//		char[] query = queryStr.toCharArray();
//		char[] text = textStr.toCharArray();
		
		char[] query = "21232523311324".toCharArray();
		char[] text = "312123223445".toCharArray();
		char[] result = new char[query.length];

		int len = findLCS(query,text,result);
		System.out.println("长度是： "+len);
		System.out.print("结果是：");
		for(int i=0;i<len;i++){
			System.out.print(result[i]);
		}

	}

	static int findLCS(char[] query, char[] text , char[] result){
		int lenQuery = query.length, lenText= text.length;
		int[][] compare = new int[lenQuery+1][lenText+1];
		int start, end , len, i , j;// start 起点， end 终点
		end = len = 0; // len 结果字串长度。
		int x=lenQuery+1, y=lenText+1 ;// 记录结果出现的位置

		// 全部设0
		for(i=0;i<lenQuery;i++){
			for(j=0;j<lenText;j++){
				compare[i][j] = 0;
			}
		}

		for(i=0;i<lenQuery;i++){
			for(j=0;j<lenText;j++){
				if(query[i]==text[j]){
					if(i==0 || j==0){
						compare[i][j] = 1;
					}else{
						compare[i][j] = compare[i-1][j-1] + 1;
						if(compare[i][j]>len){
							x= i;
							y= j;
							len = compare[i][j];
						}
					}
				}
			}
		}

		if(len==0){
			return len;
		}else{
			// y 对应着 lenText
			start = y - len+1;
			end = y;
			for(i=0;start+i<=end;i++){
				result[i] = text[start+i];
			}
			return len;
		}
	}
}
