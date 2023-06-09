package day18_0501.api.lang.string;

import java.util.Scanner;

public class StringQuiz02 {

	public static void main(String[] args) {

		/* 주민번호 검증메서드 masking(String)
		    * 마스킹 메서드는 주민번호값이 매개변수로 들어올 때
		    * 950101-*******로 마스킹 처리하여 리턴하는 static메서드를 만들어주세요.
		    * 
		    * 조건
		    * 1. 문제의 간소화를 위해 생년월일은 정상범위라고 가정합니다.
		    * 2. 13자리가 아니거나, 남,여 가 아니라면 throws처리합니다.
		    * 3. 주민번호는 - 를 포함해서 받을 수 있습니다.
		    * 4. 남, 여에 대한 정보를 출력해줍니다.
		    *  
		    * masking메서드를 만들어주세요 
		    * 검증데이터 950101-1000000 -> 남자
		    * 검증데이터 9501012000000 -> 여자
		    * 검증데이터 950101-5000000 -> 예외
		    * 검증데이터 9501015000000 -> 예외
		    * 검증데이터 950101511111 -> 예외
		    */
		
		
		
		try {
			System.out.println(masking("950101-1000000"));
			System.out.println(masking("9501012000000"));
			System.out.println(masking("950101-5000000"));	// 에러
			System.out.println(masking("9501015000000"));	//에러
			System.out.println(masking("950101511111"));	//에러
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static String masking(String num) throws Exception{
		
//		String astar = "";
//		num = num.replace("-", "");
//		int a = Integer.parseInt(num.substring(6,7));	//강제 형변환 
//		
//		
//		if(num.length() != 13 || a > 2 || a <= 0) {	// 주민번호 형식 맞지 않을 때
//			System.out.println("예외");
//		} else if(num.length() == 13 || a == 1) {	// 남자일 때
//			System.out.println("남자");
//		} else if(num.length() == 13 || a == 2) {	// 여자일 때
//			System.out.println("여자");
//		}
//		
//		return astar = "-*******";
		
		num = num.replace("-", "");
		
		if(num.length() == 13) {	// 길이가 13
			//9501012000000 -> 2
			switch (num.charAt(6)){
			case '1': 
			case '3':
				System.out.println("남자");
				break;
				
			case '2':
			case '4':
				System.out.println("여자");
				break;
			
			default:
				System.out.println("잘못 입력했습니다.");
				throw new Exception();
			}
			
		} else {
			System.out.println("주민번호는 13자리 입니다");
			throw new Exception();	// 에러 만듦
		}
		
		return num.substring(0, 6) + "-" + "*".repeat(7);	//repeat()반복
		
	}

}
