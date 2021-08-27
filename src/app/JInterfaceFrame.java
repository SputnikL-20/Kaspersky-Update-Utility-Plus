package app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class JInterfaceFrame {

	JFrame firstFrame;
	JFrame configFrame;
	JLabel lblViewAddress;
	JLabel lblViewConsole;
	JButton btnDownload;
	JButton btnUpdates;
	JButton btnDelete;
	JButton btnStop;
	JButton btnSubmit;
	JProgressBar progressBar;
	JPanel contents;
	String everything;

	public JInterfaceFrame() {
		initialize();
	}
	
	private void initialize() {
		
		String strURL = "https://github.com/sputnikl-20";

		firstFrame = new JFrame("Kaspersky Update Utility Plus");
		
		firstFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(JInterfaceFrame.class.getResource("img/k_128x128.png")));
		firstFrame.setContentPane(new JLabel(new ImageIcon(getClass().getResource("img/ksc_w500.png"))));
		firstFrame.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel layout = new JPanel(null);
		layout.setOpaque(false);
		
		try (BufferedReader reader = new BufferedReader(new FileReader("license.dat"))) {

			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        try {
					line = reader.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		    everything = sb.toString();
		} catch (IOException e2) {
			e2.printStackTrace();
		} 


		JLabel descriptionProgramm = new JLabel("О программе");
		descriptionProgramm.setBounds(455, 2, 105, 20);
		descriptionProgramm.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		descriptionProgramm.setForeground(new Color(220, 220, 220));

		descriptionProgramm.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				descriptionProgramm.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent me) {
				descriptionProgramm.setCursor(Cursor.getDefaultCursor());
			}

			public void mouseClicked(MouseEvent me) {
				JOptionPane.showMessageDialog(firstFrame, everything, "О программе", JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("Clicked on Label...");
			}
		}); 
		
		
		JEditorPane linkGitHub = new JEditorPane();
		linkGitHub.setContentType("text/html");
		linkGitHub.setOpaque(false);
		linkGitHub.setEditable(false);
		linkGitHub.setBounds(560, 0, 70, 20);
		linkGitHub.setText("<html><style>a {font-family: Segoe UI;" 
				+ "font-size:12;text-decoration:none;color:#DCDCDC;}"
				+ "</style><a href=\" " + strURL + " \">github.com</a></html>");
		linkGitHub.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						Desktop.getDesktop().browse(e.getURL().toURI());
					} catch (IOException | URISyntaxException e1) {
						Logger.getLogger("Error opening link " + e.getURL());
						e1.printStackTrace();
					}
				}
			}
		});
		

		
//		labelLinkMethod(labelLink);
		
		
//		 layout.setBorder(UIManager.getBorder("DesktopIcon.border"));

		// lblString.setVerticalAlignment(SwingConstants.CENTER);
		// lblString.addActionListener(this);
		// lblString.setSize(90,25);
//		JPanel layoutTop = new JPanel(new GridLayout(2, 1));
		
//		 layoutTop.setBorder(UIManager.getBorder("DesktopIcon.border"));
		// BoxLayout box = new BoxLayout(layoutTop, BoxLayout.Y_AXIS);
		// layoutTop.setLayout(layoutTop);

//		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//		panelTop.setBackground(new Color(0, 100, 0));
//		panelTop.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		JPanel panelTop_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		panelTop_1.setBackground(new Color(0, 100, 0));
		// panelTop.setBorder(UIManager.getBorder("DesktopIcon.border"));
		// BoxLayout topBox = new BoxLayout(panelTop, BoxLayout.X_AXIS);
		
		
		
		String dir = "Directory server: ";
		lblViewAddress = new JLabel("Text URI");
		lblViewAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblViewAddress.setBounds(5, 96, 630, 25);
		lblViewAddress.setText(dir + getAddressServer(configReader()));
		
		
		

		
		
//		label.setBorder(UIManager.getBorder("DesktopIcon.border"));
//		label.setBounds(0,0,650,45);
//		label.setFont(new Font("Tahoma", Font.BOLD, 14));
//		label.setForeground(Color.BLACK);
		JPanel panelStatus = new JPanel(null);
		panelStatus.setOpaque(false);
//		panelStatus.setBorder(UIManager.getBorder("DesktopIcon.border"));
		
//		JPanel panelStatusText = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
//		panelStatusText.setBackground(new Color(70, 130, 180));
//		panelStatusText.setBackground(new Color(0, 100, 0));
		// panelStatus.setBorder(UIManager.getBorder("DesktopIcon.border"));
		lblViewConsole = new JLabel();
		lblViewConsole.setFont(new Font("Consolas", Font.PLAIN, 12));
//		lblViewProgress.setForeground(new Color(255, 248, 220));
		lblViewConsole.setBounds(5, 130, 630, 25);
		
		lblViewConsole.setText(dir + getAddressServer(configReader()));
		
//		lblViewProgress.setBorder(new LineBorder(SystemColor.BLACK));

//		JPanel panelStatusProgress = new JPanel(new BorderLayout());
//		panelStatusProgress.setBackground(new Color(0, 100, 0));
		// panelStatusProgress.setBorder(UIManager.getBorder("DesktopIcon.border"));
//		progressBar = new JProgressBar();
//		progressBar.setIndeterminate(true);
//		progressBar.setVisible(false);	
		// label.setHorizontalAlignment(SwingConstants.LEFT);
		// label.setVerticalAlignment(SwingConstants.CENTER);

		JPanel panelButton = new JPanel(null); // new FlowLayout(FlowLayout.CENTER, 5, 70)
//		panelButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelButton.setOpaque(false);
		// panelButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
		// BoxLayout box = new BoxLayout(panelButton, BoxLayout.X_AXIS);

		btnDownload = new JButton("DOWNLOAD");
		btnDownload.setBounds(15, 75, 115, 30);
//		btnDownload.setForeground(new Color(255, 228, 225));
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downloadFiles();
				btnDownload.setEnabled(false);
				btnUpdates.setEnabled(false);
//				progressBar.setVisible(true);
			}
		});
		
		btnStop = new JButton("KILLPROCESS");
		btnStop.setBounds(135, 75, 115, 30);
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				killProcessDownloadKUU();
				btnStop.setEnabled(false);
			}
		});

		btnUpdates = new JButton((Icon) new ImageIcon(getClass().getResource("img/kaspersky.png")));
		btnUpdates.setText("UPDATES");
		btnUpdates.setBounds(255, 70, 130, 40);
		btnUpdates.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File dest = new File(getAddressServer(configReader()));
				File src = new File("Updates"); /////////////////////////Updates///////////////////////
				copyFiles(src, dest);
				btnUpdates.setEnabled(false);
//				progressBar.setVisible(true);
			}
		});
		
		btnDelete = new JButton("CLEAR DIR");
		btnDelete.setBounds(390, 75, 115, 30);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmClearDirectory(getAddressServer(configReader()));
//				deleteDirectory(getAddressServer(configReader()));
//				btnDelete.setEnabled(false);
			}
		});
		
		btnSubmit = new JButton("CONFIG");
		btnSubmit.setBounds(510, 75, 115, 30);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				firstFrame.setVisible(false);
				createNewFrame();
			}
		});

//		contents = new JPanel();

		layout.add(descriptionProgramm);
		layout.add(linkGitHub);
//		layout.add(lblViewAddress);
		
//		panelStatus.add(null);
//		panelStatusProgress.add(progressBar, BorderLayout.SOUTH); // SOUTH
//		panelStatus.add(panelStatusProgress);
		panelButton.add(lblViewConsole);
		panelButton.add(btnDownload);
		panelButton.add(btnStop);
		panelButton.add(btnUpdates);
		panelButton.add(btnDelete);
		panelButton.add(btnSubmit);

		 
		firstFrame.getContentPane().add(layout);
		firstFrame.getContentPane().add(panelStatus);
		firstFrame.getContentPane().add(panelButton);
		firstFrame.setSize(655, 500);
		firstFrame.setResizable(false);
		firstFrame.setLocationRelativeTo(null);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT_ON_CLOSE
		firstFrame.setVisible(true);
		
		try {
			initializeConfiguration();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
//		new JLabelLink(labelLink);
	}
	
//	private void labelLinkMethod(JLabel labelLink) {
////		JLabelLink link = new JLabelLink();
//		final String LABEL_TEXT = "For further information visit:";
//		final String A_VALID_LINK = "http://stackoverflow.com";
//
//	    labelLink = new JLabel(LABEL_TEXT);
//
//	    labelLink = new JLabel(A_VALID_LINK);
//	    if (JLabelLink.isBrowsingSupported()) {
//	        JLabelLink.makeLinkable(labelLink, new JLabelLink.LinkMouseListener());
//	    }
//	}
	
	private void initializeConfiguration() throws IOException {

		configFrame = new JFrame("Конфигурация");
		configFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(JInterfaceFrame.class.getResource("img/k_128x128.png")));
		
//		BufferedImage img = ImageIO.read(new File("app/img/ksc_w500.png"));
		
		configFrame.setContentPane(new JLabel(new ImageIcon(getClass().getResource("img/ksc_w500.png"))));
		configFrame.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label = new JLabel(new ImageIcon(getClass().getResource("img/kuu.png")));
		label.setBounds(0, 0, 639, 76);

		JLabel labelField = new JLabel("Адрес локального сервера:");
//		lblViewProgress.setFont(new Font("Consolas", Font.PLAIN, 12));
////		lblViewProgress.setForeground(new Color(255, 248, 220));
//		lblViewProgress.setBounds(5, 130, 630, 25);
		labelField.setBounds(5, 130, 185, 25);
		labelField.setFont(new Font("Consolas", Font.PLAIN, 12));
//		labelField.setForeground(new Color(255, 248, 220)); // new Color(0, 72, 43)
		
		JTextField textField = new JTextField(getAddressServer(configReader()), 35);
		textField.setBounds(185, 130, 445, 25);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField.setBackground(null);
		textField.setOpaque(false);
		textField.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton btnConfirm = new JButton("Применить настройки");
		btnConfirm.setBounds(10, 75, 200, 30);
		btnConfirm.setCursor(new Cursor(12));
		btnConfirm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String address = textField.getText();
				setAddressServer(address);  
				killProcessConfigurationKUU();
//				if (!firstFrame.isVisible()) {
//					System.out.println("asActive");
					configFrame.setVisible(false);
//					initialize();
//					firstFrame.setVisible(true);
					
//				} else {
//					initialize();
//					configFrame.setVisible(false);
//				}
//				configFrame.dispose();
				
			}
		});
		
		JButton btnChoosdir = new JButton("Выбрать директорию");
		btnChoosdir.setBounds(220, 75, 200, 30);
		btnChoosdir.setCursor(new Cursor(12));
		btnChoosdir.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String address = String.valueOf(choosDirectory());
				textField.setText(address);
			}
		});
	
		JButton btnConfigKuu = new JButton("Kaspersky Update Utility");
		btnConfigKuu.setBounds(430, 75, 200, 30); // 118
		btnConfigKuu.setCursor(new Cursor(12));
		btnConfigKuu.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				configurationKuu();
			}
		});
		
		JPanel panelTop = new JPanel(null);
		panelTop.setOpaque(false);
		JPanel panelBody = new JPanel(null);
		panelBody.setOpaque(false);
		JPanel panelBottom = new JPanel(null);
		panelBottom.setOpaque(false);

		panelTop.add(label);
		panelBottom.add(labelField);
//		panelTop.add(labelField);
		panelBottom.add(textField);
//		panelTop.add(textField);
		panelBottom.add(btnConfirm);
		panelBottom.add(btnChoosdir);
		panelBottom.add(btnConfigKuu);

		configFrame.getContentPane().add(panelTop);
		configFrame.getContentPane().add(panelBody);
		configFrame.getContentPane().add(panelBottom);
		
		configFrame.setSize(655, 500);
		configFrame.setResizable(false);
		configFrame.setLocationRelativeTo(null);
		configFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // .DO_NOTHING_ON_CLOSE
		configFrame.setVisible(false);
	}
	
	
	private void configurationKuu() {
		Thread worker = new Thread() {
			public void run() {
				try {
					Runtime.getRuntime().exec("cmd /C UpdateUtility-Gui.bat");
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		};
		worker.start();
	}
	
	private void killProcessConfigurationKUU() {
		Thread worker = new Thread() {
			public void run() {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM UpdateUtility-Gui.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		worker.start();
	}
	
	
	private void setAddressServer(String path) { // Properties config, 
		try {
			File configFile = new File("config.dat");
			FileInputStream inStream = new FileInputStream(configFile);
			Properties config = new Properties();
			config.load(inStream);
			config.setProperty("addressServer", path);
			FileOutputStream ouStream = new FileOutputStream(configFile);
			config.store(ouStream, path);
			lblViewConsole.setText("The server directory has been updated: " + path);
		} catch (IOException e) {
			System.out.println("Ошибка записи в файл " + e);
		}
	}
	

	
	private File choosDirectory() {
		JFileChooser fileopen = new JFileChooser();
		
		fileopen.setDialogTitle("Выбор директории");
		fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileopen.showDialog(null, "Выбор папки");
//		fileopen.showOpenDialog(configFrame);
		if (result == JFileChooser.APPROVE_OPTION ) {
			File dir = fileopen.getSelectedFile();
			return dir;
		}
		return null;	
	}


	private Properties configReader() {
		try {
			File configFile = new File("config.dat");
			FileInputStream inStream = new FileInputStream(configFile);
			Properties config = new Properties();
			config.load(inStream);
			return config;
		} catch (IOException e) {
			System.out.println("Файл не найден");
			return null;
		}
	}

	public String getAddressServer(Properties config) {
		String addressServer = config.getProperty("addressServer");
		return addressServer;
	}

	private void createNewFrame() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (!configFrame.isVisible()) {
					configFrame.setVisible(true);
				}
			}
		});

	}
	

	private void downloadFiles() {
		Thread worker = new Thread() {
			public void run() {
				try {
					String line;
					Process process = Runtime.getRuntime().exec("cmd /C StartKUU.bat");
					BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
					while ((line = input.readLine()) != null) {
						lblViewConsole.setText(line);
					}
					input.close();
				} catch (Exception err) {
					err.printStackTrace();
				}
				lblViewConsole.setText("Download completed!");
				btnDownload.setEnabled(true);
				btnUpdates.setEnabled(true);
//				progressBar.setVisible(false);
			}
		};
		worker.start();
	}
	
	private void copyFiles(File src, File dest) {
		Thread worker = new Thread() {
			public void run() {
				checkDirectory(src, dest);
				btnUpdates.setEnabled(true);
//				progressBar.setVisible(false);
			}
		};
		worker.start();
	}
	
	private void confirmClearDirectory(String path) {
		File catalog = new File(path);
		if (catalog.exists()) {
			ImageIcon icon = new ImageIcon(getClass().getResource("img/delete.png"));
			String TITLE_confirm = "Окно подтверждения";
			// Локализация кнопок
			UIManager.put("OptionPane.yesButtonText", "Да");
			UIManager.put("OptionPane.noButtonText", "Нет");
			// UIManager.put("OptionPane.cancelButtonText", "Отмена");
			int result = JOptionPane.showConfirmDialog(firstFrame,
					"Очистить выбранную директорию?\n" + catalog.getPath(), TITLE_confirm, JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, icon);

			if (result == JOptionPane.YES_OPTION) {
				int confirm = JOptionPane.showConfirmDialog(firstFrame, "Вы уверенны, файлы будут удалены навсегда?",
						"Удалить?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (confirm == JOptionPane.YES_OPTION) {
					clearDirectory(path);
				}
			}
		} else {
			lblViewConsole.setText("Directory does not exist.");
		}
	}

	private void clearDirectory(String path) {
		File catalog = new File(path);
		for (File file : catalog.listFiles()) {
			deleteDir(file);
		}
		lblViewConsole.setText("The directory has been cleared.");
	}

	private void deleteDir(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				if (!Files.isSymbolicLink(f.toPath())) {
					deleteDir(f);
				}
			}
		}
		file.delete();
	}

	private void killProcessDownloadKUU() {
		Thread worker = new Thread() {
			public void run() {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM UpdateUtility-Console.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
				btnStop.setEnabled(true);
			}
		};
		worker.start();
	}
	
	private void checkDirectory(File srcFolder, File destFolder) {
		// убедитесь, что источник существует
		if (!srcFolder.exists()) {
			lblViewConsole.setText("Directory does not exist.");
//			System.exit(0); // просто выход
		} else {

			try {
				copyFolderFiles(srcFolder, destFolder);
			} catch (IOException e) {
				e.printStackTrace();
				// ошибка, просто выход
//				System.exit(0);
			}
		}
		lblViewConsole.setText("Done");
	}
	
	private void copyFolderFiles(File src, File dest) throws IOException {

		if (src.isDirectory()) {
			// если каталог не существует, создайте его
			if (!dest.exists()) {
				dest.mkdir();
//				System.out.println("Directory copied from " + src + "  to " + dest);
				lblViewConsole.setText(String.valueOf(dest));
			}
			// выводим все содержимое каталога
			String files[] = src.list();

			for (String file : files) {
				// создаем структуру файла src и dest
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// рекурсивная копия
				copyFolderFiles(srcFile, destFile);
			}

		} else {
			// если файл, то копируй
			// Используем поток байтов для поддержки всех типов файлов
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// копируем содержимое файла в байтах
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
//			System.out.println("File copied from " + src + " to " + dest);
			lblViewConsole.setText(String.valueOf(dest));
		}
	}	
	
	private void killProcessJavaw() {
		Thread worker = new Thread() {
			public void run() {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM javaw.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		worker.start();
	}

}
