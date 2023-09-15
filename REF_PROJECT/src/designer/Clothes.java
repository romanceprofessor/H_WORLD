package designer;

import java.util.Scanner;

public class Clothes {
	static String brand = "LEE";
	String type; // top, bottom
	String color; 
	String size;  // s, m, l
	String style;  // casual, suit...
	
	public Clothes() {
		// TODO Auto-generated constructor stub
	}
	
	public Clothes(String type,String color,String size, String style) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.color = color;
		this.size = size;
		this.style = style;
	}
	
	
	void setColor(String color) {
		String old = this.color;
		this.color = color;
		System.out.println(old + ">" + color + "변경완료");
	}
	
	void setSize(String size) {
		String old = this.size;
		this.size = size;
		System.out.println(old + ">" + size + "변경완료");
	}
	
	void setStyle(String style) {
		String old = this.style;
		this.style = style;
		System.out.println(old + ">" + style + "변경완료");
	}
	
	void printClothes() {
		System.out.println("******************");
		System.out.println("["+brand+"]");
		System.out.println("종류 : "+ type);
		System.out.println("색상 : "+ color);
		System.out.println("사이즈 : "+ size);
		System.out.println("스타일 : "+ style);
		System.out.println("******************");
	}
	
	void changeClothes() {
		Scanner sc = new Scanner(System.in);
		String menu;
		String change;
		
		System.out.println("\n");
		System.out.println("0. 취소");
		System.out.println("1. 색상");
		System.out.println("2. 사이즈");
		System.out.println("3. 스타일");
		System.out.print("수정할 내용을 선택하세요. : ");
		
		menu = sc.nextLine();
		
		switch (menu) {
		case "0":
			System.out.println("취소되었습니다.");
			break;
			
		case "1":
			System.out.print("수정할 색상을 입력하세요 : ");
			
			change = sc.nextLine();
			setColor(change);
			break;
			
		case "2":
			System.out.print("수정할 사이즈를 입력하세요 : ");
			change = sc.nextLine();
			setSize(change);
			break;
			
		case "3":
			System.out.print("수정할 스타일을 입력하세요 : ");
			change = sc.nextLine();
			setStyle(change);
			break;

		default:
			System.out.print("다시선택해주세요.");
			break;
		
		}
	}
	
	
}
