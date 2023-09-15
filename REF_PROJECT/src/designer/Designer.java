package designer;

import java.util.*;

public class Designer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input;
		boolean flag = true;
		
		Clothes top = new Clothes("상의","블랙","L","티셔츠");
		Clothes bottom = new Clothes("하의","블랙","L","슬랙스");
		
		System.out.println("상의정보");
		top.printClothes();
		
		System.out.println("하의정보");
		bottom.printClothes();
		
		while(flag) {
			System.out.println("\n0. 종료");
			System.out.println("1. 상의수정");
			System.out.println("2. 하의수정");
			System.out.println("3. 상의출력");
			System.out.println("4. 하의출력");
			System.out.print("메뉴를 선택하세요 : ");
			
			input = sc.nextLine();
			
			if(input.equals("0")) {
				flag = false;
				System.out.println("종료합니다.");
			}else if(input.equals("1")) {
				top.changeClothes();
			}else if(input.equals("2")) {
				bottom.changeClothes();
			}else if(input.equals("3")) {
				top.printClothes();
			}else if(input.equals("4")) {
				bottom.printClothes();
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		
		sc.close();
	}


}
