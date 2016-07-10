package com.internet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;



public class IETest extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JComboBox jComboBox2;
	private JLabel jLabel3;
	private JTextArea jTextArea3;
	private JScrollPane jScrollPane1;
	private JLabel jLabel7;
	private JButton jButton6;
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;
	private JTextArea jTextArea2;
	private JLabel jLabel6;
	private JTextArea jTextArea1;
	//用于用户输入攻击目标的IP地址
	private JTextArea jTextIPaddr;
	
	private JLabel jLabel2;
//	private JComboBox jComboBox1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private JFileChooser jFileChooser;
	private String path;
	private String s;
	private String t;
	private FileWriter fileWriter1;
	private BufferedReader bufReader1;
	private BufferedWriter bufWriter1;
	private String ipAddress;
	private InetAddress ip;
	private int portNumber = 8080;
	private int testNum;
	private boolean flag = true;
	private String testMethod;
	private String testIntension;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IETest inst = new IETest();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setResizable(false);
			}
		});
	}
	
	public IETest() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("安全测试发包工具"); //安全测试\u5b89\u5168\u6d4b\u8bd5
			getContentPane().setBackground(new java.awt.Color(128,128,128));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				//jPanel1.setBackground(new java.awt.Color(0,0,0));
				jPanel1.setBackground(Color.BLACK);
				{
					jPanel2 = new JPanel();
					jPanel1.add(jPanel2);
					jPanel2.setPreferredSize(new java.awt.Dimension(673, 124));
					jPanel2.setBorder(BorderFactory.createTitledBorder(null, "\u53c2\u6570\u8bbe\u7f6e\u53ca\u64cd\u4f5c", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑",1,12), new java.awt.Color(255,0,0)));//参数设置及操作
					//jPanel2.setBackground(new java.awt.Color(0,0,0));
					jPanel2.setBackground(Color.BLACK);
					jPanel2.setFont(new java.awt.Font("宋体",0,12));
					{
						jLabel1 = new JLabel();
						jPanel2.add(jLabel1);
						jLabel1.setText("目标主机IP地址：");//测试方法：
						jLabel1.setPreferredSize(new java.awt.Dimension(105, 25));
						jLabel1.setForeground(new java.awt.Color(255,0,0));
						jLabel1.setFont(new java.awt.Font("宋体",0,12));
					}
					{
						
						jTextIPaddr = new JTextArea();
						jPanel2.add(jTextIPaddr);
						jTextIPaddr.setPreferredSize(new java.awt.Dimension(180, 20));	
					}
					{
						jFileChooser = new JFileChooser();
						jFileChooser.setBounds(59, 60, 32, 10);
					}
					{
						jLabel2 = new JLabel();
						jPanel2.add(jLabel2);
						jLabel2.setText("\u6d4b\u8bd5\u5f3a\u5ea6\uff1a");//测试强度：
						jLabel2.setPreferredSize(new java.awt.Dimension(80, 25));
						jLabel2.setSize(60, 25);
						jLabel2.setForeground(new java.awt.Color(255,0,0));
						jLabel2.setFont(new java.awt.Font("宋体",0,12));
					}
					{
						ComboBoxModel jComboBox2Model = 
							new DefaultComboBoxModel(
									new String[] { "", "高负载TCP", "低负载TCP", "高负载UDP", "低负载UDP"});
						jComboBox2 = new JComboBox();
						jPanel2.add(jComboBox2);
						jComboBox2.setModel(jComboBox2Model);
						jComboBox2.setPreferredSize(new java.awt.Dimension(97, 25));
						jComboBox2.setBackground(new java.awt.Color(255,255,255));
						jComboBox2.setFont(new java.awt.Font("宋体",0,12));
						jComboBox2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jComboBox2ActionPerformed(evt);
							}
						});
					}
					{
						jLabel3 = new JLabel();
						jPanel2.add(jLabel3);
						jLabel3.setText("\u6d4b\u8bd5\u57fa\u6570\uff1a");//测试基数：
						jLabel3.setPreferredSize(new java.awt.Dimension(80, 25));
						jLabel3.setForeground(new java.awt.Color(255,0,0));
						jLabel3.setFont(new java.awt.Font("宋体",0,12));
					}
					{
						jTextArea1 = new JTextArea();
						jPanel2.add(jTextArea1);
						jTextArea1.setPreferredSize(new java.awt.Dimension(85, 21));
						jTextArea1.setFont(new java.awt.Font("宋体",0,12));
					}
					{
						jLabel6 = new JLabel();
						jPanel2.add(jLabel6);
						jLabel6.setText("Payload \u8def\u5f84\uff1a");//Payload 路径：
						jLabel6.setPreferredSize(new java.awt.Dimension(91, 25));
						jLabel6.setForeground(new java.awt.Color(255,0,0));
						jLabel6.setFont(new java.awt.Font("宋体",0,12));
					}
					{
						jTextArea2 = new JTextArea();
						jPanel2.add(jTextArea2);
						jTextArea2.setPreferredSize(new java.awt.Dimension(476, 23));
						jTextArea2.setEditable(false);
						jTextArea2.setBackground(new java.awt.Color(255,255,255));
						jTextArea2.setForeground(new java.awt.Color(0,0,0));
						jTextArea2.setFont(new java.awt.Font("黑体",0,16));
					}
					{
						jButton1 = new JButton();
						jPanel2.add(jButton1);
						jButton1.setText("\u6d4f\u89c8"); //浏览
						jButton1.setPreferredSize(new java.awt.Dimension(74, 25));
					    jButton1.setBackground(new java.awt.Color(255,255,255));
						jButton1.setFont(new java.awt.Font("宋体",0,12));
						jButton1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton1.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton1MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton1MouseEntered(evt);
							}
						});
						jButton1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton1ActionPerformed(evt);
							}
						});
					}
					{
						jButton2 = new JButton();
						jPanel2.add(jButton2);
						jButton2.setText("\u8f7d\u5165"); //载入
						jButton2.setPreferredSize(new java.awt.Dimension(65, 25));
						jButton2.setSize(65, 25);
						jButton2.setBackground(new java.awt.Color(255,255,255));
						jButton2.setFont(new java.awt.Font("宋体",0,12));
						jButton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton2.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton2MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton2MouseEntered(evt);
							}
						});
						jButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton2ActionPerformed(evt);
							}
						});
					}
					{
						jButton3 = new JButton();
						jPanel2.add(jButton3);
						jButton3.setText("\u4fdd\u5b58");//保存
						jButton3.setPreferredSize(new java.awt.Dimension(65, 25));
						jButton3.setBackground(new java.awt.Color(255,255,255));
						jButton3.setFont(new java.awt.Font("宋体",0,12));
						jButton3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton3.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton3MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton3MouseEntered(evt);
							}
						});
						jButton3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton3ActionPerformed(evt);
							}
						});
					}
					{
						jButton4 = new JButton();
						jPanel2.add(jButton4);
						jButton4.setText("\u91cd\u7f6e");//重置
						jButton4.setPreferredSize(new java.awt.Dimension(65, 25));
						jButton4.setBackground(new java.awt.Color(255,255,255));
						jButton4.setFont(new java.awt.Font("宋体",0,12));
						jButton4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton4.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton4MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton4MouseEntered(evt);
							}
						});
						jButton4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton4ActionPerformed(evt);
							}
						});
					}
					{
						jLabel7 = new JLabel();
						jPanel2.add(jLabel7);
						jLabel7.setText("        ");
						jLabel7.setPreferredSize(new java.awt.Dimension(121, 17));
					}
					{
						jButton5 = new JButton();
						jPanel2.add(jButton5);
						jButton5.setText("\u5f00\u59cb"); //开始
						jButton5.setPreferredSize(new java.awt.Dimension(65, 25));
						jButton5.setBackground(new java.awt.Color(255,255,255));
						jButton5.setFont(new java.awt.Font("宋体",0,12));
						jButton5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton5.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton5MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton5MouseEntered(evt);
							}
						});
						jButton5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton5ActionPerformed(evt);
							}
						});
					}
					{
						jButton6 = new JButton();
						jPanel2.add(jButton6);
						jButton6.setText("\u7ec8\u6b62");//终止
						jButton6.setPreferredSize(new java.awt.Dimension(65, 25));
						jButton6.setBackground(new java.awt.Color(255,255,255));
						jButton6.setFont(new java.awt.Font("宋体",0,12));
						jButton6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						jButton6.addMouseListener(new MouseAdapter() {
							public void mouseExited(MouseEvent evt) {
								jButton6MouseExited(evt);
							}
							public void mouseEntered(MouseEvent evt) {
								jButton6MouseEntered(evt);
							}
						});
						jButton6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButton6ActionPerformed(evt);
							}
						});
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(670, 326));
					{
						jTextArea3 = new JTextArea();
						jScrollPane1.setViewportView(jTextArea3);
						jTextArea3.setBorder(BorderFactory.createTitledBorder(null, "Payload", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑",1,12), new java.awt.Color(255,0,0)));
						//jTextArea3.setBackground(new java.awt.Color(0,0,0));
						jTextArea3.setBackground(Color.BLACK);
						jTextArea3.setForeground(new java.awt.Color(255,0,0));
						jTextArea3.setFont(new java.awt.Font("宋体",0,12));
					}
				}
			}
			pack();
			this.setSize(700, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		int state = jFileChooser.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
		if (state == 1) {
			return;// 撤销则返回
		} else {
			File f = jFileChooser.getSelectedFile();// f为选择到的文件
			jTextArea2.setText(f.getAbsolutePath());//获取文件绝对路径
		}
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		path = jTextArea2.getText();
		jTextArea3.setText("");
		this.view(path);
	}
	
	public static String readFileByLines(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		String sum = new String();
		int line = 1;
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			line++;
			sum = sum + tempString + "\n";
		}

		return sum;
	}
	void view(String name) {
		try {

			FileReader fileReader;
			FileWriter fileWriter;
			BufferedReader bufReader;
			BufferedWriter bufWriter;
			fileReader = new FileReader(name);
			fileWriter = new FileWriter("Temp.txt");
			bufReader = new BufferedReader(fileReader);
			bufWriter = new BufferedWriter(fileWriter);

			while ((s = bufReader.readLine()) != null) {
				jTextArea3.append(s+"\n" );
				bufWriter.write(s); // 写入缓冲区（待缓冲区满了才会自动写入文件）
				bufWriter.flush(); // 立即写入文件（不用等等缓冲区满即可立即写入文件）
			}
			fileReader.close();
			fileWriter.close();
			bufReader.close();
			bufWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton4ActionPerformed(ActionEvent evt) {
		jTextArea3.setText("");
	}
	
	private void jButton3ActionPerformed(ActionEvent evt) {
		try {
			fileWriter1 = new FileWriter(path);
			bufReader1 = new BufferedReader(new StringReader(jTextArea3.getText()));
			bufWriter1 = new BufferedWriter(fileWriter1);
			System.out.println("保存后的新内容：\n");
			while ((t = bufReader1.readLine()) != null) { // 按行读取文件
				bufWriter1.write(t);
				bufWriter1.newLine();
				bufWriter1.flush();
			}
			fileWriter1.close();
			bufReader1.close();
			bufWriter1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void jButton6ActionPerformed(ActionEvent evt) {
		setFlag(false);	
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestIntension(String testIntension) {
		this.testIntension = testIntension;
	}

	public String getTestIntension() {
		return testIntension;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public InetAddress getIp() {
		return ip;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	public int getTestNum() {
		return testNum;
	}
	
	private void jComboBox2ActionPerformed(ActionEvent evt) {
		setTestIntension(jComboBox2.getSelectedItem().toString());
	}
	
	private void jButton5ActionPerformed(ActionEvent evt) {  // { "", "高负载TCP", "低负载TCP", "高负载UDP", "低负载UDP"});
		if(testIntension.equals("高负载TCP")){
			setTestNum(1000*Integer.valueOf(jTextArea1.getText()));
System.out.println(jTextIPaddr.getText());
			setIpAddress(jTextIPaddr.getText());
			for(int i =0; i<10; i++){
			Thread highThread = new Thread(new HighPayload());
			highThread.start();
			}
		}else if(testIntension.equals("低负载TCP")){
			setTestNum(Integer.valueOf(jTextArea1.getText()));
			setIpAddress(jTextIPaddr.getText());
			Thread lowThread = new Thread(new LowPayload());
			lowThread.start();
		}else if(testIntension.equals("高负载UDP")){
			setTestNum(1000*Integer.valueOf(jTextArea1.getText()));
			setIpAddress(jTextIPaddr.getText());
			for(int i =0; i<10; i++){
			Thread highThread = new Thread(new HighPayloadUDP());
			highThread.start();
			}
		}else if(testIntension.equals("低负载UDP")){
			setTestNum(Integer.valueOf(jTextArea1.getText()));
			setIpAddress(jTextIPaddr.getText());
			Thread lowThread = new Thread(new LowPayloadUDP());
			lowThread.start();
		}
		
		try {
			setIp(InetAddress.getByName(ipAddress));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void jButton2MouseEntered(MouseEvent evt) {
		IETest.this.jButton2.setBackground(Color.RED);
	}
	
	private void jButton2MouseExited(MouseEvent evt) {
		IETest.this.jButton2.setBackground(Color.WHITE);
	}
	
	private void jButton1MouseEntered(MouseEvent evt) {
		IETest.this.jButton1.setBackground(Color.RED);
	}
	
	private void jButton1MouseExited(MouseEvent evt) {
		IETest.this.jButton1.setBackground(Color.WHITE);
	}
	
	private void jButton3MouseEntered(MouseEvent evt) {
		IETest.this.jButton3.setBackground(Color.RED);
	}
	
	private void jButton3MouseExited(MouseEvent evt) {
		IETest.this.jButton3.setBackground(Color.WHITE);
	}
	
	private void jButton4MouseEntered(MouseEvent evt) {
		IETest.this.jButton4.setBackground(Color.RED);
	}
	
	private void jButton4MouseExited(MouseEvent evt) {
		IETest.this.jButton4.setBackground(Color.WHITE);
	}
	
	private void jButton5MouseEntered(MouseEvent evt) {
		IETest.this.jButton5.setBackground(Color.RED);
	}
	
	private void jButton5MouseExited(MouseEvent evt) {
		IETest.this.jButton5.setBackground(Color.WHITE);
	}
	
	private void jButton6MouseEntered(MouseEvent evt) {
		IETest.this.jButton6.setBackground(Color.RED);
	}
	
	private void jButton6MouseExited(MouseEvent evt) {
		IETest.this.jButton6.setBackground(Color.WHITE);
	}

	class HighPayload implements Runnable{
		private int t = testNum;
		private int port = portNumber;
		private InetAddress inetAddress = ip;
		@Override
		public void run(){
			for (int i = 0; i < t/10; i++) {
				if(flag == false)
					break;
				Socket connection;
				try {
					connection = new Socket(inetAddress, port);
					PrintWriter pw = new PrintWriter(connection.getOutputStream(), true);
					pw.println(readFileByLines(path));
					pw.flush();// 清空缓存
					pw.close();
				} catch(ConnectException e1){
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	class LowPayload implements Runnable{
		private int t = testNum;
		private int port = portNumber;
		private InetAddress inetAddress = ip;
		@Override
		public void run(){
			for (int i = 0; i < t; i++) {
				if(flag == false)
					break;
				Socket connection;
				try {
					connection = new Socket(inetAddress, port);
					PrintWriter pw = new PrintWriter(connection.getOutputStream(), true);
					pw.println(readFileByLines(path));
					pw.flush();// 清空缓存
					pw.close();
				} catch(ConnectException e1){
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	class HighPayloadUDP implements Runnable {
		
		private int t = testNum;
		private int port = portNumber;
		private InetAddress inetAddress = ip;
		private DatagramPacket packet = null;

		@Override
		public void run() {
			for (int i = 0; i < t/10; i++) {
				if(flag == false)
					break;
				DatagramSocket socket;
				try {
					socket = new DatagramSocket();
					packet = new DatagramPacket(readFileByLines(path).getBytes(), 
							readFileByLines(path).getBytes().length, inetAddress, port);
					socket.send(packet);
				} catch(ConnectException e1){
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
		}
	}
	
	class LowPayloadUDP implements Runnable{
		private int t = testNum;
		private int port = portNumber;
		private InetAddress inetAddress = ip;
		private DatagramPacket packet = null;
		@Override
		public void run(){
			for (int i = 0; i < t; i++) {
				if(flag == false)
					break;
				DatagramSocket socket;
				try {
					socket = new DatagramSocket();
					packet = new DatagramPacket(readFileByLines(path).getBytes(), 
							readFileByLines(path).getBytes().length, inetAddress, port);
					socket.send(packet);
				} catch(ConnectException e1){
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
