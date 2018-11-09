import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.INITIALIZE;

public class TestJframe extends JFrame {//class TestJframe 시작
	private BufferedImage bimg ; //원본 이미지 파일을 읽어올 변수
	private int width , height; //읽어 들인 이미지 원본 크기
    private JLabel imgLabel; //이미지를 출력할 레이블
    private JPanel panel; 
	
	TestJframe()
    { //class TestJframe 생성자 시작
		try
		{//try문 시작
			
			bimg = ImageIO.read(new File("001.png")); //이미지 IO를 통해 이미지를 읽어온다.
			width = bimg.getWidth(); //읽어온 이미지의 가로길이를 입력
			height = bimg.getHeight(); //읽어온 이미지의 세로길이를 입력
			
		} catch (Exception e) {
		}//try문 종료   / 특별한 처리를 해주지는 않았다.
		initialize();                      //하위 내용에서 정의한 메서드
	} //class TestJframe 생성자 종료
	 
     private void initialize() 
     {//메서드 initialize()를 정의 

//    	 Jframe
    	 setTitle("이미지 비율 조절 예제");
    	 setLayout(null);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	 setDefaultCloseOperation(DISPOSE_ON_CLOSE); 이렇게 해도 종료 ?
    	 setBounds(100, 100, 500, 500);
    	 
//    	 Jpanel
    	 panel = new JPanel();
    	 panel.setBounds(0, 0, getWidth(), getHeight());
    	 panel.setBackground(Color.BLACK);
    	 add(panel);
    	 
//    	 imgLabel
    	 imgLabel = new JLabel(new ImageIcon(bimg));
    	 imgLabel.setBounds(10, 10, 300, 300);
    	 panel.add(imgLabel);
    	 
//    	 JSlider
    	 JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 200, 100);
    	 // (가로 슬라이더, 최소값, 맥스값 , 초기값 )
    	slider.setMajorTickSpacing(30); //눈금 밑에 표시될 숫자의 크기 간격
    	slider.setPaintLabels(true); // 밑에 숫자 표시 여부
    	slider.setPaintTicks(true); //눈금 표시여부
    	slider.addChangeListener(new imgChanger()); //값이 변할경우 리스너
    	slider.setBounds(10, 460, 480, 20);
    	panel.add(slider);
    	 
    	 setVisible(true);
     }//메서드 initialize() 종료
    
    
    class imgChanger implements ChangeListener
    { // class imgChanger 정의

    	
    	
    	
		@Override
		public void stateChanged(ChangeEvent e)
		{ //ChangeListenerd의 메서드!! 중요
			
			double mag = ((JSlider)e.getSource()).getValue(); 
			//이벤트 e에는 slider를 인식하고 e.getsource를 통해 어떤 변수인지 얻은 다음 다운캐스팅!
			//후에 getvalue를 통해 값을 얻어온다~ 값은 %인 1보다 미만 숫자가 들어온다!
			
			panel.remove(imgLabel);
			// 판넬에서 이미지 아이콘을 담고 있는 이미지라벨을 내린다.
			imgLabel = null;
			// 이미지 라벨의 주소값을 해제시켜버린다.
			
			imgLabel = new JLabel(new ImageIcon(bimg.getScaledInstance((int)(width*mag), (int)(height*mag), Image.SCALE_SMOOTH)));
//			imgLabel = new JLabel(new ImageIcon(bimg.getScaledInstance((int)(width*0.5), (int)(height*0.5), Image.SCALE_SMOOTH)));
			// 이미지 라벨에 다시 새로운 라벨을 넣어준다.
			// 새로운 라벨에는 새로운 이미지 아이콘이 올라가며
			// 이 이미지 아이콘은 기존 image에 getScaledInstance메서드를 이용하여
			// 새로운 이미지 인스턴스를 얻어온다. 단 , 새로운 가로,세로, 속성을 넣은!
			
			imgLabel.setBounds(10, 10, 300, 300);//다시 위치 선정 ? .. 굳이 ?
			imgLabel.setBackground(Color.WHITE);
			panel.add(imgLabel);
			panel.repaint();
			
			//렉이 너무 심하다..
			
		} // stateChanged 메서드 종료
    	
    } // class imgChanger 종료
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static void main(String[] args) { //main 함수 시작
            new TestJframe();
	}//main 함수 시종료

}//class TestJframe 종료
